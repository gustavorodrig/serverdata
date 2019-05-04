package com.serverdata.service;

import com.serverdata.model.Server;
import com.serverdata.repository.ServerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ServerServiceTest {

    private ServerService serverService;

    @Mock
    private ServerRepository serverRepository;

    @Before
    public void setUp(){
        serverService = new ServerService(serverRepository);
    }

    @Test
    public void testAddServer() {

        Server server = createServer("AXY-21", "New One");
        when(serverRepository.save(any())).thenReturn(server);

        String serverData = serverService.addServer("AXY-21", "New One");

        Assert.assertEquals(serverData, "Server{id=0, name='AXY-21', description='New One'}");

    }

    @Test
    public void testUpdateServer() {

        Server server = createServer("AXY-21", "New One");
        when(serverRepository.findById(new Long(0))).thenReturn(Optional.of(server));

        Server serverUpdated = createServer("ZZZ-44", "Old One");
        when(serverRepository.save(server)).thenReturn(serverUpdated);

        String serverData = serverService.updateServer(new Long(0),"ZZZ-44", "Old One");

        Assert.assertEquals(serverData, "Server{id=0, name='ZZZ-44', description='Old One'}");

    }

    @Test
    public void testUpdateServerNotFound() {

        when(serverRepository.findById(new Long(0))).thenReturn(Optional.empty());

        String serverData = serverService.updateServer(new Long(0),"ZZZ-44", "Old One");

        Assert.assertEquals(serverData, "Server 0 not found");

    }

    @Test
    public void testDeleteServer() {

        Server server = createServer("AXY-21", "New One");
        when(serverRepository.findById(new Long(0))).thenReturn(Optional.of(server));

        String serverData = serverService.deleteServer(new Long(0));

        Assert.assertEquals(serverData, "Server 0 deleted");
    }

    @Test
    public void testDeleteServerNotFound() {

        when(serverRepository.findById(new Long(0))).thenReturn(Optional.empty());

        String serverData = serverService.deleteServer(new Long(0));

        Assert.assertEquals(serverData, "Server 0 not found");
    }

    @Test
    public void testCountServers() {

        when(serverRepository.findAll()).thenReturn(createListOfServers());

        Long count = serverService.countServers();

        Assert.assertEquals(count, new Long(4));

    }

    @Test
    public void testListOfServices() {

        when(serverRepository.findAll()).thenReturn(createListOfServers());

        String allServers = serverService.listServices();

        Assert.assertEquals(allServers, "Server{id=0, name='AXY-222', description='New One'}" + System.lineSeparator() +
                "Server{id=0, name='ABC-444', description='Tech'}" + System.lineSeparator() +
                "Server{id=0, name='AZY-899', description='ShutDown'}" + System.lineSeparator() +
                "Server{id=0, name='AHU-333', description='Exec'}");

    }

    @Test
    public void testListOfServiceNotFound() {

        when(serverRepository.findAll()).thenReturn(new ArrayList<>());

        String allServers = serverService.listServices();

        Assert.assertEquals(allServers, "No Server was found");

    }

    private Server createServer(String name, String description) {
        return new Server(name, description);
    }

    private List<Server> createListOfServers() {

        List<Server> servers = new ArrayList<>();

        servers.add(new Server("AXY-222", "New One"));
        servers.add(new Server("ABC-444", "Tech"));
        servers.add(new Server("AZY-899", "ShutDown"));
        servers.add(new Server("AHU-333", "Exec"));

        return servers;
    }
}
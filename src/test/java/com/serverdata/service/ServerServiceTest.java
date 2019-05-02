package com.serverdata.service;

import com.serverdata.ServerDataApplication;
import com.serverdata.model.Server;
import com.serverdata.repository.ServerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.JLineShellAutoConfiguration;
import org.springframework.shell.standard.commands.StandardCommandsAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerDataApplication.class)
@EnableAutoConfiguration(exclude = {JLineShellAutoConfiguration.class, StandardCommandsAutoConfiguration.class})
public class ServerServiceTest {

    @Autowired
    private ServerRepository serverRepository;

    @Test
    public void testAddNewServer() {

        Server savedServer = serverRepository.save(createServer("AXY-21", "New One"));

        Assert.assertEquals(savedServer.getId(), 1);
        Assert.assertEquals(savedServer.getName(), "AXY-21");
        Assert.assertEquals(savedServer.getDescription(), "New One");

    }

    @Test
    public void testUpdateServer() {

        Server savedServer = serverRepository.save(createServer("AXY-21", "New One"));
        Assert.assertEquals(savedServer.getId(), 1);
        Assert.assertEquals(savedServer.getName(), "AXY-21");
        Assert.assertEquals(savedServer.getDescription(), "New One");

        savedServer.setName("ABC-33");
        Server updatedServer = serverRepository.save(savedServer);
        Assert.assertEquals(updatedServer.getId(), 1);
        Assert.assertSame("Server name was not updated", updatedServer.getName(), "ABC-33");
        Assert.assertEquals(updatedServer.getDescription(), "New One");

    }

    @Test
    public void testDeleteServer() {

        Server savedServer = serverRepository.save(createServer("AXY-21", "New One"));
        Assert.assertEquals(savedServer.getId(), 1);
        Assert.assertEquals(savedServer.getName(), "AXY-21");
        Assert.assertEquals(savedServer.getDescription(), "New One");

        serverRepository.delete(savedServer);

        Optional<Server> serverById = serverRepository.findById(new Long(1));
        Assert.assertEquals("Server not deleted", serverById.isPresent(), Boolean.FALSE);

    }

    @Test
    public void testCountServers() {

        createServers().forEach(s-> serverRepository.save(s));
        long count = serverRepository.findAll().stream().count();
        Assert.assertEquals(count, 4);

    }

    @Test
    public void listServices() {
        createServers().forEach(s-> serverRepository.save(s));
        List<Server> allServers = serverRepository.findAll();

        Assert.assertEquals(allServers.get(0).getId(), 1);
        Assert.assertEquals(allServers.get(0).getName(), "AXY-21");
        Assert.assertEquals(allServers.get(0).getDescription(), "New One");

        Assert.assertEquals(allServers.get(1).getId(), 1);
        Assert.assertEquals(allServers.get(1).getName(), "ABC-44");
        Assert.assertEquals(allServers.get(1).getDescription(), "Tech");

        Assert.assertEquals(allServers.get(2).getId(), 1);
        Assert.assertEquals(allServers.get(2).getName(), "AZY-89");
        Assert.assertEquals(allServers.get(2).getDescription(), "ShutDown");

        Assert.assertEquals(allServers.get(3).getId(), 1);
        Assert.assertEquals(allServers.get(3).getName(), "AHU-33");
        Assert.assertEquals(allServers.get(3).getDescription(), "Exec");

    }

    private Server createServer(String name, String description){
        return new Server(name, description);
    }

    private List<Server> createServers(){

        List<Server> servers = new ArrayList<>();

        servers.add(new Server("AXY-21", "New One"));
        servers.add(new Server("ABC-44", "Tech"));
        servers.add(new Server("AZY-89", "ShutDown"));
        servers.add(new Server("AHU-33", "Exec"));

        return servers;
    }
}
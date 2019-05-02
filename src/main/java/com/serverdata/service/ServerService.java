package com.serverdata.service;

import com.serverdata.model.Server;
import com.serverdata.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public String addServer(String name, String description){

        Server server = new Server(name, description);
        Server savedService = serverRepository.save(server);
        return savedService.toString();

    }

    public String updateServer(Long id, String name, String description){

        Optional<Server> existingServer = serverRepository.findById(id);

        if(existingServer.isPresent()){
            Server server = existingServer.get();
            server.setName(name);
            server.setDescription(description);
            Server updatedServer = serverRepository.save(server);
            return updatedServer.toString();

        }

        return String.format("Server %d not found", id);
    }

    public String deleteServer(Long id){

        Optional<Server> existingServer = serverRepository.findById(id);

        if(existingServer.isPresent()){
            serverRepository.delete(existingServer.get());

            return  String.format("Server %d deleted", id);
        }
        return String.format("Server %d not found", id);
    }

    public Long countServers(){

        List<Server> allServers = serverRepository.findAll();
        return allServers.stream().count();
    }

    public String listServices(){
        List<Server> allServers = serverRepository.findAll();
        return allServers.stream().map(s -> s.toString()).collect( Collectors.joining( "/" ));
    }
}

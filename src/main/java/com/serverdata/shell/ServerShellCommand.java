package com.serverdata.shell;

import com.serverdata.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ServerShellCommand {

    @Autowired
    private ServerService serverService;

    @ShellMethod("Add new server (e.g: add {server {name} {description}")
    public String add(@ShellOption String name, @ShellOption(defaultValue = "") String description) {
        return serverService.addServer(name, description);
    }

    @ShellMethod("Update an existing server (e.g: update {id} {new server name} {new description}")
    public String update(@ShellOption Long id, @ShellOption String name, @ShellOption(defaultValue = "") String description) {
        return serverService.updateServer(id, name, description);
    }

    @ShellMethod("Delete a server (e.g: delete {id}")
    public String delete(@ShellOption Long id) {
        return serverService.deleteServer(id);
    }

    @ShellMethod("Count registered servers (e.g: count)")
    public String count() {
        return "Server count: " + serverService.countServers();
    }

    @ShellMethod("List all servers (e.g: list)")
    public String list() {
        return "List Servers: " + System.lineSeparator() + serverService.listServices();
    }

    @ShellMethod("Save a server data provided by xml file (e.g: xml /home/user/server_data.xml or C:/server_data.xml *Provide absolute path and use Forward slash*)")
    public String xml(@ShellOption String path) {
        return serverService.importXml(path);
    }

}
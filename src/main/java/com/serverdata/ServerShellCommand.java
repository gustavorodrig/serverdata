package com.serverdata;

import com.serverdata.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ServerShellCommand {

    @Autowired
    private ServerService serverService;

    @ShellMethod("Display Help")
    public String info() {
        return "show Help Info";
    }

    @ShellMethod("Add new server (e.g: add |server name| |description|")
    public String add(@ShellOption String name, @ShellOption String description) {
        return serverService.addServer(name, description);
    }

    @ShellMethod("update an existing server (e.g: update |id| |new server name| |new description|")
    public String update(@ShellOption Long id, @ShellOption String name, @ShellOption String description) {
        return serverService.updateServer(id, name, description);
    }

    @ShellMethod("delete a server (e.g: delete |id|")
    public String delete(@ShellOption Long id) {
        return serverService.deleteServer(id);
    }

    @ShellMethod("count registered servers (e.g: count)")
    public String count() {
        return "Server count " + serverService.countServers();
    }

    @ShellMethod("list all servers (e.g: list)")
    public String list() {
        return "List Servers " + serverService.listServices();
    }

}
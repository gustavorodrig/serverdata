package com.serverdata;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.jline.JLineShellAutoConfiguration;
import org.springframework.shell.standard.commands.StandardCommandsAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.fail;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {JLineShellAutoConfiguration.class, StandardCommandsAutoConfiguration.class})
@ActiveProfiles("test")
public class ServerDataApplicationTests {

    private static final String APP_ERROR = "Error starting application";

    public static void main(String[] args) {
        try {
            SpringApplication.run(ServerDataApplicationTests.class, args);
        } catch (BeansException e){
            e.printStackTrace();
            fail(APP_ERROR);
        }
    }
}
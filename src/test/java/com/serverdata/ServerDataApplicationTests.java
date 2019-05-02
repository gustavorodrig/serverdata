package com.serverdata;

import org.jline.reader.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.JLineShellAutoConfiguration;
import org.springframework.shell.standard.commands.StandardCommandsAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {JLineShellAutoConfiguration.class, StandardCommandsAutoConfiguration.class})
public class ServerDataApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(ServerDataApplicationTests.class, args);
    }

    @Bean
    public Parser parser() {
        return (var1, var2, var3) -> null;
    }
}
package com.serverdata.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.shell.jline.PromptProvider;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackages = {"com.serverdata"})
@EntityScan(basePackages = {"com.serverdata.model"})
@EnableJpaRepositories(basePackages = {"com.serverdata.repository"})
public class ServerDataApplication {

	public static void main(String[] args) {
		run(ServerDataApplication.class, args);
	}

	@Bean
	public PromptProvider promptProvider() {
		return () -> new AttributedString("server command:>",
				AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
	}
}



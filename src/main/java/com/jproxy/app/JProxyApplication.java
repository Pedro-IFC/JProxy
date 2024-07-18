package com.jproxy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JProxyApplication {
	public static void main(String[] args) {
		SpringApplication.run(JProxyApplication.class, args);
	}
}

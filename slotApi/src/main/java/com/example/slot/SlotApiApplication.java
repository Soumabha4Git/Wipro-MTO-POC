package com.example.slot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SlotApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlotApiApplication.class, args);
	}

}

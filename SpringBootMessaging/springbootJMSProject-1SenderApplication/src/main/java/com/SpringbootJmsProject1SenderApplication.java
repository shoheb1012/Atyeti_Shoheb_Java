package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringbootJmsProject1SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsProject1SenderApplication.class, args);

		System.out.println("SpringbootJmsProject1SenderApplication Running..");

	}

}

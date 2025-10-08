package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EnableScheduling
public class SpringbootJmsProject1SenderApplication_Scheduling {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsProject1SenderApplication_Scheduling.class, args);

		System.out.println("SpringbootJmsProject1SenderApplication_Scheduling Running..");

	}

}

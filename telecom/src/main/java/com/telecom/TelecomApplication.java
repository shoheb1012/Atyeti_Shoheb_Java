package com.telecom;

import com.telecom.model.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories
public class  TelecomApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context= SpringApplication.run(TelecomApplication.class, args);

		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		Arrays.sort(beanDefinitionNames);
		for(String beans : beanDefinitionNames)
		{
			System.out.println(beans);
		}

	}


}

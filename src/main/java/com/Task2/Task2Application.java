package com.Task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Task2Application {

	public static void main(String[] args)
	{
		SpringApplication app = new SpringApplication(Task2Application.class);
		app.addListeners(new ApplicationPidFileWriter("shutdown.pid"));
		app.run(args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
		{

			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
}

package com.mojo.wikimap;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WikimapApplication {
	
	protected final Logger logger = Logger.getLogger(getClass().getName());
	
	public static void main(String[] args) {
		SpringApplication.run(WikimapApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Starting application!");
		return (args) -> {
			//URI uri = URI.create("");
			//String response = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", String.class);
			logger.info("Hello, you may now interact with the wikimedia api.");
		};
		
		
	}

}

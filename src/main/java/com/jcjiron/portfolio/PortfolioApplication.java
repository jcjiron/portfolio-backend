package com.jcjiron.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {


		String username = System.getenv("SPRING_MAIL_USERNAME");
		String password = System.getenv("SPRING_MAIL_PASSWORD");
		String destination = System.getenv("MAIL_DESTINATION");

		if (username == null || password == null || destination == null) {
			throw new IllegalStateException("Environment variables SPRING_MAIL_USERNAME, SPRING_MAIL_PASSWORD, and MAIL_DESTINATION must be set");
		}

		System.setProperty("spring.mail.username", username);
		System.setProperty("spring.mail.password", password);
		System.setProperty("mail.destination", destination);

		SpringApplication.run(PortfolioApplication.class, args);
	}

}

package com.jcjiron.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{



	@Autowired
	private final EmailSender emailSender;

	@Value("${email.destination}")
		private String emailTo;

		@Value("${spring.mail.username}")
		private String emailFrom;

	@Async
	@Override
	public void sendContactMail(String name, String email, String message) throws Exception {
		final String subject = "Portfolio email | " + name;
		final String text = "Name: " + name + "\nEmail: " + email + "\nMessage: " + message;

		emailSender.sendMail(emailFrom, emailTo, subject, text);
	}
}

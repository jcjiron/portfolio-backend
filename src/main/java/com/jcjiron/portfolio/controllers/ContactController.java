package com.jcjiron.portfolio.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcjiron.portfolio.services.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController()
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/email")
	public ResponseEntity postMethodName( @RequestBody HashMap<String, String> body) {

		String name = body.get("name");
		String email = body.get("email");
		String message = body.get("message");

		try{
			contactService.sendContactMail(name, email, message);
            return ResponseEntity.ok().build();
		}catch(Exception exception){
			log.severe("Error sending email: " + exception.getMessage());
            return ResponseEntity.badRequest().build();
		}
	}

}

package com.jcjiron.portfolio.services;

public interface ContactService {
    
    void sendContactMail(String name, String email, String message) throws Exception;
}

package com.jcjiron.portfolio.services;

public interface EmailSender {
    void sendMail(String from, String destination, String subject, String text) throws Exception;
}

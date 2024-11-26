package com.jcjiron.portfolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(String from, String destination, String subject, String text) throws Exception{
            final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            populateMimeMsg(mimeMessageHelper, from, destination, subject, text);
            javaMailSender.send(mimeMessage);
    }

    public void populateMimeMsg(MimeMessageHelper mimeMessageHelper, String from, String to, String subject, String text) throws MessagingException {
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.addTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, false);
    }
}

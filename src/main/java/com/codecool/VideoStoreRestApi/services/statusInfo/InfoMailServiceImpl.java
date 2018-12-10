package com.codecool.VideoStoreRestApi.services.statusInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class InfoMailServiceImpl implements InfoMailService {

    @Autowired
    MailSender sender;

    @Override
    public void send(String to, String subject, String text) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            sender.send(message);
        } catch (MailException e){
            e.printStackTrace();
        }
    }
}

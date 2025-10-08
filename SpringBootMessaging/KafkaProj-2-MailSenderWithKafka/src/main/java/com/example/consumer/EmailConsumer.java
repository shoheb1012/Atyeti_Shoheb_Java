package com.example.consumer;

import com.example.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = "${app.topic.name}",groupId = "grp2")
    public void consume(EmailRequest emailRequest)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        javaMailSender.send(message);

        System.out.println("Email sent to : "+emailRequest.getTo());

    }
}

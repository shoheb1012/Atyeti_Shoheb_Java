package com.example.pubisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class PublisherApp implements CommandLineRunner {

    @Autowired
    private JmsTemplate template;

    @Override
    public void run(String... args) throws Exception {
        template.send("topic-1", session -> session.createTextMessage("Sender message:: " + new Date()));
        System.out.println("Sender has sent the message");
    }
}

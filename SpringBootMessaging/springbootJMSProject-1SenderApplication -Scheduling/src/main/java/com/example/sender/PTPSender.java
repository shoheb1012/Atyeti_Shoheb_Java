package com.example.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PTPSender  {
    @Autowired
   private JmsTemplate jmsTemplate;

    @Scheduled(cron = "*/10 * * * * * ")
    public void sendMessage()
    {
        System.out.println("About to send JMS message...");
        jmsTemplate.send("testmq1",session-> session.createTextMessage("from the sender:: "+new Date()));
        System.out.println("Sender has sent the Message");

    }
}

package com.example.subscribers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {


    @JmsListener(destination = "topic-1")
    public void readMessage(String msg)
    {
        System.out.println("Receiver ::message "+msg);
    }
}

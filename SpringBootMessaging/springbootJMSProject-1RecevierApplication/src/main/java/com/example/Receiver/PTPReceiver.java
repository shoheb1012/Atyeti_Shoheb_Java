package com.example.Receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PTPReceiver {

    @JmsListener(destination = "testmq1")
    public void receiveMessage(String message)
    {
        System.out.println("Reaciver::message"+message);
    }
}

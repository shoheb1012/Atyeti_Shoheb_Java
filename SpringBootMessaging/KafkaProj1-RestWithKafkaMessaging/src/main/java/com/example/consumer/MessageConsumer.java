package com.example.consumer;

import com.example.store.MessageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private MessageStore store;

    @KafkaListener(topics = "${app.topic.name}",groupId = "grp1")
    public void readMessage(String message)
    {
        //Add received message to MessageStore
         store.addMessage(message);
    }

}

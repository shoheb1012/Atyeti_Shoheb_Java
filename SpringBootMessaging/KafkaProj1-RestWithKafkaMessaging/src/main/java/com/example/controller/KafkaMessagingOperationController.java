package com.example.controller;

import com.example.producer.MessageProducer;
import com.example.store.MessageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KafkaMessagingOperationController {

    @Autowired
   private MessageProducer messageProducer;

    @Autowired
    private MessageStore messageStore;

    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam("message")String message)
    {
        String result = messageProducer.sendMessage(message);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }


    @GetMapping("/readAll")
    public ResponseEntity<List<String>> showAllMessages()
    {
        //read all the messages from messageStore
        return new ResponseEntity<List<String>>(messageStore.showAllMessage(),HttpStatus.OK);
    }
}

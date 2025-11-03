package com.example.controller;

import com.example.dto.EmailRequest;
import com.example.producer.EmailProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailProducer producer;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest)
    {
        return new ResponseEntity<>(producer.sendEmailRequest(emailRequest), HttpStatus.OK);
    }


}

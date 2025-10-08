package com.example.controller;

import com.example.dto.SmsRequest;
import com.example.producer.SmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    private SmsProducer smsProducer;

    @PostMapping("/sendSms")
    public ResponseEntity<String> sendSmsRequest(@RequestBody SmsRequest request)
    {
        return new ResponseEntity<>(smsProducer.sendSms(request), HttpStatus.OK);
    }
}

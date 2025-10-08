package com.example.consumer;

import com.example.dto.SmsRequest;
import com.example.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SmsConsumer {

    private final SmsService smsService;

    @Autowired
    public SmsConsumer(SmsService smsService) {
        this.smsService = smsService;
    }

    @KafkaListener(topics = "sms-topic", groupId = "sms-group")
    public void consume(SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.getPhoneNumber(), smsRequest.getMessage());
        System.out.println("SMS sent to: " + smsRequest.getPhoneNumber());
    }

}

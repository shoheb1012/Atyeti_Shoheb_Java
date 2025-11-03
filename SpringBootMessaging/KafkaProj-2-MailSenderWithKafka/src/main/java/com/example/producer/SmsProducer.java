package com.example.producer;

import com.example.dto.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SmsProducer {

    @Autowired
    KafkaTemplate<String, SmsRequest> smsRequestKafkaTemplate;


    private String topic="sms-topic";

    public String sendSms(SmsRequest smsRequest)
    {
        smsRequestKafkaTemplate.send(topic,smsRequest);

        return "SMS sent successfully";
    }
}

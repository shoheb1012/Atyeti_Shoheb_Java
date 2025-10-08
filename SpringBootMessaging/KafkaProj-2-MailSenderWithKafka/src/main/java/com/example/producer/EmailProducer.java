package com.example.producer;

import com.example.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Autowired
    private KafkaTemplate<String, EmailRequest> template;

    @Value("${app.topic.name}")
    private String topic;

    public String sendEmailRequest(EmailRequest emailRequest)
    {
        template.send(topic,emailRequest);
        return "Email request sent successfully";
    }

}

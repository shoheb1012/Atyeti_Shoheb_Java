package com.example.service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    // Replace with your Twilio credentials
    public static final String ACCOUNT_SID = "AC8075d4035ee9311b04d3e263a79bbed5";
    public static final String AUTH_TOKEN = "b54fceee07bcef6c86f2447fb38ecb7a";
    public static final String FROM_NUMBER = "+919004200484"; // Twilio number

    public void sendSms(String to, String messageText) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(to),    // recipient
                new PhoneNumber(FROM_NUMBER),  // sender
                messageText             // message body
        ).create();

        System.out.println("SMS sent with SID: " + message.getSid());
    }
}

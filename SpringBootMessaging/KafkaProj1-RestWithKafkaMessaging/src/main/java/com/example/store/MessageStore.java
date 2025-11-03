package com.example.store;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStore {

    private List<String> messagesList = new ArrayList<>();

    public void addMessage(String message)
    {
        messagesList.add(message);
    }

    public List<String> showAllMessage()
    {
        return messagesList;
    }
}

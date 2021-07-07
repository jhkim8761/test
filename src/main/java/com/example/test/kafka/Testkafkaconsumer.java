package com.example.test.kafka;

import com.example.test.dto.Persondto;
import com.example.test.repository.Personrepository;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Testkafkaconsumer {

    @Autowired
    private Personrepository personrepository;

    @KafkaListener(topics = "exam",groupId = "foo")
    public void consume(String messeage) throws IOException{
        // mapObject
        // jsonstring
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(message);

        String personId = element.getAsJsonObject().get("personId").getAsString();
        String personName = element.getAsJsonObject().get("personName").getAsString();

    }
}

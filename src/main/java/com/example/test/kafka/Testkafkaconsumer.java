package com.example.test.kafka;

import com.example.test.dto.Persondto;
import com.example.test.repository.Personrepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class Testkafkaconsumer {

    @Autowired
    private Personrepository personrepository;

    @KafkaListener(topics = "exam",groupId = "foo")
    public void consume(String json) throws IOException{
        // mapObject
        // jsonstring
        /*JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        String personId = element.getAsJsonObject().get("personId").getAsString();
        String personName = element.getAsJsonObject().get("personName").getAsString();

        Persondto persondto = new Persondto();
        persondto.setPersonId(personId);
        persondto.setPersonName(personName);*/

        Gson gson = new Gson();

        Persondto persondto = gson.fromJson(json, Persondto.class);
        personrepository.save(persondto).getPersonId();
    }
}

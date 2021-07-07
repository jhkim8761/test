package com.example.test.service;

import com.example.test.dto.Persondto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Testkafkaproducer {
    private static final String TOPIC = "exam";
    private final KafkaTemplate<String, Persondto> kafkaTemplate;

    @Autowired
    public Testkafkaproducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Persondto persondto){
        Persondto sendPersondto = new Persondto();
        sendPersondto.setPersonId(persondto.getPersonId());
        sendPersondto.setPersonName(persondto.getPersonName());

        Gson gson = new Gson();
        String json = gson.toJson(sendPersondto);
        System.out.println(json);
        this.kafkaTemplate.send(TOPIC, json);
    }

}

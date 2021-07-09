package com.example.test.service;

import com.example.test.dto.Persondto;
import com.example.test.dto.Productdto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Testkafkaproducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private String TOPIC = "";

    @Autowired
    public Testkafkaproducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void kafkaInsertPerson(Persondto persondto){
        TOPIC = "person";
        Persondto sendPersondto = new Persondto();
        sendPersondto.setPersonId(persondto.getPersonId());
        sendPersondto.setPersonName(persondto.getPersonName());

        Gson gson = new Gson();
        String json = gson.toJson(sendPersondto);
        System.out.println(json);
        this.kafkaTemplate.send(TOPIC, json);
    }

    public void kafkaInsertProduct(Productdto productdto){
        TOPIC = "product";
        Productdto sendProductdto = new Productdto();
        sendProductdto.setProductId(productdto.getProductId());
        sendProductdto.setProductName(productdto.getProductName());

        Gson gson = new Gson();
        String json = gson.toJson(sendProductdto);
        System.out.println(json);
        this.kafkaTemplate.send(TOPIC, json);
    }

}

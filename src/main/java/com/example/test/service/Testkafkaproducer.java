package com.example.test.service;

import com.example.test.dto.Persondto;
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
        System.out.println(persondto);
        //this.kafkaTemplate.send(TOPIC, String.valueOf(persondto));
    }

}

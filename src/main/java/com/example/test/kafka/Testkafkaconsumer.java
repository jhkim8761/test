package com.example.test.kafka;

import com.example.test.dto.Persondto;
import com.example.test.repository.Personrepository;
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
    }
}

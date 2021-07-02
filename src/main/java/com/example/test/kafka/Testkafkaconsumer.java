package com.example.test.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Testkafkaconsumer {

    @KafkaListener(topics = "exam",groupId = "foo")
    public void consume(String messeage) throws IOException{
        System.out.println(String.format("Consumed message : %s", messeage));
    }
}

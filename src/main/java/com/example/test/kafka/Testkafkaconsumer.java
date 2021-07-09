package com.example.test.kafka;

import com.example.test.dto.Persondto;
import com.example.test.dto.Productdto;
import com.example.test.repository.Personrepository;
import com.example.test.repository.Productrepository;
import com.google.gson.Gson;
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

    @Autowired
    private Productrepository productrepository;

    @KafkaListener(topics = "person",groupId = "foo")
    public void consumePerson(String json) throws IOException{
        Gson gson = new Gson();

        Persondto persondto = gson.fromJson(json, Persondto.class);
        personrepository.save(persondto).getPersonId();
    }

    @KafkaListener(topics = "product",groupId = "foo")
    public void consumeProduct(String json) throws IOException{
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);

        String productId = element.getAsJsonObject().get("productId").getAsString();
        String productName = element.getAsJsonObject().get("productName").getAsString();

        Productdto productdto = new Productdto();
        productdto.setProductId(productId);
        productdto.setProductName(productName);

        productrepository.save(productdto).getProductId();
    }
}

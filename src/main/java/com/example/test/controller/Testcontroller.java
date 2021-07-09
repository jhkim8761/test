package com.example.test.controller;

import com.example.test.dto.Orderdto;
import com.example.test.dto.Persondto;
import com.example.test.dto.Productdto;
import com.example.test.service.Testkafkaproducer;
import com.example.test.service.Testservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Testcontroller {

    @Autowired
    private Testservice testservice;

    private Testkafkaproducer testkafkaproducer;

    @Autowired
    Testcontroller(Testkafkaproducer testkafkaproducer){
        this.testkafkaproducer = testkafkaproducer;
    }

    @PostMapping("/kafka/post/person")
    public ResponseEntity<String> kafkaInsertPerson(@RequestBody Persondto persondto) {
        this.testkafkaproducer.kafkaInsertPerson(persondto);
        return ResponseEntity.ok().body("Topic Person 추가완료");
    }

    @PostMapping("/kafka/post/product")
    public ResponseEntity<String> kafkaInsertProduct(@RequestBody Productdto productdto) {
        this.testkafkaproducer.kafkaInsertProduct(productdto);
        return ResponseEntity.ok().body("Topic Product 추가완료");
    }

    @PostMapping("/post/person")
    public ResponseEntity<String> insertPerson(@RequestBody Persondto persondto) {
        testservice.savePerson(persondto);
        return ResponseEntity.ok().body("person 추가완료");
    }

    @GetMapping("/get/person")
    public ResponseEntity<List<Persondto>> selectPerson() {
        List<Persondto> personlist = testservice.getPersonlist();
        return ResponseEntity.ok(personlist);
    }

    @PostMapping("/post/product")
    public ResponseEntity<String> insertProduct(@RequestBody Productdto productdto) {
       testservice.saveProduct(productdto);
        return ResponseEntity.ok().body("product 추가완료");
    }

    @GetMapping("/get/product")
    public ResponseEntity<List<Productdto>> selectProduct() {
        List<Productdto> productlist = testservice.getProductlist();
        return ResponseEntity.ok(productlist);
    }

    @PostMapping("/post/order")
    public ResponseEntity<String> insertOrder(@RequestBody Orderdto orderdto) {
        testservice.saveOrder(orderdto);

        return ResponseEntity.ok("order 추가완료");
    }

    @GetMapping("/get/order")
    public ResponseEntity<List<Orderdto>> selectOrder() {
        List<Orderdto> orderlist = testservice.getOrderist();

        return ResponseEntity.ok(orderlist);
    }
}

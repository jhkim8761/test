package com.example.test.service;

import com.example.test.dto.Mongodbdto;
import com.example.test.dto.Orderdto;
import com.example.test.dto.Persondto;
import com.example.test.dto.Productdto;
import com.example.test.repository.Mongorepository;
import com.example.test.repository.Orderrepository;
import com.example.test.repository.Personrepository;
import com.example.test.repository.Productrepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class Testservice {

    private final Personrepository personrepository;
    private final Productrepository productrepository;
    private final Orderrepository orderrepository;
    private final Mongorepository mongorepository;


    @Transactional
    public String savePerson(Persondto persondto){
        return personrepository.save(persondto).getPersonId();
    }

    @Transactional
    public List<Persondto> getPersonlist() {
        List<Persondto> persondtos = personrepository.findAll();
        return persondtos;
    }

    @Transactional
    public String saveProduct(Productdto productdto){
        return productrepository.save(productdto).getProductId();
    }

    @Transactional
    public List<Productdto> getProductlist() {
        List<Productdto> productdtos = productrepository.findAll();
        return productdtos;
    }

    @Transactional
    public String saveOrder(Orderdto orderdto){
        return orderrepository.save(orderdto).getOrderId();
    }

    @Transactional
    public List<Orderdto> getOrderist() {
        List<Orderdto> orderdtos = orderrepository.findAll();
        return orderdtos;
    }

    @Transactional
    public String saveMongodb(Mongodbdto mongodbdto){
        return mongorepository.save(mongodbdto).getId();
    }

}

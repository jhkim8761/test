package com.example.test.repository;

import com.example.test.dto.Mongodbdto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Mongorepository extends MongoRepository<Mongodbdto, String> {
}

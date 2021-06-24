package com.example.test.service;

import com.example.test.dto.Testdto;
import com.example.test.repository.Testrepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class Testservice {

    @Autowired
    private Testrepository testrepository;

    @Transactional
    public String savePost(Testdto testdto){
        return testrepository.save(testdto).getPersonId();
    }

}

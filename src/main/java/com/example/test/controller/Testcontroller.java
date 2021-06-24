package com.example.test.controller;

import com.example.test.dto.Testdto;
import com.example.test.service.Testservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Testcontroller {

    @Autowired
    private Testservice testservice;

    @PostMapping("/post")
    public ResponseEntity<String> signin(@RequestBody Testdto testdto) {
        testservice.savePost(testdto);

        return ResponseEntity.ok().build();
    }
}

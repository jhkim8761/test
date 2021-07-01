package com.example.test.controller;

import com.example.test.dto.Persondto;
import com.example.test.service.Testservice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class TestcontrollerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    Testservice testservice;

    @Test
    @DisplayName("멤버 추가")
    void insertPerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                .post("/post/person")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is4xxClientError());

    }

    @Test
    @DisplayName("멤버 조회")
    void selectPerson() throws Exception{
        List<Persondto> persondtoList = new ArrayList<>();
        given(testservice.getPersonlist()).willReturn(persondtoList);
        mockMvc.perform(get("/get/person"))
                .andExpect(status().isOk());
    }
}
package com.example.test.service;

import com.example.test.dto.Persondto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class TestserviceTest {

    @Autowired
    Testservice testservice;

    @MockBean
    Persondto persondto;

    @Test
    @DisplayName("멤버 추가")
    void insertPerson() {
        //String personId = "7";
        //String personName = "마길동";

        //Persondto persondto = new Persondto();
        //persondto.setPersonId(personId);
        //persondto.setPersonName(personName);

        //log.info("1111111111111111111111111");
        //log.info(persondto.getPersonId());
        //log.info(persondto.getPersonName());
        //log.info("1111111111111111111111111");

        testservice.savePerson(persondto);

        verify(testservice).savePerson(persondto);
    }

    @Test
    @DisplayName("멤버 조회")
    void selectPerson() {
        String personId = "7";

        List<Persondto> persondtos = testservice.getPersonlist();

        for(int i=0; i < persondtos.size(); i++){
            assertThat(persondtos.get(i).getPersonId() == personId);
        }
    }
}
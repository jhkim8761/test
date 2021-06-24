package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSON")
public class Testdto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String personId;
    private String personName;

}

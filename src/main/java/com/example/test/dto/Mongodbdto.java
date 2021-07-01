package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "history")
public class Mongodbdto {
    @Id
    private String id;
    private String threadId;
    private String uri;
    private String parameter;
    private int status;
    private String method;
}

package com.example.test.repository;

import com.example.test.dto.Testdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface Testrepository extends JpaRepository<Testdto, String> {
}

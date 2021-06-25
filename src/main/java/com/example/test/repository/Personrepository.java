package com.example.test.repository;

import com.example.test.dto.Persondto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Personrepository extends JpaRepository<Persondto, String> {
}

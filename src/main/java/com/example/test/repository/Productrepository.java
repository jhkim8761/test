package com.example.test.repository;

import com.example.test.dto.Productdto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Productdto, String> {
}

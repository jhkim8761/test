package com.example.test.repository;

import com.example.test.dto.Orderdto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orderrepository extends JpaRepository<Orderdto,String> {

}

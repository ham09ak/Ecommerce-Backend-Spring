package com.example.Ecommerce.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Ecommerce.Models.CartEntity;

public interface CartDao extends JpaRepository<CartEntity, Long>{
    Optional<CartEntity> findByName(String name);
}
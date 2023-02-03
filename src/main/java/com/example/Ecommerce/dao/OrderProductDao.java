package com.example.Ecommerce.dao;

import com.example.Ecommerce.Models.OrderProductEntuty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDao extends JpaRepository<OrderProductEntuty, Long> {
}

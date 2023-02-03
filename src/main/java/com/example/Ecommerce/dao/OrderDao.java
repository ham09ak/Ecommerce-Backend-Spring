package com.example.Ecommerce.dao;

import com.example.Ecommerce.Models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,Long> {
}

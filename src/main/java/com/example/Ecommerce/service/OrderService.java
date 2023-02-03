package com.example.Ecommerce.service;

import com.example.Ecommerce.Models.OrderEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderService {
    @NotNull
    Iterable<OrderEntity> getAllOrders();

    OrderEntity create(@NotNull(message = "The order cannot be null.") @Valid OrderEntity order);
    void update (@NotNull(message = "The order cannot be null.") @Valid OrderEntity order);
}

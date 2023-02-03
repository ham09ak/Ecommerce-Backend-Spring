package com.example.Ecommerce.service;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.example.Ecommerce.Models.OrderProductEntuty;

public interface OrderProductService {
    OrderProductEntuty create(@NotNull(message = "The products for order cannot be null.")
                        @Valid OrderProductEntuty orderProduct);
}

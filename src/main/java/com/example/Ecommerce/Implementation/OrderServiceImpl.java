package com.example.Ecommerce.Implementation;

import com.example.Ecommerce.Models.OrderEntity;
import com.example.Ecommerce.dao.OrderDao;
import com.example.Ecommerce.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public @NotNull Iterable<OrderEntity> getAllOrders() {
        return this.orderDao.findAll();
    }

    @Override
    public OrderEntity create(@NotNull(message = "The order cannot be null.") @Valid OrderEntity order) {
        return this.orderDao.save(order);
    }

    @Override
    public void update(@NotNull(message = "The order cannot be null.") @Valid OrderEntity order) {
        this.orderDao.save(order);

    }
}

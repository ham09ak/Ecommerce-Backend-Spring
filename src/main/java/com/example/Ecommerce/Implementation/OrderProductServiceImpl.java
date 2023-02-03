package com.example.Ecommerce.Implementation;

import com.example.Ecommerce.Models.OrderProductEntuty;
import com.example.Ecommerce.dao.OrderProductDao;
import com.example.Ecommerce.service.OrderProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public OrderProductEntuty create(
            @NotNull(message = "The products for order cannot be null.") @Valid OrderProductEntuty orderProduct) {
        return this.orderProductDao.save(orderProduct);
    }
}

package com.example.Ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Ecommerce.dto.OrderProductDTO;
import com.example.Ecommerce.exception.ResourceNotFoundException;
import com.example.Ecommerce.Models.OrderEntity;
import com.example.Ecommerce.Models.OrderProductEntuty;
import com.example.Ecommerce.Models.OrderStatus;
import com.example.Ecommerce.service.OrderProductService;
import com.example.Ecommerce.service.OrderService;
import com.example.Ecommerce.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService,
                           OrderProductService orderProductService) {
        super();
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<OrderEntity> list(){
        return this.orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderEntity> create(@RequestBody OrderForm form){
        List<OrderProductDTO> formDtos = form.getpOrderProductDtos();
        validateProductsExistance(formDtos);
        OrderEntity order = new OrderEntity();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProductEntuty> orderProducts = new ArrayList<OrderProductEntuty>();
        for(OrderProductDTO dto: formDtos) {
            orderProducts.add(orderProductService.create(new OrderProductEntuty(order, productService.getProduct(
                    dto.getProduct().getId()), dto.getQuantity())));
        }
        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);

    }

    private void validateProductsExistance(List<OrderProductDTO> orderProducts) {
        List<OrderProductDTO> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");

        }


    }

    public  static class OrderForm {
        private List<OrderProductDTO> pOrderProductDtos;

        public List<OrderProductDTO> getpOrderProductDtos() {
            return pOrderProductDtos;
        }

        public void setpOrderProductDtos(List<OrderProductDTO> pOrderProductDtos) {
            this.pOrderProductDtos = pOrderProductDtos;
        }

    }
}

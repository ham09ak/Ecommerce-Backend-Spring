package com.example.Ecommerce.Models;
import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
@Entity
@Table(name = "orderProducts")
public class OrderProductEntuty {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPk pk;

    @Column(nullable = false)
    private Integer quantity = 1;

    public OrderProductEntuty(OrderEntity order, Product product, Integer quantity) {
        pk = new OrderProductPk();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    public OrderProductPk getPk() {
        return pk;
    }

    public void setPk(OrderProductPk pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderProductEntuty other = (OrderProductEntuty) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }
        return true;
    }
}

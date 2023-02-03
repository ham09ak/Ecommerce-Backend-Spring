package com.example.Ecommerce.Models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.io.Serializable;
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderProductPk implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    private OrderEntity order;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="productId")
    private Product product;

    public OrderProductPk() {
        super();
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result  = prime * result  + ((order.getId() == null)
                ? 0
                : order
                .getId()
                .hashCode());
        result = prime * result  + ((product.getId() == null)
                ? 0
                : product
                .getId()
                .hashCode());
        return result ;
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
        OrderProductPk other = (OrderProductPk) obj;
        if (order == null) {
            if (other.order != null) {
                return false;
            }
        }else if (!order.equals(other.order)) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        }else if (!product.equals(other.product)) {
            return false;
        }
        return true;
    }
}

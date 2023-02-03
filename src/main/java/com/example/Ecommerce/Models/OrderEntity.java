package com.example.Ecommerce.Models;
import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;

    @OneToMany(mappedBy="pk.order")
    private List<OrderProductEntuty> orderProducts = new ArrayList<OrderProductEntuty>();

    public OrderEntity() {
        super();
    }

    public OrderEntity(LocalDate dateCreated, String status, List<OrderProductEntuty> orderProducts) {
        super();
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProductEntuty> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductEntuty> orderProducts) {
        this.orderProducts = orderProducts;
    }

}

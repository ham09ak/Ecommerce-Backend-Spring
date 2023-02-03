package com.example.Ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Carts")
public class CartEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private double price;

    private int quantity;

    private String pictureUrl;


    @JsonBackReference(value = "user")
    @ManyToOne
    private User user;

    public CartEntity() {
        super();
    }

    public CartEntity(String name, Double price, int quantity,
                String pictureUrl, User user) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
        this.user = user;
    }

    public Long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double  getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int  getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}







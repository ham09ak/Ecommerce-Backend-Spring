package com.example.Ecommerce.Models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean admin;

    private String email;

    private String nameOnCard;

    private String cardNumber;

    private int cvv;

    private String address;

    @JsonProperty(access = Access.AUTO)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Categories> categories;

    @JsonProperty(access = Access.AUTO)
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    private List<CartEntity> carts;

    public User() {
        super();
    }

    public User(String username, String password, boolean admin, String email, String nameOnCard,
                String cardNumber, int cvv, String address, List<Categories> categories, List<CartEntity> carts) {
        super();
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.email = email;
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.address = address;
        this.categories = categories;
        this.carts = carts;
    }

    public Long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(List<CartEntity> carts) {
        this.carts = carts;
    }

    public void addCategoryToUser(Categories category) {
        if (getCategories()==null) {
            this.categories = new ArrayList<>();
        }
        getCategories().add(category);
        category.setUser(this);
    }

    public void addCartToUser(CartEntity cart) {
        if(getCarts()==null) {
            this.carts = new ArrayList<>();
        }
        getCarts().add(cart);
        cart.setUser(this);
    }

    public void removeFromCart(CartEntity cart) {
        if (getCarts()!=null) {
            getCarts().remove(cart);
        }
    }

}

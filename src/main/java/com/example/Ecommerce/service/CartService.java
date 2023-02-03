package com.example.Ecommerce.service;
import java.util.*;
import com.example.Ecommerce.Models.CartEntity;
public interface CartService {
    CartEntity addCartToUser(CartEntity cart, long idUser);

    void deleteCart(long id);

    List<CartEntity> findCartsForUser(long idUser);

    CartEntity findCartById(long id);

    void removeFromCart(long idCart, long idUser);

    CartEntity findByCartName(String name);
}

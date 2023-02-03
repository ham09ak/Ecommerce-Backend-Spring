package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.CartEntity;
import com.example.Ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addCartToUser/{idUser}")
    CartEntity addCartToUser(@RequestBody CartEntity cart, @PathVariable long idUser) {
        return cartService.addCartToUser(cart, idUser);
    }
    @DeleteMapping("/deleteCart/{id}")
    void deleteCart(@PathVariable long id) {
        cartService.deleteCart(id);
    }
    @GetMapping("/findCartsForUser/{idUser}")
    List<CartEntity> findCartsForUser(@PathVariable long idUser) {
        return cartService.findCartsForUser(idUser);
    }
    @GetMapping("/findCartById/{id}")
    CartEntity findCartById(@PathVariable long id) {
        return cartService.findCartById(id);
    }
    @DeleteMapping("/removeFromCart/{idCart}/{idUser}")
    void removeFromCart(@PathVariable long idCart, @PathVariable long idUser) {
        cartService.removeFromCart(idCart, idUser);
    }

    @GetMapping("/findByCartName/{name}")
    CartEntity findByCartName(@PathVariable String name) {
        return cartService.findByCartName(name);
    }
}

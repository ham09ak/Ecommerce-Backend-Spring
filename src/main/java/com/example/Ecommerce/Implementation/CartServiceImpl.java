package com.example.Ecommerce.Implementation;
import java.util.List;
import java.util.Optional;
import com.example.Ecommerce.Models.CartEntity;
import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.dao.CartDao;
import com.example.Ecommerce.dao.UserDao;
import com.example.Ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Override
    public CartEntity addCartToUser(CartEntity cart, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        user.addCartToUser(cart);
        return cartDao.save(cart);
    }

    @Override
    public void deleteCart(long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<CartEntity> findCartsForUser(long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        return user.getCarts();
    }

    @Override
    public CartEntity findCartById(long id) {
        return cartDao.findById(id).orElse(null);
    }

    @Override
    public void removeFromCart(long idCart, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        CartEntity cart = cartDao.findById(idCart).orElse(null);
        user.removeFromCart(cart);
        cartDao.delete(cart);
    }

    @Override
    public CartEntity findByCartName(String name) {
        Optional<CartEntity> carts = cartDao.findByName(name);
        if (carts.isPresent()) {
            CartEntity cart = carts.get();
            return cart;
        }
        return null;
    }

}

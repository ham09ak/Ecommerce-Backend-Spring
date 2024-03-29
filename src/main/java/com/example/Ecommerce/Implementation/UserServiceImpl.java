package com.example.Ecommerce.Implementation;

import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.dao.UserDao;
import com.example.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        List<User> users = userDao.findAll();
        if (users.size() == 0) {
            user.setAdmin(true);
        }

        for (User userExist : users) {
            if (user.getUsername().equals(userExist.getUsername())) {
                userExist.setUsername(userExist.getUsername());
                userExist.setPassword(userExist.getPassword());
                return userDao.save(userExist);
            }
        }

        return userDao.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User editUser(User user, long id) {
        User existUser = userDao.findById(id).orElse(null);
        existUser.setUsername(user.getUsername());
        existUser.setPassword(user.getPassword());
        existUser.setAdmin(user.isAdmin());
        existUser.setEmail(user.getEmail());
        existUser.setNameOnCard(user.getNameOnCard());
        existUser.setCardNumber(user.getCardNumber());
        existUser.setCvv(user.getCvv());
        existUser.setAddress(user.getAddress());
        return userDao.save(existUser);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> users = userDao.findByUsername(username);
        if (users.isPresent()) {
            User user = users.get();
            return user;
        }
        return null;
    }
}

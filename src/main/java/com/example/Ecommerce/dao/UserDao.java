package com.example.Ecommerce.dao;
import java.util.*;
import com.example.Ecommerce.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}

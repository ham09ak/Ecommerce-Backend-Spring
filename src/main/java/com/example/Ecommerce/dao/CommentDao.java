package com.example.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Ecommerce.Models.Comments;

public interface CommentDao extends JpaRepository<Comments, Long> {

}
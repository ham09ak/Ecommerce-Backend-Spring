package com.example.Ecommerce.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Ecommerce.Models.Categories;

public interface CategoryDao extends JpaRepository<Categories, Long>{

}
package com.example.Ecommerce.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Ecommerce.Models.Tag;

public interface TagDao extends JpaRepository<Tag, Long>{
    @Query("SELECT p FROM Tag p WHERE p.name LIKE :n")
    List<Tag> findByName(@Param("n") String name);
}

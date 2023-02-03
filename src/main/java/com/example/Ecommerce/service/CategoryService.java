package com.example.Ecommerce.service;
import com.example.Ecommerce.Models.Categories;

import java.util.List;

public interface CategoryService {
    Categories addCategoryToUser(Categories category, long idUser);

    Categories editCategory(Categories category, long id);

    Categories findCategoryById(long id);

    void deleteCategory(long id);

    List<Categories> findAllCategories();

    List<Categories> findCategoriesForUser(long id);
}

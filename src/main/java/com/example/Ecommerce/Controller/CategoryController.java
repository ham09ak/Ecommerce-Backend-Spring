package com.example.Ecommerce.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Ecommerce.Models.Categories;
import com.example.Ecommerce.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategoryToUser/{idUser}")
    Categories addCategoryToUser(@RequestBody Categories category, @PathVariable long idUser) {
        return categoryService.addCategoryToUser(category, idUser);
    }

    @PutMapping("/editCategory/{id}")
    Categories editCategory(@RequestBody Categories category, @PathVariable long id) {
        return categoryService.editCategory(category, id);
    }

    @GetMapping("/findCategoryById/{id}")
    Categories findCategoryById(@PathVariable long id) {
        return categoryService.findCategoryById(id);
    }

    @DeleteMapping("/deleteCategory/{id}")
    void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/findAllCategories")
    List<Categories> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/findCategoriesForUser/{id}")
    List<Categories> findCategoriesForUser(@PathVariable long id) {
        return categoryService.findCategoriesForUser(id);
    }
}

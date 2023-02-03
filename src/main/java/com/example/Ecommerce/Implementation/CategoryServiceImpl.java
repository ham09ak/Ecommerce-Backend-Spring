package com.example.Ecommerce.Implementation;
import java.util.List;
import com.example.Ecommerce.Models.Categories;
import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.dao.CategoryDao;
import com.example.Ecommerce.dao.UserDao;
import com.example.Ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Categories addCategoryToUser(Categories category, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        user.addCategoryToUser(category);
        return categoryDao.save(category);
    }

    @Override
    public Categories editCategory(Categories category, long id) {
        Categories existsCategory = categoryDao.findById(id).orElse(null);
        existsCategory.setName(category.getName());
        return categoryDao.save(existsCategory);
    }

    @Override
    public Categories findCategoryById(long id) {
        return categoryDao.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(long id) {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Categories> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public List<Categories> findCategoriesForUser(long id) {
        User user = userDao.findById(id).orElse(null);
        return user.getCategories();
    }
}

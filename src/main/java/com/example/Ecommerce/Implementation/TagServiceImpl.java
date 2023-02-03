package com.example.Ecommerce.Implementation;

import com.example.Ecommerce.Models.Product;
import com.example.Ecommerce.Models.Tag;
import com.example.Ecommerce.dao.ProductDao;
import com.example.Ecommerce.dao.TagDao;
import com.example.Ecommerce.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public void addTagToProduct(long idProduct, long idTag) {
        Product product = productDao.findById(idProduct).orElse(null);
        Tag tag = tagDao.findById(idTag).orElse(null);
        tag.addProductToTag(product);
        product.addTag(tag);

    }

    @Override
    public List<Tag> findTagsForProduct(long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        return product.getTags();
    }

    @Override
    public void deleteTagFromProduct(long idTag, long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        Tag tag = tagDao.findById(idTag).orElse(null);
        product.getTags().remove(tag);

    }

    @Override
    public Tag addTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public void deleteTag(long id) {
        tagDao.deleteById(id);
    }

    @Override
    public Tag findTagById(long id) {
        return tagDao.findById(id).orElse(null);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagDao.findAll();
    }

    @Override
    public List<Product> findProductsForTag(long idTag) {
        Tag tag = tagDao.findById(idTag).orElse(null);
        return tag.getProducts();
    }

}

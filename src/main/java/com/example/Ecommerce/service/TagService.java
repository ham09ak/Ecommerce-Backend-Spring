package com.example.Ecommerce.service;
import com.example.Ecommerce.Models.Product;
import com.example.Ecommerce.Models.Tag;

import java.util.List;

public interface TagService {
    void addTagToProduct(long idProduct, long idTag);

    List<Tag> findTagsForProduct(long idProduct);

    List<Tag> findAllTags();

    void deleteTagFromProduct(long idTag, long idProduct);

    Tag addTag(Tag tag);

    void deleteTag(long id);

    Tag findTagById(long id);

    List<Product> findProductsForTag(long idTag);
}

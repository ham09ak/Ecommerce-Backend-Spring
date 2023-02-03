package com.example.Ecommerce.service;

import com.example.Ecommerce.Models.Comments;

import java.util.List;

public interface CommentService {

    Comments addCommentToProduct(Comments comment, long idProduct);

    Comments editComment(Comments comment, long id);

    Comments findCommentById(long id);

    void deleteComment(long id);

    List<Comments> findCommentsForProduct(long idProduct);

    List<Comments> findAllComments();
}

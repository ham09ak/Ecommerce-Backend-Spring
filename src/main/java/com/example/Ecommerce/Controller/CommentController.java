package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.Comments;
import com.example.Ecommerce.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addCommentToProduct/{idProduct}")
    Comments addCommentToProduct(@RequestBody Comments comment, @PathVariable long idProduct) {
        return commentService.addCommentToProduct(comment, idProduct);
    }
    @PutMapping("/editComment/{id}")
    Comments editComment(@RequestBody Comments comment, @PathVariable long id) {
        return commentService.editComment(comment, id);
    }
    @GetMapping("/findCommentById/{id}")
    Comments findCommentById(@PathVariable long id) {
        return commentService.findCommentById(id);
    }
    @DeleteMapping("/deleteComment/{id}")
    void deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
    }
    @GetMapping("/findCommentsForProduct/{idProduct}")
    List<Comments> findCommentsForProduct(@PathVariable long idProduct) {
        return commentService.findCommentsForProduct(idProduct);
    }
    @GetMapping("/findAllComments")
    List<Comments> findAllComments() {
        return commentService.findAllComments();
    }
}

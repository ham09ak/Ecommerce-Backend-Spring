package com.example.Ecommerce.Implementation;
import java.util.Date;
import java.util.List;
import com.example.Ecommerce.Models.Comments;
import com.example.Ecommerce.Models.Product;
import com.example.Ecommerce.dao.CommentDao;
import com.example.Ecommerce.dao.ProductDao;
import com.example.Ecommerce.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Comments addCommentToProduct(Comments comment, long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        comment.setAddedAt(new Date());
        product.addCommentToProduct(comment);
        return commentDao.save(comment);
    }

    @Override
    public Comments editComment(Comments comment, long id) {
        Comments existComponent = commentDao.findById(id).orElse(null);
        existComponent.setTitle(comment.getTitle());
        existComponent.setMessage(comment.getMessage());
        existComponent.setAddedAt(new Date());
        existComponent.setAddedBy(comment.getAddedBy());
        return commentDao.save(existComponent);
    }

    @Override
    public Comments findCommentById(long id) {
        return commentDao.findById(id).orElse(null);
    }

    @Override
    public void deleteComment(long id) {
        commentDao.deleteById(id);
    }

    @Override
    public List<Comments> findCommentsForProduct(long idProduct) {
        Product product = productDao.findById(idProduct).orElse(null);
        return product.getComments();
    }

    @Override
    public List<Comments> findAllComments() {
        return commentDao.findAll();
    }
}

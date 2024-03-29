package com.example.Ecommerce.Models;
import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    @Column( length = 100000 )
    private String message;

    private String addedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt;

    @JsonBackReference(value = "product")
    @ManyToOne
    private Product product;

    public Comments() {
        super();
    }

    public Comments(String title, String message, String addedBy, Date addedAt, Product product) {
        super();
        this.title = title;
        this.message = message;
        this.addedBy = addedBy;
        this.addedAt = addedAt;
        this.product = product;
    }

    public Long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

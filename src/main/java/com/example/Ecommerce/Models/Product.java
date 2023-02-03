package com.example.Ecommerce.Models;
import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String pictureUrl;

    @JsonBackReference(value = "category")
    @ManyToOne
    private Categories category;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tag_products", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Tag> tags;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Comments> comments;

    public Product () {
        super();
    }

    public Product(String name, String description, Double price, String pictureUrl, Categories category, List<Tag> tags,
                   List<Comments> comments) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.category = category;
        this.tags = tags;
        this.comments = comments;
    }

    public Long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void addCommentToProduct(Comments comment) {
        if (getComments() == null) {
            this.comments = new ArrayList<>();
        }
        getComments().add(comment);
        comment.setProduct(this);
    }

    public void addTag(Tag tag) {
        if (getTags() == null) {
            this.tags = new ArrayList<>();
        }
        if (!getTags().contains(tag)) {
            getTags().add(tag);
        }
    }
}

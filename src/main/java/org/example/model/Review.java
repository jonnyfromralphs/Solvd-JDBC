package org.example.model;

public class Review {
    private double rating;
    private String comment;
    private Product product;
    private User user;
    private Cart cart;

    public Review(double rating, String comment, Product product, User user, Cart cart) {
        this.rating = rating;
        this.comment = comment;
        this.product = product;
        this.user = user;
        this.cart = cart;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

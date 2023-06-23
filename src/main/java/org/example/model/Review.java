package org.example.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="review")
@XmlAccessorType(XmlAccessType.FIELD)
public class Review {
    private int id;
    @XmlElement(name="rating")
    private double rating;
    @XmlElement(name="comment")
    private String comment;
    private int productId;

    public Review() {}
    public Review(double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int id, double rating, String comment, int productId) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.productId = productId;
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

}

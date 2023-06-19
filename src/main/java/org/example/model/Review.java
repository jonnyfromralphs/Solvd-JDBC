package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="review")
@XmlAccessorType(XmlAccessType.FIELD)
public class Review {
    @JsonProperty("rating")
    @XmlElement(name="rating")
    private double rating;
    @JsonProperty("comment")
    @XmlElement(name="comment")
    private String comment;

    public Review() {}
    public Review(double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
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

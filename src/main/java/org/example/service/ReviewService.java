package org.example.service;

import org.example.dao.ReviewDAO;
import org.example.model.Product;
import org.example.model.Review;
import org.example.model.User;

import java.util.List;

public class ReviewService {
    private ReviewDAO reviewDAO;
    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public List<Review> getAllReviews() {
        return reviewDAO.getAll();
    }

    public List<Review> getAllProductReviews(Product product) {
        return reviewDAO.getReviewsByProduct(product);
    }

    public Review getReviewById(int id) {
        return reviewDAO.getById(id);
    }

    public void createReview(Review review, User user, Product product) {
        reviewDAO.create(review, user, product);
    }

    public void deleteReeview(int id) {
        reviewDAO.delete(id);
    }

    public void updateReview(Review review, int id) {
        reviewDAO.update(review, id);
    }

}

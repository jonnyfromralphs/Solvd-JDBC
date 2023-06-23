package org.example.service;

import org.example.mapper.ReviewMapper;
import org.example.model.Review;

import java.util.List;

public class ReviewBatisService {
    private ReviewMapper reviewMapper;

    public ReviewBatisService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public Review selectReviewById(int id) {
        return reviewMapper.selectReviewById(id);
    }

    public List<Review> getAllReviewsByProductId(int id) {
        return reviewMapper.getAllReviewsByProductId(id);
    }

    public void addReview(Review review) {
        reviewMapper.addReview(review);
    }

    public void deleteReview(int id) {
        reviewMapper.deleteReview(id);
    }

    public int getIdByReview(String comment) {
        return reviewMapper.getIdByReview(comment);
    }

    public void updateReview(Review review) {
        reviewMapper.updateReview(review);
    }
}

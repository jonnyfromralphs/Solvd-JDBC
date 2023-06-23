package org.example.mapper;

import org.example.model.Review;
import java.util.List;

public interface ReviewMapper {
    Review selectReviewById(int id);
    List<Review> getAllReviewsByProductId(int id);
    void addReview(Review review);
    void deleteReview(int id);
    int getIdByReview(String comment);
    void updateReview(Review review);
}

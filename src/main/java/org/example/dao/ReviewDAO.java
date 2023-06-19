package org.example.dao;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.Review;
import org.example.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO extends AbstractDAO<Review>{
    public ReviewDAO(Connection connection) {
        super(connection, "review");
    }

    @Override
    public Review mapResultSetToObject(ResultSet resultSet) throws SQLException {
        double rating = resultSet.getDouble("rating");
        String comment = resultSet.getString("comment");
        return new Review(rating, comment);
    }

    @Override
    public void create(Review review) {
        String query = "INSERT INTO review (rating, comment, product_id, user_id, user_cart_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setDouble(1, review.getRating());
            statement.setString(2, review.getComment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Review review, User user, Product product) {
        String query = "INSERT INTO review (rating, comment, product_id, user_id, user_cart_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setDouble(1, review.getRating());
            statement.setString(2, review.getComment());
            statement.setInt(3, new ProductDAO(getConnection()).getProductId(product));
            statement.setInt(4, new UserDAO(getConnection()).getUserId(user));
            statement.setInt(5, new UserDAO(getConnection()).getUserCartId(user));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Review review, int id) {
        String query = "UPDATE review SET rating = ?, comment = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setDouble(1, review.getRating());
            statement.setString(2, review.getComment());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviewsByProduct(Product product) {
        String query = "SELECT rating, comment FROM review WHERE product_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            int productId = new ProductDAO(getConnection()).getProductId(product);
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            List<Review> reviews = new ArrayList<>();
            while (resultSet.next()) {
                Review review = mapResultSetToObject(resultSet);
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

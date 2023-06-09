package org.example.dao;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.model.Review;
import org.example.model.User;

import java.sql.*;
import java.time.LocalDate;

public class ReviewDAO extends AbstractDAO<Review>{
    public ReviewDAO(Connection connection) {
        super(connection, "review");
    }

    @Override
    public Review mapResultSetToObject(ResultSet resultSet) throws SQLException {
        double rating = resultSet.getDouble("rating");
        String comment = resultSet.getString("comment");
        int productId = resultSet.getInt("product_id");
        int userId = resultSet.getInt("user_id");
        int cartId = resultSet.getInt("cart_id");
        Product product = new ProductDAO(getConnection()).getById(productId);
        User user = new UserDAO(getConnection()).getById(userId);
        Cart cart = new CartDAO(getConnection()).getById(cartId);
        return new Review(rating, comment, product, user, cart);
    }

    @Override
    public void create(Review review) {
        String query = "INSERT INTO review (rating, comment, product_id, user_id, user_cart_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setDouble(1, review.getRating());
            statement.setString(2, review.getComment());
            statement.setInt(3, new ProductDAO(getConnection()).getProductId(review.getProduct()));
            statement.setInt(4, new UserDAO(getConnection()).getUserId(review.getUser()));
            statement.setInt(5, new CartDAO(getConnection()).getAll().size() + 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Review review, int id) {

    }
}

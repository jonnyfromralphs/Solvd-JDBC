package org.example.dao;

import org.example.model.Cart;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

public class CartDAO extends AbstractDAO<Cart> {
    public CartDAO(Connection connection) {
        super(connection, "cart");
    }

    @Override
    public void create(Cart cart) {
        String query = "INSERT INTO cart (id, creation_date) VALUES (?. ?);";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, cart.getId());
            statement.setDate(2, Date.valueOf(cart.getCreationDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cart cart, int id) {
        String query = "UPDATE cart SET id = ?, creation_date = ?;";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setDate(2, Date.valueOf(cart.getCreationDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cart mapResultSetToObject(ResultSet resultSet) throws SQLException {
        LocalDate creationDate = resultSet.getDate("creation_date").toLocalDate();
        return new Cart(creationDate, new HashMap<>());
    }

}

package org.example.dao;

import org.example.model.Address;
import org.example.model.Cart;
import org.example.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class UserDAO extends AbstractDAO<User>{

    public UserDAO(Connection connection) {
        super(connection, "user");
    }

    public int getUserId(User user) {
        String query = "SELECT id FROM user WHERE username = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getUserIdByUsername(String username) {
        String query = "SELECT id FROM user WHERE username = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getUserCartId(User user) {
        String query = "SELECT cart_id FROM user WHERE username = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("cart_id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public User mapResultSetToObject(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        LocalDate registrationDate = resultSet.getDate("registration_date").toLocalDate();
        int cartId = resultSet.getInt("cart_id");
        Cart cart = new CartDAO(getConnection()).getById(cartId);
        List<Address> addresses = new AddressDAO(getConnection()).getAddressesByUser(username);
        return new User(username, email, password, registrationDate, cart, addresses);
    }

    @Override
    public void create(User user) {
        String query = "INSERT INTO user (username, email, password, registration_date, cart_id) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            int newCartId = new CartDAO(getConnection()).getAll().size() + 1;
            Cart newCart = new Cart(newCartId, LocalDate.now(), null);
            new CartDAO(getConnection()).create(newCart);
            statement.setInt(5, newCartId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user, int id) {
        String query = "UPDATE user SET username = ?, email = ?, password = ?, registration_date = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

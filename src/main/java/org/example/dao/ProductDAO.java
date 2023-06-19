package org.example.dao;

import org.example.model.Product;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends AbstractDAO<Product> {
    public ProductDAO(Connection connection) {
        super(connection, "product");
    }

    public int getProductId(Product product) {
        String query = "SELECT id FROM product WHERE name = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, product.getName());
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

    @Override
    public Product mapResultSetToObject(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        double price = resultSet.getDouble("price");
        int qty = resultSet.getInt("stock_quantity");
        return new Product(name, description, price, qty);
    }

    @Override
    public void create(Product product) {
        String query = "INSERT INTO product (name, description, price, stock_quantity) VALUES (?, ?, ? ,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product, int id) {
        String query = "UPDATE product SET name = ?, description = ?, price = ?, stock_quantity = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

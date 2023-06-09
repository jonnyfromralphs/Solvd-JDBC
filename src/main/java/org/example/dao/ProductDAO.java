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
            int id = statement.executeQuery().findColumn("id");
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Product mapResultSetToObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product, int id) {

    }
}

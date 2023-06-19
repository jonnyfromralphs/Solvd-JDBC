package org.example.dao;

import org.example.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends AbstractDAO<Category> {
    public CategoryDAO(Connection connection) {
        super(connection, "category");
    }

    @Override
    public Category mapResultSetToObject(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Category(name, description);
    }

    @Override
    public void create(Category category) {
        String query = "INSERT INTO category (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category, int id) {
        String query = "UPDATE category SET name = ?, description = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

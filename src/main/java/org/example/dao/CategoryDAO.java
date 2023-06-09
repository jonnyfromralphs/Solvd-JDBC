package org.example.dao;

import org.example.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends AbstractDAO<Category> {
    public CategoryDAO(Connection connection) {
        super(connection, "category");
    }

    @Override
    public Category mapResultSetToObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void create(Category object) {

    }

    @Override
    public void update(Category object, int id) {

    }
}

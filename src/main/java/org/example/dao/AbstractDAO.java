package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements IDAO<T>{
    private Connection connection;
    private String tableName;

    public AbstractDAO(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public T getById(int id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToObject(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        String query = "SELECT * FROM " + tableName + ";";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<T> objects = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println();
                objects.add(mapResultSetToObject(resultSet));
            }
            return objects;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract T mapResultSetToObject(ResultSet resultSet) throws SQLException;
}

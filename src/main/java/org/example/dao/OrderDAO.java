package org.example.dao;

import org.example.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends AbstractDAO<Order>{
    public OrderDAO(Connection connection) {
        super(connection, "order");
    }

    @Override
    public Order mapResultSetToObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void create(Order object) {

    }

    @Override
    public void update(Order object, int id) {

    }
}

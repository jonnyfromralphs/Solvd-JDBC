package org.example.dao;

import org.example.model.Address;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends AbstractDAO<Address> {
    public AddressDAO(Connection connection) {
        super(connection, "address");
    }

    @Override
    public Address mapResultSetToObject(ResultSet resultSet) throws SQLException {
        String addressLineOne = resultSet.getString("address_line1");
        String addressLineTwo = resultSet.getString("address_line2");
        String city = resultSet.getString("city");
        String state = resultSet.getString("state");
        String zipCode = resultSet.getString("zip_code");
        return new Address(addressLineOne, addressLineTwo, city, state, zipCode);
    }

    public List<Address> getAddressesByUser(String username) {
        String query = "SELECT address_line1, address_line2, city, state, zip_code FROM address AS a JOIN user_address AS ua ON a.id = ua.address_id" +
                " JOIN user AS u on ua.user_id = u.id" +
                " WHERE u.id = ?;";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, new UserDAO(getConnection()).getUserIdByUsername(username));
            ResultSet resultSet = statement.executeQuery();
            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()) {
                addresses.add(mapResultSetToObject(resultSet));
            }
            return addresses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void create(Address address) {
        String query = "INSERT INTO address (address_line1, address_line2, city, state, zip_code) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, address.getAddressLineOne());
            statement.setString(2, address.getAddressLineTwo());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getState());
            statement.setString(5, address.getZipCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAddressWithUser(Address address, User user) {
        create(address);
        String query = "INSERT INTO user_address (user_id, address_id) VALUES (?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, new UserDAO(getConnection()).getUserId(user));
            statement.setInt(2, getAddressId(address));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAddressId(Address address) {
        String query = "SELECT id FROM address WHERE address_line1 = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, address.getAddressLineOne());
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
    public void update(Address address, int id) {
        String query = "UPDATE address SET address_line1 = ?, address_line2 = ?, city = ?, state = ?, zip_code = ? WHERE id = ?;";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, address.getAddressLineOne());
            statement.setString(2, address.getAddressLineTwo());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getState());
            statement.setString(5, address.getZipCode());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

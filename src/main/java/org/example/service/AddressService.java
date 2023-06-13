package org.example.service;

import org.example.dao.AddressDAO;
import org.example.model.Address;
import org.example.model.User;

import java.util.List;

public class AddressService {
    private AddressDAO addressDAO;
    public AddressService(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public List<Address> getAllAddressesByUser(String username) {
        return addressDAO.getAddressesByUser(username);
    }

    public List<Address> getAllAddresses() {
        return addressDAO.getAll();
    }

    public void createAddressWithUser(Address address, User user) {
        addressDAO.createAddressWithUser(address, user);
    }

    public Address getAddressById(int id) {
        return addressDAO.getById(id);
    }

    public void updateAddress(Address address, int id) {
        addressDAO.update(address, id);
    }
}

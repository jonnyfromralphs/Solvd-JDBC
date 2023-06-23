package org.example.mapper;

import org.example.model.Address;

public interface AddressMapper {
    Address selectAddressById(int id);
    void addAddress(Address address);
    void addAddressForUser(int arg0, int arg1);
    void deleteAddress(int id);
    int getIdByAddress(String addressLine);
    void updateAddress(Address address);
}

package org.example.service;

import org.example.mapper.AddressMapper;
import org.example.model.Address;

public class AddressBatisService {
    private AddressMapper addressMapper;

    public AddressBatisService(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Address selectAddressById(int id) {
        return addressMapper.selectAddressById(id);
    }

    public void addAddress(Address address) {
        addressMapper.addAddress(address);
    }

    public void addAddressForUser(int arg0, int arg1) {
        addressMapper.addAddressForUser(arg0, arg1);
    }

    public void deleteAddress(int id) {
        addressMapper.deleteAddress(id);
    }

    public int getIdByAddress(String addressLine) {
        return addressMapper.getIdByAddress(addressLine);
    }

    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }
}

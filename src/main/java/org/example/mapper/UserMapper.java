package org.example.mapper;

import org.example.model.Address;
import org.example.model.User;
import java.util.List;

public interface UserMapper {
    User selectUserById(int id);
    User selectUserWithAddresses(int id);
    List<Address> selectUsersAddresses(int id);
    void addUser(User user);
    void deleteUser(int id);
    int getIdByUsername(String username);
    void updateUser(User user);
}

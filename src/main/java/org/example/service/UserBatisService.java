package org.example.service;

import org.example.mapper.UserMapper;
import org.example.model.Address;
import org.example.model.User;

import java.util.List;

public class UserBatisService {
    private UserMapper userMapper;
    public UserBatisService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    public User selectUserWithAddresses(int id) {
        return userMapper.selectUserWithAddresses(id);
    }

    public List<Address> selectUsersAddresses(int id) {
        return userMapper.selectUsersAddresses(id);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public int getIdByUsername(String username) {
        return userMapper.getIdByUsername(username);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

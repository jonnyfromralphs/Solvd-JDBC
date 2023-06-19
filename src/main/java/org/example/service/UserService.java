package org.example.service;

import org.example.dao.UserDAO;
import org.example.model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User getUserById(int id) {
        return userDAO.getById(id);
    }

    public void createUser(User user) {
        userDAO.create(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    public void updateUser(User user, int id) {
        userDAO.update(user, id);
    }

    public int getUserId(User user) {
        return userDAO.getUserId(user);
    }
}

package org.example;

import org.example.dao.AbstractDAO;
import org.example.dao.CartDAO;
import org.example.dao.UserDAO;
import org.example.model.Cart;
import org.example.service.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Connection connection;
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("src/main/resources/db.properties")));

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
            UserService userService = new UserService(new UserDAO(connection));
            userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

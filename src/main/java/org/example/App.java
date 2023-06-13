package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.service.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;
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

            User jonathan = new User("jt", "jt@gmail.com", "password", LocalDate.now(), null, null);
//            userService.createUser(jonathan);
//            int id = userService.getUserId(jonathan);
//            userService.deleteUser(id);
//
            ProductService productService = new ProductService(new ProductDAO(connection));
            Product iphone = new Product("Apple iPhone 15", "Apples latest iPhone", 1599.99, 100);
//            productService.createProduct(iphone);

            ReviewService reviewService = new ReviewService(new ReviewDAO(connection));
            Review reviewForIPhone = new Review(4.6, "good phone");
//            reviewService.createReview(reviewForIPhone, jonathan, iphone);
            List<Review> iPhoneReviews = reviewService.getAllProductReviews(iphone);
            iPhoneReviews.forEach(review -> System.out.println(review.getRating() + ": " + review.getComment()));

            AddressService addressService = new AddressService(new AddressDAO(connection));
            Address jonathansAddress = new Address("123 W St", "Apt 203", "Los Angeles", "California", "91203");
            Address jonathansAddress2 = new Address("122453 W St", "Apt 203", "Los Angeles", "California", "91203");
//            addressService.createAddressWithUser(jonathansAddress, jonathan);
//            addressService.createAddressWithUser(jonathansAddress2, jonathan);
            List<Address> jonathansAddresses = addressService.getAllAddressesByUser("jt");
            jonathansAddresses.forEach(address -> System.out.println(address.getAddressLineOne()));

            CategoryService categoryService = new CategoryService(new CategoryDAO(connection));
            Category category = new Category("Communication", "Technology used to communicate through said device");
            categoryService.createCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

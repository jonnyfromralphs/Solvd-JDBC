package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.*;
import org.example.model.*;
import org.example.service.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class MyBatisMain {

    public static void main(String[] args) {
        try (InputStream propsStream = Resources.getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(propsStream);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            props.setProperty("url", url);
            props.setProperty("username", username);
            props.setProperty("password", password);

            String xmlConfig = "mybatis-config.xml";

            try (InputStream inputStream = Resources.getResourceAsStream(xmlConfig);
                 SqlSession session = new SqlSessionFactoryBuilder().build(inputStream, props).openSession(true)) {

                UserBatisService userService = new UserBatisService(session.getMapper(UserMapper.class));
                User user = userService.selectUserById(1);
                User newUser = new User("Gary11", "gary11@gmail.com", "password", LocalDate.now(), null, null);
                userService.addUser(newUser);
                user.setUsername("newJt103");
                userService.updateUser(user);

                AddressBatisService addressService = new AddressBatisService(session.getMapper(AddressMapper.class));
                Address address = new Address("543 W St", "Apt 700", "Los Angeles", "CA", "01093");
                addressService.addAddress(address);
                addressService.addAddressForUser(5, 2);
                List<Address> garysAddresses = userService.selectUsersAddresses(5);

                ProductBatisService productService = new ProductBatisService(session.getMapper(ProductMapper.class));
                Product iphone = new Product("Apple iPhone 15", "Apples latest iPhone", 1599.99, 100);
                productService.addProduct(iphone);

                ReviewBatisService reviewService = new ReviewBatisService(session.getMapper(ReviewMapper.class));
                Review reviewForIPhone = new Review(0, 4.6, "good phone", 1);
                Review reviewForIPhoneTwo = new Review(0, 2.9, "bad phone", 1);
                reviewService.addReview(reviewForIPhone);
                reviewService.addReview(reviewForIPhoneTwo);
                List<Review> reviewsForIPhone = reviewService.getAllReviewsByProductId(1);

                CategoryBatisService categoryService = new CategoryBatisService(session.getMapper(CategoryMapper.class));
                Category category = new Category("Communication", "Technology used to communicate through said device");
                categoryService.addCategory(category);
                categoryService.deleteCategory(1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

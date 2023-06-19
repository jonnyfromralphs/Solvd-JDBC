package org.example.model;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private LocalDate registration_date;
    private Cart cart;
    private List<Address> addresses;

    public User(String username, String email, String password, LocalDate registration_date, Cart cart, List<Address> addresses) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
        this.cart = cart;
        this.addresses = addresses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

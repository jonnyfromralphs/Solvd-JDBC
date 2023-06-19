package org.example.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private int id;
    private LocalDate creationDate;
    private HashMap<Product, Integer> cartItems;

    public Cart(int id, LocalDate creationDate, HashMap<Product, Integer> cartItems) {
        this.id = id;
        this.creationDate = creationDate;
        this.cartItems = cartItems;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public HashMap<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Product, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

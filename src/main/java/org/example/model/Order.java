package org.example.model;

import java.time.LocalDate;

public class Order {
    private LocalDate orderDate;
    private double totalAmount;
    private Cart cart;


    public Order(LocalDate orderDate, double totalAmount, Cart cart, User user) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.cart = cart;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

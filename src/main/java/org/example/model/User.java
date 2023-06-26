package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.example.jacksonService.LocalDateDeserializer;
import org.example.xmlService.LocalDateAdapter;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @JsonProperty("username")
    @XmlElement(name="username")
    private String username;
    @JsonProperty("email")
    @XmlElement(name="email")
    private String email;
    @JsonProperty("password")
    @XmlElement(name="password")
    private String password;
    @JsonProperty("registration_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @XmlElement(name="registration_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate registrationDate;
    @JsonIgnore
    private Cart cart;

    @JsonIgnore
    @XmlElementWrapper(name="addresses")
    @XmlElement(name="address")
    private List<Address> addresses;

    public User(String username, String email, String password, LocalDate registration_date, Cart cart, List<Address> addresses) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registration_date;
        this.cart = cart;
        this.addresses = addresses;
    }

    public User() {}

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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
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

package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @JsonProperty("address_line1")
    @XmlElement(name="address_line1")
    private String addressLineOne;
    @JsonProperty("address_line2")
    @XmlElement(name="address_line2")
    private String addressLineTwo;
    @JsonProperty("city")
    @XmlElement(name="city")
    private String city;
    @JsonProperty("state")
    @XmlElement(name="state")
    private String state;
    @JsonProperty("zip_code")
    @XmlElement(name="zip_code")
    private String zipCode;

    public Address() {}

    public Address(String addressLineOne, String addressLineTwo, String city, String state, String zipCode) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

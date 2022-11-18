package com.music.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="addressId")
    private int addressId;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="district")
    private String district;
    @Column(name="pinCode")
    private int pinCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    /*@JoinTable(
            name="music.user_address",
            joinColumns= @JoinColumn(name="addressId")
    )*/


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

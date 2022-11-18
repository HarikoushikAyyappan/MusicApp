package com.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserForm {
    @Id
    @Column(name="formId")
    private int formId;
    @Column(name="userId")
    private int userId;
    @Column(name="userName")
    private String userName;
    @Column(name="role")
    private String role;
    @Column(name="password")
    private String password;
    @Column(name="faddressId")
    private int faddressId;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="district")
    private String district;
    @Column(name="pinCode")
    private int pinCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFaddressId() {
        return faddressId;
    }

    public void setFaddressId(int faddressId) {
        this.faddressId = faddressId;
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
}

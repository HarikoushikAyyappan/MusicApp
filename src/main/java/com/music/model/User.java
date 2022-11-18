package com.music.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="userId")
    private int userId;
    @Column(name="userName")
    private String userName;
    @Column(name="role")
    private String role;
    @Column(name="password")
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addressList;
    /*@JoinTable(
            name="music.user_address",
            joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="addressId"))
    @LazyCollection(LazyCollectionOption.FALSE)*/

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @OneToOne
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

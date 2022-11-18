package com.music.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @Column(name="basketId")
    private int basketId;
    @OneToOne
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private Set <Song> songList;

    public Set<Song> getSongList() {
        return songList;
    }

    public void setSongList(Set<Song> songList) {
        this.songList = songList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }
}

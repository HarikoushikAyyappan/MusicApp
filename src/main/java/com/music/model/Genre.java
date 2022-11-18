package com.music.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="genre")
public class Genre {
    @Id
    @Column(name="genreId")
    private int genreId;
    @Column(name="genreName")
    private String genreName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="music.genre_song",
            joinColumns = @JoinColumn(name="genreId"),
            inverseJoinColumns = @JoinColumn(name="songId"))
            public Set<Song> songList;

    public Set<Song> getSongList() {
        return songList;
    }

    public void setSongList(Set<Song> songList) {
        this.songList = songList;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}

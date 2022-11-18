package com.music.model;

import javax.persistence.*;

@Entity
@Table(name="song")
public class Song {
    @Id
    @Column(name="songId")
    private int songId;
    @Column(name="songName")
    private String songName;
    @Column(name="downloads")
    private int downloads;
    private String block;

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @ManyToOne
    @JoinTable(
            name="music.song_duration",
            joinColumns= @JoinColumn(name="songId")
    )
    private Duration duration;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name="music.genre_song",
            joinColumns= @JoinColumn(name="songId")
    )
    private Genre genre;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

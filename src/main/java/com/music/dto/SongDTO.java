package com.music.dto;

import com.music.model.Genre;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class SongDTO {
    private int songId;
    private String songName;
    private int downloads;
    @OneToMany
    private List<Genre> genre;

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
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

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }
}

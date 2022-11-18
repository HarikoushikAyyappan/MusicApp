package com.music.dto;

import com.music.model.Song;

import java.util.List;

public class DurationDTO {

    private int durationId;

    private float timeDuration;

    private List<Song> songs ;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getDurationId() {
        return durationId;
    }

    public void setDurationId(int durationId) {
        this.durationId = durationId;
    }

    public float getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(float timeDuration) {
        this.timeDuration = timeDuration;
    }
}

package com.music.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="duration")
public class Duration {
    @Id
    @Column(name="durationId")
    private int durationId;
    @Column(name="timeDuration")
    private float timeDuration;
    @OneToMany
    @JoinTable(
            name="music.song_duration",
            joinColumns = @JoinColumn(name="durationId"),
            inverseJoinColumns = @JoinColumn(name="songId"))
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

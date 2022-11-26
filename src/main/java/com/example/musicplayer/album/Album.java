package com.example.musicplayer.album;

import com.example.musicplayer.artist.Artist;
import com.example.musicplayer.song.Song;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer releaseDate;
    @ManyToOne
    @JsonIgnore
    private Artist artist;
    @OneToMany(cascade = CascadeType.REMOVE)
    private final List<Song> songList = new ArrayList<>();

    public Album(String name, Integer releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }
}

package com.example.musicplayer.song;

import com.example.musicplayer.album.Album;
import com.example.musicplayer.artist.Artist;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
   /* @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist; */
    @ManyToOne
    @JsonIgnore
    private Album album;

    public Song(String name) {
        this.name = name;
    }
}

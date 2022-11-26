package com.example.musicplayer.artist;

import com.example.musicplayer.album.Album;
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
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String genre;
    @OneToMany(cascade = CascadeType.REMOVE)
    private final List<Album> albumList = new ArrayList<>();

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}

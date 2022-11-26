package com.example.musicplayer.song;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("{id}")
    Song getSong(@PathVariable Integer id) {
        return songService.getSong(id);
    }

    @PostMapping("{id}")
    Song postSong(@PathVariable Integer id, @RequestBody Song song) {
        return songService.postSong(id, song);
    }

    @PutMapping("{id}")
    Song updateSong(@PathVariable Integer id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("{id}")
    void deleteSong(@PathVariable Integer id) {
        songService.deleteSong(id);
    }
}

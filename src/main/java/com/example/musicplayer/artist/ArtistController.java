package com.example.musicplayer.artist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @GetMapping("{id}")
    Artist getArtist(@PathVariable Integer id) {
        return artistService.getArtist(id);
    }

    @PostMapping
    Artist postArtist(@RequestBody Artist artist) {
        return artistService.postArtist(artist);
    }

    @PutMapping("{id}")
    Artist updateArtist(@PathVariable Integer id, @RequestBody Artist artist) {
        return artistService.updateArtist(id, artist);
    }

    @DeleteMapping("{id}")
    void deleteArtist(@PathVariable Integer id) {
        artistService.deleteArtist(id);
    }
}

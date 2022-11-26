package com.example.musicplayer.album;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @GetMapping("{id}")
    Album getAlbum(@PathVariable Integer id) {
        return albumService.getAlbum(id);
    }

    @PostMapping("{id}")
    Album postAlbum(@PathVariable Integer id, @RequestBody Album album) {
        return albumService.postAlbum(id, album);
    }

    @PutMapping("{id}")
    Album updateAlbum(@PathVariable Integer id, @RequestBody Album album) {
        return albumService.updateAlbum(id, album);
    }

    @DeleteMapping("{id}")
    void deleteAlbum(@PathVariable Integer id) {
        albumService.deleteAlbum(id);
    }
}

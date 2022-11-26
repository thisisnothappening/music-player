package com.example.musicplayer.album;

import com.example.musicplayer.artist.ArtistService;
import com.example.musicplayer.exception.AlbumNotFoundException;
import com.example.musicplayer.exception.ArtistNotFoundException;
import com.example.musicplayer.exception.NullFieldException;
import com.example.musicplayer.song.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;

    public AlbumService(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbum(Integer id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album not found"));
    }

    public Album postAlbum(Integer id, Album album) {
        if (album.getName() == null || album.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        if (!artistService.existsById(id)) {
            throw new ArtistNotFoundException("Artist not found");
        }
        albumRepository.save(album);
        artistService.addAlbum(id, album);
        return albumRepository.save(album);
    }

    public void addSong(Integer id, Song song) {
        Album album = getAlbum(id);
        album.getSongList().add(song);
        albumRepository.save(album);
        song.setAlbum(album);
    }

    public boolean existsById(Integer id) {
        return albumRepository.existsById(id);
    }

    public Album updateAlbum(Integer id, Album album) {
        if (album.getName() == null || album.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        Album existingAlbum = getAlbum(id);
        existingAlbum.setName(album.getName());
        existingAlbum.setReleaseDate(album.getReleaseDate());
        return albumRepository.save(existingAlbum);
    }

    public void deleteAlbum(Integer id) {
        albumRepository.delete(getAlbum(id));
    }
}

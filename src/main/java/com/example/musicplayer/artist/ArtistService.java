package com.example.musicplayer.artist;

import com.example.musicplayer.album.Album;
import com.example.musicplayer.album.AlbumService;
import com.example.musicplayer.exception.ArtistNameTakenException;
import com.example.musicplayer.exception.ArtistNotFoundException;
import com.example.musicplayer.exception.NullFieldException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtist(Integer id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException("Artist not found"));
    }

    public Artist postArtist(Artist artist) {
        if (artist.getName() == null || artist.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        if (artistRepository.existsByName(artist.getName())) {
            throw new ArtistNameTakenException("This name is already taken");
        }
        return artistRepository.save(artist);
    }

    public void addAlbum(Integer id, Album album) {
        Artist artist = getArtist(id);
        artist.getAlbumList().add(album);
        artistRepository.save(artist);
        album.setArtist(artist);
    }

    public boolean existsById(Integer id) {
        return artistRepository.existsById(id);
    }

    public Artist updateArtist(Integer id, Artist artist) {
        if (artist.getName() == null || artist.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        if (artistRepository.existsByName(artist.getName())) {
            throw new ArtistNameTakenException("This name is already taken");
        }
        Artist existingArtist = getArtist(id);
        existingArtist.setName(artist.getName());
        existingArtist.setGenre(artist.getGenre());
        return artistRepository.save(existingArtist);
    }

    public void deleteArtist(Integer id) {
        artistRepository.delete(getArtist(id));
    }
}

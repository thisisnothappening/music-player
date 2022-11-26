package com.example.musicplayer.song;

import com.example.musicplayer.album.AlbumService;
import com.example.musicplayer.exception.AlbumNotFoundException;
import com.example.musicplayer.exception.NullFieldException;
import com.example.musicplayer.exception.SongNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumService albumService;

    public SongService(SongRepository songRepository, AlbumService albumService) {
        this.songRepository = songRepository;
        this.albumService = albumService;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public Song getSong(Integer id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song not found"));
    }

    public Song postSong(Integer id, Song song) {
        if (song.getName() == null || song.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        if (!albumService.existsById(id)) {
            throw new AlbumNotFoundException("Album not found");
        }
        songRepository.save(song);
        albumService.addSong(id, song);
        return songRepository.save(song);
    }

    public Song updateSong(Integer id, Song song) {
        if (song.getName() == null || song.getName().trim().length() < 1) {
            throw new NullFieldException("Field cannot be null");
        }
        Song existingSong = getSong(id);
        existingSong.setName(song.getName());
        return songRepository.save(existingSong);
    }

    public void deleteSong(Integer id) {
        songRepository.delete(getSong(id));
    }
}

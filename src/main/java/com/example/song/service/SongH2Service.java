package com.example.song.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;
import com.example.song.repository.SongRepository;

@Service
public class SongH2Service implements SongRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs() {
        return (ArrayList<Song>) db.query("select * from PLAYLIST", new SongRowMapper());
    }

    @Override
    public Song addSong(Song song) {
        db.update("insert into playlist(songName, lyricist, singer, musicDirector) values (?,?,?,?)",
                song.getSongName(),
                song.getLyricist(), song.getSinger(), song.getMusicDirector());
        return db.queryForObject(
                "Select * from playlist where songName = ? and lyricist = ? and singer = ? and musicDirector = ?",
                new SongRowMapper(), song.getSongName(),
                song.getLyricist(), song.getSinger(), song.getMusicDirector());
    }

    @Override
    public Song getSongById(int songId) {
        try {
            return db.queryForObject("Select * from playlist where songId = ?", new SongRowMapper(), songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updateSong(int id, Song song) {
        if (song.getSongName() != null) {
            db.update("UPDATE playlist SET songName = ? WHERE songId = ?", song.getSongName(), id);
        }
        if (song.getLyricist() != null) {
            db.update("UPDATE playlist SET lyricist = ? WHERE songId = ?", song.getLyricist(), id);
        }
        if (song.getSinger() != null) {
            db.update("UPDATE playlist SET singer = ? WHERE songId = ?", song.getSinger(), id);
        }
        if (song.getMusicDirector() != null) {
            db.update("UPDATE playlist SET musicDirector = ? WHERE songId = ?", song.getMusicDirector(), id);
        }
        return getSongById(id);
    }

    @Override
    public void deleteSong(int id) {
        db.update("delete from playlist where songId = ?", id);
    }

}

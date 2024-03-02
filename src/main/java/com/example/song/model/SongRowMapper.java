package com.example.song.model;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {

    @Override
    @Nullable
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Song(rs.getInt("songId"),
                rs.getString("songName"),
                rs.getString("lyricist"),
                rs.getString("singer"),
                rs.getString("musicDirector"));
    }
}

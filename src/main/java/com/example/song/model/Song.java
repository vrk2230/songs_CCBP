package com.example.song.model;

public class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public Song() {
    }

    /**
     * @return int return the songId
     */
    public int getSongId() {
        return songId;
    }

    /**
     * @param songId the songId to set
     */
    public void setSongId(int songId) {
        this.songId = songId;
    }

    /**
     * @return String return the songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName the songName to set
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return String return the lyricist
     */
    public String getLyricist() {
        return lyricist;
    }

    /**
     * @param lyricist the lyricist to set
     */
    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    /**
     * @return String return the singer
     */
    public String getSinger() {
        return singer;
    }

    /**
     * @param singer the singer to set
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * @return String return the musicDirector
     */
    public String getMusicDirector() {
        return musicDirector;
    }

    /**
     * @param musicDirector the musicDirector to set
     */
    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

}

package com.company;

/**
 * a class that holds details of a track
 */
public class Track {
    private String trackName;
    private int time; //second
    private String album;
    private String singer;
    private int year;
    private boolean isFavorite;

    /**
     * create a track and set its name and singers name and release year to given parameters
     * @param trackName
     * @param singer
     * @param year
     */
    public Track(String trackName,String singer,int year){
        if (year < 1000)
            year += 2000;
        this.singer = singer;
        this.trackName = trackName;
        this.year = year;
        this.album = "unknown";
        this.time = 180;
        this.isFavorite = false;
    }

    /**
     * get the name of a track
     * @return
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * get the time length of a track
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     * get the album
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     * get the singers name
     * @return
     */
    public String getSinger() {
        return singer;
    }

    /**
     * get the release year
     * @return
     */

    public int getYear() {
        return year;
    }

    /**
     * set the album
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * set duration
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     *if the track is in favorite return true
     * else returns false
     * @return
     */
    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * set isfavorite field of the track
     * @param favorite
     */
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    /**
     * print information of the track
     */
    public void print(){
        System.out.println("-----------------------");
        if (isFavorite)
            System.out.println("IN FAVORITE");
        System.out.println("Album : " + album);
        System.out.println("Singer : " + singer);
        System.out.println("Song : " + trackName);
        System.out.println("Release : " + year);
        System.out.println("-----------------------");
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Track> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<Track>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param track The file to be added.
     */
    public void addFile(Track track)
    {
        boolean isRepeated = isRepeated(track);
        if(isRepeated == false)
            files.add(track);
        else
            System.out.println("This track has been added before!");
    }

    /**
     * creates a track with given parameters then add it to collection
     * @param name
     * @param singer
     * @param year
     */
    public void addFile(String name,String singer,int year)
    {
        Track track = new Track(name,singer,year);
        files.add(track);
    }

    /**
     * searches the collection
     * if finds a file similar to track returns true
     * else returns false
     * @param track
     * @return
     */
    private boolean isRepeated(Track track){
        for (Track tr : files)
            if (tr.equals(track))
                return true;
        return false;
    }
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        files.get(index).print();
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        int i = 1;
        for (Track track: files){
            System.out.print((i++) + ") ");
            track.print();
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        Track track = files.get(index);
        Iterator<Track> it = files.iterator();
        while (it.hasNext()){
            Track k = it.next();
            if (k.equals(track)){
                it.remove();
            }
        }

    }

    /**
     * search tracks names to find tracks which their names include given string
     * print those tracks
     * @param name
     */
    public void searchInName(String name)
    {
        int num = 0;
        System.out.println("Result of searching " + name + " in tracks");
        Iterator<Track> it = files.iterator();
        while (it.hasNext()){
            Track k = it.next();
            if (k.getTrackName().toLowerCase().contains(name.toLowerCase())){
                k.print();
                num = 1;
            }
        }
        if (num == 0)
            System.out.println("no result :(");
    }
    /**
     * search singers to find tracks which their singer names include given string
     * print those tracks
     * @param name
     */
    public void searchInSinger(String name)
    {
        int num = 0;
        System.out.println("Result of searching " + name + " in singers");
        Iterator<Track> it = files.iterator();
        while (it.hasNext()){
            Track k = it.next();
            if (k.getSinger().toLowerCase().contains(name.toLowerCase())){
                k.print();
                num = 1;
            }
        }
        if (num == 0)
            System.out.println("no result :(");
    } /**
 * search tracks  to find tracks which their names or singer names include given string
 * print those tracks
 * @param name
 */
public void searchAll(String name)
{
    int num = 0;
    System.out.println("Result of searching " + name );
    Iterator<Track> it = files.iterator();
    while (it.hasNext()){
        Track k = it.next();
        if (k.getTrackName().toLowerCase().contains(name.toLowerCase()) || k.getSinger().toLowerCase().contains(name.toLowerCase())){
            k.print();
            num = 1;
        }
    }
    if (num == 0){
        System.out.println("no result :(");
    }
}

    /**
     * get a track of collection by its index
     * @param index
     * @return
     */
    public Track getTrack(int index){
        return files.get(index);

    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        player.startPlaying(getTrack(index - 1).getTrackName());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    public boolean validIndex(int index)
    {
        if (index < 1 || index > files.size())
            return false;
        else
            return true;

    }

    /**
     * get the last track of collection
     * @return
     */
    public Track lastTrack(){
        // files.get(files.size() - 1).print();
        return files.get(files.size() - 1);
    }
}

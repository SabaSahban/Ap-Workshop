package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {

        MusicCollection jazz = new MusicCollection();
        MusicCollection pop = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        MusicCollection favorite = new MusicCollection();
        MusicCollection allTracks = new MusicCollection();
        jazz.addFile("hi", "hi", 2002);
        allTracks.addFile(jazz.lastTrack());
        jazz.addFile("bye", "bye", 2009);
        allTracks.addFile(jazz.lastTrack());
        jazz.addFile("salam", "salam", 2010);
        allTracks.addFile(jazz.lastTrack());
        jazz.addFile("hava", "sal", 2000);
        allTracks.addFile(jazz.lastTrack());
        jazz.listAllFiles();
        jazz.removeFile(1);
        jazz.listAllFiles();
        favorite.addFile(jazz.getTrack(1));
        jazz.searchAll("h");
    }

}

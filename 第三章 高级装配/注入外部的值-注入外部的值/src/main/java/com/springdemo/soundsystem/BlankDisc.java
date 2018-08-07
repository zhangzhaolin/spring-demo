package com.springdemo.soundsystem;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title , String artist) {
        this.title = title;
        this.artist = artist;
        this.play();
    }

    public void play() {
        System.out.println("title : " + title + " artist : " + artist);
    }


}

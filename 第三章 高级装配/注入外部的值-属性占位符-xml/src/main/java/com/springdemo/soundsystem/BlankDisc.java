package com.springdemo.soundsystem;

import javax.annotation.Resource;

public class BlankDisc implements CompactDisc {

    @Resource
    private String title;
    private String artist;

    public BlankDisc(String title , String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("title : " + title + " artist : " + artist);
    }


}

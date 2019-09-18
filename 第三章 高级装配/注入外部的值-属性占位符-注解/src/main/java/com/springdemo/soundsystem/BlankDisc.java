package com.springdemo.soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/app.properties")
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(
            @Value("${disc.title}") String title,
            @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("title : " + title + " artist : " + artist);
    }


}

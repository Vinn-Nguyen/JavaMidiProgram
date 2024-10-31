/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: Manages the linkedlist melody and stores all the music files 
 */

package com.sound_game;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class LinkedListMelodyManager extends MelodyManager implements Drawable{

    //get the files
    static FileSystem sys = FileSystems.getDefault();
    static String prependPath = "mid" + sys.getSeparator();
    static String apprendType = ".mid" + sys.getSeparator();

    //stores the file
    String[] files = {"motive1am", "motive2am", "motive3am", "motive1E", "motive2E", "motive3E"};

    //super class for linkedlist
    LinkedListMelodyManager(){
        super();
    }

    //setup
    void setup(){
        for(int i = 0; i<files.length; i++){
            addMidiFile(prependPath+files[i]+apprendType);
        }
    }

    //file size
    int size(){
        return files.length;
    }

    //plays the melodies
    public void draw(){
        playMelodies();
    }
}

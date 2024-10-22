package com.sound_game;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class LinkedListMelodyManager extends MelodyManager implements Drawable{

    static FileSystem sys = FileSystems.getDefault();
    static String prependPath = "mid" + sys.getSeparator();
    static String apprendType = ".mid" + sys.getSeparator();

    String[] files = {"motive1am", "motive2am", "motive3am",
"motive1E", "motive2E", "motive3E"};

    LinkedListMelodyManager(){
        super();
    }

    void setup(){
        for(int i = 0; i<files.length; i++){
            addMidiFile(prependPath+files[i]+apprendType);
        }
    }

    int size(){
        return files.length;
    }

    public void draw(){
        playMelodies();
    }

}

package com.sound_game;

public class LinkedListMelody implements Drawable{
    public void draw(){
        //fill in to play melody
    }

    MelodyNode curPlayingNode = null; //initialize
    public void start(){
        if(head != null){
            curPlayingNode = head;
            head.start();
        }
    }

    //play each node in the list
    public void play(){
        //check if curPlayingNode is null
        //check if curPlayingNode is at the end of playing --atEnd();
        //if so, play the enext node unless it is null
    }
}

/*
 * This is the super class for the LinkedList
 */

package com.sound_game;

import processing.core.PApplet;

public abstract class MelodyButton extends Button{
    LinkedListMelody melody;

    //overload the constructor for default sizes 150 x 25
    MelodyButton(PApplet main_, LinkedListMelody melody, String label_,float x_, float y_)
    {
        super(main_, label_, x_, y_); 
    }
}

//play button extends melody button
class PlayButton extends MelodyButton{
    //overload the constructor for default sizes 150 x 25
    PlayButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Play", x_, y_); 
    }
    
    //start melody
    public void onPress(){
        melody.start();
    } 
}



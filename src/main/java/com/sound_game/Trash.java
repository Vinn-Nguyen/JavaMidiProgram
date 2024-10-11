/*
 Name: Wren Nguyen
 Date: 9.23.2024
 Description: Information for the trash object is stored here. Trash is white and drawn as circles.
 */

package com.sound_game;
import processing.core.*;

public class Trash extends NPC{ //inherits from NPC
    Trash(PApplet main_){
        super(main_, 50, main_.color(255,255,255), 2);
    }

    void szChange(){ //makes the size bigger
        sz = 70;
    }
}
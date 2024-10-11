/*
 Name: Wren Nguyen
 Date: 9.23.2024
 Description: Information for the trash object is stored here. Trash is white and drawn as circles.
 Reduces health to 1.
 */

package com.sound_game;
import processing.core.*;

public class Trash extends NPC{ //inherits from NPC
    Trash(App main_){
        super(main_, 50, main_.color(255,255,255), CIRC);
    }

    //play "trash" midi file
    void collision(Avatar avatar){
        super.collision(avatar, App.TRASH_MIDI);
    }
}
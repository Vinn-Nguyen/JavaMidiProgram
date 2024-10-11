/*
 Name: Wren Nguyen
 Date: Oct.2024
 Description: Information for the food object is stored here. Food are green circles, increase health by 1.
 */

package com.sound_game;
import processing.core.*;

public class Food extends NPC{ //inherits from NPC

    Food(App main_){
        super(main_, 20, main_.color(0, 255,0), CIRC);
    }

    //play "food" midi file
    void collision(Avatar avatar){
        int whichSound = (int) main.random(App.FOODSTART_MIDI,App.FOODEND_MIDI);

        super.collision(avatar, whichSound);
    }
}

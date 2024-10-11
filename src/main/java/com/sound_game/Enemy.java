/*
 Name: Wren Nguyen
 Date: Oct.2024
 Description: Information for the enemy objects is stored here. Enemy are red squares. Reduce health by 1.
 */

package com.sound_game;
import processing.core.*;

public class Enemy extends NPC{ //inherits from NPC
    Enemy(App main_){
        super(main_,60, main_.color(255,0,0), RECT);
    }

    //play "enemy" midi file
    void collision(Avatar avatar){
        super.collision(avatar, App.ENEMY_MIDI);
    }
}

/*
 Name: Wren Nguyen
 Date: Oct.2024
 Description: Information for the enemy objects is stored here. Enemy are
 */

package com.sound_game;
import processing.core.*;

public class Enemy extends NPC{ //inherits from NPC
    Enemy(PApplet main_){
        super(main_,60, main_.color(255,0,0), 1);
    }

    //changes from squares to circles
    void shapeChange(){
        shapeType = 2;
    }
}

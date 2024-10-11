/*
 Name: Wren Nguyen
 Date: Oct.2024
 Description: GameEnd is the end state when the player loses.
 */

package com.sound_game;
import processing.core.*;

public class GameEndController extends GameController{
    GameEndController(App main_){
        super(main_);
    }

    public void draw(){ //Gameover end screen
        main.background(0);
        main.fill(255);
        main.text("Game Over", (main.width/2)-50, (main.height/2));
        main.text("Press spacebar to replay the game", (main.width/2)-75, (main.height/2)+15);
    }

    public void keyPressed(){ //when ' ' is pressed on GameEnd, will reset to GamePlay
        if(main.key == ' '){
            nextController = GameController.GAME_PLAY; 
        }
    }
}

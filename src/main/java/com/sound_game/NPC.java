/*
 Name: Wren Nguyen
 Date: 9.22.2024
 Description: Superclass for the interactive shapes (NPCs) within the Particle Engine
 */

package com.sound_game;
import processing.core.*;

public class NPC extends Shapes{ //inherits from Shapes
    //call objects
    Food food;
    Enemy enemy;
    Trash trash;

    NPC(PApplet main_, float sz_, int color_, int shapeType_){  //NPC container
        super(main_, sz_, color_, shapeType_);
        spawn();
        move();
        reverse();
    }

    void spawn(){  //spawns the shape in a random location at a random speed
        //random x and y
        x = main.random(sz, main.width - sz - 2);
        y = main.random(sz , main.height - sz - 2);

        //random speed
        speedX = main.random(-3, 3);
        speedY = main.random(-3, 3);
    }

    void reverse(){ //bounce
        speedX = speedX * -1;
        speedY = speedY * -1;
    }

    void collision(Shapes shapes){ //when there is a collision, the shape will spawn at a different location
        if(isHit(shapes)){
            spawn();
        }
    }

    void enemyCollision(Enemy enemy){ //when there is a collision between NPCs, the shape will bounce
        if(isHit(enemy)){
            reverse();
        }
    }

    void move(){ //move function
        half = sz/2; //half the size
        y = y + speedY; //movement of Y
        x = x + speedX; //movement of X

        //allows shapes to bounce off the left and right of screen
        if(x - half < 0 || x + half > main.width){
            speedX = speedX * -1;
        }
        //allows shapes to bounce off the top and bottom of screen
        if(y - half < 0 || y + half > main.height){
            speedY = speedY * -1;
        }
    }

    void keyPressed(){ //activate the keypressed from the objects
        food.colorChange();
        enemy.shapeChange();
        trash.szChange();
    }
}
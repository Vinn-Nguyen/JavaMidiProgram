/*
 Name: Wren Nguyen
 Date: Oct.2024
 Description: Information for the avatar object is stored here. Avatar is a cat.
 */

package com.sound_game;
import processing.core.PApplet;

public class Avatar extends Shapes {
    int health = 10; //health

    Avatar(PApplet main_){ //avatar container
        super(main_,45, main_.color(0, 0, 255), 3);
        //sprite = main_.getSprite();
        x = main.width/2;
        y = main.height/2;
    }

    void setStart(float x_, float y_){ //start in the center of the screen
        x = x_;
        y = y_;
    }

    void display(){ //display custom sprite
        main.imageMode(PApplet.CENTER);
        main.image(sprite, x, y);
    }

    void collision(Shapes shapes){ //increase/decrease/reset health when interacting with NPCs
        hit = isHit(shapes);
        if(hit){
            if(shapes instanceof Food){ //food instance +1
                health++;
                PApplet.println("Increase! HP:" + health);
            }
            else if(shapes instanceof Enemy){ //enemy instance -1
                health--;
                PApplet.println("Decrease! HP:" + health);
            }
            else if(shapes instanceof Trash){
                health = 1; //reset health to 1
                PApplet.println("Gone! HP:" + health);
            }
        }
    }

    //check HP
    float getHealth(){
        return health;
    }
}

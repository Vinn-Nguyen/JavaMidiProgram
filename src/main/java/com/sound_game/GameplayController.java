/*
 Name: Wren Nguyen
 Date: 9.23.2024
 Description: This object controlls all the shapes and everything relating to it.
 */

package com.sound_game;
import java.util.ArrayList;
import processing.core.*;

public class GameplayController extends GameController {
    //declare other classes
    Shapes shapes;
    NPC npc;
    Avatar avatar;
    Enemy enemies;
    Food foods;

    //declare arraylists
    ArrayList<Shapes> gameObjects;
    ArrayList<NPC> npcs;

    ArrayList<Food> food; //array list for multiple food objects
    int foodCount = 15; //number of food objects
    
    ArrayList<Enemy> enemy; //array list for multiple enemy objects
    int enemyCount = 4; //number of enemy objects

    ArrayList<Trash> trash; //array list fro muliple trash objects
    int trashCount = 3;


    GameplayController(PApplet main_){
        super(main_);
        init(); //call to initalize
    }

    public void init(){  //initalize the game objects
        //init the classes
        avatar = new Avatar(main);
        food = new ArrayList<>();
        enemy = new ArrayList<>();
        trash = new ArrayList<>();
        
        //loops that create the objects
        for(int i =0; i < foodCount; i++){
            food.add(new Food(main));
        }
        for(int i =0; i < enemyCount; i++){
            enemies = new Enemy(main);
            enemy.add(new Enemy(main));
        }
        for(int i = 0; i < trashCount; i++){
            trash.add(new Trash(main));
        }

        //init the npcs
        npcs = new ArrayList<>();
        npcs.addAll(food);
        npcs.addAll(enemy);
        npcs.addAll(trash);

        //init the gameObjects (shapes)
        gameObjects = new ArrayList<>();
        gameObjects.add(avatar);
        gameObjects.addAll(npcs);
    }

    
    public void draw(){ //animate game objects
        //background
        main.background(0);

        //functions
        display(); 
        collisions();
        move();

        //check if game should stop -- if health <0
        if (avatar.getHealth() <= 0){
            nextController = GameController.GAME_END; //switch
        }
    }

    
    public void display(){ //display all game objects
        avatar.display(); 

        //loops display the multiple objects of the food and enemy objects
        for(int i =0; i < gameObjects.size(); i++){
            gameObjects.get(i).display();
        }
    }
    
    void move(){ //allows NPCs to move around the screen
        for(int i =0; i < enemyCount; i++){
            enemy.get(i).move();
            enemy.get(i).enemyCollision(enemies);
        }
        for(int i = 0; i < foodCount; i++){
            food.get(i).move();
        }
        for(int i = 0; i < trashCount; i++){
            trash.get(i).move();
        }
    }

    public void collisions(){ //collisions of all the objects
        //collision between avatar and npcs
        for(int i =0; i < npcs.size(); i++){
            avatar.collision(npcs.get(i));
            npcs.get(i).collision(avatar);
        }
    }

    public void setAvatar(float x, float y){ //set avatar location
        avatar.setStart(x, y);
    }

    public void mouseDragged(){
        setAvatar(main.mouseX, main.mouseY);
    }

    public void reset(){ //reset game
        super.reset();
        init();
    }
}

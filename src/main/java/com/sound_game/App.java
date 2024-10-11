/*
 * c2017-2024 Courtney Brown 
 * Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
 * 
 * Name: Wren Nguyen
 * Date: Oct 2024
 * Description: This is the Main/App class.
 * Avatar - cat - starting Health: 10
 * Food - green circles - increases health by 1
 * Enemy - red rectangles - decreases health by 1
 * Trash - white circles - reduces health to 1
 */

 package com.sound_game;

 //importing the JMusic stuff
 import jm.music.data.*;
 import jm.util.*;
 
 //import FileSystem for cross-platform file referencing
 import java.nio.file.FileSystem;
 import java.nio.file.FileSystems;
 
 //Processing
 import processing.core.*;

 //Array Lists
 import java.util.ArrayList;
 
 //make sure this class name matches your file name, if not fix.
 public class App extends PApplet {
	 
	 //make cross-platform
	 static FileSystem sys = FileSystems.getDefault();
 
	 //the getSeperator() creates the appropriate back or forward slash based on the OS in which it is running -- OS X & Windows use same code :) 
	 static String filePath = "mid"  + sys.getSeparator(); // path to the midi file -- you can change this to your file
																 // location/name
	//name of all the midi files
	String [] midiFiles = {"food", "food2", "enemy", "trash", };
	//static constants sound files
	static final int FOODSTART_MIDI = 1;
	static final int FOODEND_MIDI = 2;
	static final int ENEMY_MIDI = 3;
	static final int TRASH_MIDI = 4;

	//static avatar file
	static PImage AVATARIMG;
	
	//melody manager
	MelodyManager melodyManager = new MelodyManager();

	//game control
	ArrayList<GameController> controllers = new ArrayList<>();
    int curState = GameController.GAME_PLAY;
	
	 public static void main(String[] args) {
		 PApplet.main("com.sound_game.App");		
	 }
 
	 public void settings()
	 {
		 size(700, 700);
		 melodyManager.addMidiFile(filePath);
	 }
 
	 //doing all the setup stuff for the midi and also make the background black
	 //AND initializes the game
	 public void setup() {
		background(0);
		addMidiFiles();
		AVATARIMG = loadImage("/Users/vinnnguyen/Java MIDI Program/mid/avatar.png");
		/* test sound
		for(int i = 0; i<midiFiles.length; i++){
			melodyManager.start(i);
		}*/

		initGame();
	 }

	 //add game states
	 public void initGame(){
		controllers.add(new GameplayController(this));
		controllers.add(new GameEndController(this));
		
	 }

	 //add midi files to the melody manager
	 public void addMidiFiles(){
		for(int i = 0; i<midiFiles.length; i++){
			melodyManager.addMidiFile(filePath + midiFiles[i] + ".mid");
		}
	 }
 
	 //play the melody in real-time
	 public void draw()
	 {
		melodyManager.playMelodies(); 
		controllers.get(curState).draw();

		//changing game states
		int next = controllers.get(curState).switchController();
		if (next != GameController.DO_NOT_CHANGE){
			controllers.get(curState).reset();
			curState = next;
		}
	 }
 
	 //spacebar resets the game
	 public void keyPressed() {
		controllers.get(curState).keyPressed();
	 }

	 //mousedragged for the avatar
	 public void mouseDragged() {
		controllers.get(curState).mouseDragged();
	 }

	 //access to melodyManager
	 public MelodyManager getMelodyManager(){
		return melodyManager;
	 }

	 //get Avatar image
	 public PImage getSprite(){
        return AVATARIMG;
    }
 }
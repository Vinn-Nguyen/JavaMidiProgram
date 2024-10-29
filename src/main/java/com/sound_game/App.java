/*
 * c2017-2024 Courtney Brown 
 * Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
 * 
 * Name: Wren Nguyen
 * Date: Oct 2024
 * Description: This is the main.
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
	static String prepend = "mid" + sys.getSeparator(); 
	static String apprendType = ".mid" + sys.getSeparator();

	ArrayList<OnMousePress> presses = new ArrayList<>();
	ArrayList<Drawable> draws = new ArrayList<>();
	
	
	//melody manager
	LinkedListMelodyManager manager = new LinkedListMelodyManager();
	LinkedListMelody melody = new LinkedListMelody(); 
	
	public static void main(String[] args) {
		PApplet.main("com.sound_game.App");		
	}
 
	public void settings(){
		size(500, 500);
		manager.setup();;
		addNodes();
		setupButtons();
		addMelodyDraw();
	}

	public void addMelodyDraw(){
		draws.add(melody);
		draws.add(manager);
	}

	void addNodes(){
		for (int i = 0; i<manager.size(); i++){
			melody.insertAtEnd(new MelodyNode (manager, i));
		}
	}

	public void setupButtons(){
		float centerX = width/2;
		float centerY = height/2;
		float spacer = 8;

		PlayButton play = new PlayButton(this, melody, centerX, centerY);
		draws.add(play);
		presses.add(play);
	}
 
	public void setup() {
		background(0);
	}

	 public void draw(){
		for(Drawable drawer : draws){
			drawer.draw();
		}
	 }

	 public void mousePressed(){
		for(OnMousePress press : presses){
			press.mousePressed(mouseX, mouseY);
		}
	 }
}
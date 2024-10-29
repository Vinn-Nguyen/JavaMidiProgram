/*
 * c2017-2024 Courtney Brown 
 * Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
 * 
 * Name: Wren Nguyen
 * Date: Oct 2024
 * Description: This is the main. Fair warning, i got it to work earlier, and then I broke it
 * It probably has something to do with my start method
 * I'm so sorry but i'm also so tired.
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
		float spacer = 50;

		PlayButton play = new PlayButton(this, melody, centerX, centerY);
		draws.add(play);
		presses.add(play);

		StopButton stop = new StopButton(this, melody, centerX, centerY+spacer);
		draws.add(stop);
		presses.add(stop);

		LoopButton loop = new LoopButton(this, melody, centerX, centerY+(spacer*2));
		draws.add(loop);
		presses.add(loop);

		UnitTest unitTest = new UnitTest(this, melody, centerX, centerY+(spacer*3));
		draws.add(unitTest);
		presses.add(unitTest);

		WeaveButton1 weaveButton1 = new WeaveButton1(this, melody, centerX, centerY-(spacer*3));
		draws.add(weaveButton1);
		presses.add(weaveButton1);

		WeaveButton2 weaveButton2 = new WeaveButton2(this, melody, centerX, centerY-(spacer*2));
		draws.add(weaveButton2);
		presses.add(weaveButton2);

		WeaveButton3 weaveButton3 = new WeaveButton3(this, melody, centerX, centerY-spacer);
		draws.add(weaveButton3);
		presses.add(weaveButton3);
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
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
	
	
	//melody managers
	TreeMelodyManager manager = new TreeMelodyManager();
	LinkedListMelody melody = new LinkedListMelody(manager);
	TreeMelody treeMelody = new TreeMelody(manager); 
	
	public static void main(String[] args) {
		PApplet.main("com.sound_game.App");		
	}
 
	public void settings(){
		size(500, 500);
		manager.setup();
		addMelodyDraw();
		setupButtons();
		manager.print();
		melody.print();
	}

	public void addMelodyDraw(){
		draws.add(melody);
		draws.add(manager);
	}

	public void setupButtons(){
		float centerX = width/2;
		float centerY = height/2;
		float spacer = 30;

		PlayButton play = new PlayButton(this, melody, centerX, centerY);
		draws.add(play);
		presses.add(play);

		StopButton stop = new StopButton(this, melody, centerX, centerY+spacer);
		draws.add(stop);
		presses.add(stop);

		LoopButton loop = new LoopButton(this, melody, centerX, centerY + (spacer*2));
		draws.add(loop);
		presses.add(loop);

		PrintButton PrintButton = new PrintButton(this, melody, centerX, centerY - (spacer*3));
		draws.add(PrintButton);
		presses.add(PrintButton);

		ClearButton ClearButton = new ClearButton(this, melody, centerX, centerY + (spacer*3));
		draws.add(ClearButton);
		presses.add(ClearButton);

		ReverseButton ReverseButton = new ReverseButton(this, melody, centerX, centerY + (spacer*4));
		draws.add(ReverseButton);
		presses.add(ReverseButton);

		TestMelodyTreeButton TestMelodyTreeButton = new TestMelodyTreeButton(this, melody, treeMelody, centerX, centerY - spacer);
		draws.add(TestMelodyTreeButton);
		presses.add(TestMelodyTreeButton);
		
		PrintMelodyButton PrintMelodyButton = new PrintMelodyButton(this, melody, centerX, centerY - (spacer*2));
		draws.add(PrintMelodyButton);
		presses.add(PrintMelodyButton);
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
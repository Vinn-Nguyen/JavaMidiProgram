/*
 * c2017-2024 Courtney Brown 
 * Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
 * 
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
 
 //make sure this class name matches your file name, if not fix.
 public class App extends PApplet {
	 
	 //make cross-platform
	 static FileSystem sys = FileSystems.getDefault();
 
	 //the getSeperator() creates the appropriate back or forward slash based on the OS in which it is running -- OS X & Windows use same code :) 
	 static String filePath = "mid"  + sys.getSeparator() +  "gardel_por.mid"; // path to the midi file -- you can change this to your file
																 // location/name
 
	MelodyManager melodyManager = new MelodyManager();
	
	 public static void main(String[] args) {
		 PApplet.main("com.sound_game.App");		
	 }
 
	 public void settings()
	 {
		 size(500, 500);
		 melodyManager.addMidiFile(filePath);
	 }
 
	 //doing all the setup stuff for the midi and also make the background black
	 public void setup() {
 
		 background(0);
		melodyManager.start(0);
	 }
 
	 //play the melody in real-time
	 public void draw()
	 {
		melodyManager.playMelodies(); 
	 }
 
	 //start the melody at the beginning again when a key is pressed
	 public void keyPressed() {
		 //player.reset();
 
	 }

 }
/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: This is the super class to make buttons
 */

package com.sound_game;

import processing.core.PApplet;

public abstract class MelodyButton extends Button{
    LinkedListMelody melody; //init

    //overload the constructor for default sizes 150 x 25
    MelodyButton(PApplet main_, LinkedListMelody melody_, String label_,float x_, float y_)
    {
        super(main_, label_, x_, y_); 
        melody = melody_;

    }

    public void onPress(){
        melody.start();
    }
}

//play button extends melody button
class PlayButton extends MelodyButton{
    LinkedListMelody melody; //init

    //overload the constructor for default sizes 150 x 25
    PlayButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Play", x_, y_); 
    }
    
    //start melody
    public void onPress(){
        melody.start();
    } 
}

//stop button extends melody button
class StopButton extends MelodyButton{
    LinkedListMelody melody; //init

    //overload the constructor for default sizes 150 x 25
    StopButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Stop", x_, y_); 
        melody = melody_;
    }
    
    //stop melody
    public void onPress(){
        melody.stop(); 
    } 
}

//stop button extends melody button
class LoopButton extends MelodyButton{
    LinkedListMelody melody; //init
    boolean looping; //check if its looping

    //overload the constructor for default sizes 150 x 25
    LoopButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Loop", x_, y_); 
        looping = false;
        melody = melody_;
    }
    
    //loop melody
    public void onPress(){
        looping = !looping;
        melody.loop(looping);
        melody.play();
    }
}



//stop button extends melody button
class PrintButton extends MelodyButton{
    LinkedListMelody melody; //init

    //overload the constructor for default sizes 150 x 25
    PrintButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Print", x_, y_);
        melody = melody_;
    }
    
    //print when pressed
    public void onPress(){
        melody.print();
    }
}

//clear button extends melody button
class ClearButton extends MelodyButton{
    LinkedListMelody melody; //init

    ClearButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Clear", x_, y_); 
        melody = melody_;
    }
    
    //clear commands
    public void onPress(){
        melody.clear();
        melody.print();
    }
}

//reverse the melody button 
class ReverseButton extends MelodyButton{
    LinkedListMelody melody; //init

    //overload the constructor for default sizes 150 x 25
    ReverseButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Reverse", x_, y_); 
        melody = melody_;
    }
    
    //reverse the melody when pressed
    public void onPress(){
        melody.reverse();
    }
}

//print melody button
class PrintMelodyButton extends Button{
    LinkedListMelody melody; //init

    PrintMelodyButton(PApplet main_, LinkedListMelody melody_, float x_, float y_){
        super(main_, "Print Melody", x_, y_);
        melody = melody_;
    }
    //makes the button pressable
    public void onPress(){
        melody.print();
    }
}

//plays marry had a little lamb
class TestMary extends Button{
    TreeMelody treeMelody; //init

    TestMary(PApplet main_, LinkedListMelody melody_, TreeMelody treeMelody_, float x_, float y_){
        super(main_, "Test Mary Had a Little Lamb", x_, y_);
        this.treeMelody = treeMelody_;
    }
 
    //makes the button pressable
    public void onPress(){
        TreeMelodyManager manager = new TreeMelodyManager(); //creat the tree manager

        String [] files = {"MaryHadALittleLamb"}; //load mary had a little lamb
        manager.setFiles(files); //set the file
        manager.setup(); //init the set up
        manager.convertToMotivesAndReplace(4); //convert note count to 4

        treeMelody.setRoot(null); //root = null
        treeMelody.setMelodyManager(manager); //set the melody at the manager
        treeMelody.train(4, 0); //count of 4, with index starting at 0
        
        System.out.println("Melody tree test with MaryHadALittleLamb"); //print to make sure it works
        treeMelody.printTree(); //print the tree
    }
}
/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: This is the super class to make buttons
 */

package com.sound_game;

import processing.core.PApplet;

public abstract class MelodyButton extends Button{
    LinkedListMelody melody;

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
    LinkedListMelody melody;

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
    LinkedListMelody melody;

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
    LinkedListMelody melody;
    boolean looping; //check to loop

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
    LinkedListMelody melody;

    //overload the constructor for default sizes 150 x 25
    PrintButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Print", x_, y_);
        melody = melody_;
    }
    
    //loop melody
    public void onPress(){
        melody.print();
    }
}

//stop button extends melody button
class ClearButton extends MelodyButton{
    LinkedListMelody melody;

    //overload the constructor for default sizes 150 x 25
    ClearButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Clear", x_, y_); 
        melody = melody_;
    }
    
    //loop melody
    public void onPress(){
        melody.clear();
        melody.print();
    }
}

//stop button extends melody button
class ReverseButton extends MelodyButton{
    LinkedListMelody melody; 

    //overload the constructor for default sizes 150 x 25
    ReverseButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Reverse", x_, y_); 
        melody = melody_;
    }
    
    //loop melody
    public void onPress(){
        melody.reverse();
    }
}

//print melody button
class PrintMelodyButton extends Button{
    LinkedListMelody melody;

    PrintMelodyButton(PApplet main_, LinkedListMelody melody_, float x_, float y_){
        super(main_, "Print Melody", x_, y_);
        melody = melody_;
    }
    public void onPress(){
        melody.print();
    }
}

class TestMelodyTreeButton extends Button{
    TreeMelody treeMelody;

    TestMelodyTreeButton(PApplet main_, LinkedListMelody melody_, TreeMelody treeMelody_, float x_, float y_){
        super(main_, "Test Tree Melody", x_, y_);
        this.treeMelody = treeMelody_;
    }

    public void onPress(){
        TreeMelodyManager manager = new TreeMelodyManager();
        String [] files = {"MaryHadALittleLamb"};
        manager.setFiles(files);
        manager.setup();
        manager.convertToMotivesAndReplace(4);
        treeMelody.setRoot(null);
        treeMelody.setMelodyManager(manager);
        treeMelody.train(4, 0);
        treeMelody.printTree();
        System.out.println("Melody Tree Tested with MaryHadALittleLamb");
    }
}


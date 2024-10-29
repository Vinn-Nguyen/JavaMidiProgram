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
    MelodyButton(PApplet main_, LinkedListMelody melody, String label_,float x_, float y_)
    {
        super(main_, label_, x_, y_); 
    }
}

//play button extends melody button
class PlayButton extends MelodyButton{
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
    //overload the constructor for default sizes 150 x 25
    StopButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Stop", x_, y_); 
    }
    
    //stop melody
    public void onPress(){
        melody.stop();
    } 
}

//stop button extends melody button
class LoopButton extends MelodyButton{
    //overload the constructor for default sizes 150 x 25
    LoopButton(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Loop", x_, y_); 
    }
    
    //loop melody
    public void onPress(){
        melody.loop(true);
    }
}

class WeaveButton1 extends MelodyButton{
    MelodyManager manager;
    //overload the constructor for default sizes 150 x 25
    WeaveButton1(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Weave1", x_, y_); 
    }
    
    //weave melody option 1
    public void onPress(){
        melody.weave(new MelodyNode(manager, 1), 1, 2);
    }
}

class WeaveButton2 extends MelodyButton{
    MelodyManager manager;
    //overload the constructor for default sizes 150 x 25
    WeaveButton2(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Weave1", x_, y_); 
    }
    
    //weave melody option 2
    public void onPress(){
        melody.weave(new MelodyNode(manager, 1), 2, 3);
    }
}

class WeaveButton3 extends MelodyButton{
    MelodyManager manager;
    //overload the constructor for default sizes 150 x 25
    WeaveButton3(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Weave1", x_, y_); 
    }
    
    //weave melody option 2
    public void onPress(){
        melody.weave(new MelodyNode(manager, 1), 3, 4);
    }
}

class UnitTest extends MelodyButton{
    WeaveUnitTest unitTest;
    //overload the constructor for default sizes 150 x 25
    UnitTest(PApplet main_, LinkedListMelody melody_,float x_, float y_)
    {
        super(main_, melody_, "Weave1", x_, y_); 
    }
    
    //weave melody option 2
    public void onPress(){
        unitTest.testWeave1();
        unitTest.testWeave2();
    }
}



package com.sound_game;

public class MelodyNode {
    MelodyManager melodyManager = new MelodyManager(); //object reference
    MelodyNode next; //next node in the list
    int whichMelody; //index for melody manager

    public MelodyNode(LinkedListMelodyManager manager, int i) {
        
    }

    //get the next node
    public MelodyNode getNext(){
        return next;
    }

    //set the next node
    public void setNext(MelodyNode nextPtr){
        this.next = nextPtr;
    }

    //copy the same node
    public MelodyNode copy(){
        return new MelodyNode(null, whichMelody);
    }

    //get melody index
    int getMelodyIndex(){
        return whichMelody;
    }

    //check when it ends
    boolean atEnd(){
        return melodyManager.atEnd(whichMelody);
    }

    void start(){
        melodyManager.start(whichMelody);
    }
}

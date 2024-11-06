package com.sound_game;
import java.util.ArrayList;

public class TreeMelodyNode extends MelodyNode {
    //array list
    ArrayList<Integer> melody;
    ArrayList<TreeMelodyNode> next;

    //call manager
    //TreeMelodyManager melodyManager;
    //index
    int index;

    public TreeMelodyNode(TreeMelodyManager melodyManager, int index, ArrayList<Integer> melody){
        super(melodyManager, index);
        this.melodyManager = melodyManager;
        this.index = index;
        this.melody = melody;
        this.next = new ArrayList<>();
    }

    //add next node
    public void addNextNodes(ArrayList<TreeMelodyNode> motives){
        TreeMelodyNode curNode;
        int lastPitch = melody.getLast();
        for(int i = 0; i <= motives.size(); i++ ){
            if(lastPitch == curNode.getFirst()){
                ((TreeMelodyManager)melodyManager).popNoteFromMelody(index);
            }

        }
    }

    //get melody
    public ArrayList<Integer> getMelody(){
        return melody;
    }

    //get next nodes
    public ArrayList<TreeMelodyNode> getNextNodes(){
        return next;
    }

    //get melody manager
    public TreeMelodyManager getMelodyManager(){
        return melodyManager;
    }

    //get index of node
    public int getIndex(){
        return index;
    }

    //print tree
    public void printTree() {
        System.out.println(index + ": " + melody);
        for (TreeMelodyNode nextNode : next) 
        {
            nextNode.printTree();
        }
    }
}

/*
 * Wren Nguyen
 * Project: Tree Melody pt 2
 * Description: contains functions and getters/setters of the tree melody
 */

package com.sound_game;
import java.util.ArrayList;

public class TreeMelody{
    //variables
    private TreeMelodyNode root;
    private TreeMelodyManager melodyManager;

    //init
    public TreeMelody(TreeMelodyManager melodyManager){
        this.melodyManager = melodyManager;
    }

    //play
    public void play(){
        TreeMelodyNode current = root; //current is root
        while(current != null){ //while not null

            //get index to play
            MelodyPlayer player = melodyManager.getPlayer(current.getIndex());
            player.play();

            //next
            ArrayList<TreeMelodyNode> next = current.getNextNodes();

            //go through index
            if(next.size() > 0){
                int nextIndex = (int)(Math.random() * next.size()); //choose random 
                current = next.get(nextIndex); //go to the next index
            }
            else{
                current = null;
            }
        }
    }

    //get root
    public TreeMelodyNode getRoot(){
        return root;
    }

    //set root
    public void setRoot(TreeMelodyNode root){
        this.root = root;
    }
    
    //get treemelodymanager
    public TreeMelodyManager getTreeMelodyManager(){
        return melodyManager;
    }

    //set melody manager
    public void setMelodyManager(TreeMelodyManager melodyManager){
        this.melodyManager = melodyManager;
    }

    //train function
    public void train(int noteMotiveCount, int rootIndex){
        ArrayList<TreeMelodyNode> motives = new ArrayList<>(); //init
        melodyManager.convertToMotivesAndReplace(noteMotiveCount); //converter
        root = new TreeMelodyNode(melodyManager, rootIndex, motives.get(rootIndex).getMelody()); //init root
        int index = 0; //init index

        for(int i=0; i <motives.size(); i++){
            ArrayList <Integer> motive = motives.get(i).getMelody();
            TreeMelodyNode current = new TreeMelodyNode(melodyManager, i, motive);
            motives.add(current);
        }
        root = motives.get(index);
        motives.remove(root);

        root.addNextNodes(motives);
    }
}

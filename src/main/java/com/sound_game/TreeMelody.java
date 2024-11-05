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
                int nextIndex = (int)(Math.random() * next.size());
                current = next.get(nextIndex);
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
        ArrayList<MelodyPlayer> motives = melodyManager.convertToMotives(noteMotiveCount);
        root = new TreeMelodyNode(melodyManager, rootIndex, motives.get(rootIndex).getMelody());
    
        for(int i=0; i <motives.size(); i++){
            TreeMelodyNode current = root;
            ArrayList <Integer> motive = motives.get(i).getMelody();

            while(current != null){
                if(motive.get(0).equals(current.getMelody().get(current.getMelody().size()))){
                    current.addNextNode(new TreeMelodyNode(melodyManager, i, motive));
                }
                current = current.getNextNodes().isEmpty() ? null : current.getNextNodes().get(0);
            }
        }
    }

    public void printTree(TreeMelodyNode node){
        if (node == null){
            return;
        } 
        
        System.out.println(node.getIndex() + ": " + node.getMelody());
        for (TreeMelodyNode next : node.getNextNodes()){
            printTree(next);
        }
    }

    public void printTree() {
        if(root != null){
            root.printTree();
        }
    }
}

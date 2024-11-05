package com.sound_game;
import java.util.ArrayList;

public class TreeMelody{
    private TreeMelodyNode root;
    private TreeMelodyManager melodyManager;

    public TreeMelody(TreeMelodyManager melodyManager){
        this.melodyManager = melodyManager;
    }

    public void play(){
        TreeMelodyNode current = root;
        while(current != null){
            MelodyPlayer player = melodyManager.getPlayer(current.getIndex());
            player.play();
            ArrayList<TreeMelodyNode> next = current.getNextNodes();

            if(next.size() > 0){
                int nextIndex = (int)(Math.random() * next.size());
                current = next.get(nextIndex);
            }
            else{
                current = null;
            }
        }
    }

    public TreeMelodyNode getRoot(){
        return root;
    }

    public void setRoot(TreeMelodyNode root){
        this.root = root;
    }
    
    public TreeMelodyManager getTreeMelodyManager(){
        return melodyManager;
    }

    public void setMelodyManager(TreeMelodyManager melodyManager){
        this.melodyManager = melodyManager;
    }

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

    public void printTree(TreeMelodyNode node, String space){
        if (node == null){
            return;
        } 
        
        System.out.println(space + node.getIndex() + ": " + node.getMelody());
        for (TreeMelodyNode next : node.getNextNodes()){
            printTree(next, space + "    ");
        }
    }

    public void printTree() {
        if(root != null){
            root.printTree("");
        }
        
    }
}

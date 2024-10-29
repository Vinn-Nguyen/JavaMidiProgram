package com.sound_game;

public class LinkedListMelody implements Drawable{
    MelodyManager melodyManager;
    MelodyNode curPlayingNode = null; //initialize
    public MelodyNode head; //start of list
    public MelodyNode next; //next node of list
    int currentIndex = 0; //index of code
    boolean isPlaying = true; //switch for notes
    
    public void draw(){
        //fill in to play melody
    }

    public void start(){
        if(head != null){
            curPlayingNode = head;
            head.start();
        }
    }

    //play each node in the list
    public void play(){
        //check if curPlayingNode is null
        if(curPlayingNode != null){

            //check if curPlayingNode is at the end of playing --atEnd();
           if(curPlayingNode.atEnd()){
            curPlayingNode = curPlayingNode.getNext();

            //if so, play the enext node unless it is null
            if(curPlayingNode != null){
                curPlayingNode.start();
            }
           }

           //if not playing, kill the code
           if(!isPlaying){
            System.exit(0);
           }
        } 
        
    }

    public void print(){
        curPlayingNode = head; //start at the head
        while(curPlayingNode != null){//traverse the list
            System.out.println(curPlayingNode.whichMelody); //print the index
            curPlayingNode = curPlayingNode.next; //go to the next node
        }
    }

    //insert melody node at indicated index
    void insert(int index, MelodyNode node){
        if(isEmpty()){
            head = node;
        }
        
        curPlayingNode = head; //start at the head
        for(int i=1; i < index && curPlayingNode != null; i++){ //create an index while traversing the list
            curPlayingNode = curPlayingNode.getNext();
            currentIndex = index; //assign a currentIndex to the index
        }
        curPlayingNode.setNext(node); //insert the node
    }

    //insert node at start (prepend)
    void insertAtStart(MelodyNode node){
        if(isEmpty())
            head = node;
        else{
            curPlayingNode = head; //start at the head
            curPlayingNode = node; //create a new node at the head
            head.next = curPlayingNode; //push the other nodes beneath the new head
        }
    }

    //insert at the end of a list (append)
    public void insertAtEnd(MelodyNode node){
        if(isEmpty())
            head = node;
        else{
            MelodyNode current = head; //start at the head
            while(current.getNext()!= null){ //traverse through the list
                current = current.getNext();//go to the next node until the end
            }
            current.setNext(node); //insert node at the end
        }
    }

    //check if list is empty
    boolean isEmpty(){ 
        return head == null;
    }

    void loop(boolean loop_){
        if(loop_){
        //check if curPlayingNode is null
            if(curPlayingNode != null){
                
                //check if curPlayingNode is at the end of playing --atEnd();
                if(curPlayingNode.atEnd()){
                    curPlayingNode = curPlayingNode.getNext();
                
                    //if so, play the next node unless it is null
                    if(curPlayingNode != null){
                    curPlayingNode.start();
                    }

                    //if it is null, go back to the head and redo the list
                    if(curPlayingNode == null){
                        curPlayingNode = head;
                    }
                }
            }    
        }
    }

    //will kill the code when called
    void stop(){
        this.isPlaying = false;
    }

    //weave
    void weave(MelodyNode node, int count, int skip){
        MelodyNode previous = null; //reference previous node
        curPlayingNode = head; //start from top

        //traverse list to find the node's position
        for(int i = 0; i < skip && curPlayingNode != null; i++){
            previous = curPlayingNode;
            curPlayingNode = curPlayingNode.next;
        }

        //if empty, insert at head
        if (isEmpty()){
            head = null;
        }
        //insert after the previous node
        else{ 
            node.next = curPlayingNode;
            previous.next = node;
        }

        //move the previous node to the next position 
        if (curPlayingNode != null){
            previous = curPlayingNode;
            curPlayingNode = curPlayingNode.next;
        }
    }
    //custom methods
    //clear list
    void clear(){
        MelodyNode previous = null; //reference previous node
        curPlayingNode = head; //start from the top

        while(curPlayingNode != null){ //traverse list to delete all nodes

            //if node is head
            if (previous == null){
                head = curPlayingNode.next;
            }
            else{
                previous.next = curPlayingNode.next;
            }
            //move to the next node
            curPlayingNode = curPlayingNode.next;
        }
    }

    //reverse linkedlist
    void reverse(){
        MelodyNode previous = null; //reference previous node
        MelodyNode nextNode; //node after
        curPlayingNode = head; //start from the top

        while(curPlayingNode != null){ //traverse list 
            //store the next node
            nextNode = curPlayingNode.next;
            //reverse next node with the current
            curPlayingNode.next = previous;
            //move nodes one along
            previous = curPlayingNode;
            curPlayingNode = next;
        }
    }
}
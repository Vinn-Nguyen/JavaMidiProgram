/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: LinkedListMelody contains all the commands for the linked list
 */

package com.sound_game;

public class LinkedListMelody implements Drawable{
    MelodyManager melodyManager;
    MelodyNode curPlayingNode = null; //initialize
    public MelodyNode head; //start of list
    public MelodyNode next; //next node of list
    int currentIndex = 0; //index of code
    boolean isPlaying = true; //switch for notes
    private boolean looping = false;
    
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
        } 
        
    }

    public void print(){
        MelodyNode current = head; //start at the head
        while(current != null){//traverse the list
            System.out.println(current.whichMelody); //print the index
            current = current.next; //go to the next node
        }
    }

    //insert melody node at indicated index
    void insert(int index, MelodyNode node){
        if(isEmpty()){
            head = node;
        }
        
        MelodyNode current = head; //start at the head
        for(int i=1; i < index && current != null; i++){ //create an index while traversing the list
            current = current.getNext();
            currentIndex = index; //assign a currentIndex to the index
        }
        current.setNext(node); //insert the node
    }

    //insert node at start (prepend)
    void insertAtStart(MelodyNode node){
        if(isEmpty())
            head = node;
        else{
            MelodyNode current = head; //start at the head
            current = node; //create a new node at the head
            head.next = current; //push the other nodes beneath the new head
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

    //loop
    void loop(boolean loop_){
        looping = loop_;
    }

    //stop
    void stop(){
        curPlayingNode = null;
    }

    //weave
    void weave(MelodyNode node, int count, int skip){
        MelodyNode previous = null; //reference previous node
        MelodyNode current = head; //start from top

        //traverse list to find the node's position
        for(int i = 0; i < skip && current != null; i++){
            previous = current;
            current = current.next;
        }

        //if empty, insert at head
        if (isEmpty()){
            head = null;
        }
        //insert after the previous node
        else{ 
            node.next = current;
            previous.next = node;
        }

        //move the previous node to the next position 
        if (current != null){
            previous = current;
            current = current.next;
        }
    }

    //custom methods
    //clear list
    void clear(){
        MelodyNode previous = null; //reference previous node
        MelodyNode current = head; //start from the top

        while(current != null){ //traverse list to delete all nodes

            //if node is head
            if (previous == null){
                head = current.next;
            }
            else{
                previous.next = current.next;
            }
            //move to the next node
            current = current.next;
        }
    }

    //reverse linkedlist
    void reverse(){
        MelodyNode previous = null; //reference previous node
        MelodyNode nextNode; //node after
        MelodyNode current = head; //start from the top

        while(current != null){ //traverse list 
            //store the next node
            nextNode = current.next;
            //reverse next node with the current
            current.next = previous;
            //move nodes one along
            previous = current;
            current = nextNode;
        }
    }
}
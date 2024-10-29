/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: Test out Weave
 */

package com.sound_game;

public class WeaveUnitTest extends App{
    //MelodyManager manager - object reference to a MelodyManager class
    //LinkedListMelody melodyList - linked list Melody object
    static MelodyManager manager = new MelodyManager();
    static LinkedListMelody melodyList;


    public static void main(String[] args){
        melodyList = new LinkedListMelody();
        melodyList.insert(1, new MelodyNode(manager, 3));
        melodyList.insert(2, new MelodyNode(manager, 3));
        melodyList.insert(3, new MelodyNode(manager, 3));
        melodyList.insert(4, new MelodyNode(manager, 3));
        melodyList.insert(5, new MelodyNode(manager, 3));
        melodyList.insert(6, new MelodyNode(manager, 3));
        melodyList.insert(7, new MelodyNode(manager, 3));
        melodyList.insert(8, new MelodyNode(manager, 3));
        melodyList.insert(9, new MelodyNode(manager, 3));
        melodyList.insert(10, new MelodyNode(manager, 3));
        melodyList.insert(11, new MelodyNode(manager, 3));
        melodyList.insert(12, new MelodyNode(manager, 3));

        testWeave1();
        testWeave2();

    }
    //Test Weave1
    static void testWeave1(){
        melodyList.weave(new MelodyNode(manager, 12),3, 4);
        melodyList.print();
    }

    static void testWeave2(){
        melodyList.weave(new MelodyNode(manager, 12),5, 10);
        melodyList.print();
    }
    
}
/*
 * Wren Nguyen
 * Project: Music Generator pt 1
 * Description: Allows the buttons to be pressed using mouse
 */

package com.sound_game;

public interface OnMousePress {
    abstract void onPress();
    abstract void mousePressed(float mx, float my);
}
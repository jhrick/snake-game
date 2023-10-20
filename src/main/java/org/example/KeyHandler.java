package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public String direction;

    public KeyHandler() {
        direction = "right";
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && direction != "right") {
            direction = "left";
        } else if (keyCode == KeyEvent.VK_RIGHT && direction != "left") {
            direction = "right";
        } else if (keyCode == KeyEvent.VK_UP && direction != "down") {
            direction = "up";
        } else if (keyCode == KeyEvent.VK_DOWN && direction != "up") {
            direction = "down";
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

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

        switch (keyCode) {
            case KeyEvent.VK_LEFT -> direction = "left";
            case KeyEvent.VK_RIGHT -> direction = "right";
            case KeyEvent.VK_UP -> direction = "up";
            case KeyEvent.VK_DOWN -> direction = "down";
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

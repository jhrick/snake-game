package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public String direction;
    private final GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
        setDefaultValues();
    }

    public void setDefaultValues() {
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
        } else if (keyCode == KeyEvent.VK_ENTER && !gp.snake.isRunning()) {
            setDefaultValues();

            gp.timer.stop();

            gp.startGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

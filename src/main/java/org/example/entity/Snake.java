package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import java.awt.*;
import java.util.Objects;

public class Snake extends Entity {

    KeyHandler keyH;
    GamePanel gp;

    boolean running;

    public Snake(KeyHandler keyH, GamePanel gp) {
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 96;
        y = 96;
        running = true;
    }

    public void update() {
        move();
    }

    private void move() {
        if (Objects.equals(keyH.direction, "left")) {
            x -= gp.tileSize;
        } else if (Objects.equals(keyH.direction, "right")) {
            x += gp.tileSize;
        } else if (Objects.equals(keyH.direction, "up")) {
            y -= gp.tileSize;
        } else if (Objects.equals(keyH.direction, "down")) {
            y += gp.tileSize;
        }
    }

    public boolean pickApple(Apple apple) {
        int appleXPosition = apple.getX();
        int appleYPosition = apple.getY();

        return this.x == appleXPosition && this.y == appleYPosition;
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.green);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

    public boolean isRunning() {
        return running;
    }
}

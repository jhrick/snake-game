package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import java.awt.*;
import java.util.Objects;

public class Snake extends Entity{

    private int speed;

    KeyHandler keyH;
    GamePanel gp;

    public Snake(KeyHandler keyH, GamePanel gp) {
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 96;
        y = 96;
        speed = 48;
    }

    public void update() {
        if (Objects.equals(keyH.direction, "left")) {
            x -= speed;
        } else if (Objects.equals(keyH.direction, "right")) {
            x += speed;
        } else if (Objects.equals(keyH.direction, "up")) {
            y -= speed;
        } else if (Objects.equals(keyH.direction, "down")) {
            y += speed;
        }
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.green);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}

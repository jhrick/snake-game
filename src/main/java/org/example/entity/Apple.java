package org.example.entity;

import org.example.GamePanel;

import java.awt.*;
import java.util.Random;

public class Apple extends Entity {

    GamePanel gp;

    public Apple(GamePanel gp) {
        this.gp = gp;

        setRandomPositions();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRandomPositions() {
        Random random = new Random();

        x = random.nextInt(17) * 48;
        y = random.nextInt(13) * 48;
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.red);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

}

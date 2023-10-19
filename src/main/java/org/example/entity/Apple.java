package org.example.entity;

import org.example.GamePanel;

import java.awt.*;

public class Apple extends Entity {

    GamePanel gp;

    public Apple(GamePanel gp) {
        this.gp = gp;

        this.x = generatePosition(gp.screenWidth);
        this.y = generatePosition(gp.screenHeight);
    }

    private int generatePosition(int max) {
        double pseudoRandomNum = Math.random();

        return (int) Math.floor((pseudoRandomNum * max));
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.red);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

}

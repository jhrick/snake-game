package org.example.entity;

import org.example.GamePanel;
import org.example.KeyHandler;

import java.awt.*;
import java.util.LinkedList;

public class Snake extends Entity {

    KeyHandler keyH;
    GamePanel gp;

    boolean running;

    LinkedList<Piece> pieces = new LinkedList<>();

    public Snake(KeyHandler keyH, GamePanel gp) {
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();

        pieces.addFirst(new Piece(this.x, this.y));
        pieces.add(new Piece((pieces.get(0).getX() - gp.tileSize), (pieces.get(0).getY() - gp.tileSize)));
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
        String direction = keyH.direction;

        for (int i = pieces.size() - 1; i > 0; i--) {
            pieces.get(i).setX(pieces.get(i - 1).getX());
            pieces.get(i).setY(pieces.get(i - 1).getY());
        }

        switch (direction) {
            case "left": {
                x -= gp.tileSize;
                pieces.get(0).setX(x);
                break;
            }
            case "right": {
                x += gp.tileSize;
                pieces.get(0).setX(x);
                break;
            }
            case "up": {
                y -= gp.tileSize;
                pieces.get(0).setY(y);
                break;
            }
            case "down": {
                y += gp.tileSize;
                pieces.get(0).setY(y);
                break;
            }
        }
    }

    public Apple checkApple(Apple apple) {
        int appleXPosition = apple.getX();
        int appleYPosition = apple.getY();

        if (this.x == appleXPosition && this.y == appleYPosition) {
            apple = new Apple(gp);

            pieces.addLast(new Piece(pieces.get(pieces.size() - 1).getX(), pieces.get(pieces.size() - 1).getY()));

            System.out.printf("new apple!!x: %d; y %d", apple.getX(), apple.getY());

            return apple;
        }

        return apple;
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.green);

        for (Piece piece : pieces) {
            g2.fillRect(piece.getX(), piece.getY(), gp.tileSize, gp.tileSize);
        }
    }

    public boolean isRunning() {
        return running;
    }
}

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

    int snakeHeadX;
    int snakeHeadY;

    public Snake(KeyHandler keyH, GamePanel gp) {
        this.keyH = keyH;
        this.gp = gp;

        setDefaultValues();

        pieces.addFirst(new Piece(this.x, this.y));
        pieces.add(new Piece((pieces.get(0).getX() - gp.tileSize), (pieces.get(0).getY() - gp.tileSize)));

        snakeHeadX = pieces.getFirst().getX();
        snakeHeadY = pieces.getFirst().getY();
    }

    public void setDefaultValues() {
        x = 96;
        y = 96;
        running = true;
    }

    public void update() {
        move();
        checkCollision();
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

            return apple;
        }

        return apple;
    }

    public void render(Graphics2D g2) {
        for (int i = (pieces.size() - 1); i > 0; i--) {
            int currentPieceX = pieces.get(i).getX();
            int currentPieceY = pieces.get(i).getY();

            g2.setColor(new Color(0, 153, 0));
            g2.fillRect(currentPieceX, currentPieceY, gp.tileSize, gp.tileSize);
        }

        snakeHeadX = pieces.getFirst().getX();
        snakeHeadY = pieces.getFirst().getY();

        g2.setColor(new Color(0, 204, 0));
        g2.fillRect(snakeHeadX, snakeHeadY, gp.tileSize, gp.tileSize);
    }

    public boolean isRunning() {
        return running;
    }

    public void checkCollision() {
        snakeHeadX = pieces.getFirst().getX();
        snakeHeadY = pieces.getFirst().getY();

        for (int i = (pieces.size() - 1); i > 0; i--) {
            int currentPieceX = pieces.get(i).getX();
            int currentPieceY = pieces.get(i).getY();


            if (snakeHeadX == (currentPieceX) && snakeHeadY == (currentPieceY)) {
                running = false;
                System.out.println("stop running");
                System.out.println("X: " + (snakeHeadX == currentPieceX));
                System.out.println("Y: " + (snakeHeadY == currentPieceY));
                break;
            }
        }

        if ((snakeHeadX) == gp.screenWidth || (snakeHeadX)< 0) {
            running = false;
        } else if ((snakeHeadY) == gp.screenHeight || (snakeHeadY) < 0) {
            running = false;
        }
    }
}

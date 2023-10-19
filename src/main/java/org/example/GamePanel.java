package org.example;

import org.example.entity.Apple;
import org.example.entity.Snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    public int tileSize = 48; //48x48
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize; // 768px
    public final int screenHeight = maxScreenRow * tileSize; // 576px;

    Thread gameTread;

    int FPS = 60; // 60 frame per seconds;

    KeyHandler keyH = new KeyHandler();

    // snake
    Snake snake;

    // apple
    Apple apple;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        snake = new Snake(keyH, this);
        apple = new Apple(this);
    }

    public void startGameTread() {
        gameTread = new Thread(this);
        gameTread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 /FPS; // 1 nano second divide per 60FPS
        double delta = 0;
        long lastUpdate = System.nanoTime();
        long currentTime;
        long timer = 0;
        int count = 0;

        while (gameTread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastUpdate) / drawInterval;
            timer += (currentTime - lastUpdate);

            lastUpdate = currentTime;

            if (delta >= 1) {
                update(count);
                repaint();
                count++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + count);
                timer = 0;
                count = 0;
            }
        }
    }

    public void update(int count) {
        if (count == 30) {
            snake.update();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        snake.render(g2);

        apple.render(g2);

        g2.dispose();
    }
}

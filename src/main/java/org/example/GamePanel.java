package org.example;

import org.example.entity.Apple;
import org.example.entity.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    // screen settings
    public int tileSize = 48; //48x48
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize; // 768px
    public final int screenHeight = maxScreenRow * tileSize; // 576px;

    final int delay = 150;
    Timer timer;

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

    public void startGame() {
        timer = new Timer(delay, this);
        timer.start();
    }

    public void update() {
        snake.update();

        apple = snake.checkApple(apple);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        snake.render(g2);

        apple.render(g2);

        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (snake.isRunning()) {
            update();
        }
        repaint();
    }
}

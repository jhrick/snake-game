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

    KeyHandler keyH;

    // snake
    Snake snake;

    // apple
    Apple apple;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        
        this.setDoubleBuffered(true);

        keyH = new KeyHandler(this);

        this.addKeyListener(keyH);

        this.setFocusable(true);
    }

    public void startGame() {
        timer = new Timer(delay, this);

        snake = new Snake(keyH, this);
        apple = new Apple(this);

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

        if (snake.isRunning()) {
            snake.render(g2);

            apple.render(g2);
        } else {
            String text = "GAME OVER";

            Font font = new Font("sans serif", Font.BOLD, 48);

            FontMetrics metrics = g2.getFontMetrics(font);

            int x = (screenWidth - metrics.stringWidth(text)) / 2;
            int y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();

            g2.setColor(Color.red);
            g2.setFont(font);
            g2.drawString(text, x, y);

            text = "press enter for play again";

            font = new Font("sans serif", Font.PLAIN, 12);

            metrics = g2.getFontMetrics(font);

            x = (screenWidth - metrics.stringWidth(text)) / 2;
            y = ((screenHeight - metrics.getHeight()) / 2) + metrics.getAscent();

            g2.setColor(Color.WHITE);
            g2.setFont(font);
            g2.drawString(text, x, (y + tileSize));
        }

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

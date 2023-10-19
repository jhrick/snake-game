package org.example;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Snake Game");

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        window.pack();

    }
}
package org.example;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setTitle("Snake Game");

        window.pack();

        window.setResizable(false);

        window.setLocationRelativeTo(null);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
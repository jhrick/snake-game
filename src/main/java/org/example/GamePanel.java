package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    protected int tileSize = 48;

    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = maxScreenCol * tileSize; // 768px
    private final int screenHeight = maxScreenRow * tileSize; // 576px;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


}

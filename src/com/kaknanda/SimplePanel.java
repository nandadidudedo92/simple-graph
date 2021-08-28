package com.kaknanda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SimplePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 300;
    static final int SCREEN_HEIGHT = 100;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75 ;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    boolean running = false;
    Timer timer;
    Random random;

    SimplePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension( SCREEN_WIDTH, SCREEN_HEIGHT ));
        this.setBackground(randomColor());
        this.setFocusable(true);
        this.startGraph();

    }

    public Color randomColor() {
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public void startGraph() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++){
            if(i == 0) {
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0 ; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        x[0] = x[0] + UNIT_SIZE;
    }

    public void checkCollisions() {

        if(x[0] > SCREEN_WIDTH - UNIT_SIZE ) {
            x[0] = 0;
            y[0] = y[0]+UNIT_SIZE;
            this.setBackground(randomColor());
        }

        if(y[0] > SCREEN_HEIGHT - UNIT_SIZE) {
            y[0] = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkCollisions();
        }
        repaint();
    }
}

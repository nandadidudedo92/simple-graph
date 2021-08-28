package com.kaknanda;

import javax.swing.*;

public class SimpleFrame extends JFrame {

    SimpleFrame(){

        this.add(new SimplePanel());
        this.setTitle("Simple Graph");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author rueln
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        
        JLabel clickCountLabel = new JLabel("0");
        JButton clickButton = new JButton("Click!");
        
        ClickListener clickListener = new ClickListener(this.calculator, clickCountLabel);
        clickButton.addActionListener(clickListener);
        
        container.add(clickCountLabel, BorderLayout.NORTH);
        container.add(clickButton, BorderLayout.SOUTH);
    }

}

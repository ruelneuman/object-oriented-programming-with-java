package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    public NoticeBoard() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("Notice Board");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField textField = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel label = new JLabel();

        ActionEventListener copier = new ActionEventListener(textField, label);
        button.addActionListener(copier);

        container.add(textField);
        container.add(button);
        container.add(label);

    }
}

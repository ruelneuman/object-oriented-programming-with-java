package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Survey");
        this.frame.setPreferredSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        
        //set layout
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));
        
        //create check box objects and add them to container
        JCheckBox yesCheckBox = new JCheckBox("Yes!");
        JCheckBox noCheckBox = new JCheckBox("No!");
        container.add(yesCheckBox);
        container.add(noCheckBox);

        container.add(new JLabel("Why?"));

        //create radio button objects
        JRadioButton noReasonRadioButton = new JRadioButton("No reason.");
        JRadioButton funRadioButton = new JRadioButton("Because it is fun!");

        //add radio button objects to a ButtonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(noReasonRadioButton);
        buttonGroup.add(funRadioButton);

        //add radio buttons to container
        container.add(noReasonRadioButton);
        container.add(funRadioButton);
        
        container.add(new JButton("Done!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}

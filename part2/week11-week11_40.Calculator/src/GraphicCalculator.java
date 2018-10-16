
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private CalculatorLogic calculator;

    public GraphicCalculator(CalculatorLogic calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        frame.setLayout(new GridLayout(3, 1));

        JTextField outputField = new JTextField("0");
        outputField.setEnabled(false);

        JTextField inputField = new JTextField();

        JPanel buttonPanel = createButtonPanel();

        JButton additionButton = (JButton) buttonPanel.getComponent(0);
        JButton subtractionButton = (JButton) buttonPanel.getComponent(1);
        JButton resetButton = (JButton) buttonPanel.getComponent(2);

        ActionListener additionButtonListener = new AdditionButtonListener(this.calculator, inputField, outputField, resetButton);
        additionButton.addActionListener(additionButtonListener);

        ActionListener subtractionButtonListener = new SubtractionButtonListener(this.calculator, inputField, outputField, resetButton);
        subtractionButton.addActionListener(subtractionButtonListener);

        ActionListener resetButtonListener = new ResetButtonListener(this.calculator, inputField, outputField, resetButton);
        resetButton.addActionListener(resetButtonListener);

        container.add(outputField);
        container.add(inputField);
        container.add(buttonPanel);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton additionButton = new JButton("+");
        JButton subtractionButton = new JButton("-");
        JButton resetButton = new JButton("Z");
        resetButton.setEnabled(false);

        buttonPanel.add(additionButton);
        buttonPanel.add(subtractionButton);
        buttonPanel.add(resetButton);

        return buttonPanel;
    }

    public JFrame getFrame() {
        return frame;
    }

}

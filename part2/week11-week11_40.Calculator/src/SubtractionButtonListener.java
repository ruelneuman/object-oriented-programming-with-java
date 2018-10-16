
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rueln
 */
public class SubtractionButtonListener implements ActionListener {

    private CalculatorLogic calculator;
    private JTextField inputField;
    private JTextField outputField;
    private JButton resetButton;

    public SubtractionButtonListener(CalculatorLogic calculator, JTextField inputField, JTextField outputField, JButton resetButton) {
        this.calculator = calculator;
        this.inputField = inputField;
        this.outputField = outputField;
        this.resetButton = resetButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (IntegerChecker.isInteger(this.inputField.getText())) {
            int input = Integer.parseInt(this.inputField.getText());
            this.calculator.subtraction(input);
            this.outputField.setText(Integer.toString(this.calculator.getResult()));

            Boolean outputIsZero = this.calculator.getResult() == 0;
            this.resetButton.setEnabled(!outputIsZero);
        }
        this.inputField.setText("");
    }

}

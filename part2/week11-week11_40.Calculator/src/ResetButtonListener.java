
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
public class ResetButtonListener implements ActionListener {

    private CalculatorLogic calculator;
    private JTextField inputField;
    private JTextField outputField;
    private JButton resetButton;

    public ResetButtonListener(CalculatorLogic calculator, JTextField inputField, JTextField outputField, JButton resetButton) {
        this.calculator = calculator;
        this.inputField = inputField;
        this.outputField = outputField;
        this.resetButton = resetButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculator.reset();
        this.outputField.setText(Integer.toString(this.calculator.getResult()));
        this.inputField.setText("");
        this.resetButton.setEnabled(false);

    }

}

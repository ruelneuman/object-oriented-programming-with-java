/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
public class CalculatorLogic {
    
    private int value;
    
    public void addition(int input) {
        value += input;
    }
    
    public void subtraction(int input) {
        value -= input;
    }
    
    public void reset() {
        value = 0;
    }

    public int getResult() {
        return value;
    }
    
    
}

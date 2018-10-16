/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
public class BoundedCounter {

    private int value;
    private int upperLimit;

    public BoundedCounter(int upperLimit) {
        this.value = 0;
        this.upperLimit = upperLimit;
    }

    public void next() {
        if (this.value == upperLimit) {
            this.value = 0;
        } else {
            this.value++;
        }

    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        if (value < 0 || value > this.upperLimit) {
            return;
        }
        this.value = value;
    }

    @Override
    public String toString() {
        String initialZero = "0";
        if (this.value > 9) {
            initialZero = "";
        }
        return initialZero + this.value;

    }
}

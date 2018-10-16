/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author rueln
 */
public class Thermometer implements Sensor {

    private boolean isOn;
    private Random random = new Random();

    public Thermometer() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (!this.isOn()) {
            throw new IllegalStateException("The thermometer is off.");
        }
        int maxTemp = 30;
        int minTemp = -30;

        return random.nextInt((maxTemp - minTemp) + 1) + minTemp;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rueln
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Integer> readings = new ArrayList<Integer>();

    public AverageSensor() {
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (sensors.isEmpty()) {
            throw new IllegalStateException("No sensors added.");
        }

        if (!this.isOn()) {
            throw new IllegalStateException("The sensor is off.");
        }

        int sum = 0;
        int count = 0;

        for (Sensor sensor : sensors) {
            sum += sensor.measure();
            count++;
        }

        int average = sum / count;

        readings.add(average);

        return average;
    }

    public List<Integer> readings() {
        return readings;
    }
    
}

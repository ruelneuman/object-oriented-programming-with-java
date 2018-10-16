/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author rueln
 */
public class Cow implements Milkable, Alive {

    private String name;
    private double capacity;
    private double amount;
    private Random random = new Random();
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + random.nextInt(26);
        this.amount = 0;
    }

    public Cow() {
        this.name = NAMES[random.nextInt(NAMES.length)];
        this.capacity = 15 + random.nextInt(26);
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + Math.ceil(this.capacity);
    }

    @Override
    public double milk() {
        double milk = this.amount;
        this.amount = 0;
        return milk;
    }

    @Override
    public void liveHour() {
        this.amount += (1.3 * random.nextDouble()) + 0.7;

        if (this.amount > this.capacity) {
            this.amount = this.capacity;
        }

    }
}

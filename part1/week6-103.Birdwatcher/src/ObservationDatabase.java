/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
import java.util.ArrayList;

public class ObservationDatabase {

    ArrayList<Bird> birds;

    public ObservationDatabase() {
        this.birds = new ArrayList<Bird>();
    }

    public boolean observe(String name) {
        for (Bird bird : this.birds) {
            if (name.equals(bird.getName())) {
                bird.increaseObservations();
                return true;
            }
        }
        return false;
    }

    public void addBird(String name, String latinName) {
        this.birds.add(new Bird(name, latinName));
    }

    public String statistics() {
        String stats = "";
        for (Bird bird : birds) {
            stats += bird.toString() + "\n";
        }
        return stats;
    }

    public String showBird(String name) {
        for (Bird bird : this.birds) {
            if (name.equals(bird.getName())) {
                return bird.toString();
            }
        }
        return null;
    }
}

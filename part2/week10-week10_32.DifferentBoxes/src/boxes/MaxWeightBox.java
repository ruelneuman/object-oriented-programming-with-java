/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rueln
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> box;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.box = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (totalWeight() + thing.getWeight() <= this.maxWeight) {
            this.box.add(thing);
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Thing thing : box) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.box.contains(thing);
    }
}

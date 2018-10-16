/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class Group implements Movable {

    private List<Movable> group;
    
    public Group() {
        this.group = new ArrayList<Movable>();
    }

    @Override
    public String toString() {
        String string = "";
        for (Movable movable : group) {
            string += movable.toString() + "\n";
        }
        return string;
    }
    
    public void addToGroup(Movable movable) {
        this.group.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : group){
            movable.move(dx, dy);
        }
    } 
}

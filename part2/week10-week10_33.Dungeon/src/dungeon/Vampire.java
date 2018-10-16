/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author rueln
 */
public class Vampire extends Actor {

    public Vampire(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "v";
    }

    @Override
    public void move(char direction, Dungeon dungeon) {
                
        if (direction == 'a') {
            int newX = this.getX() - 1;
            if (dungeon.locationUnoccupied(newX, this.getY()) && dungeon.inBounds(newX, this.getY())) {
                this.setX(newX);
            }
        }
        if (direction == 's') {
            int newY = this.getY() + 1;
            if (dungeon.locationUnoccupied(this.getX(), newY) && dungeon.inBounds(this.getX(), newY)) {
                this.setY(newY);
            }
        }
        if (direction == 'd') {
            int newX = this.getX() + 1;
            if (dungeon.locationUnoccupied(newX, this.getY()) && dungeon.inBounds(newX, this.getY())) {
                this.setX(newX + 1);
            }
        }
        if (direction == 'w') {
            int newY = this.getY() - 1;
            if (dungeon.locationUnoccupied(this.getX(), newY) && dungeon.inBounds(this.getX(), newY)) {
                this.setY(newY);
            }
        }

    }

}

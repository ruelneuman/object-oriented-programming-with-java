/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author rueln
 */
public class Player extends Actor {

    public Player() {
        super(0, 0);
    }

    @Override
    public String toString() {
        return "@";
    }

    @Override
    public void move(char direction, Dungeon dungeon) {
        if (direction == 'a') {
            int newX = this.getX() - 1;
            if (dungeon.inBounds(newX, this.getY())) {
                this.setX(newX);
            }
        }
        if (direction == 's') {
            int newY = this.getY() + 1;
            if (dungeon.inBounds(this.getX(), newY)) {
                this.setY(newY);
            }
        }
        if (direction == 'd') {
            int newX = this.getX() + 1;
            if (dungeon.inBounds(newX, this.getY())) {
                this.setX(newX);
            }
        }
        if (direction == 'w') {
            int newY = this.getY() - 1;
            if (dungeon.inBounds(this.getX(), newY)) {
                this.setY(newY);
            }
        }
    }
    
}

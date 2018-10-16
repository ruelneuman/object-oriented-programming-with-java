/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;


public class Worm {

    private int X;
    private int Y;
    private Direction direction;
    private List<Piece> worm;
    private Boolean growNext;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        X = originalX;
        Y = originalY;
        direction = originalDirection;
        worm = new ArrayList<Piece>();
        worm.add(new Piece(originalX, originalY));
        growNext = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public int getLength() {
        return worm.size();
    }

    public List<Piece> getPieces() {
        return worm;
    }

    public void move() {

        switch (direction) {
            case UP:
                Y--;
                break;
            case DOWN:
                Y++;
                break;
            case RIGHT:
                X++;
                break;
            case LEFT:
                X--;
                break;
            default:
                break;
        }

        if (!growNext && getLength() >= 3) {
            worm.remove(0);
        }

        growNext = false;

        worm.add(new Piece(X, Y));

    }

    public void grow() {
        growNext = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : worm) {
            if (piece.getX() == wormPiece.getX() && piece.getY() == wormPiece.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {

        for (int i = 0; i < getLength() - 1; i++) {
            if (wormHead().getX() == worm.get(i).getX() && wormHead().getY() == worm.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
    
    public Piece wormHead() {
        return worm.get(getLength() - 1);
    }

}

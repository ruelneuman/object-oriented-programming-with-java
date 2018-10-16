/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author rueln
 */
public class PersonalBoard extends GameOfLifeBoard {

    private static final int[][] NEIGHBOURS = {{-1, -1}, {-1, 0}, {-1, +1}, {0, -1}, {0, +1}, {+1, -1}, {+1, 0}, {+1, +1}};

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        Random random = new Random();
        boolean[][] board = super.getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = random.nextDouble() < probabilityForEachCell;
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (isOutsideBoard(x, y)) {
            return false;
        }

        boolean[][] board = super.getBoard();
        return board[x][y];
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (isOutsideBoard(x, y)) {
            return;
        }

        boolean[][] board = super.getBoard();
        board[x][y] = true;
    }

    @Override
    public void turnToDead(int x, int y) {
        if (isOutsideBoard(x, y)) {
            return;
        }

        boolean[][] board = super.getBoard();
        board[x][y] = false;
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int livingNeighbours = 0;
        boolean[][] board = super.getBoard();

        for (int[] offset : NEIGHBOURS) {
            if (isAlive(x + offset[0], y + offset[1])) {
                livingNeighbours++;
            }
        }

        return livingNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (!isAlive(x, y) && livingNeighbours == 3) {
            turnToLiving(x, y);
        } else if (isAlive(x, y) && (livingNeighbours < 2 || livingNeighbours > 3)) {
            turnToDead(x, y);
        }
    }

    private boolean isOutsideBoard(int x, int y) {
        return x >= super.getWidth() || y >= super.getHeight() || x < 0 || y < 0;
    }

}

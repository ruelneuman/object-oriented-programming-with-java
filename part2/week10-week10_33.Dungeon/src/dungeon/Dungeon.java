/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rueln
 */
public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private List<Actor> actors;
    private Random random;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.actors = new ArrayList<Actor>();
        this.random = new Random();
        this.reader = new Scanner(System.in);
    }

    public void run() {
        this.populate();
        while (this.moves > 0 && this.vampires > 0) {
            this.printDungeon();
            this.turn();
        }
        this.printEndMessage();
    }

    public void populate() {
        this.actors.add(new Player());

        int numVampires = 0;

        while (numVampires < this.vampires) {
            int x = this.random.nextInt(this.length);
            int y = this.random.nextInt(this.height);
            Vampire vampire = new Vampire(x, y);

            if (locationUnoccupied(vampire.getX(), vampire.getY())) {
                this.actors.add(vampire);
                numVampires++;
            }
        }

    }

    public void turn() {
        String input = reader.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);
            this.step(command);
        }

        this.moves--;
    }

    public void printDungeon() {
        System.out.println(this.moves);

        System.out.println("");

        for (Actor actor : this.actors) {
            System.out.println(actor + " " + actor.getX() + " " + actor.getY());
        }

        System.out.println("");

        this.printOverheadView();

        System.out.println("");

    }

    public void printEndMessage() {
        if (this.vampires <= 0) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }

    private void printOverheadView() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                String toPrint = "."; //default print symbol
                for (Actor actor : this.actors) {
                    if (actor.getX() == j && actor.getY() == i) {
                        toPrint = actor.toString();
                    }
                }
                System.out.print(toPrint);
            }
            System.out.println("");
        }
    }

    private char randomDirection() {
        int rand = this.random.nextInt(4);

        if (rand == 0) {
            return 'a';
        }
        if (rand == 1) {
            return 's';
        }
        if (rand == 2) {
            return 'd';
        }
        if (rand == 3) {
            return 'w';
        }
        return ' ';
    }

    public Boolean locationUnoccupied(int x, int y) {
        for (Actor actor : this.actors) {
            if (actor.getX() == x && actor.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public Boolean inBounds(int x, int y) {
        if (x < 0 || x >= this.length) {
            return false;
        }
        if (y < 0 || y >= this.height) {
            return false;
        }
        return true;
    }

    private Boolean locationHasVampire(int x, int y) {
        for (Actor actor : this.actors) {
            if (actor instanceof Vampire && actor.getX() == x && actor.getY() == y) {
                return true;
            }
        }
        return false;
    }
    
    private void step(char command) {       
        int playerX = 0;
        int playerY = 0;
        
        for (Actor actor : this.actors) {
            if (actor instanceof Player) {
                actor.move(command, this);
                playerX = actor.getX();
                playerY = actor.getY();                        
                break;
            }
        }

        if (locationHasVampire(playerX, playerY)) {
        ArrayList<Actor> toBeKilled = new ArrayList<Actor>();
        for (Actor actor : this.actors) {
            if (actor instanceof Vampire && actor.getX() == playerX && actor.getY() == playerY) {
              toBeKilled.add(actor);
              this.vampires--;
            }
        }
        this.actors.removeAll(toBeKilled);
        
    }
        
        for (Actor actor : this.actors) {
            if (vampiresMove && actor instanceof Vampire) {
                actor.move(this.randomDirection(), this);
            }
        }

    }
}

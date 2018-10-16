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

public class Team {

    private String name;
    private int max;
    private ArrayList<Player> team;

    public Team(String name) {
        this.name = name;
        this.max = 16;
        this.team = new ArrayList<Player>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        if (this.team.size() < this.max) {
            team.add(player);
        }
    }

    public void printPlayers() {
        for (Player player : this.team) {
            System.out.println(player);
        }
    }

    public void setMaxSize(int maxSize) {
        this.max = maxSize;
    }

    public int size() {
        return team.size();
    }

    public int goals() {
        int goals = 0;
        for (Player player : this.team) {
            goals += player.goals();
        }
        return goals;
    }

}

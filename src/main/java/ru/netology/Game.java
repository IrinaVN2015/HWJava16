package ru.netology;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName1 + " is not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName2 + " is not registered");
        }
        if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
            return 0;
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }


    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

}


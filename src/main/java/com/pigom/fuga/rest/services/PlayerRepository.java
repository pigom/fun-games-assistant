package com.pigom.fuga.rest.services;

import com.pigom.fuga.rest.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>() ;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}

package com.pigom.fuga.rest.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private String name;
    private long id;
    private Set<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        if (this.players == null) {
            this.players = new HashSet<>();
        }
        this.players.add(player);
    }
}

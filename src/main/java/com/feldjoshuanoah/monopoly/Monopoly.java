package com.feldjoshuanoah.monopoly;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the application. This takes care of setting up and managing
 * the game while it is in progress.
 */
public class Monopoly {

    /**
     * The maximum amount of players that can participate in a game.
     */
    private static final int MAX_PLAYERS = 4;

    /**
     * The players participating in the game.
     */
    private final List<Player> players;

    /**
     * Creates a new game.
     */
    public Monopoly() {
        players = new ArrayList<>();
    }

    /**
     * Adds a player to the list of participating players. If there already are
     * {@link #MAX_PLAYERS} in the game, this method will have no effect on the
     * list of players.
     *
     * @param name The name of the player to add.
     */
    public void addPlayer(final String name) {
        if (players.size() < MAX_PLAYERS) {
            players.add(new Player(name));
        }
    }
}

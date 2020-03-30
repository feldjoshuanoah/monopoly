package com.feldjoshuanoah.monopoly;

import com.feldjoshuanoah.monopoly.property.AbstractProperty;

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
     * The properties that the participating players can buy or have bought.
     */
    public static final List<AbstractProperty> PROPERTIES = new ArrayList<>();

    /**
     * The players participating in the game.
     */
    private final List<Player> players;

    /**
     * Creates a new game.
     */
    private Monopoly() {
        players = new ArrayList<>();
    }

    /**
     * Returns the current instance of the class.
     *
     * @return The current instance of the class.
     */
    public static Monopoly getInstance() {
        return Singleton.INSTANCE;
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

    /**
     * Helper class to make {@link Monopoly} a singleton. This uses the approach
     * of Bill Pugh which exploits the fact that if the main class is loaded,
     * the {@code Singleton} class is not loaded into memory. Only when the
     * {@link #getInstance()} method is classed, this class gets loaded and
     * creates the singleton class instance.
     */
    private static class Singleton {

        /**
         * The instance of the main class.
         */
        private static final Monopoly INSTANCE = new Monopoly();
    }
}

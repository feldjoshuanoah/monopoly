package com.feldjoshuanoah.monopoly;

import com.feldjoshuanoah.monopoly.property.AbstractProperty;
import com.feldjoshuanoah.monopoly.property.Railroad;
import com.feldjoshuanoah.monopoly.property.Street;
import com.feldjoshuanoah.monopoly.property.Street.Group;
import com.feldjoshuanoah.monopoly.property.Utility;

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
    public static final AbstractProperty[] PROPERTIES = new AbstractProperty[] {
            // This is the only part of the application where we break the
            // maximum line length of 80 characters to keep the code more
            // concise and readable. The target line length in this case is 100
            // characters.
            new Street("Mediteranean Avenue", 60, Group.BROWN, 2, 10, 30, 90, 160, 250),
            new Street("Baltic Avenue", 60, Group.BROWN, 4, 20, 60, 180, 320, 450),
            new Street("Oriental Avenue", 100, Group.LIGHT_BLUE, 6, 30, 90, 270, 400, 550),
            new Street("Vermont Avenue", 100, Group.LIGHT_BLUE, 6, 30, 90, 270, 400, 550),
            new Street("Connecticut Avenue", 120, Group.LIGHT_BLUE, 8, 40, 100, 300, 450, 600),
            new Street("St. Charles Place", 140, Group.PINK, 10, 50, 150, 450, 625, 750),
            new Street("States Avenue", 140, Group.PINK, 10, 50, 150, 450, 625, 750),
            new Street("Virginia Avenue", 160, Group.PINK, 12, 60, 180, 500, 700, 900),
            new Street("St. James Place", 180, Group.ORANGE, 14, 70, 200, 550, 750, 950),
            new Street("Tennessee Avenue", 180, Group.ORANGE, 14, 70, 200, 550, 750, 950),
            new Street("New York Avenue", 200, Group.ORANGE, 16, 80, 220, 600, 800, 1000),
            new Street("Kentucky Avenue", 220, Group.RED, 18, 90, 250, 700, 875, 1050),
            new Street("Indiana Avenue", 220, Group.RED, 18, 90, 250, 700, 875, 1050),
            new Street("Illinois Avenue", 240, Group.RED, 20, 100, 300, 750, 925, 1100),
            new Street("Atlantic Avenue", 260, Group.YELLOW, 22, 110, 330, 800, 975, 1150),
            new Street("Ventnor Avenue", 260, Group.YELLOW, 22, 110, 330, 800, 975, 1150),
            new Street("Marvin Gardens", 280, Group.YELLOW, 24, 120, 360, 850, 1025, 1200),
            new Street("Pacific Avenue", 300, Group.GREEN, 26, 130, 390, 900, 1100, 1275),
            new Street("North Carolina Avenue", 300, Group.GREEN, 26, 130, 390, 900, 1100, 1275),
            new Street("Pennsylvania Avenue", 320, Group.GREEN, 28, 150, 450, 1000, 1200, 1400),
            new Street("Park Place", 350, Group.BLUE, 35, 175, 500, 1100, 1300, 1500),
            new Street("Park Place", 400, Group.BLUE, 50, 200, 600, 1400, 1700, 2000),
            new Railroad("Reading Railroad"),
            new Railroad("Pennsylvania Railroad"),
            new Railroad("B. And O. Railroad"),
            new Railroad("Short Line"),
            new Utility("Electric Company"),
            new Utility("Water Works")
    };
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

    public static void main(String[] args) {
        for (int i = 0; i < PROPERTIES.length; i++) {
            System.out.println(PROPERTIES[i]);
        }
    }
}

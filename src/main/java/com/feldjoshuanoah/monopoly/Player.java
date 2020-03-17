package com.feldjoshuanoah.monopoly;

/**
 * A player participating in a game.
 */
public class Player {

    /**
     * The amount of money that the player receives when the game starts.
     */
    private static final int STARTING_BALANCE = 2000;

    /**
     * The name of the player.
     */
    private final String name;
    /**
     * The current balance of the player. At the start of the game this will
     * hold the value of the constant {@link #STARTING_BALANCE}.
     */
    private int balance;

    /**
     * Creates a new player with the given name.
     *
     * @param name The name of the player.
     */
    public Player(final String name) {
        this.name = name;
        balance = STARTING_BALANCE;
    }

    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current balance of the player.
     *
     * @return The current balance of the player.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Modifies the balance by the given amount. A positive number represents
     * money being added to the bank account while a negative number represents
     * money being removed from the bank account.
     *
     * @param amount The amount to add or remove from the bank account.
     */
    public void modifyBalance(int amount) {
        balance += amount;
    }
}

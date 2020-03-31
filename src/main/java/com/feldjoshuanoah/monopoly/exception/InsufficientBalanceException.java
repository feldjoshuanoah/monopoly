package com.feldjoshuanoah.monopoly.exception;

/**
 * An exception that is thrown if a player doesn't have enough money to perform
 * a desired action, for example buying a property or paying rent.
 */
public class InsufficientBalanceException extends Exception {

    /**
     * Creates a new exception.
     */
    public InsufficientBalanceException() {
        super("The balance is insufficient to perform the desired action.");
    }
}

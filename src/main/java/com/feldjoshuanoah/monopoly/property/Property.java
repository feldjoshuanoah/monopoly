package com.feldjoshuanoah.monopoly.property;

import com.feldjoshuanoah.monopoly.Player;

/**
 * A property which a player can buy.
 */
public abstract class Property {

    /**
     * The name of the property.
     */
    private final String name;
    /**
     * The price a player has to pay to buy the property.
     */
    private final int price;

    /**
     * The owner of the property. If this is {@code null}, the property can be
     * bought by a player when he lands on the corresponding field.
     */
    private Player owner;

    /**
     * Creates a new property.
     *
     * @param name  The name of the property.
     * @param price The price a player has to pay to buy this property.
     */
    public Property(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the property.
     *
     * @return The name of the property.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the property for which it can be bought
     *
     * @return The price of the property for which it can be bought.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the owner of the property. A return value of {@code null} means
     * that no player has bought the property yet and that it can be bought if a
     * player lands on it.
     *
     * @return The owner of the property or {@code null}.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Returns the rent a player (that isn't the owner) has to pay when he lands
     * on the property.
     *
     * @return The rent a player has to pay when he lands on the property.
     */
    public abstract int getRent();
}

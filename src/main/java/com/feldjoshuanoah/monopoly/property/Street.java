package com.feldjoshuanoah.monopoly.property;

import com.feldjoshuanoah.monopoly.Monopoly;

/**
 * A street is the most basic of the three property types. It belongs to a
 * specific color group and has different rent prices for different amounts of
 * houses. The rent also depends on the color group it belongs to - the
 * {@link Group#BROWN brown} properties are the cheapest while the
 * {@link Group#BLUE blue} properties are the most expensive.
 */
public class Street extends AbstractProperty {

    /**
     * The color group that the property belongs to.
     */
    private final Group group;

    /**
     * The rents for the different amount of houses. The value at index 0 is the
     * rent a player has to pay if another player owns the property but there is
     * no house on it yet while the value at index 5 is the rent for a hotel.
     */
    private final int[] rents;

    /**
     * The amount of houses currently built on the street.
     */
    private int houses;

    /**
     * Creates a new street property that belongs to a specific color group. If
     * the rents array doesn't contain exactly six elements, an
     * {@link IllegalArgumentException} is thrown.
     *
     * @param name  The name of the street.
     * @param price The price a player has to pay to buy the street.
     * @param group The color group the street belongs to.
     * @param rents The rents for the different amount of houses (has to contain
     *              exactly six elements).
     *
     * @throws IllegalArgumentException If the rents array doesn't contain
     *                                  exactly six elements.
     */
    public Street(final String name, final int price, final Group group,
                  final int... rents) {
        super(name, price);
        if (rents.length != 6) {
            throw new IllegalArgumentException("The length of the rents array "
                    + "has to be 6.");
        }
        this.group = group;
        this.rents = rents;
    }

    /**
     * Returns the rent a player (that isn't the owner) has to pay if he lands
     * on the street. If the owner has all streets of the color group and the
     * street has no houses built on it yet, the base rent is doubled.
     *
     * @return The rent a player has to pay.
     */
    @Override
    public int getRent() {
        int rent = rents[houses];
        // If the player owns all of the properties of the color group and the
        // street has no houses built on it yet, the base rent is doubled.
        if (houses == 0 && Monopoly.PROPERTIES.stream().filter(property ->
                property instanceof Street && ((Street) property).getGroup()
                .equals(group)).noneMatch(property -> property.getOwner()
                != getOwner())) {
            rent *= 2;
        }
        return rent;
    }

    /**
     * Returns the group that the street belongs to.
     *
     * @return The group that the street belongs to.
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Returns the amount of houses currently built on the street.
     *
     * @return The amount of houses currently built on the street.
     */
    public int getHouses() {
        return houses;
    }

    /**
     * A color group contains up to three properties.
     */
    public enum Group {

        BROWN,
        LIGHT_BLUE,
        PINK,
        ORANGE,
        RED,
        YELLOW,
        GREEN,
        BLUE
    }
}

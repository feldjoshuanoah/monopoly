package com.feldjoshuanoah.monopoly.property;

import com.feldjoshuanoah.monopoly.Monopoly;

/**
 * A utility is a special type of property where the rent is based on the number
 * of utilities the owner has and the amount shown on the dice of the player
 * that lands on the property.
 */
public class Utility extends AbstractProperty {

    /**
     * The factor to multiply the amount shown on the dice with if the owner
     * only owns this utility and not the other one as well.
     */
    private static final int ONE_FACTOR = 4;
    /**
     * The factor to multiply the amount shown on the dice with if the owner
     * owns both utility properties.
     */
    private static final int TWO_FACTOR = 10;

    /**
     * Creates a new utility property.
     *
     * @param name  The name of the utility.
     * @param price The price a player has to pay to buy this utility.
     */
    public Utility(String name, int price) {
        super(name, price);
    }

    /**
     * Returns the factor with which the amount shown on the dice has to be
     * multiplied. If the owner only owns one of the utility properties the rent
     * is four times the amount shown on the dice; otherwise it's ten times.
     *
     * @return The factor with which the amount shown on the dice has to be
     *         multiplied.
     */
    @Override
    public int getRent() {
        return Monopoly.PROPERTIES.stream().filter(property -> property
                instanceof Utility && property.getOwner().equals(getOwner()))
                .count() == 2 ? TWO_FACTOR : ONE_FACTOR;
    }
}

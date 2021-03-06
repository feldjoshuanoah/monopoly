package com.feldjoshuanoah.monopoly.property;

import com.feldjoshuanoah.monopoly.Monopoly;

import java.util.Arrays;

/**
 * A utility is a special type of property where the rent is based on the number
 * of utilities the owner has and the amount shown on the dice of the player
 * that lands on the property.
 */
public class Utility extends AbstractProperty {

    /**
     * The default price for the utilities.
     */
    private static final int PRICE = 150;

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
     * @param name The name of the utility.
     */
    public Utility(String name) {
        super(name, PRICE);
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
        return Arrays.stream(Monopoly.PROPERTIES).filter(property -> property
                instanceof Utility && property.getOwner().equals(getOwner()))
                .count() == 2 ? TWO_FACTOR : ONE_FACTOR;
    }
}

package com.feldjoshuanoah.monopoly.property;

import com.feldjoshuanoah.monopoly.Monopoly;

import java.util.Arrays;

/**
 * A railroad is a special type of property of which there are four in the game.
 * The rent of railroads is calculated using the formula {@code rent = b * 2^o},
 * where {@code b} is the {@link #BASE_RENT} and {@code o} is the amount of
 * railroads owned by the owner of the railroad.
 */
public class Railroad extends AbstractProperty {

    /**
     * The default price for the railroads.
     */
    private static final int PRICE = 200;

    /**
     * The base rent if the owner just owns one of the four available railroads.
     */
    private static final int BASE_RENT = 25;

    /**
     * Creates a new railroad property.
     *
     * @param name The name of the railroad.
     */
    public Railroad(final String name) {
        super(name, PRICE);
    }

    /**
     * Returns the rent a player (that isn't the owner) has to pay if he lands
     * on the railroad. The rent is calculated with the formula
     * {@code rent = b * 2^o}, where {@code b} is the {@link #BASE_RENT} and
     * {@code o} is the amount of railroads owned by the owner of the railroad.
     *
     * <p>Note that this will return a wrong value if no player owns the
     * property yet but this shouldn't be an issue since the method shouldn't
     * even be called in that case.
     *
     * @return The rent a player has to pay.
     */
    @Override
    public int getRent() {
        return BASE_RENT * (int) Math.pow(2, Arrays.stream(Monopoly.PROPERTIES)
                .filter(property -> property instanceof Railroad && property
                .getOwner().equals(getOwner())).count() - 1);
    }
}

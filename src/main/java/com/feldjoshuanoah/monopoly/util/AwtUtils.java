package com.feldjoshuanoah.monopoly.util;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains utility methods for handling AWT related operations.
 */
public final class AwtUtils {

    /**
     * Holds already loaded fonts to reduce the amount of I/O actions for
     * loading fonts from the resources directory. The key will always be in the
     * format {@code "name.size"}.
     */
    private static final Map<Character, BufferedImage> CHARACTERS
            = new HashMap<>();

    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                CHARACTERS.put(c, ImageIO.read(AwtUtils.class.getClassLoader()
                        .getResource("font/regular/" + c + ".png")));
            } catch (final IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Since this is a utility class we don't want any outer class to be able to
     * create a new instance of this class.
     */
    private AwtUtils() {
    }

    /**
     * Draws a string with our custom created font. This system is probably not
     * ideal but works in our use case. It draws a string by drawing the images
     * of the single characters by hand.
     *
     * @param string     The string to draw.
     * @param x          The x-component of the upper-left corner of the text.
     * @param y          The y-component of the upper-left corner of the text.
     * @param graphics2d The graphics context on which to draw.
     */
    public static void drawString(final String string, final int x, final int y,
                                  final Graphics2D graphics2d) {
        int currentX = x;
        for (final char character : string.toUpperCase().toCharArray()) {
            if (character == ' ') {
                currentX += 2;
            } else {
                graphics2d.drawImage(CHARACTERS.get(character), currentX, y,
                        null);
                currentX += CHARACTERS.get(character).getWidth();
            }
            currentX += 1;
        }
    }
}

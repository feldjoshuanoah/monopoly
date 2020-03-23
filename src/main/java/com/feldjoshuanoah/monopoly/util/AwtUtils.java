package com.feldjoshuanoah.monopoly.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
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
    private static final Map<String, Font> FONT_CACHE = new HashMap<>();

    /**
     * Since this is a utility class we don't want any outer class to be able to
     * create a new instance of this class.
     */
    private AwtUtils() {
    }

    /**
     * Loads a font from the {@code fonts} folder which is located in the
     * resources directory. Only files that are in the TTF format can be loaded
     * by this method. Fonts that are loaded will be kept in the
     * {@link #FONT_CACHE font cache} to reduce the amount of I/O actions when
     * this method is called twice with the same parameter.
     *
     * <p>If the font cannot be loaded due to an {@link IOException} (for
     * example if the file could not be found), this method will return
     * {@code null}.
     *
     * @param  name The name of the font file to load.
     * @param  size The font size to load, in points (pt).
     * @return      The loaded font or {@code null} if the font could not be
     *              loaded.
     */
    public static Font loadFont(final String name, final float size) {
        final String cacheKey = name + "." + size;
        Font font = FONT_CACHE.getOrDefault(cacheKey, null);
        if (font == null) {
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, new File("font/"
                        + name + ".ttf")).deriveFont(size);
                GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .registerFont(font);
                FONT_CACHE.put(cacheKey, font);
            } catch (final IOException | FontFormatException exception) {
                // TODO: We should probably handle these exceptions better.
                exception.printStackTrace();
            }
        }
        return font;
    }
}

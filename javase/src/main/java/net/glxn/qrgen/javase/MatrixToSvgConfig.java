package net.glxn.qrgen.javase;

import java.awt.*;

public class MatrixToSvgConfig {

    private final Color onColor;

    private final Color offColor;

    /**
     * Creates a default config with on color {@link #BLACK} and off color
     * {@link #WHITE}, generating normal black-on-white barcodes.
     */
    public MatrixToSvgConfig() {
        this(Color.BLACK, Color.WHITE);
    }

    /**
     * @param onColor  pixel on color, specified as an ARGB value as an int
     * @param offColor pixel off color, specified as an ARGB value as an int
     */
    public MatrixToSvgConfig(Color onColor, Color offColor) {
        this.onColor = onColor;
        this.offColor = offColor;
    }

    public Color getPixelOnColor() {
        return onColor;
    }

    public Color getPixelOffColor() {
        return offColor;
    }

}

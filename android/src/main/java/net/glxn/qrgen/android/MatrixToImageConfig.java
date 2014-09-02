package net.glxn.qrgen.android;

import android.graphics.Bitmap;

public class MatrixToImageConfig {

    public static final int BLACK = 0xFF000000;

    public static final int WHITE = 0xFFFFFFFF;

    private final int onColor;

    private final int offColor;

    /**
     * Creates a default config with on color {@link #BLACK} and off color
     * {@link #WHITE}, generating normal black-on-white barcodes.
     */
    public MatrixToImageConfig() {
        this(BLACK, WHITE);
    }

    /**
     * @param onColor  pixel on color, specified as an ARGB value as an int
     * @param offColor pixel off color, specified as an ARGB value as an int
     */
    public MatrixToImageConfig(int onColor, int offColor) {
        this.onColor = onColor;
        this.offColor = offColor;
    }

    public int getPixelOnColor() {
        return onColor;
    }

    public int getPixelOffColor() {
        return offColor;
    }

    Bitmap.Config getBufferedImageColorModel() {
        //On Android the ALPHA_8 model doesn't work, results in empty files and therefore IOExceptions
        return Bitmap.Config.ARGB_8888;
    }
}

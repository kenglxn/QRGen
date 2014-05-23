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
	 * @param onColor
	 *            pixel on color, specified as an ARGB value as an int
	 * @param offColor
	 *            pixel off color, specified as an ARGB value as an int
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
//		return 0;
		// Use faster BINARY if colors match default
		//Represents an image with 8-bit RGBA color components packed into integer pixels.
		//Represents an opaque byte-packed 1, 2, or 4 bit image.
		return onColor == BLACK && offColor == WHITE ? Bitmap.Config.ALPHA_8: Bitmap.Config.ARGB_8888;
		//return onColor == BLACK && offColor == WHITE ? Bitmap.TYPE_BYTE_BINARY: BufferedImage.TYPE_INT_RGB;
	}
}

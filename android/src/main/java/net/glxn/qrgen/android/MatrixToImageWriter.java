package net.glxn.qrgen.android;

import android.graphics.Bitmap;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class MatrixToImageWriter {

    private static final MatrixToImageConfig DEFAULT_CONFIG = new MatrixToImageConfig();

    private MatrixToImageWriter() {
    }

    /**
     * Renders a {@link BitMatrix} as an image, where "false" bits are rendered
     * as white, and "true" bits are rendered as black. Uses default
     * configuration.
     *
     * @param matrix {@link BitMatrix} to write
     * @return {@link Bitmap} representation of the input
     */
    public static Bitmap toBitmap(BitMatrix matrix) {
        return toBitmap(matrix, DEFAULT_CONFIG);
    }

    /**
     * As {@link #toBitmap(BitMatrix)}, but allows customization of the output.
     *
     * @param matrix {@link BitMatrix} to write
     * @param config output configuration
     * @return {@link Bitmap} representation of the input
     */
    public static Bitmap toBitmap(BitMatrix matrix, MatrixToImageConfig config) {
        final int onColor = config.getPixelOnColor();
        final int offColor = config.getPixelOffColor();
        final int width = matrix.getWidth();
        final int height = matrix.getHeight();
        final int[] pixels = new int[width * height];

        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = matrix.get(x, y) ? onColor : offColor;
            }
        }

        Bitmap image = Bitmap.createBitmap(width, height, config.getBufferedImageColorModel());
        image.setPixels(pixels, 0, width, 0, 0, width, height);
        return image;
    }

    /**
     * Writes a {@link BitMatrix} to a file.
     *
     * @see #writeToFile(com.google.zxing.common.BitMatrix, String, java.io.File, MatrixToImageConfig)
     */
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        writeToFile(matrix, format, file, DEFAULT_CONFIG);
    }

    /**
     * As {@link #writeToFile(BitMatrix, String, File)}, but allows
     * customization of the output.
     */
    public static void writeToFile(BitMatrix matrix, String format, File file, MatrixToImageConfig config) throws IOException {
        Bitmap image = toBitmap(matrix, config);
        if (!BitmapIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * Writes a {@link BitMatrix} to a stream.
     *
     * @see #writeToStream(com.google.zxing.common.BitMatrix, String, java.io.OutputStream, MatrixToImageConfig)
     */
    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        writeToStream(matrix, format, stream, DEFAULT_CONFIG);
    }

    /**
     * As {@link #writeToStream(BitMatrix, String, OutputStream)}, but allows
     * customization of the output.
     */
    public static void writeToStream(
            BitMatrix matrix,
            String format,
            OutputStream stream,
            MatrixToImageConfig config
    ) throws IOException {
        Bitmap image = toBitmap(matrix, config);
        if (!BitmapIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }
}

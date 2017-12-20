package net.glxn.qrgen.android;

import android.graphics.Bitmap;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.glxn.qrgen.core.AbstractQRCode;
import net.glxn.qrgen.core.exception.QRGenerationException;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.scheme.Schema;
import net.glxn.qrgen.core.scheme.VCard;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class QRCode extends AbstractQRCode {

    protected final String text;
    private MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig();

    protected QRCode(String text) {
        this.text = text;
        qrWriter = new QRCodeWriter();
    }

    /**
     * Create a QR code from the given text. <br/>
     * <br/>
     * <p/>
     * There is a size limitation to how much you can put into a QR code. This
     * has been tested to work with up to a length of 2950 characters.<br/>
     * <br/>
     * <p/>
     * The QRCode will have the following defaults: <br/>
     * {size: 100x100}<br/>
     * {imageType:PNG} <br/>
     * <br/>
     * <p/>
     * Both size and imageType can be overridden: <br/>
     * Image type override is done by calling
     * {@link AbstractQRCode#to(net.glxn.qrgen.core.image.ImageType)} e.g.
     * QRCode.from("hello world").to(JPG) <br/>
     * Size override is done by calling {@link AbstractQRCode#withSize} e.g.
     * QRCode.from("hello world").to(JPG).withSize(125, 125) <br/>
     *
     * @param text the text to encode to a new QRCode, this may fail if the text
     *             is too large. <br/>
     * @return the QRCode object <br/>
     */
    public static QRCode from(String text) {
        return new QRCode(text);
    }

    /**
     * Creates a a QR Code from the given {@link Schema}.
     * <p/>
     * The QRCode will have the following defaults: <br/>
     * {size: 100x100}<br/>
     * {imageType:PNG} <br/>
     * <br/>
     *
     * @param schema the schema to encode as QRCode
     * @return the QRCode object
     */
    public static QRCode from(Schema schema) {
        return new QRCode(schema.generateString());
    }

    /**
     * Overrides the imageType from its default {@link net.glxn.qrgen.core.image.ImageType#PNG}
     *
     * @param imageType the {@link net.glxn.qrgen.core.image.ImageType} you would like the resulting QR to be
     * @return the current QRCode object
     */
    public QRCode to(ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    /**
     * override default colors (black on white)
     * notice that the color format is "0x(alpha: 1 byte)(RGB: 3 bytes)"
     * @param onColor the color for the qrcode
     * @param offColor the color for the background
     */
    public QRCode withColor(int onColor, int offColor) {
        matrixToImageConfig = new MatrixToImageConfig(onColor, offColor);
        return this;
    }

    /**
     * Overrides the size of the qr from its default 125x125
     *
     * @param width  the width in pixels
     * @param height the height in pixels
     * @return the current QRCode object
     */
    public QRCode withSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * Overrides the default charset by supplying a {@link com.google.zxing.EncodeHintType#CHARACTER_SET} hint to {@link
     * com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public QRCode withCharset(String charset) {
        return withHint(EncodeHintType.CHARACTER_SET, charset);
    }

    /**
     * Overrides the default error correction by supplying a {@link com.google.zxing.EncodeHintType#ERROR_CORRECTION} hint to
     * {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public QRCode withErrorCorrection(ErrorCorrectionLevel level) {
        return withHint(EncodeHintType.ERROR_CORRECTION, level);
    }

    /**
     * Sets hint to {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public QRCode withHint(EncodeHintType hintType, Object value) {
        hints.put(hintType, value);
        return this;
    }

    /**
     * Returns a {@link android.graphics.Bitmap} without creating a {@link java.io.File} first.
     *
     * @return {@link android.graphics.Bitmap} of this QRCode
     */
    public Bitmap bitmap() {
        try {
            return MatrixToImageWriter.toBitmap(createMatrix(text), matrixToImageConfig);
        } catch (WriterException e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }
    }

    @Override
    public File file() {
        File file;
        try {
            file = createTempFile();
            MatrixToImageWriter.writeToFile(createMatrix(text), imageType.toString(), file, matrixToImageConfig);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }

        return file;
    }

    @Override
    public File file(String name) {
        File file;
        try {
            file = createTempFile(name);
            MatrixToImageWriter.writeToFile(createMatrix(text), imageType.toString(), file, matrixToImageConfig);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }

        return file;
    }

    @Override
    protected void writeToStream(OutputStream stream) throws IOException, WriterException {
        MatrixToImageWriter.writeToStream(createMatrix(text), imageType.toString(), stream, matrixToImageConfig);
    }
}

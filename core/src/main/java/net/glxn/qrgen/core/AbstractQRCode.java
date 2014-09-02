package net.glxn.qrgen.core;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import net.glxn.qrgen.core.exception.QRGenerationException;
import net.glxn.qrgen.core.image.ImageType;

import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * QRCode generator. This is a simple class that is built on top of <a href="http://code.google.com/p/zxing/">ZXING</a><br/><br/>
 * <p/>
 * Please take a look at their framework, as it has a lot of features. <br/> This small project is just a wrapper that gives a
 * convenient interface to work with. <br/><br/>
 * <p/>
 * Start here: {@link AbstractQRCode#from(String)} (e.g QRCode.from("hello"))
 */
public abstract class AbstractQRCode {

    protected final HashMap<EncodeHintType, Object> hints = new HashMap<>();

    protected Writer qrWriter;

    protected int width = 125;

    protected int height = 125;

    protected ImageType imageType = ImageType.PNG;

    /**
     * Overrides the imageType from its default {@link ImageType#PNG}
     *
     * @param imageType the {@link ImageType} you would like the resulting QR to be
     * @return the current QRCode object
     */
    public AbstractQRCode to(ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    /**
     * Overrides the size of the qr from its default 125x125
     *
     * @param width  the width in pixels
     * @param height the height in pixels
     * @return the current QRCode object
     */
    public AbstractQRCode withSize(int width, int height) {
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
    public AbstractQRCode withCharset(String charset) {
        return withHint(EncodeHintType.CHARACTER_SET, charset);
    }

    /**
     * Overrides the default error correction by supplying a {@link com.google.zxing.EncodeHintType#ERROR_CORRECTION} hint to
     * {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public AbstractQRCode withErrorCorrection(ErrorCorrectionLevel level) {
        return withHint(EncodeHintType.ERROR_CORRECTION, level);
    }

    /**
     * Sets hint to {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public AbstractQRCode withHint(EncodeHintType hintType, Object value) {
        hints.put(hintType, value);
        return this;
    }

    /**
     * returns a {@link File} representation of the QR code. The file is set to be deleted on exit (i.e. {@link
     * java.io.File#deleteOnExit()}). If you want the file to live beyond the life of the jvm process, you should make a copy.
     *
     * @return qrcode as file
     */
    public abstract File file();

    /**
     * returns a {@link File} representation of the QR code. The file has the given name. The file is set to be deleted on exit
     * (i.e. {@link java.io.File#deleteOnExit()}). If you want the file to live beyond the life of the jvm process, you should
     * make a copy.
     *
     * @param name name of the created file
     * @return qrcode as file
     * @see #file()
     */
    public abstract File file(String name);

    /**
     * returns a {@link ByteArrayOutputStream} representation of the QR code
     *
     * @return qrcode as stream
     */
    public ByteArrayOutputStream stream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            writeToStream(stream);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }

        return stream;
    }

    /**
     * writes a representation of the QR code to the supplied  {@link OutputStream}
     *
     * @param stream the {@link OutputStream} to write QR Code to
     */
    public void writeTo(OutputStream stream) {
        try {
            writeToStream(stream);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }
    }

    protected abstract void writeToStream(OutputStream stream) throws IOException, WriterException;

    protected BitMatrix createMatrix(String text) throws WriterException {
        return qrWriter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, width, height, hints);
    }

    protected File createTempFile() throws IOException {
        File file = File.createTempFile("QRCode", "." + imageType.toString().toLowerCase());
        file.deleteOnExit();
        return file;
    }

    protected File createTempFile(String name) throws IOException {
        File file = File.createTempFile(name, "." + imageType.toString().toLowerCase());
        file.deleteOnExit();
        return file;
    }

    public Writer getQrWriter() {
        return qrWriter;
    }

    public void setQrWriter(Writer qrWriter) {
        this.qrWriter = qrWriter;
    }
}

package net.glxn.qrgen;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import net.glxn.qrgen.exception.QRGenerationException;
import net.glxn.qrgen.image.ImageType;

/**
 * QRCode generator. This is a simple class that is built on top of <a href="http://code.google.com/p/zxing/">ZXING</a><br/><br/>
 *
 * Please take a look at their framework, as it has a lot of features. <br/>
 * This small project is just a wrapper that gives a convenient interface to work with. <br/><br/>
 *
 * Start here: {@link QRCode#from(String)} (e.g QRCode.from("hello"))
 */
public class QRCode {

    private final String text;
    private ImageType imageType = ImageType.PNG;
    private int width = 125;
    private int height = 125;

    private QRCode(String text) {
        this.text = text;
    }

    /**
     * Create a QR code from the given text.    <br/><br/>
     * 
     * There is a size limitation to how much you can put into a QR code. This has been tested to work with up to a length of 2950 characters.<br/><br/>
     * 
     * The QRCode will have the following defaults:     <br/>
     * {size: 100x100}<br/>{imageType:PNG}  <br/><br/>
     * 
     * Both size and imageType can be overridden:   <br/>
     * Image type override is done by calling {@link QRCode#to(net.glxn.qrgen.image.ImageType)} e.g. QRCode.from("hello world").to(JPG) <br/>
     * Size override is done by calling {@link QRCode#withSize} e.g. QRCode.from("hello world").to(JPG).withSize(125, 125)  <br/>
     * 
     * @param text the text to encode to a new QRCode, this may fail if the text is too large. <br/>
     * @return the QRCode object    <br/>
     */
    public static QRCode from(String text) {
        return new QRCode(text);
    }

    /**
     * Overrides the imageType from its default {@link ImageType#PNG}
     * @param imageType the {@link ImageType} you would like the resulting QR to be
     * @return the current QRCode object
     */
    public QRCode to(ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    /**
     * Overrides the size of the qr from its default 125x125
     * @param width the width in pixels
     * @param height the height in pixels
     * @return the current QRCode object
     */
    public QRCode withSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * returns a {@link File} representation of the QR code. The file is set to be deleted on exit (i.e. {@link java.io.File#deleteOnExit()}).
     * If you want the file to live beyond the life of the jvm process, you should make a copy.
     * @return qrcode as file
     */
    public File file() {
        File file;
        try {
            file = createTempFile();
            MatrixToImageWriter.writeToFile(createMatrix(), imageType.toString(), file);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }

        return file;
    }

    /**
     * returns a {@link ByteArrayOutputStream} representation of the QR code
     * @return qrcode as stream
     */
    public ByteArrayOutputStream stream() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            MatrixToImageWriter.writeToStream(createMatrix(), imageType.toString(), stream);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }

        return stream;
    }

    /**
     * writes a representation of the QR code to the supplied  {@link OutputStream}
     * @param stream the {@link OutputStream} to write QR Code to
     */
    public void writeTo(OutputStream stream) {
        try {
            MatrixToImageWriter.writeToStream(createMatrix(), imageType.toString(), stream);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }
    }

    private BitMatrix createMatrix() throws WriterException {
        return new QRCodeWriter().encode(text, com.google.zxing.BarcodeFormat.QR_CODE, width, height);
    }

    private File createTempFile() throws IOException {
        File file = File.createTempFile("QRCode", "."+imageType.toString().toLowerCase());
        file.deleteOnExit();
        return file;
    }
}

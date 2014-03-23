package net.glxn.qrgen;


import com.google.zxing.*;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.glxn.qrgen.exception.*;
import net.glxn.qrgen.image.*;
import net.glxn.qrgen.vcard.VCard;

import java.io.*;
import java.util.*;

/**
 * QRCode generator. This is a simple class that is built on top of <a href="http://code.google.com/p/zxing/">ZXING</a><br/><br/>
 *
 * Please take a look at their framework, as it has a lot of features. <br/>
 * This small project is just a wrapper that gives a convenient interface to work with. <br/><br/>
 *
 * Start here: {@link QRCode#from(String)} (e.g QRCode.from("hello"))
 */
public class QRCode {

    Writer qrWriter;
    private int width = 125;
    private int height = 125;
    private final String text;
    private ImageType imageType = ImageType.PNG;
    private final HashMap<EncodeHintType,Object> hints = new HashMap<EncodeHintType, Object>();

    private QRCode(String text) {
        this.text = text;
        qrWriter = new QRCodeWriter();
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
     * Creates a a QR Code from the given {@link VCard}.
     * 
     * The QRCode will have the following defaults:     <br/>
     * {size: 100x100}<br/>{imageType:PNG}  <br/><br/>
     * 
     * @param vcard the vcard to encode as QRCode
     * @return the QRCode object
     */
    public static QRCode from(VCard vcard){
    	return new QRCode(vcard.toString());
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
     * Overrides the default charset by supplying a {@link com.google.zxing.EncodeHintType#CHARACTER_SET}
     * hint to {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public QRCode withCharset(String charset) {
        return withHint(EncodeHintType.CHARACTER_SET, charset);
    }
    
    /**
     * Overrides the default error correction by supplying a {@link com.google.zxing.EncodeHintType#ERROR_CORRECTION}
     * hint to {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     *
     * @return the current QRCode object
     */
    public QRCode withErrorCorrection(ErrorCorrectionLevel level) {
        return withHint(EncodeHintType.ERROR_CORRECTION, level);
    }
    
    /**
     * Sets hint to {@link com.google.zxing.qrcode.QRCodeWriter#encode}
     * @return the current QRCode object
     */
    public QRCode withHint(EncodeHintType hintType, Object value) {
        hints.put(hintType, value);
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
     * returns a {@link File} representation of the QR code. The file has the given name. 
     * The file is set to be deleted on exit (i.e. {@link java.io.File#deleteOnExit()}).
     * If you want the file to live beyond the life of the jvm process, you should make a copy.
     * 
     * @see #file()
     * @param name name of the created file
     * @return qrcode as file
     */
    public File file(String name) {
    	File file;
    	try{
    		file = createTempFile(name);
    		MatrixToImageWriter.writeToFile(createMatrix(), imageType.toString(), file);
    	} catch (Exception e){
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
            writeToStream(stream);
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
            writeToStream(stream);
        } catch (Exception e) {
            throw new QRGenerationException("Failed to create QR image from text due to underlying exception", e);
        }
    }

    private void writeToStream(OutputStream stream) throws IOException, WriterException {
        MatrixToImageWriter.writeToStream(createMatrix(), imageType.toString(), stream);
    }

    private BitMatrix createMatrix() throws WriterException {
        return qrWriter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, width, height, hints);
    }

    private File createTempFile() throws IOException {
        File file = File.createTempFile("QRCode", "."+imageType.toString().toLowerCase());
        file.deleteOnExit();
        return file;
    }
    
    private File createTempFile(String name) throws IOException {
    	File file = File.createTempFile(name, "."+imageType.toString().toLowerCase());
        file.deleteOnExit();
        return file;
    }
}

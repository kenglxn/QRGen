package net.glxn.qrgen;


import com.google.zxing.*;
import com.google.zxing.Writer;
import com.google.zxing.common.*;
import net.glxn.qrgen.exception.*;
import net.glxn.qrgen.image.*;
import org.junit.*;

import java.io.*;
import java.util.*;

public class QRCodeTest {

    @Test
    public void shouldGetFileFromTextWithDefaults() throws Exception {
        File file = QRCode.from("Hello World").file();
        Assert.assertNotNull(file);
    }

    @Test
    public void shouldGetFileWithNameFromTextWithDefaults() throws Exception {
        File file = QRCode.from("Hello World").file("Hello World");
        Assert.assertNotNull(file);
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }

    @Test
    public void shouldGetSTREAMFromTextWithDefaults() throws Exception {
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();
        Assert.assertNotNull(stream);
    }

    @Test
    public void shouldHandleLargeString() throws Exception {

        int length = 2950;
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = 'a';
        }
        String text = new String(chars);
        Assert.assertEquals(length, text.length());

        File file = QRCode.from(text).to(ImageType.PNG).file();
        Assert.assertNotNull(file);
    }

    @Test
    public void shouldGetFileFromTextWithImageTypeOverrides() throws Exception {
        File jpg = QRCode.from("Hello World").to(ImageType.JPG).file();
        Assert.assertNotNull(jpg);
        File gif = QRCode.from("Hello World").to(ImageType.GIF).file();
        Assert.assertNotNull(gif);
    }

    @Test
    public void shouldGetFileWithNameFromTextWithImageTypeOverrides() throws Exception {
        File jpg = QRCode.from("Hello World").to(ImageType.JPG).file("Hello World");
        Assert.assertNotNull(jpg);
        Assert.assertTrue(jpg.getName().startsWith("Hello World"));
        File gif = QRCode.from("Hello World").to(ImageType.GIF).file("Hello World");
        Assert.assertNotNull(gif);
        Assert.assertTrue(gif.getName().startsWith("Hello World"));
    }

    @Test
    public void shouldGetStreamFromText() throws Exception {
        ByteArrayOutputStream stream = QRCode.from("Hello World").to(ImageType.PNG).stream();
        Assert.assertNotNull(stream);
        File tempFile = File.createTempFile("test", ".tmp");
        long lengthBefore = tempFile.length();
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        stream.writeTo(fileOutputStream);
        Assert.assertTrue(lengthBefore < tempFile.length());
    }

    @Test
    public void shouldWriteToSuppliedStream() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        QRCode.from("Hello World").writeTo(stream);

        Assert.assertNotNull(stream);
        File tempFile = File.createTempFile("test", ".tmp");
        long lengthBefore = tempFile.length();
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        stream.writeTo(fileOutputStream);
        Assert.assertTrue(lengthBefore < tempFile.length());
    }

    @Test
    public void shouldBeAbleToOverrideDimensionsToFile() throws Exception {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file();
        Assert.assertNotNull(file);
        Assert.assertTrue(defaultSize == defaultSize2);
        Assert.assertTrue(defaultSize < file.length());
    }

    @Test
    public void shouldBeAbleToOverrideDimensionsToFileWithName() throws Exception {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file("Hello World");
        Assert.assertNotNull(file);
        Assert.assertTrue(defaultSize == defaultSize2);
        Assert.assertTrue(defaultSize < file.length());
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }

    @Test
    public void shouldBeAbleToSupplyEncodingHint() throws Exception {
        String charset = "UTF-8";
        final Object[] charsetHint = new Object[1];
        try {
            final QRCode from = QRCode.from("Jour férié");
            from.qrWriter = new Writer() {
                @Override
                public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
                    throw new UnsupportedOperationException("not implemented");
                }

                @Override
                public BitMatrix encode(String contents, BarcodeFormat format, int width, int height,
                                        Map<EncodeHintType, ?> hints)
                        throws WriterException {
                    charsetHint[0] = hints.get(EncodeHintType.CHARACTER_SET);
                    return new BitMatrix(0);
                }
            };
            from.to(ImageType.PNG).withCharset(charset).stream();
        } catch (QRGenerationException ignored) {
        }
        Assert.assertEquals(charset, charsetHint[0]);
    }
}

package net.glxn.qrgen.javase;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.exception.QRGenerationException;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.scheme.VCard;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class QRCodeTest {

    @Test
    public void shouldGetFileFromVCardWithDefaults() {
        VCard johnDoe = new VCard("John Doe")
                .setName("John Doe")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Berlin")
                .setTitle("Mister")
                .setCompany("John Doe Inc.")
                .setPhoneNumber("1234")
                .setWebsite("www.example.org");
        File file = QRCode.from(johnDoe).file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetFileFromVCardWithExtendedChars() {
        VCard johnDoe = new VCard("John Doe")
                .setName("Björkelundsvägen")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Gråbo")
                .setTitle("Mister")
                .setCompany("John Doe Inc.")
                .setPhoneNumber("1234")
                .setWebsite("www.Björkelundsvägen.org");
        File file = QRCode.from(johnDoe).file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetBitmapFileFromText() {
        File file = QRCode.from("www.example.org").to(ImageType.BMP).file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetFileFromTextWithDefaults() {
        File file = QRCode.from("Hello World").file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetFileWithNameFromTextWithDefaults() {
        File file = QRCode.from("Hello World").file("Hello World");
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }

    @Test
    public void shouldGetSTREAMFromTextWithDefaults() {
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();
        Assert.assertNotNull(stream);
    }

    @Test
    public void shouldHandleLargeString() {
        int length = 2950;
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = 'a';
        }
        String text = new String(chars);
        Assert.assertEquals(length, text.length());

        File file = QRCode.from(text).to(ImageType.PNG).file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetFileFromTextWithImageTypeOverrides() {
        File jpg = QRCode.from("Hello World").to(ImageType.JPG).file();
        Assert.assertNotNull(jpg);
        File gif = QRCode.from("Hello World").to(ImageType.GIF).file();
        assertThat(gif).exists();
        assertThat(gif).canRead();
        assertThat(gif.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetFileWithNameFromTextWithImageTypeOverrides() {
        File jpg = QRCode.from("Hello World").to(ImageType.JPG).file("Hello World");
        Assert.assertNotNull(jpg);
        Assert.assertTrue(jpg.getName().startsWith("Hello World"));
        File gif = QRCode.from("Hello World").to(ImageType.GIF).file("Hello World");
        assertThat(gif).exists();
        assertThat(gif).canRead();
        assertThat(gif.length()).isGreaterThan(0);
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
        assertThat(tempFile.length()).isGreaterThan(lengthBefore);
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
        assertThat(tempFile.length()).isGreaterThan(lengthBefore);
    }

    @Test
    public void shouldBeAbleToOverrideDimensionsToFile() {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
        Assert.assertEquals(defaultSize, defaultSize2);
        Assert.assertTrue(defaultSize < file.length());
    }

    @Test
    public void shouldBeAbleToOverrideDimensionsToFileWithName() {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file("Hello World");
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
        Assert.assertEquals(defaultSize, defaultSize2);
        Assert.assertTrue(defaultSize < file.length());
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }

    @Test
    public void shouldBeAbleToSupplyEncodingHint() {
        String expected = "UTF-8";
        final Object[] capture = new Object[1];
        try {
            final QRCode from = QRCode.from("Jour férié");
            from.setQrWriter(writerWithCapture(capture));
            from.to(ImageType.PNG).withCharset(expected).stream();
        } catch (QRGenerationException ignored) {
        }
        assertCapturedHint(expected, capture, EncodeHintType.CHARACTER_SET);
    }

    @Test
    public void shouldBeAbleToSupplyErrorCorrectionHint() {
        ErrorCorrectionLevel expected = ErrorCorrectionLevel.L;
        final Object[] capture = new Object[1];
        try {
            final QRCode from = QRCode.from("Jour férié");
            from.setQrWriter(writerWithCapture(capture));
            from.to(ImageType.PNG).withErrorCorrection(ErrorCorrectionLevel.L).stream();
        } catch (QRGenerationException ignored) {
        }
        assertCapturedHint(expected, capture, EncodeHintType.ERROR_CORRECTION);
    }

    @Test
    public void shouldBeAbleToSupplyAnyHint() throws Exception {
        String expected = "a hint";
        EncodeHintType[] hintTypes = EncodeHintType.values();
        for (EncodeHintType type : hintTypes) {
            final Object[] capture = new Object[1];
            try {
                final QRCode from = QRCode.from("Jour férié");
                from.setQrWriter(writerWithCapture(capture));
                from.to(ImageType.PNG).withHint(type, expected).stream();
            } catch (QRGenerationException ignored) {
            }
            assertCapturedHint(expected, capture, type);
        }
    }

    @Test
    public void shouldColorOutput() throws IOException {
        File file = QRCode.from("Hello World").withColor(0xFFFF0000, 0xFFFFFFAA).file();
        File tempFile = File.createTempFile("qr_", ".png");
        Files.copy(file.toPath(), new FileOutputStream(tempFile));
    }

    @Test
    public void shouldGetSvgFromText() {
        File file = QRCode.from("www.example.org").svg();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetSvgWithSizeFromText() {
        File file = QRCode.from("www.example.com").withSize(250, 250).svg();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetSvgWithSizeAndColorFromText() {
        File file = QRCode.from("www.example.com").withSize(250, 250).withColor(30, 90).svg();
        assertThat(file).exists();
        assertThat(file).canRead();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    public void shouldGetSvgFromTextAsStream() {
        ByteArrayOutputStream outs = new ByteArrayOutputStream();
        QRCode.from("www.example.org").svg(outs);
        byte[] data = outs.toByteArray();
        assertThat(data).isNotEmpty();
        assertThat(data.length).isGreaterThan(0);
        assertThat(data).startsWith("<?xml".getBytes());
    }

    @Test
    public void shouldGetSvgWithSizeFromTextAsStream() {
        ByteArrayOutputStream outs = new ByteArrayOutputStream();
        QRCode.from("www.example.com").withSize(250, 250).svg(outs);
        byte[] data = outs.toByteArray();
        assertThat(data).isNotEmpty();
        assertThat(data.length).isGreaterThan(0);
        assertThat(data).startsWith("<?xml".getBytes());
    }

    @Test
    public void shouldGetSvgWithSizeAndColorFromTextAsStream() {
        ByteArrayOutputStream outs = new ByteArrayOutputStream();
        QRCode.from("www.example.com").withSize(250, 250).withColor(30, 90).svg(outs);
        byte[] data = outs.toByteArray();
        assertThat(data).isNotEmpty();
        assertThat(data.length).isGreaterThan(0);
        assertThat(data).startsWith("<?xml".getBytes());
    }

    @SuppressWarnings("unchecked")
    private void assertCapturedHint(Object expected, Object[] capture, EncodeHintType type) {
        Assert.assertEquals(expected, ((Map<EncodeHintType, ?>) capture[0]).get(type));
    }

    private Writer writerWithCapture(final Object[] capture) {
        return new Writer() {
            @Override
            public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
                throw new UnsupportedOperationException("not implemented");
            }

            @Override
            public BitMatrix encode(String c, BarcodeFormat f, int w, int h, Map<EncodeHintType, ?> hs) throws WriterException {
                capture[0] = hs;
                return new BitMatrix(0);
            }
        };
    }
}

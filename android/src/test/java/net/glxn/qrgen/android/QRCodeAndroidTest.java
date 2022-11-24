package net.glxn.qrgen.android;

import android.graphics.Bitmap;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.scheme.VCard;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class QRCodeAndroidTest {

    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldCreateBitmapWithDefaults() throws Exception {
        Bitmap bmp = QRCode.from("www.example.org").bitmap();
        Assert.assertNotNull(bmp);
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetFileAsBitmapWithDefaults() throws Exception {
        File file = QRCode.from("www.example.org").to(ImageType.BMP).file();
        Assert.assertNotNull(file);
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetFileFromVCardWithDefaults() throws Exception {
        VCard johnDoe = new VCard("John Doe")
                .setName("John Doe")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Berlin")
                .setTitle("Mister").setCompany("John Doe Inc.")
                .setPhoneNumber("1234").setWebsite("www.example.org");
        File file = QRCode.from(johnDoe).file();
        Assert.assertNotNull(file);
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetFileFromTextWithDefaults() throws Exception {
        File file = QRCode.from("Hello World").file();
        Assert.assertNotNull(file);
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetFileWithNameFromTextWithDefaults() throws Exception {
        File file = QRCode.from("Hello World").file("Hello World");
        Assert.assertNotNull(file);
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetSTREAMFromTextWithDefaults() throws Exception {
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();
        Assert.assertNotNull(stream);
    }
    @Ignore("needs android implementation, robolectric broken")
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
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldGetFileWithNameFromTextWithImageTypeOverrides() throws Exception {
        File jpg = QRCode.from("Hello World").to(ImageType.JPG)
                         .file("Hello World");
        Assert.assertNotNull(jpg);
        Assert.assertTrue(jpg.getName().startsWith("Hello World"));
        File gif = QRCode.from("Hello World").to(ImageType.GIF)
                         .file("Hello World");
        Assert.assertNotNull(gif);
        Assert.assertTrue(gif.getName().startsWith("Hello World"));
    }
    @Ignore("needs android implementation, robolectric broken")
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
    @Ignore("needs android implementation, robolectric broken")
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
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldBeAbleToOverrideDimensionsToFile() throws Exception {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file().length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file();
        Assert.assertNotNull(file);
        Assert.assertTrue(defaultSize == defaultSize2);
        //This seems not to work due to some limitations of robolectric, the genrated file on disk is also broken
        //Assert.assertTrue(defaultSize < file.length());
    }
    @Ignore("needs android implementation, robolectric broken")
    @Test
    public void shouldBeAbleToOverrideDimensionsToFileWithName() throws Exception {
        long defaultSize = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        long defaultSize2 = QRCode.from("Hello World").to(ImageType.PNG).file("Hello World").length();
        File file = QRCode.from("Hello World").to(ImageType.PNG).withSize(250, 250).file("Hello World");
        Assert.assertNotNull(file);
        Assert.assertTrue(defaultSize == defaultSize2);
        //This seems not to work due to some limitations of robolectric, the genrated file on disk is also broken
        //Assert.assertTrue(defaultSize < file.length());
        Assert.assertTrue(file.getName().startsWith("Hello World"));
    }
}

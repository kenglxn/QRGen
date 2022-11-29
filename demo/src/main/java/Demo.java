import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.scheme.*;
import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        // get QR file from text using defaults
        File file = QRCode.from("Hello World").file();

        // get QR stream from text using defaults
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();

        // override the image type to be JPG
        QRCode.from("Hello World").to(ImageType.JPG).file();
        QRCode.from("Hello World").to(ImageType.JPG).stream();

        // override image size to be 250x250
        QRCode.from("Hello World").withSize(250, 250).file();
        QRCode.from("Hello World").withSize(250, 250).stream();

        // override size and image type
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).file();
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).stream();

        // override default colors (black on white)
        // notice that the color format is "0x(alpha: 1 byte)(RGB: 3 bytes)"
        // so in the example below it's red for foreground and yellowish for background, both 100% alpha (FF).
        QRCode.from("Hello World").withColor(0xFFFF0000, 0xFFFFFFAA).file();

        // supply own outputstream
        QRCode.from("Hello World").to(ImageType.PNG).writeTo(new ByteArrayOutputStream());

        // supply own file name
        QRCode.from("Hello World").file("QRCode");

        // supply charset hint to ZXING
        QRCode.from("Hello World").withCharset("UTF-8");

        // supply error correction level hint to ZXING
        QRCode.from("Hello World").withErrorCorrection(ErrorCorrectionLevel.L);

        // supply any hint to ZXING
        QRCode.from("Hello World").withHint(EncodeHintType.CHARACTER_SET, "UTF-8");

        // encode contact data as vcard using defaults
        VCard johnDoe = new VCard("John Doe")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Doestown")
                .setTitle("Mister")
                .setCompany("John Doe Inc.")
                .setPhoneNumber("1234")
                .setWebsite("www.example.org");
        QRCode.from(johnDoe).file();

        // encode email data
        EMail email = new EMail("John.Doe@example.org");
        QRCode.from(email).file();

        // encode mms data
        MMS mms = new MMS("8675309", "Hello Jenny");
        QRCode.from(mms).file();

        // encode sms data
        SMS sms = new SMS("8675309", "Hello Jenny");
        QRCode.from(sms).file();

        // encode MeCard data
        MeCard janeDoe = new MeCard("Jane Doe");
        janeDoe.setEmail("john.doe@example.org");
        janeDoe.setAddress("John Doe Street 1, 5678 Doestown");
        janeDoe.setTelephone("1234");
        QRCode.from(janeDoe).file();

        // if using special characters don't forget to supply the encoding
        VCard johnSpecial = new VCard("Jöhn Dɵe")
                .setAddress("ëåäöƞ Sträät 1, 1234 Döestüwn");
        QRCode.from(johnSpecial).withCharset("UTF-8").file();

        // TODO
        // - BizCard: currrently not implemented
        // - Bookmark
        // - Email
        // - GeoInfo
        // - Girocode
        // - GooglePlay
        // - ICal
        // - KddiAu
        // - MMS
        // - MeCard
        // - SMS
        // - Telephone
        // - Url
        // - VCard
        // - Wifi
        // - YouTube
    }
}
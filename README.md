QRGen: a simple QRCode generation api for java built on top ZXING

Dependencies:

* ZXING: http://code.google.com/p/zxing/

Get it:

QRGen is available from maven central using the following dependency declaration:

Gradle:
```gradle
dependencies {
    compile ("net.glxn:qrgen:1.2")
}
```

Maven:
```xml
<dependencies>
    <dependency>
        <groupId>net.glxn</groupId>
        <artifactId>qrgen</artifactId>
        <version>1.2</version>
    </dependency>
</dependencies>
```

Or you can clone and build yourself:
```bash
git clone git://github.com/kenglxn/QRGen.git
cd QRGen/
mvn clean install
```

Usage:

```java
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

// supply own outputstream
QRCode.from("Hello World").to(ImageType.PNG).writeTo(outputStream);
```

License:

* http://www.apache.org/licenses/LICENSE-2.0.html

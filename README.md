[![Build Status](https://travis-ci.org/kenglxn/QRGen.png?branch=master)](https://travis-ci.org/kenglxn/QRGen) [![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/kenglxn/qrgen/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

### QRGen: a simple QRCode generation api for java built on top ZXING

#### Dependencies:

ZXING: http://code.google.com/p/zxing/

#### Get it:

QRGen is available from [Maven Central Repository](http://search.maven.org/#browse%7C-852965118) using the following dependency declaration:

Gradle:

    dependencies {
        compile ("net.glxn:qrgen:1.3")
    }
    
Maven:

    <dependencies>
        <dependency>
            <groupId>net.glxn</groupId>
            <artifactId>qrgen</artifactId>
            <version>1.3</version>
        </dependency>
    </dependencies>

Or you can clone and build yourself:

    git clone git://github.com/kenglxn/QRGen.git
    cd QRGen/
    mvn clean install

#### Usage:

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

// supply own file name
QRCode.from("Hello World").file("QRCode");

// supply charset hint to ZXING
QRCode.from("Hello World").withCharset("UTF-8");

// encode contact data as vcard
VCard johnDoe = new VCard("John Doe")
							.setEmail("john.doe@example.org")
							.setAddress("John Doe Street 1, 5678 Doestown")
							.setTitle("Mister")
							.setCompany("John Doe Inc.")
							.setPhonenumber("1234")
							.setWebsite("www.example.org");
QRCode.from(johnDoe).file();

```

#### License:

http://www.apache.org/licenses/LICENSE-2.0.html


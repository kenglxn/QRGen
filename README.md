[![Build Status](https://travis-ci.org/kenglxn/QRGen.png?branch=master)](https://travis-ci.org/kenglxn/QRGen)
[![Release](https://img.shields.io/github/tag/kenglxn/QRGen.svg?label=JitPack)](https://jitpack.io/#kenglxn/QRGen)

### QRGen: a simple QRCode generation api for java built on top ZXING

#### Dependencies:

ZXING: http://code.google.com/p/zxing/

#### Get it:

QRGen consists of three modules: ```core```, ```javase``` and ```android```.

As of 2.1.0 QRGen is available from [jitpack.io](https://jitpack.io/#kenglxn/QRGen). QRGen is no longer deployed to maven central (ref: #61).
Older releases are available from [Maven Central Repository](http://search.maven.org/#browse%7C-852965118).

Maven:

```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

Gradle:

```gradle
    allprojects {
        repositories {
            // ...
            maven { url "https://jitpack.io" }
        }
    }
```

##### Nexus proxy setup for jitpack

See https://github.com/jitpack/jitpack.io/issues/506 for solution.

(thanks to @LTheobald for the heads up)

#### Java Application

When developing a Java application you need to add ```javase``` module to your list of dependencies. The required ```core``` module will be added automatically by your build system:


Gradle:

```gradle
    dependencies {
        compile 'com.github.kenglxn.QRGen:javase:2.3.0'
    }
```

Maven:

```xml
    <dependencies>
        <dependency>
            <groupId>com.github.kenglxn.qrgen</groupId>
            <artifactId>javase</artifactId>
            <version>2.3.0</version>
        </dependency>
    </dependencies>
```

##### Android

When you want to use QRGen inside your android application you need to add the ```android``` module to your list of dependencies. The required ```core``` module will be added automatically by your build system:

Gradle:

```gradle
    dependencies {
        compile 'com.github.kenglxn.QRGen:android:2.3.0'
    }
```

Maven:

```xml
    <dependencies>
        <dependency>
            <groupId>com.github.kenglxn.qrgen</groupId>
            <artifactId>android</artifactId>
            <version>2.3.0</version>
        </dependency>
    </dependencies>
```

Or you can clone and build yourself:

```bash
    git clone git://github.com/kenglxn/QRGen.git
    cd QRGen/
    mvn clean install
```

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

// override default colors (black on white)
// notice that the color format is "0x(alpha: 1 byte)(RGB: 3 bytes)"
// so in the example below it's red for foreground and yellowish for background, both 100% alpha (FF).
QRCode.from("Hello World").withColor(0xFFFF0000, 0xFFFFFFAA).file();

// supply own outputstream
QRCode.from("Hello World").to(ImageType.PNG).writeTo(outputStream);

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
MMS mms = new MMS("Hello World");
QRCode.from(mms).file();

// encode sms data
SMS sms = new SMS("Hello World");
QRCode.from(sms).file();

// encode MeCard data
MeCard johnDoe = new MeCard("John Doe");
johnDoe.setEmail("john.doe@example.org");
johnDoe.setAddress("John Doe Street 1, 5678 Doestown");
johnDoe.setTelephone("1234");
QRCode.from(johnDoe).file();

// if using special characters don't forget to supply the encoding
VCard johnSpecial = new VCard("Jöhn Dɵe")
                        .setAddress("ëåäöƞ Sträät 1, 1234 Döestüwn");
QRCode.from(johnSpecial).withCharset("UTF-8").file();

```

#### Android only

On Android you have a special method `bitmap()` which returns a `android.graphics.Bitmap` without creating a `File` object before, so you can use the generated `android.graphics.Bitmap` immediately inside an `ImageView`:

```java
Bitmap myBitmap = QRCode.from("www.example.org").bitmap();
ImageView myImage = (ImageView) findViewById(R.id.imageView);
myImage.setImageBitmap(myBitmap);
```

#### License:

http://www.apache.org/licenses/LICENSE-2.0.html

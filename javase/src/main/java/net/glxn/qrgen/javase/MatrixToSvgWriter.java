package net.glxn.qrgen.javase;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.common.BitMatrix;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

class MatrixToSvgWriter {

    private MatrixToSvgWriter() {
        // private utility class constuctor
    }

    private static SVGGraphics2D toSvgDocument(BitMatrix matrix, QRCode qrCode) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();

        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);

        MatrixToImageConfig config = qrCode.matrixToImageConfig;

        SVGGraphics2D svgGraphics = new SVGGraphics2D(document);
        svgGraphics.setColor(new Color(config.getPixelOffColor()));
        svgGraphics.fillRect(0, 0, width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (matrix.get(x, y)) {
                    svgGraphics.setColor(new Color(config.getPixelOnColor()));
                    svgGraphics.fillRect(x, y, 1, 1);
                }
            }
        }

        if (qrCode.logo != null) {
            int logoXLocation = (width - qrCode.logoWidth) / 2;
            int logoYLocation = (height - qrCode.logoHeight) / 2;
            svgGraphics.drawImage(
                qrCode.logo,
                logoXLocation,
                logoYLocation,
                qrCode.logoWidth,
                qrCode.logoHeight,
                new ImageObserver() {

                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return true;
                    }
                });
        }

        return svgGraphics;

    }

    static void writeToStream(BitMatrix matrix, OutputStream outs, QRCode qrCode) throws IOException {
        SVGGraphics2D g2 = toSvgDocument(matrix, qrCode);

        OutputStreamWriter out = new OutputStreamWriter(outs);
        g2.stream(out);
    }

    static void writeToPath(BitMatrix matrix, Path file, QRCode qrCode) throws IOException {
        SVGGraphics2D g2 = toSvgDocument(matrix, qrCode);

        FileWriter out = new FileWriter(file.toFile());
        g2.stream(out);
    }
}

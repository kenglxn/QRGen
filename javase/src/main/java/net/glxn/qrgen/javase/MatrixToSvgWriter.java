package net.glxn.qrgen.javase;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.common.BitMatrix;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

class MatrixToSvgWriter {

    private MatrixToSvgWriter() {
        // private utility class constuctor
    }

    private static SVGGraphics2D toSvgDocument(BitMatrix matrix, MatrixToImageConfig config) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();

        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);

        SVGGraphics2D svgGraphics = new SVGGraphics2D(document);
        svgGraphics.setColor(new Color(config.getPixelOffColor()));
        svgGraphics.fillRect(0,0, width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (matrix.get(x,y)) {
                    svgGraphics.setColor(new Color(config.getPixelOnColor()));
                    svgGraphics.fillRect(x, y, 1, 1);
                }
            }
        }

        return svgGraphics;


    }

    static void writeToPath(BitMatrix matrix, Path file, MatrixToImageConfig matrixToImageConfig) throws IOException {
        SVGGraphics2D g2 = toSvgDocument(matrix, matrixToImageConfig);

        FileWriter out = new FileWriter(file.toFile());
        g2.stream(out);
    }
}

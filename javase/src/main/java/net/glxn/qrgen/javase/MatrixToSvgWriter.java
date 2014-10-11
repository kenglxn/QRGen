package net.glxn.qrgen.javase;

import com.google.zxing.common.BitMatrix;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class MatrixToSvgWriter {

    public static SVGGraphics2D toSvgDocument(BitMatrix matrix, MatrixToSvgConfig config) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        SVGGraphics2D svgGraphics = new SVGGraphics2D(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (matrix.get(x, y)) {
                    svgGraphics.setColor(config.getPixelOnColor());
                    svgGraphics.fillRect(x, y, 1, 1);
                } else {
                    svgGraphics.setColor(config.getPixelOffColor());
                    svgGraphics.fillRect(x, y, 1, 1);
                }
            }
        }

        return svgGraphics;
    }

    public static void writeToPath(BitMatrix matrix, String format, Path file) throws IOException {
        SVGGraphics2D g2 = toSvgDocument(matrix, new MatrixToSvgConfig());
        SVGUtils.writeToSVG(file.toFile(), g2.getSVGElement());
    }
}

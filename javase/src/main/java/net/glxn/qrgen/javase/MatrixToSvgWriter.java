package net.glxn.qrgen.javase;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.common.BitMatrix;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class MatrixToSvgWriter {

    private static final MatrixToImageConfig DEFAULT_CONFIG = new MatrixToImageConfig();

    private static SVGGraphics2D toSvgDocument(BitMatrix matrix, MatrixToImageConfig config) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        SVGGraphics2D svgGraphics = new SVGGraphics2D(width, height);

        svgGraphics.setColor(new Color(config.getPixelOffColor()));

        svgGraphics.fillRect(0,0, width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (matrix.get(x, y)) {
                    svgGraphics.setColor(new Color(config.getPixelOnColor()));
                    svgGraphics.fillRect(x, y, 1, 1);
                }
            }
        }

        return svgGraphics;
    }

    public static void writeToPath(BitMatrix matrix, Path file) throws IOException {
        SVGGraphics2D g2 = toSvgDocument(matrix, DEFAULT_CONFIG);
        SVGUtils.writeToSVG(file.toFile(), g2.getSVGElement());
    }


}

package net.glxn.qrgen.core.scheme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encodes a geographic information, format is:
 * <code>geo:40.71872,-73.98905,100?q=Ankara</code>
 */
public class Geo implements Schema<Geo> {

    public static final String GEO = "geo";
    public static final String Q = "q";
    private String q = "";
    private List<String> points = new ArrayList<>();

    public List<String> getPoints() {
        return points;
    }

    public void setPoints(List<String> points) {
        if (points == null) {
            return;
        }
        this.points = points;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @Override
    public Geo parseSchema(String code) {
        if (code == null || !code.trim().toLowerCase().startsWith(GEO)) {
            throw new IllegalArgumentException("this is not a geo info code: " + code);
        }
        String[] points = code.trim().toLowerCase().replaceAll(GEO + ":", "").split(",");
        if (points.length > 0) {
            Collections.addAll(this.points, points);
        }
        return this;
    }

    @Override
    public String generateString() {
        return GEO + ":" + String.join(",", points) + (q.isEmpty() ? "" : "?" + Q + "=" + q);
    }

    @Override
    public String toString() {
        return generateString();
    }

    public static Geo parse(final String geoInfoCode) {
        Geo geo = new Geo();
        geo.parseSchema(geoInfoCode);
        return geo;
    }
}

package net.glxn.qrgen.core.scheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Encodes a geographic information, format is:
 * <code>geo:40.71872,-73.98905,100?q=Ankara</code>
 */
public class GEO extends Schema {

    public static final String GEO = "geo";
    public static final String Q = "q";
    private String q;
    private List<String> points;

    /**
     * Default constructor to construct new geo info object.
     */
    public GEO() {
        super();
        this.points = new ArrayList<String>();
    }

    public List<String> getPoints() {
        return points;
    }

    public void setPoints(List<String> points) {
        this.points = points;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @Override
    public Schema parseSchema(String code) {
        if (code == null || !code.trim().toLowerCase().startsWith(GEO)) {
            throw new IllegalArgumentException("this is not a geo info code: " + code);
        }
        String[] points = code.trim().toLowerCase().replaceAll(GEO + ":", "").split(",");
        if (points != null && points.length > 0) {
            for (String point : points) {
                this.points.add(point);
            }
        }
        return this;
    }

    @Override
    public String generateString() {
        StringBuilder builder = new StringBuilder();
        if (points != null) {
            int s = points.size();
            for (int i = 0; i < s; i++) {
                builder.append(points.get(i));
                if (i < s - 1) {
                    builder.append(",");
                }
            }
        }
        return GEO + ":" + builder.toString() + (q.isEmpty() ? "" : "?" + Q + "=" + q);
    }

    @Override
    public String toString() {
        return generateString();
    }

    public static GEO parse(final String geoInfoCode) {
        GEO geo = new GEO();
        geo.parseSchema(geoInfoCode);
        return geo;
    }
}

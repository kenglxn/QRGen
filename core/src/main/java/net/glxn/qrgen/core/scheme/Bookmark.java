package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Bookmark encoding
 */
public class Bookmark implements Schema<Bookmark> {

    private static final String BEGIN_BOOKMARK = "MEBKM";
    private static final String URL = "URL";
    private static final String TITLE = "TITLE";
    private static final String LINE_SEPARATOR = ";";
    private String url;
    private String title;

    public Bookmark() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        withUrl(url);
    }

    public Bookmark withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        withTitle(title);
    }

    public Bookmark withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public Bookmark parseSchema(String code) {
        if (code == null || !code.startsWith(BEGIN_BOOKMARK)) {
            throw new IllegalArgumentException("this is not a valid Bookmark code: " + code);
        }
        Map<String, String> parameters =
                getParameters(code.replaceFirst(BEGIN_BOOKMARK + ":", ""), LINE_SEPARATOR, ":");
        if (parameters.containsKey(URL)) {
            setUrl(parameters.get(URL));
        }
        if (parameters.containsKey(TITLE)) {
            setTitle(parameters.get(TITLE));
        }
        return this;
    }

    @Override
    public String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BEGIN_BOOKMARK).append(":");
        if (url != null) {
            sb.append(URL).append(":").append(url).append(LINE_SEPARATOR);
        }
        if (title != null) {
            sb.append(TITLE).append(":").append(title).append(LINE_SEPARATOR);
        }
        sb.append(LINE_SEPARATOR);
        return sb.toString();
    }

    /**
     * Returns the textual representation of this bookmark of the form
     * <p>
     * MEBKM:URL:google.com;TITLE:Google;
     * </p>
     */
    @Override
    public String toString() {
        return generateString();
    }

    public static Bookmark parse(final String code) {
        return new Bookmark().parseSchema(code);
    }

}

package net.glxn.qrgen.core.scheme;

/**
 * Encodes a url connection, format is: <code>HTTP://URL</code>
 * 
 */
public class Url extends Schema {

	private static final String HTTP_PROTOCOL = "HTTP://";
	private static final String HTTPS_PROTOCOL = "HTTPS://";
	private String url;

	public Url() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Schema parseSchema(String code) {
		if (code != null) {
			url = code.trim();
			if (!url.isEmpty()) {
				url = url.toUpperCase();
				if (!url.startsWith(HTTP_PROTOCOL) && !url.startsWith(HTTPS_PROTOCOL)) {
					url = HTTP_PROTOCOL + url;
				}
			}
		}
		return this;
	}

	@Override
	public String generateString() {
		return url;
	}

	@Override
	public String toString() {
		return generateString();
	}

	public static Url parse(final String code) {
		Url u = new Url();
		u.parseSchema(code);
		return u;
	}

}

package net.glxn.qrgen.core.scheme;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlCode implements QRCodeScheme {

	public static class UrlCodeSchemeDesc implements QRCodeSchemeDesc<UrlCode> {

		@Override
		public boolean matches(String qrCodeString) {
			try {
				createScheme(qrCodeString);
				return true;
			} catch (IllegalArgumentException e) {
				return false;
			}
		}

		@Override
		public UrlCode createScheme(String qrCodeString) {
			return new UrlCode(qrCodeString);
		}

	}

	private URL url;

	public UrlCode() {
	}

	public UrlCode(final String urlCode) {
		try {
			url = new URL(urlCode);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("this is not a valid URL code: "
					+ urlCode);
		}
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url.toString();
	}
}

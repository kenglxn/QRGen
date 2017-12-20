package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UrlTest {

	private static final String URL = "http://github.com/kenglxn/QRGen";

	@Test
	public void testParseString() {
		assertTrue(Url.parse(URL).getUrl().equals(URL.toUpperCase()));
	}

	@Test
	public void testToString() {
		assertTrue(Url.parse(URL).toString().equals(URL.toUpperCase()));
	}

}

package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Test;

public class UrlCodeTest {

	@Test
	public void urlFromString() throws Exception {
		UrlCode urlCode = new UrlCode("http://www.google.de");
		assertEquals(new URL("http://www.google.de"), urlCode.getUrl());
	}

	@Test(expected = IllegalArgumentException.class)
	public void urlCodeFromNull() {
		new UrlCode(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void urlCodeFromEmptyString() {
		new UrlCode("");
	}

	@Test
	public void testToString() throws Exception {
		UrlCode urlCode = new UrlCode();
		urlCode.setUrl(new URL("http://www.github.org"));

		assertEquals("http://www.github.org", urlCode.toString());
	}

}

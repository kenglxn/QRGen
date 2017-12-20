package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GooglePlayTest {

	private static final String APP = "de.pawlidi.android";
	private static final String CODE = "{{{market://details?id=" + APP + "}}}";

	@Test
	public void testParse() {
		assertTrue(GooglePlay.parse(CODE).getAppPackage().equals(APP));
	}

	@Test
	public void testToString() {
		assertTrue(GooglePlay.parse(CODE).toString().equals(CODE));
	}
}

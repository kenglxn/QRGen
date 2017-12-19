package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EMailTest {

	private static final String MAIL = "email@address.com";

	@Test
	public void testParse() {
		assertTrue(EMail.parse("mailto:" + MAIL).getEmail().equals(MAIL));
	}

	@Test
	public void testToString() {
		assertTrue(EMail.parse("mailto:" + MAIL).toString().equals("mailto:" + MAIL));
	}

}

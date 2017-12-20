package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TelephoneTest {

	private static final String TEL = "+1-212-555-1212";

	@Test
	public void testParse() {
		assertTrue(Telephone.parse("tel:" + TEL).getTelephone().equals(TEL));
	}

	@Test
	public void testToString() {
		assertTrue(Telephone.parse("tel:" + TEL).toString().equals("tel:" + TEL));
	}

}

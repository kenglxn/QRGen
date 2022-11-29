package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeoTest {

	private static final String GEO_INFO = "geo:40.71872,-73.98905,100";

	@Test
	public void testParseString() {
		assertTrue(Geo.parse(GEO_INFO).getPoints().size() == 3);
	}

	@Test
	public void testToString() {
		assertTrue(Geo.parse(GEO_INFO).toString().equals(GEO_INFO));
	}

}

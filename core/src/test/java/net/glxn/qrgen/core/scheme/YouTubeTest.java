package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class YouTubeTest {

	private static final String VIDEO = "w3jLJU7DT5E";

	@Test
	public void testParse() {
		assertTrue(YouTube.parse(YouTube.YOUTUBE + ":" + VIDEO).getVideoId().equals(VIDEO));
	}

	@Test
	public void testToString() {
		assertTrue(YouTube.parse(YouTube.YOUTUBE + ":" + VIDEO).toString().equals(YouTube.YOUTUBE + ":" + VIDEO));
	}
}

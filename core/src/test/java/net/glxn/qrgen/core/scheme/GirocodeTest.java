package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertEquals;
import net.glxn.qrgen.core.scheme.Girocode.Encoding;

import org.junit.Test;

public class GirocodeTest {

	@Test
	public void parseStringLf() {
		checkParseString("\n");
	}

	@Test
	public void parseStringCrLf() {
		checkParseString("\r\n");
	}

	private void checkParseString(final String lineFeed) {
		Girocode girocode = Girocode.parse("BCD" + lineFeed + //
				"001" + lineFeed + //
				"1" + lineFeed + //
				"SCT" + lineFeed + //
				"DAAABCDGGD" + lineFeed + //
				"Miss Marple" + lineFeed + //
				"DE91300776014444814989" + lineFeed + //
				"EUR27.06" + lineFeed + //
				"xyz" + lineFeed + //
				"reference" + lineFeed + //
				"for a good prupose" + lineFeed + //
				"Watch this Girocode :-)"

		);
		assertEquals(Encoding.UTF_8, girocode.getEncoding());
		assertEquals("DAAABCDGGD", girocode.getBic());
		assertEquals("Miss Marple", girocode.getName());
		assertEquals("DE91300776014444814989", girocode.getIban());
		assertEquals("EUR27.06", girocode.getAmount());
		assertEquals("xyz", girocode.getPurposeCode());
		assertEquals("reference", girocode.getReference());
		assertEquals("for a good prupose", girocode.getText());
		assertEquals("Watch this Girocode :-)", girocode.getHint());
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseNull() {
		Girocode.parse(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseEmptyString() {
		Girocode.parse("");
	}

	@Test
	public void testToString() {
		Girocode girocode = new Girocode();
		girocode.setEncoding(Encoding.UTF_8);
		girocode.setBic("DAAABCDGGD");
		girocode.setName("Miss Marple");
		girocode.setIban("DE91300776014444814989");
		girocode.setAmount("EUR27.06");
		girocode.setPurposeCode("xyz");
		girocode.setText("for a good prupose");
		girocode.setHint("Watch this Girocode :-)");

		assertEquals("BCD\n" + //
				"001\n" + //
				"1\n" + //
				"SCT\n" + //
				"DAAABCDGGD\n" + //
				"Miss Marple\n" + //
				"DE91300776014444814989\n" + //
				"EUR27.06\n" + //
				"xyz\n" + //
				"\n" + //
				"for a good prupose\n" + //
				"Watch this Girocode :-)\n"

		, girocode.toString());
	}

	@Test
	public void testToStringWithReference() {
		Girocode girocode = new Girocode();
		girocode.setEncoding(Encoding.UTF_8);
		girocode.setBic("DAAABCDGGD");
		girocode.setName("Miss Marple");
		girocode.setIban("DE91300776014444814989");
		girocode.setAmount("EUR27.06");
		girocode.setPurposeCode("xyz");
		girocode.setReference("reference");
		girocode.setHint("Watch this Girocode :-)");

		assertEquals("BCD\n" + //
				"001\n" + //
				"1\n" + //
				"SCT\n" + //
				"DAAABCDGGD\n" + //
				"Miss Marple\n" + //
				"DE91300776014444814989\n" + //
				"EUR27.06\n" + //
				"xyz\n" + //
				"reference\n" + //
				"\n" + //
				"Watch this Girocode :-)\n"

		, girocode.toString());
	}

}

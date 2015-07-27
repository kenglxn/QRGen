package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VCardTest {

	@Test
	public void vcardFromString() {
		VCard vcard = VCard.parse("BEGIN:VCARD\n" + //
				"VERSION:3.0\n" + //
				"N:Cookiemonster\n" + //
				"ORG:CTV\n" + //
				"TITLE:monster\n" + //
				"TEL:0023478324\n" + //
				"URL:www.sesamestreet.com\n" + //
				"EMAIL:cookiemonster@sesamestreet.com\n" + //
				"ADR:Sesamestreet 1\n" + //
				"NOTE:more cookies, please\n" + //
				"END:VCARD");
		assertEquals("Cookiemonster", vcard.getName());
		assertEquals("Sesamestreet 1", vcard.getAddress());
		assertEquals("CTV", vcard.getCompany());
		assertEquals("cookiemonster@sesamestreet.com", vcard.getEmail());
		assertEquals("monster", vcard.getTitle());
		assertEquals("www.sesamestreet.com", vcard.getWebsite());
		assertEquals("0023478324", vcard.getPhoneNumber());
		assertEquals("more cookies, please", vcard.getNote());
	}

	@Test(expected = IllegalArgumentException.class)
	public void vcardFromNull() {
		VCard.parse(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void vcardFromEmptyString() {
		VCard.parse("");
	}

	@Test
	public void vcardWithName() {
		VCard vcard = new VCard("Herbert");
		assertEquals("Herbert", vcard.getName());
	}

	@Test
	public void testToString() {
		VCard vcard = new VCard();
		vcard.setName("Cookiemonster");
		vcard.setAddress("Sesamestreet 1");
		vcard.setCompany("CTV");
		vcard.setEmail("cookiemonster@sesamestreet.com");
		vcard.setTitle("monster");
		vcard.setWebsite("www.sesamestreet.com");
		vcard.setPhoneNumber("0023478324");
		vcard.setNote("more cookies, please");

		assertEquals("BEGIN:VCARD\n" + //
				"VERSION:3.0\n" + //
				"N:Cookiemonster\n" + //
				"ORG:CTV\n" + //
				"TITLE:monster\n" + //
				"TEL:0023478324\n" + //
				"URL:www.sesamestreet.com\n" + //
				"EMAIL:cookiemonster@sesamestreet.com\n" + //
				"ADR:Sesamestreet 1\n" + //
				"NOTE:more cookies, please\n" + //
				"END:VCARD", vcard.toString());
	}

}

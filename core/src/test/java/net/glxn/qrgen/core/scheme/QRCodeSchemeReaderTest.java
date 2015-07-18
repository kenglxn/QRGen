package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.*;

import java.net.URL;

import net.glxn.qrgen.core.scheme.Girocode.Encoding;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class QRCodeSchemeReaderTest {
	
	private QRCodeSchemeReader reader = new QRCodeSchemeReader();

	@Test
	public void readWifi() {
		QRCodeScheme scheme = reader.read("WIFI:S:some weird SSID;T:WPA;P:aintNoSecret;H:true;");
		assertNotNull(scheme);
		assertThat(scheme, is(Wifi.class));
		Wifi wifi = (Wifi)scheme;
		assertEquals("some weird SSID",wifi.getSsid());
		assertEquals("WPA", wifi.getAuthentication());
		assertEquals("aintNoSecret", wifi.getPsk());
		assertEquals(true, wifi.isHidden());
	}

	@Test
	public void readVCard() {
		QRCodeScheme scheme = reader.read("BEGIN:VCARD\n" + //
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
		assertNotNull(scheme);
		assertThat(scheme, is(VCard.class));
		VCard vcard = (VCard)scheme;
		assertEquals("Cookiemonster", vcard.getName());
		assertEquals("Sesamestreet 1", vcard.getAddress());
		assertEquals("CTV", vcard.getCompany());
		assertEquals("cookiemonster@sesamestreet.com", vcard.getEmail());
		assertEquals("monster", vcard.getTitle());
		assertEquals("www.sesamestreet.com", vcard.getWebsite());
		assertEquals("0023478324", vcard.getPhoneNumber());
		assertEquals("more cookies, please", vcard.getNote());
	}

	@Test
	public void readGirocode() {
		QRCodeScheme scheme = reader.read("BCD\n" + //
				"001\n" + //
				"1\n" + //
				"SCT\n" + //
				"DAAABCDGGD\n" + //
				"Miss Marple\n" + //
				"DE91300776014444814989\n" + //
				"EUR27.06\n" + //
				"xyz\n" + //
				"reference\n" + //
				"for a good prupose\n" + //
				"Watch this Girocode :-)"

		);
		assertNotNull(scheme);
		assertThat(scheme, is(Girocode.class));
		Girocode girocode = (Girocode)scheme;
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
	
	@Test
	public void readUrlCode() throws Exception {
		QRCodeScheme scheme = reader.read("http://www.github.org");
		assertNotNull(scheme);
		assertThat(scheme, is(UrlCode.class));
		UrlCode urlCode = (UrlCode)scheme;
		assertEquals(new URL("http://www.github.org"), urlCode.getUrl());
	}



	@Test(expected=IllegalArgumentException.class)
	public void readUnknownScheme() {
		reader.read("hihi");
	}
}

package net.glxn.qrgen.core.scheme;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class DelegatingQRCodeSchemeParserTest extends QRCodeSchemeParserImplTest {

	protected QRCodeSchemeParser createParser() {
		return new DelegatingQRCodeSchemeParser();
	}
	
	@Test
	public void getSupportedSchemes() {
		Set<Class<?>> expectedTypes = new LinkedHashSet<Class<?>>();
		expectedTypes.add(Girocode.class);
		expectedTypes.add(VCard.class);
		expectedTypes.add(Wifi.class);
		expectedTypes.add(URL.class);
		expectedTypes.add(Foo.class);
		assertEquals(expectedTypes, createParser().getSupportedSchemes());
	}

	@Test
	public void parseUrlCode() throws Exception {
		Object scheme = createParser().parse("foo:bar");
		assertNotNull(scheme);
		assertThat(scheme, is(Foo.class));
	}


}

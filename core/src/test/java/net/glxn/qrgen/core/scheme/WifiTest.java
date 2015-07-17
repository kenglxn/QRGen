package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.*;
import net.glxn.qrgen.core.scheme.Wifi;
import net.glxn.qrgen.core.scheme.Wifi.Authentication;

import org.junit.Test;

public class WifiTest {

	@Test
	public void wifiFromString() {
		Wifi wifi = new Wifi(
				"WIFI:S:some weird SSID;T:WPA;P:aintNoSecret;H:true;");
		assertEquals("some weird SSID", wifi.getSsid());
		assertEquals("WPA", wifi.getAuthentication());
		assertEquals("aintNoSecret", wifi.getPsk());
		assertEquals(true, wifi.isHidden());
	}

	@Test(expected = IllegalArgumentException.class)
	public void wifiFromNull() {
		new Wifi(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void wifiFromEmptyString() {
		new Wifi("");
	}

	@Test
	public void wifiFromHeaderOnly() {
		Wifi wifi = new Wifi("WIFI:");
		assertNull(null, wifi.getSsid());
		assertNull(null, wifi.getAuthentication());
		assertNull(null, wifi.getPsk());
		assertEquals(false, wifi.isHidden());
	}

	@Test
	public void testToString() {
		Wifi wifi = new Wifi();
		wifi.setSsid("some weird SSID");
		wifi.setAuthentication(Authentication.WPA);
		wifi.setPsk("aintNoSecret");
		wifi.setHidden(true);

		assertEquals("WIFI:S:some weird SSID;T:WPA;P:aintNoSecret;H:true;",
				wifi.toString());
	}

}

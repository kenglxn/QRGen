package net.glxn.qrgen.core.scheme;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.glxn.qrgen.core.scheme.Wifi.Authentication;

import org.junit.Test;

public class EnterpriseWifiTest {

    @Test
    public void parse() {
        EnterpriseWifi wifi = EnterpriseWifi.parse(
                "WIFI:S:some weird SSID;U:Spock;P:aintNoSecret;E:PEAP;PH:MS-CHAPv2;H:true;");
        assertEquals("some weird SSID", wifi.getSsid());
        assertEquals("Spock", wifi.getUser());
        assertEquals("aintNoSecret", wifi.getPsk());
        assertEquals("PEAP", wifi.getEap());
        assertEquals("MS-CHAPv2", wifi.getPhase());
        assertEquals(true, wifi.isHidden());
    }

    /**
     * The following characters need to be escaped with a backslash (\) in the
     * SSID and PSK strings: backslash (\), single-quote ('), double-quote ("),
     * dot (.), colon (:), comma (,), and semicolon (;)
     */
    @Test
    public void parseEscapeSsidAndAuth() {
        EnterpriseWifi wifi = EnterpriseWifi.parse(
                "WIFI:S:s\\;o\\,\\\"me \\'wei\\\\rd\\. SSID\\;;U:Sp\\;ock;P:\\;a\\,\\\"intNo\\,Sec\\\\ret;E:PEAP;PH:MS-CHAPv2;false;");

        assertEquals("s;o,\"me 'wei\\rd. SSID;", wifi.getSsid());
        assertEquals("Sp;ock", wifi.getUser());
        assertEquals(";a,\"intNo,Sec\\ret", wifi.getPsk());
        assertEquals("PEAP", wifi.getEap());
        assertEquals("MS-CHAPv2", wifi.getPhase());
        assertEquals(false, wifi.isHidden());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNull() {
        EnterpriseWifi.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyString() {
        EnterpriseWifi.parse("");
    }

    @Test
    public void parseHeaderOnly() {
        EnterpriseWifi wifi = EnterpriseWifi.parse("WIFI:");
        assertNull(null, wifi.getSsid());
        assertNull(null, wifi.getUser());
        assertNull(null, wifi.getPsk());
        assertNull(null, wifi.getEap());
        assertNull(null, wifi.getPhase());
        assertEquals(false, wifi.isHidden());
    }

    @Test
    public void testToString() {
        EnterpriseWifi wifi = new EnterpriseWifi();
        wifi.setSsid("some weird SSID");
        wifi.setUser("Spock");
        wifi.setPsk("aintNoSecret");
        wifi.setEap("PEAP");
        wifi.setPhase("MS-CHAPv2");
        wifi.setHidden(true);

        assertEquals("WIFI:S:some weird SSID;U:Spcok;P:aintNoSecret;E:PEAP;PH:MS-CHAPv2;H:true;",
                wifi.toString());
    }

    @Test
    public void testToStringEscapeUsernameAndPassword() {
        EnterpriseWifi wifi = new EnterpriseWifi();
        wifi.setSsid("s;o,\"me 'wei\\rd. SSID;");
        wifi.setUser("Sp;ock");
        wifi.setPsk(";a,\"intNo,Sec\\ret");
        wifi.setEap("PEAP");
        wifi.setPhase("MS-CHAPv2");
        wifi.setHidden(false);

        assertEquals("WIFI:S:s\\;o\\,\\\"me \\'wei\\\\rd\\. SSID\\;;U:Sp\\;ock;P:\\;a\\,\\\"intNo\\,Sec\\\\ret;E:PEAP;PH:MS-CHAPv2;H:false;",
                wifi.toString());
    }

}

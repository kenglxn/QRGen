package net.glxn.qrgen.core.scheme;

import java.util.Map;

import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

/**
 * Encodes a Wifi connection, format is:
 * <code>WIFI:S:SSID;U:USER;P:PSK;E:EAP;PH:PHASE;;</code>
 */
public class EnterpriseWifi extends Wifi {

    private static final String USER = "U";
    private static final String EAP = "E";
    private static final String PHASE = "PH";
    private String username;
    private String eap;
    private String phase;
    private boolean hidden = false;
    public EnterpriseWifi() {
    }

    public static EnterpriseWifi parse(final String wifiCode) {
        if (wifiCode == null || !wifiCode.startsWith(WIFI_PROTOCOL_HEADER)) {
            throw new IllegalArgumentException(
                    "this is not a valid WIFI code: " + wifiCode);
        }
        EnterpriseWifi wifi = new EnterpriseWifi();
        Map<String, String> parameters = getParameters(
                wifiCode.substring(WIFI_PROTOCOL_HEADER.length()), "(?<!\\\\);");
        if (parameters.containsKey(SSID)) {
            wifi.setSsid(unescape(parameters.get(SSID)));
        }
        if (parameters.containsKey(PSK)) {
            wifi.setPsk(unescape(parameters.get(PSK)));
        }
        if (parameters.containsKey(USER)) {
            wifi.setUser(unescape(parameters.get(USER)));
        }
        if (parameters.containsKey(EAP)) {
            wifi.setEap(unescape(parameters.get(EAP)));
        }
        if (parameters.containsKey(PHASE)) {
            wifi.setPhase(unescape(parameters.get(PHASE)));
        }
        return wifi;
    }

    public static String escape(final String text) {
        return text.replace("\\", "\\\\").replace(",", "\\,")
                .replace(";", "\\;").replace(".", "\\.")
                .replace("\"", "\\\"").replace("'", "\\'");
    }

    public static String unescape(final String text) {
        return text.replace("\\\\", "\\").replace("\\,", ",")
                .replace("\\;", ";").replace("\\.", ".")
                .replace("\\\"", "\"").replace("\\'", "'");
    }

    public EnterpriseWifi withUsername(String username) {
        this.username = username;
        return this;
    }

    public EnterpriseWifi setUsername(String username) {
        withUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public EnterpriseWifi withEap(String eap) {
        this.eap = eap;
        return this;
    }

    public EnterpriseWifi setEap(String eap) {
        withEap(eap);
    }

    public String getEap() {
        return eap;
    }

    public EnterpriseWifi withPhase(String phase) {
        this.phase = phase;
        return this;
    }

    public void setPhase(String phase) {
        withPhase(phase);
    }

    public String getPhase() {
        return phase;
    }

    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder(WIFI_PROTOCOL_HEADER);
        if (getSsid() != null) {
            bob.append(SSID).append(":").append(escape(getSsid())).append(";");
        }
        if (getUsername() != null) {
            bob.append(USER).append(":").append(getUsername()).append(";");
        }
        if (getPsk() != null) {
            bob.append(PSK).append(":").append(escape(getPsk())).append(";");
        }
        if (getEap() != null) {
            bob.append(EAP).append(":").append(escape(getEap())).append(";");
        }
        if (getPhase() != null) {
            bob.append(PHASE).append(":").append(escape(getPhase())).append(";");
        }
        bob.append(HIDDEN).append(":").append(isHidden()).append(";");
        return bob.toString();
    }
}

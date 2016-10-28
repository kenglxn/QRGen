package net.glxn.qrgen.core.scheme;

import java.util.Map;

import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

/**
 * Encodes a Wifi connection, format is:
 * <code>WIFI:T:AUTHENTICATION;S:SSID;P:PSK;H:HIDDEN;</code>
 */
public class Wifi {

	protected static final String WIFI_PROTOCOL_HEADER = "WIFI:";
	protected static final String AUTHENTICATION = "T";
	protected static final String SSID = "S";
	protected static final String PSK = "P";
	protected static final String HIDDEN = "H";
	protected String authentication;
	protected String ssid;
	protected String psk;
	protected boolean hidden = false;
	public Wifi() {
	}

	public static Wifi parse(final String wifiCode) {
		if (wifiCode == null || !wifiCode.startsWith(WIFI_PROTOCOL_HEADER)) {
			throw new IllegalArgumentException(
					"this is not a valid WIFI code: " + wifiCode);
		}
		Wifi wifi = new Wifi();
		Map<String, String> parameters = getParameters(
				wifiCode.substring(WIFI_PROTOCOL_HEADER.length()), "(?<!\\\\);");
		if (parameters.containsKey(SSID)) {
			wifi.setSsid(unescape(parameters.get(SSID)));
		}
		if (parameters.containsKey(AUTHENTICATION)) {
			wifi.setAuthentication(parameters.get(AUTHENTICATION));
		}
		if (parameters.containsKey(PSK)) {
			wifi.setPsk(unescape(parameters.get(PSK)));
		}
		if (parameters.containsKey(HIDDEN)) {
			wifi.setHidden(parameters.get(HIDDEN));
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

	/**
	 * @return the authentication
	 */
	public String getAuthentication() {
		return authentication;
	}

	/**
	 * @param authentication
	 *            the authentication to set
	 */
	public void setAuthentication(Authentication authentication) {
		setAuthentication(authentication.toString());
	}

	/**
	 * @param authentication
	 *            the authentication to set
	 */
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	/**
	 * @param authentication
	 *            the authentication to set
	 */
	public Wifi withAuthentication(Authentication authentication) {
		setAuthentication(authentication);
		return this;
	}

	/**
	 * @return the ssid
	 */
	public String getSsid() {
		return ssid;
	}

	/**
	 * @param ssid
	 *            the ssid to set
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	/**
	 * @param ssid
	 *            the ssid to set
	 */
	public Wifi withSsid(String ssid) {
		setSsid(ssid);
		return this;
	}

	/**
	 * @return the psk
	 */
	public String getPsk() {
		return psk;
	}

	/**
	 * @param psk
	 *            the psk to set
	 */
	public void setPsk(String psk) {
		this.psk = psk;
	}

	/**
	 * @param psk
	 *            the psk to set
	 */
	public Wifi withPsk(String psk) {
		setPsk(psk);
		return this;
	}

	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * @param value
	 *            the hidden to set
	 */
	public void setHidden(final String value) {
		setHidden(Boolean.valueOf(value));
	}

	/**
	 * @param hidden
	 *            the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * @param hidden
	 *            the hidden to set
	 */
	public Wifi withHidden(boolean hidden) {
		setHidden(hidden);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder bob = new StringBuilder(WIFI_PROTOCOL_HEADER);
		if (getSsid() != null) {
			bob.append(SSID).append(":").append(escape(getSsid())).append(";");
		}
		if (getAuthentication() != null) {
			bob.append(AUTHENTICATION).append(":").append(getAuthentication())
					.append(";");
		}
		if (getPsk() != null) {
			bob.append(PSK).append(":").append(escape(getPsk())).append(";");
		}
		bob.append(HIDDEN).append(":").append(isHidden()).append(";");
		return bob.toString();
	}

	public enum Authentication {
		WEP, WPA, nopass;
	}

}

package net.glxn.qrgen.core.scheme;

import java.util.Map;

/**
 * Encodes a Wifi connection, format is:
 * <code>WIFI:T:AUTHENTICATION;S:SSID;P:PSK;H:HIDDEN;</code>
 */
public class Wifi extends AbstractQRCodeScheme {

	public static class WifiSchemeDesc implements QRCodeSchemeDesc<Wifi> {

		@Override
		public boolean matches(String qrCodeString) {
			return qrCodeString.startsWith(WIFI_PROTOCOL_HEADER);
		}

		@Override
		public Wifi createScheme(String qrCodeString) {
			return new Wifi(qrCodeString);
		}

	}

	public enum Authentication {
		WEP, WPA, nopass;
	}

	private static final String WIFI_PROTOCOL_HEADER = "WIFI:";
	private static final String AUTHENTICATION = "T";
	private static final String SSID = "S";
	private static final String PSK = "P";
	private static final String HIDDEN = "H";

	private String authentication;
	private String ssid;
	private String psk;
	private boolean hidden = false;

	public Wifi() {
	}

	public Wifi(final String wifiCode) {
		if (wifiCode == null || !wifiCode.startsWith(WIFI_PROTOCOL_HEADER)) {
			throw new IllegalArgumentException(
					"this is not a valid WIFI code: " + wifiCode);
		}
		Map<String, String> parameters = getParameters(
				wifiCode.substring(WIFI_PROTOCOL_HEADER.length()), ";");
		if (parameters.containsKey(SSID)) {
			setSsid(parameters.get(SSID));
		}
		if (parameters.containsKey(AUTHENTICATION)) {
			setAuthentication(parameters.get(AUTHENTICATION));
		}
		if (parameters.containsKey(PSK)) {
			setPsk(parameters.get(PSK));
		}
		if (parameters.containsKey(HIDDEN)) {
			setHidden(parameters.get(HIDDEN));
		}
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
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
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
	public void setHidden(final String value) {
		setHidden(Boolean.valueOf(value));
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
			bob.append(SSID).append(":").append(getSsid()).append(";");
		}
		if (getAuthentication() != null) {
			bob.append(AUTHENTICATION).append(":").append(getAuthentication())
					.append(";");
		}
		if (getPsk() != null) {
			bob.append(PSK).append(":").append(getPsk()).append(";");
		}
		bob.append(HIDDEN).append(":").append(isHidden()).append(";");
		return bob.toString();
	}

}

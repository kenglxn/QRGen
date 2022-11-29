package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Encodes a e-mail address, format is: <code>mailto:mail@address.com</code>
 *
 */
public class EMail implements Schema<EMail> {

	private static final String MAILTO = "mailto";
	private String email;

	/**
	 * Default constructor to construct new e-mail object.
	 */
	public EMail() {
		super();
	}

	public EMail(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public EMail setEmail(String email) {
		this.email = email;
		return this;
	}

	public EMail withEmail(String email) {
		return setEmail(email);
	}

	@Override
	public EMail parseSchema(String code) {
		if (code == null || !code.toLowerCase().startsWith(MAILTO)) {
			throw new IllegalArgumentException("this is not a valid email code: " + code);
		}
		Map<String, String> parameters = getParameters(code.toLowerCase());
		if (parameters.containsKey(MAILTO)) {
			setEmail(parameters.get(MAILTO));
		}
		return this;
	}

	@Override
	public String generateString() {
		return MAILTO + ":" + email;
	}

	public static EMail parse(final String emailCode) {
		EMail mail = new EMail();
		mail.parseSchema(emailCode);
		return mail;
	}

	@Override
	public String toString() {
		return generateString();
	}
}

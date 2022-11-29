package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Encodes a sms code, format is: <code>sms:+1-212-555-1212:subject</code>
 * 
 */
public class SMS implements Schema<SMS> {

	private static final String SMS = "SMSTO";
	private String number;
	private String subject;

	public SMS() {
	}

	public SMS(String number, String subject) {
		this.number = number;
		this.subject = subject;
	}

	public String getNumber() {
		return number;
	}

	public SMS setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public SMS setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public SMS parseSchema(String code) {
		if (code == null || !code.trim().toLowerCase().startsWith(SMS)) {
			throw new IllegalArgumentException("this is not a valid sms code: " + code);
		}
		Map<String, String> parameters = getParameters(code.trim().toLowerCase());
		if (parameters.containsKey(SMS)) {
			setNumber(parameters.get(SMS));
		}
		if (getNumber() != null && parameters.containsKey(getNumber())) {
			setSubject(parameters.get(getNumber()));
		}
		return this;
	}

	@Override
	public String generateString() {
		return SMS + ":" + number + (subject != null ? ":" + subject : "");
	}

	@Override
	public String toString() {
		return generateString();
	}

	public static SMS parse(final String code) {
		SMS sms = new SMS();
		sms.parseSchema(code);
		return sms;
	}
}

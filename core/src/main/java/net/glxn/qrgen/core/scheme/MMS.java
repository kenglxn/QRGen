package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Encodes a mms code, format is: <code>mms:+1-212-555-1212:subject</code>
 * 
 */
public class MMS implements Schema<MMS> {

	private static final String MMS = "mms";
	private String number;
	private String subject;

	public MMS() {
	}

	public MMS(String number, String subject) {
		this.number = number;
		this.subject = subject;
	}

	public String getNumber() {
		return number;
	}

	public MMS setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public MMS setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public MMS parseSchema(String code) {
		if (code == null || !code.trim().toLowerCase().startsWith(MMS)) {
			throw new IllegalArgumentException("this is not a valid sms code: " + code);
		}
		Map<String, String> parameters = getParameters(code.trim().toLowerCase());
		if (parameters.containsKey(MMS)) {
			setNumber(parameters.get(MMS));
		}
		if (getNumber() != null && parameters.containsKey(getNumber())) {
			setSubject(parameters.get(getNumber()));
		}
		return this;
	}

	@Override
	public String generateString() {
		return MMS + ":" + number + (subject != null ? ":" + subject : "");
	}

	@Override
	public String toString() {
		return generateString();
	}

	public static MMS parse(final String mmsCode) {
		MMS mms = new MMS();
		mms.parseSchema(mmsCode);
		return mms;
	}
}

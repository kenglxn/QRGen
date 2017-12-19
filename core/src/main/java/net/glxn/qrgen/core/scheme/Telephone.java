package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Encodes a telephone number, format is: <code>tel:+1-212-555-1212</code>
 *
 */
public class Telephone extends Schema {

	private static final String TEL = "tel";
	private String telephone;

	/**
	 * Default constructor to construct new telephone object.
	 */
	public Telephone() {
		super();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public Schema parseSchema(String code) {
		if (telephone == null || !telephone.trim().toLowerCase().startsWith(TEL)) {
			throw new IllegalArgumentException("this is not a valid telephone code: " + telephone);
		}
		Map<String, String> parameters = getParameters(telephone.trim().toLowerCase());
		if (parameters.containsKey(TEL)) {
			setTelephone(parameters.get(TEL));
		}
		return this;
	}

	@Override
	public String generateString() {
		return TEL + ":" + telephone;
	}

	@Override
	public String toString() {
		return generateString();
	}

	public static Telephone parse(final String telephone) {
		Telephone tel = new Telephone();
		tel.parseSchema(telephone);
		return tel;
	}
}

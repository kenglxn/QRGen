package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.DEFAULT_PARAM_SEPARATOR;
import static net.glxn.qrgen.core.scheme.util.SchemeUtil.LINE_FEED;

/**
 * European banking code, currently defines only SEPA credit transfer.
 */
public class Girocode implements Schema<Girocode> {

	protected static final String SERVICE_HEADER = "BCD";
	protected static final String FUNCTION_SEPA_CREDIT_TRANSFER = "SCT";
	protected static final String VERSION_1 = "001";

	public enum Encoding {
		UTF_8, ISO_8859_1, ISO_8859_2, ISO_8859_4, ISO_8859_5, ISO_8859_7, ISO_8859_10, ISO_8859_15;

		public String value() {
			return "" + (ordinal() + 1);
		}

		@Override
		public String toString() {
			return value();
		}

		public static Encoding encodingFor(final String value) {
			for (Encoding encoding : values()) {
				if (encoding.value().equals(value)) {
					return encoding;
				}
			}
			throw new IllegalArgumentException(String.format("unknown encoding value '%s'", value));
		}
	}

	private String name;
	private String iban;
	private String bic;
	private String amount;
	private String purposeCode;
	private String reference;
	private String text;
	private Encoding encoding;
	private String hint;

	public Girocode() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPurposeCode() {
		return purposeCode;
	}

	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	@Override
	public Girocode parseSchema(String code) {
		if (code == null) {
			throw new IllegalArgumentException("null is not a valid Girocode");
		}
		String[] params = code.split(DEFAULT_PARAM_SEPARATOR);
		if (params.length < 6 || params[0].equals("SERVICE_HEADER")) {
			throw new IllegalArgumentException("this is not a valid Girocode: " + code);
		}
		setEncoding(Encoding.encodingFor(params[2]));
		setBic(params[4]);
		setName(params[5]);
		setIban(params[6]);
		if (params.length > 7) {
			setAmount(params[7]);
		}
		if (params.length > 8) {
			setPurposeCode(params[8]);
		}
		if (params.length > 9) {
			setReference(params[9]);
		}
		if (params.length > 10) {
			setText(params[10]);
		}
		if (params.length > 11) {
			setHint(params[11]);
		}
		return this;
	}

	@Override
	public String generateString() {
		return SERVICE_HEADER + LINE_FEED +
				VERSION_1 + LINE_FEED +
				(getEncoding() == null ? "" : getEncoding()) + LINE_FEED +
				FUNCTION_SEPA_CREDIT_TRANSFER + LINE_FEED +
				(getBic() == null ? "" : getBic()) + LINE_FEED +
				(getName() == null ? "" : getName()) + LINE_FEED +
				(getIban() == null ? "" : getIban()) + LINE_FEED +
				(getAmount() == null ? "" : getAmount()) + LINE_FEED +
				(getPurposeCode() == null ? "" : getPurposeCode()) + LINE_FEED +
				(getReference() == null ? "" : getReference()) + LINE_FEED +
				(getText() == null ? "" : getText()) + LINE_FEED +
				(getHint() == null ? "" : getHint()) + LINE_FEED;
	}

	@Override
	public String toString() {
		return generateString();
	}

	public static Girocode parse(final String qrCode) {
		Girocode girocode = new Girocode();
		girocode.parseSchema(qrCode);
		return girocode;
	}

}

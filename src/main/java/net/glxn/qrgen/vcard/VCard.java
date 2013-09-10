package net.glxn.qrgen.vcard;

/**
 * A simple wrapper for vCard data to use with ZXing QR Code generator.
 * 
 * See also http://zxing.appspot.com/generator/ and Contact Information
 * 
 * @author Frederik Hahne <atomfrede@gmail.com>
 * 
 */
public class VCard {

	private static final String NAME = "N:";
	private static final String COMPANY = "ORG:";
	private static final String TITLE = "TITLE:";
	private static final String PHONE = "TEL:";
	private static final String WEB = "URL:";
	private static final String EMAIL = "EMAIL:";
	private static final String ADDRESS = "ADR:";

	private String name;
	private String company;
	private String title;
	private String phonenumber;
	private String email;
	private String address;
	private String website;

	public VCard(String name) {
		this.name = name;
	}

	public VCard setName(String name) {
		this.name = name;
		return this;
	}

	public VCard setCompany(String company) {
		this.company = company;
		return this;
	}

	public VCard setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
		return this;
	}

	public VCard setTitle(String title) {
		this.title = title;
		return this;
	}

	public VCard setEmail(String email) {
		this.email = email;
		return this;
	}

	public VCard setAddress(String address) {
		this.address = address;
		return this;
	}

	public VCard setWebsite(String website) {
		this.website = website;
		return this;
	}

	/**
	 * Returns the textual representation of this vcard of the form
	 * 
	 * BEGIN:VCARD N:John Doe ORG:Company TITLE:Title TEL:1234
	 * URL:www.example.org EMAIL:john.doe@example.org ADR:Street END:VCARD
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("BEGIN:VCARD\n");
		if (name != null) {
			sb.append(NAME + name);
		}
		if (company != null) {
			sb.append("\n"+COMPANY + company);
		}
		if (title != null) {
			sb.append("\n"+TITLE + title);
		}
		if (phonenumber != null) {
			sb.append("\n"+PHONE + phonenumber);
		}
		if (website != null) {
			sb.append("\n"+WEB + website);
		}
		if (email != null) {
			sb.append("\n"+EMAIL + email);
		}
		if (address != null) {
			sb.append("\n"+ADDRESS + address);
		}
		sb.append("\nEND:VCARD");
		return sb.toString();
	}
}

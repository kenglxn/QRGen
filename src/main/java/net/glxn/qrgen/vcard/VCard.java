package net.glxn.qrgen.vcard;

/**
 * A simple wrapper for vCard data to use with ZXing QR Code generator.
 * <p/>
 * See also http://zxing.appspot.com/generator/ and Contact Information
 *
 * @author Frederik Hahne <atomfrede@gmail.com>
 */
public class VCard {

    private static final String NAME = "N;charset=utf-8:";

    private static final String COMPANY = "ORG;charset=utf-8:";

    private static final String TITLE = "TITLE;charset=utf-8:";

    private static final String PHONE = "TEL:";

    private static final String WEB = "URL;charset=utf-8:";

    private static final String EMAIL = "EMAIL:";

    private static final String ADDRESS = "ADR;charset=utf-8:";

    private String name;

    private String company;

    private String title;

    private String phonenumber;

    private String email;

    private String address;

    private String website;

    @SuppressWarnings("UnusedDeclaration")
    public VCard() {
    }

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
     * <p/>
     * BEGIN:VCARD N:John Doe ORG:Company TITLE:Title TEL:1234 URL:www.example.org EMAIL:john.doe@example.org ADR:Street
     * END:VCARD
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VCARD\n");
        sb.append("VERSION:3.0\n");
        if (name != null) {
            sb.append(NAME).append(name);
        }
        if (company != null) {
            sb.append("\n" + COMPANY)
              .append(company);
        }
        if (title != null) {
            sb.append("\n" + TITLE)
              .append(title);
        }
        if (phonenumber != null) {
            sb.append("\n" + PHONE)
              .append(phonenumber);
        }
        if (website != null) {
            sb.append("\n" + WEB).append(website);
        }
        if (email != null) {
            sb.append("\n" + EMAIL).append(email);
        }
        if (address != null) {
            sb.append("\n" + ADDRESS).append(address);
        }
        sb.append("\nEND:VCARD");
        return sb.toString();
    }
}

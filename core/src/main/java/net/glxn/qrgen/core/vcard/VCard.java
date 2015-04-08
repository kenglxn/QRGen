package net.glxn.qrgen.core.vcard;

/**
 * A simple wrapper for vCard data to use with ZXing QR Code generator.
 *
 * See also http://zxing.appspot.com/generator/ and Contact Information
 *
 * @author Frederik Hahne <atomfrede@gmail.com>
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

    private String phoneNumber;

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

    public VCard setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        
        sb.append("BEGIN:VCARD"+System.lineSeparator());
        sb.append("VERSION:3.0"+System.lineSeparator());
        if (name != null) {
            sb.append(NAME).append(name);
        }
        if (company != null) {
            sb.append(System.lineSeparator() + COMPANY)
              .append(company);
        }
        if (title != null) {
            sb.append(System.lineSeparator() + TITLE)
              .append(title);
        }
        if (phoneNumber != null) {
            sb.append(System.lineSeparator() + PHONE)
              .append(phoneNumber);
        }
        if (website != null) {
            sb.append(System.lineSeparator() + WEB).append(website);
        }
        if (email != null) {
            sb.append(System.lineSeparator() + EMAIL).append(email);
        }
        if (address != null) {
            sb.append(System.lineSeparator() + ADDRESS).append(address);
        }
        sb.append(System.lineSeparator()+"END:VCARD");
        return sb.toString();
    }
}

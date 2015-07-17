package net.glxn.qrgen.core.vcard;

/**
 * A simple wrapper for vCard data to use with ZXing QR Code generator.
 *
 * See also http://zxing.appspot.com/generator/ and Contact Information
 *
 * @author Frederik Hahne <atomfrede@gmail.com>
 * @deprecated use {@link net.glxn.qrgen.core.scheme.VCard} instead.
 */
@Deprecated
public class VCard extends net.glxn.qrgen.core.scheme.VCard {
	
    public VCard() {
    	super();
    }

    public VCard(String name) {
    	super();
    	setName(name);
    }


}
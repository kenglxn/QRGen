package net.glxn.qrgen.core.scheme;

import java.io.UnsupportedEncodingException;
import java.util.Set;

/**
 * Common interface for classes that can interpret certain QR code text into content types like e.g. Wifi.
 * TODO: does this parser stuff make sense at all?
 */
public interface QRCodeSchemeParser {

	/**
	 * Tries to parse the given QR code text.
	 * @param qrCodeText
	 * @return the interpreted type
	 * @throws UnsupportedEncodingException if the code is not supported by this interpreter.
	 */
	Object parse(final String qrCodeText) throws UnsupportedEncodingException;
	
	/**
	 * @return the scheme types supported by this interpreter.
	 */
	Set<Class<?>> getSupportedSchemes();
}

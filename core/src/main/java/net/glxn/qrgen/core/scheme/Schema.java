
package net.glxn.qrgen.core.scheme;

/**
 * Abstract schema class
 *
 */
public abstract class Schema {

	/**
	 * Parses a given string for a QR code schema
	 * 
	 * @param code to be parsed
	 * @return schema
	 */
	public abstract Schema parseSchema(String code);

	/**
	 * Generates code string.
	 * 
	 * @return code
	 */
	public abstract String generateString();
}

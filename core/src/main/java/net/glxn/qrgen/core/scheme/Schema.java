
package net.glxn.qrgen.core.scheme;

/**
 * Abstract schema class
 *
 */
public interface Schema<T> {

	/**
	 * Parses a given string for a QR code schema
	 * 
	 * @param code to be parsed
	 * @return schema
	 */
	T parseSchema(String code);

	/**
	 * Generates code string.
	 * 
	 * @return code
	 */
	String generateString();
}

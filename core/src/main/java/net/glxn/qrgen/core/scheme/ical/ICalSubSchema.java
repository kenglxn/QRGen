package net.glxn.qrgen.core.scheme.ical;

import java.util.Map;

/**
 * Abstact class for sub schema.
 */
public interface ICalSubSchema<T> {

	/**
	 * Parse qr code sub schema for given code string and parent parameters.
	 * 
	 * @param parameters parent parameters
	 * @param code to be parsed
	 * @return schema
	 */
	T parseSchema(Map<String, String> parameters, String code);

	/**
	 * Generates code string.
	 * 
	 * @return code
	 */
	String generateString();

}

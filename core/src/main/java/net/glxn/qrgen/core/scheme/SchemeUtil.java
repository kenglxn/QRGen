package net.glxn.qrgen.core.scheme;

import java.util.LinkedHashMap;
import java.util.Map;

public class SchemeUtil {

	public static final String LINE_FEED = "\n";
	public static  final String DEFAULT_PARAM_SEPARATOR = "\r?\n";
	public static  final String DEFAULT_KEY_VALUE_SEPARATOR = ":";

	public static  Map<String, String> getParameters(final String qrCode,
			final String paramSeparator) {
		return getParameters(qrCode, paramSeparator, DEFAULT_KEY_VALUE_SEPARATOR);
	}

	public static  Map<String, String> getParameters(final String qrCode) {
		return getParameters(qrCode, DEFAULT_PARAM_SEPARATOR, ":");
	}

	public static  Map<String, String> getParameters(final String qrCode,
			final String paramSeparator, final String keyValueSeparator) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		String[] parts = qrCode.split(paramSeparator);
		for (int i = 0; i < parts.length; i++) {
			String[] param = parts[i].split(keyValueSeparator);
			if (param.length > 1) {
				result.put(param[0], param[1]);
			}
		}
		return result;
	}


}

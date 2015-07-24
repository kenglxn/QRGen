package net.glxn.qrgen.core.scheme;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementation for the built in types like e.g. {@link Wifi}. 
 * TODO: does this parser stuff make sense at all?
 */
public class QRCodeSchemeParserImpl implements QRCodeSchemeParser {

	@Override
	public Object parse(String qrCodeText) throws UnsupportedEncodingException {
		for (Class<?> type : getSupportedSchemes()) {
			Object instance = createInstance(qrCodeText, type);
			if (instance != null) {
				return instance;
			}
		}
		throw new UnsupportedEncodingException("unkonwn QR code scheme: "
				+ qrCodeText);
	}

	protected Object createInstance(final String qrCodeText, final Class<?> type) {
		try {
			Constructor<?> constructor = type.getConstructor(String.class);
			return constructor.newInstance(qrCodeText);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Set<Class<?>> getSupportedSchemes() {
		Set<Class<?>> supportedSchemes = new LinkedHashSet<Class<?>>();
		supportedSchemes.add(Girocode.class);
		supportedSchemes.add(VCard.class);
		supportedSchemes.add(Wifi.class);
		supportedSchemes.add(URL.class);
		return supportedSchemes;
	}

}

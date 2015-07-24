package net.glxn.qrgen.core.scheme;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Central parser for QRCodes that just delegates to registered {@link QRCodeSchemeParser}s.
 * TODO: does this parser stuff make sense at all?
 */
public class DelegatingQRCodeSchemeParser implements QRCodeSchemeParser {

	private Set<QRCodeSchemeParser> parser;
	
	@Override
	public Set<Class<?>> getSupportedSchemes() {
		Set<Class<?>> supportedSchemes = new LinkedHashSet<Class<?>>();
		for (QRCodeSchemeParser parser : getParser()) {
			supportedSchemes.addAll(parser.getSupportedSchemes());
		}
		return supportedSchemes;
	}


	public Object parse(final String qrCodeText) throws UnsupportedEncodingException{
		for (QRCodeSchemeParser parser : getParser()) {
			try {
				return parser.parse(qrCodeText);
			} catch (UnsupportedEncodingException e) {
				// go on
			}
		}
		throw new UnsupportedEncodingException("unkonwn QR code scheme: "
				+ qrCodeText);
	}

	protected Set<QRCodeSchemeParser> getParser() {
		if (parser == null) {
			parser = loadParser();
		}
		return parser;
	}
	
	protected Set<QRCodeSchemeParser> loadParser() {
		Set<QRCodeSchemeParser> result = new LinkedHashSet<QRCodeSchemeParser>();
		try {
			Enumeration<URL> resources = this.getClass().getClassLoader()
					.getResources("META-INF/qrcode.meta");
			for (URL url : Collections.list(resources)) {
				Properties properties = new Properties();
				try (InputStream is = url.openStream()) {
					properties.load(is);
					String prop = properties.getProperty(QRCodeSchemeParser.class.getName());
					String[] parserNames = prop.split(",");
					for (String className : parserNames) {
						result.add(createParserInstance(className));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("failed to load schemes", e);
		}
		return result;
	}


	protected QRCodeSchemeParser createParserInstance(String className)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Class<?> clazz = Class.forName(className.trim());
		return (QRCodeSchemeParser) clazz.newInstance();
	}

}

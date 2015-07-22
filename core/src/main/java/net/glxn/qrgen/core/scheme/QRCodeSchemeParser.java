package net.glxn.qrgen.core.scheme;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * TODO: does this class make sense at all?
 */
public class QRCodeSchemeParser {

	private List<Class<QRCodeScheme>> schemes;

	public QRCodeScheme parse(final String qrCodeString) {
		for (Class<QRCodeScheme> schemeClass : getSchemes()) {
			QRCodeScheme instance = createInstance(schemeClass, qrCodeString);
			if (instance != null) {
				return instance;
			}
		}
		throw new IllegalArgumentException("unkonwn QR code scheme: "
				+ qrCodeString);
	}

	protected QRCodeScheme createInstance(Class<QRCodeScheme> schemeClass, final String qrCodeString) {
		try {
			Constructor<QRCodeScheme> constructor = schemeClass.getConstructor(String.class);
			return constructor.newInstance(qrCodeString);
		} catch (InvocationTargetException e) {
			if (!(e.getCause() instanceof IllegalArgumentException)) {
				throw new RuntimeException("failed to instantiate scheme " + schemeClass, e);
			}
			// does not match
			return null;
		} catch (Exception e) {
			throw new RuntimeException("failed to instantiate scheme " + schemeClass, e);
		}

	}
	
	protected List<Class<QRCodeScheme>> getSchemes() {
		if (schemes == null) {
			schemes = loadSchemes();
		}
		return schemes;
	}
	
	@SuppressWarnings("unchecked")
	protected List<Class<QRCodeScheme>> loadSchemes() {
		List<Class<QRCodeScheme>> result = new ArrayList<Class<QRCodeScheme>>();
		try {
			Enumeration<URL> resources = this.getClass().getClassLoader()
					.getResources("META-INF/qrcode.meta");
			for (URL url : Collections.list(resources)) {
				Properties properties = new Properties();
				try (InputStream is = url.openStream()) {
					properties.load(is);
					String prop = properties.getProperty(QRCodeScheme.class.getName());
					String[] schemeNames = prop.split(",");
					for (String scheme : schemeNames) {
						result.add((Class<QRCodeScheme>) Class.forName(scheme.trim()));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("failed to load schemes", e);
		}
		return result;
	}
}

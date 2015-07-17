package net.glxn.qrgen.core.scheme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.glxn.qrgen.core.scheme.Girocode.GirocodeSchemeDesc;
import net.glxn.qrgen.core.scheme.VCard.VCardSchemeDesc;
import net.glxn.qrgen.core.scheme.Wifi.WifiSchemeDesc;

public class QRCodeSchemeReader {

	private final static List<QRCodeSchemeDesc<?>> KNOWN_SCHEMES;
	
	static {
		List<QRCodeSchemeDesc<?>> schemeDescs = new ArrayList<QRCodeSchemeDesc<?>>();
		schemeDescs.add(new WifiSchemeDesc());
		schemeDescs.add(new VCardSchemeDesc());
		schemeDescs.add(new GirocodeSchemeDesc());
		KNOWN_SCHEMES = Collections.unmodifiableList(schemeDescs);
	}
	
	public QRCodeScheme read(final String qrCodeString) {
		for (QRCodeSchemeDesc<?> qrCodeSchemeDesc : KNOWN_SCHEMES) {
			if (qrCodeSchemeDesc.matches(qrCodeString)) {
				return qrCodeSchemeDesc.createScheme(qrCodeString);
			}
		}
		throw new IllegalArgumentException("unkonwn QR code scheme: " + qrCodeString);
	}
}

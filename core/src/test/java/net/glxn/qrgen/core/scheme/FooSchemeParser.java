package net.glxn.qrgen.core.scheme;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Set;

public class FooSchemeParser implements QRCodeSchemeParser {

	@Override
	public Object parse(String qrCodeText) throws UnsupportedEncodingException {
		if (qrCodeText.startsWith("foo:")) {
			return new Foo();
		}
		throw new UnsupportedEncodingException("too bad");
	}

	@Override
	public Set<Class<? extends Schema>> getSupportedSchemes() {
		Set<Class<? extends Schema>> supportedSchemes = new LinkedHashSet<Class<? extends Schema>>();
		supportedSchemes.add(Foo.class);
		return supportedSchemes;
	}

}

package net.glxn.qrgen.core.scheme;

public interface QRCodeSchemeDesc<T extends QRCodeScheme> {

	boolean matches(final String qrCodeString);

	T createScheme(final String qrCodeString);
}

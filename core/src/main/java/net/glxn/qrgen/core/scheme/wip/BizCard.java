package net.glxn.qrgen.core.scheme.wip;

import net.glxn.qrgen.core.scheme.Schema;

/**
 * <a href="https://github.com/zxing/zxing/wiki/Barcode-Contents#bizcard">...</a>
 * TODO: implement or delete
 */
class BizCard implements Schema<BizCard> {

	public BizCard() {
	}

	@Override
	public String toString() {
		return generateString();
	}

	@Override
	public BizCard parseSchema(String code) {
		// TODO implement
		return null;
	}

	@Override
	public String generateString() {
		// TODO implement
		return "NOT IMPLEMENTED!!!";
	}

}

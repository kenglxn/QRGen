package net.glxn.qrgen.core.scheme.ical;

import java.util.Map;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.LINE_FEED;

/**
 * TODO: implement or delete
 */
class IJournal implements ICalSubSchema<IJournal> {

	public static final String NAME = "VJOURNAL";
	private static final String BEGIN_TODO = "BEGIN:VJOURNAL";

	public IJournal() {
	}

	@Override
	public IJournal parseSchema(Map<String, String> parameters, String code) {
		return null;
	}

	@Override
	public String generateString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BEGIN_TODO).append(LINE_FEED);
		// TODO
		sb.append(LINE_FEED).append("END:VJOURNAL");
		return sb.toString();
	}

	@Override
	public String toString() {
		return generateString();
	}

}

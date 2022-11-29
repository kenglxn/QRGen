package net.glxn.qrgen.core.scheme.ical;

import java.util.Map;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.LINE_FEED;

/**
 * TODO: implement or delete
 */
class IToDo implements ICalSubSchema<IToDo> {

	public static final String NAME = "VTODO";
	private static final String BEGIN_TODO = "BEGIN:VTODO";

	public IToDo() {
	}

	@Override
	public IToDo parseSchema(Map<String, String> parameters, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateString() {
		return BEGIN_TODO + LINE_FEED + LINE_FEED + "END:VTODO";
	}

	@Override
	public String toString() {
		return generateString();
	}
}

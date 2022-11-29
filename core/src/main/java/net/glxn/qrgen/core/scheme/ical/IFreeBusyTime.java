package net.glxn.qrgen.core.scheme.ical;

import java.util.Map;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.LINE_FEED;

/**
 * TODO: implement or delete
 */
class IFreeBusyTime implements ICalSubSchema<IFreeBusyTime> {

	public static final String NAME = "VFREEBUSY";
	private static final String BEGIN_TODO = "BEGIN:VFREEBUSY";

	public IFreeBusyTime() {
		super();
	}

	@Override
	public IFreeBusyTime parseSchema(Map<String, String> parameters, String code) {
		return null;
	}

	@Override
	public String generateString() {
		return BEGIN_TODO + LINE_FEED + LINE_FEED + "END:VFREEBUSY";
	}

	@Override
	public String toString() {
		return generateString();
	}


}

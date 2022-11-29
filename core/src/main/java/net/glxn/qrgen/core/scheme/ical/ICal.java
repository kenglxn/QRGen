package net.glxn.qrgen.core.scheme.ical;

import net.glxn.qrgen.core.scheme.Schema;

import static net.glxn.qrgen.core.scheme.util.SchemeUtil.LINE_FEED;
import static net.glxn.qrgen.core.scheme.util.SchemeUtil.getParameters;

import java.util.Map;

/**
 * 
 * A simple wrapper for iCal data to use with ZXing QR Code generator.
 *
 */
public class ICal implements Schema<ICal> {

	private static final String BEGIN_VCALENDAR = "BEGIN:VCALENDAR";
	private ICalSubSchema<?> subSchema;

	/**
	 * Invisible default constructor.
	 */
	protected ICal() {
	}

	public ICal(IEvent subSchema) {
		this.subSchema = subSchema;
	}

	public ICalSubSchema<?> getSubSchema() {
		return subSchema;
	}

	public IEvent getIEvent() {
		if (subSchema instanceof IEvent) {
			return (IEvent) subSchema;
		}
		return null;
	}


	@Override
	public ICal parseSchema(String code) {
		if (code == null || !code.startsWith(BEGIN_VCALENDAR)) {
			throw new IllegalArgumentException("this is not a valid ICal code: " + code);
		}
		Map<String, String> parameters = getParameters(code);
		if (parameters.containsKey(IEvent.NAME)) {
			subSchema = new IEvent().parseSchema(parameters, code);
		}
		return this;
	}

	@Override
	public String generateString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BEGIN_VCALENDAR).append(LINE_FEED);
		sb.append("VERSION:2.0").append(LINE_FEED);
		sb.append("PRODID:-//hacksw/handcal//NONSGML v1.0//EN").append(LINE_FEED);
		if (subSchema != null) {
			sb.append(subSchema.generateString());
		}
		sb.append(LINE_FEED).append("END:VCALENDAR");
		return sb.toString();
	}

	@Override
	public String toString() {
		return generateString();
	}
}

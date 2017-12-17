/*
 * Copyright (C) 2017 Maximilian Pawlidi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.SchemeUtil.LINE_FEED;
import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

import java.util.Map;

/**
 * A simple wrapper for iEvent data to use with ZXing QR Code generator.
 * 
 * <code>
 * BEGIN:VEVENT 
 * UID:uid1@example.com 
 * DTSTAMP:19970714T170000Z 
 * ORGANIZER;CN=John Doe:MAILTO:john.doe@example.com 
 * DTSTART:19970714T170000Z
 * DTEND:19970715T035959Z 
 * SUMMARY:Bastille Day Party 
 * END:VEVENT
 * </code>
 * 
 * @author pawlidim
 *
 */
public class IEvent {

	public static final String NAME = "VEVENT";
	private static final String BEGIN_EVENT = "BEGIN:VEVENT";
	private static final String UID = "UID";
	private static final String STAMP = "DTSTAMP";
	private static final String ORGANIZER = "ORGANIZER";
	private static final String START = "DTSTART";
	private static final String END = "DTEND";
	private static final String SUMMARY = "SUMMARY";

	private String uid;
	private String stamp;
	private String organizer;
	private String start;
	private String end;
	private String summary;

	public IEvent() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public static IEvent parse(Map<String, String> parameters, final String icalCode) {
		IEvent event = new IEvent();
		if (parameters.containsKey(UID)) {
			event.setUid(parameters.get(UID));
		}
		if (parameters.containsKey(STAMP)) {
			event.setStamp(parameters.get(STAMP));
		}
		if (parameters.containsKey(START)) {
			event.setStart(parameters.get(START));
		}
		if (parameters.containsKey(END)) {
			event.setEnd(parameters.get(END));
		}
		if (parameters.containsKey(SUMMARY)) {
			event.setSummary(parameters.get(SUMMARY));
		}
		Map<String, String> param = getParameters(icalCode);
		// TODO
		return event;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BEGIN_EVENT).append(LINE_FEED);
		if (uid != null) {
			sb.append(UID).append(":").append(uid).append(LINE_FEED);
		} else if (stamp != null) {
			sb.append(STAMP).append(":").append(stamp).append(LINE_FEED);
		} else if (organizer != null) {
			sb.append(ORGANIZER).append(";").append(organizer).append(LINE_FEED);
		} else if (start != null) {
			sb.append(START).append(":").append(start).append(LINE_FEED);
		} else if (end != null) {
			sb.append(END).append(":").append(end).append(LINE_FEED);
		} else if (summary != null) {
			sb.append(SUMMARY).append(":").append(summary).append(LINE_FEED);
		}
		sb.append(LINE_FEED).append("END:VEVENT");
		return sb.toString();
	}

}

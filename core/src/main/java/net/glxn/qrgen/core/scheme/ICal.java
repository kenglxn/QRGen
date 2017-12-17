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
 * 
 * A simple wrapper for iCal data to use with ZXing QR Code generator.
 * 
 * @author pawlidim
 *
 */
public class ICal {

	private static final String BEGIN_VCALENDAR = "BEGIN:VCALENDAR";
	private IEvent event;
	private IToDo toDo;
	private IJournal journal;
	private IFreeBusyTime freeBusyTime;

	/**
	 * Invisible default constructor.
	 */
	private ICal() {
		super();
	}

	public ICal(IEvent event) {
		this();
		this.event = event;
	}

	public ICal(IToDo toDo) {
		this();
		this.toDo = toDo;
	}

	public ICal(IJournal journal) {
		this();
		this.journal = journal;
	}

	public ICal(IFreeBusyTime freeBusyTime) {
		this();
		this.freeBusyTime = freeBusyTime;
	}

	public IEvent getEvent() {
		return event;
	}

	public void setEvent(IEvent event) {
		this.event = event;
	}

	public IToDo getToDo() {
		return toDo;
	}

	public void setToDo(IToDo toDo) {
		this.toDo = toDo;
	}

	public IJournal getJournal() {
		return journal;
	}

	public void setJournal(IJournal journal) {
		this.journal = journal;
	}

	public IFreeBusyTime getFreeBusyTime() {
		return freeBusyTime;
	}

	public void setFreeBusyTime(IFreeBusyTime freeBusyTime) {
		this.freeBusyTime = freeBusyTime;
	}

	public static ICal parse(final String icalCode) {
		if (icalCode == null || !icalCode.startsWith(BEGIN_VCALENDAR)) {
			throw new IllegalArgumentException("this is not a valid ICal code: " + icalCode);
		}

		ICal iCal = null;
		Map<String, String> parameters = getParameters(icalCode);
		if (parameters.containsKey(IEvent.NAME)) {
			iCal = new ICal(IEvent.parse(parameters, icalCode));
		}
		if (parameters.containsKey(IToDo.NAME)) {
			iCal = new ICal(IToDo.parse(parameters, icalCode));
		}
		if (parameters.containsKey(IJournal.NAME)) {
			iCal = new ICal(IJournal.parse(parameters, icalCode));
		}
		if (parameters.containsKey(IFreeBusyTime.NAME)) {
			iCal = new ICal(IFreeBusyTime.parse(parameters, icalCode));
		}
		return iCal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BEGIN_VCALENDAR).append(LINE_FEED);
		sb.append("VERSION:2.0").append(LINE_FEED);
		sb.append("PRODID:-//hacksw/handcal//NONSGML v1.0//EN").append(LINE_FEED);
		if (event != null) {
			sb.append(event.toString());
		} else if (toDo != null) {
			sb.append(toDo.toString());
		} else if (journal != null) {
			sb.append(journal.toString());
		} else if (freeBusyTime != null) {
			sb.append(freeBusyTime.toString());
		}
		sb.append(LINE_FEED).append("END:VCALENDAR");
		return sb.toString();
	}
}

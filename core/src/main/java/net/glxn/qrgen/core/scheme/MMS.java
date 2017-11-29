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

import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

import java.util.Map;

/**
 * Encodes a mms code, format is: <code>mms:+1-212-555-1212:subject</code>
 * 
 * @author pawlidim
 *
 */
public class MMS {

	public static final String MMS = "mms";
	private String number;
	private String subject;

	public MMS() {
		super();
	}

	public MMS(String number, String subject) {
		super();
		this.number = number;
		this.subject = subject;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static MMS parse(final String mmsCode) {
		if (mmsCode == null || !mmsCode.trim().toLowerCase().startsWith(MMS)) {
			throw new IllegalArgumentException("this is not a valid sms code: " + mmsCode);
		}
		MMS mms = new MMS();
		Map<String, String> parameters = getParameters(mmsCode.trim().toLowerCase());
		if (parameters.containsKey(MMS)) {
			mms.setNumber(parameters.get(MMS));
		}
		if (mms.getNumber() != null && parameters.containsKey(mms.getNumber())) {
			mms.setSubject(parameters.get(mms.getNumber()));
		}
		return mms;
	}

	@Override
	public String toString() {
		return MMS + ":" + number + (subject != null ? ":" + subject : "");
	}

}

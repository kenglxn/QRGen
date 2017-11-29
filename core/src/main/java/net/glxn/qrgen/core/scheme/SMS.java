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
 * Encodes a sms code, format is: <code>sms:+1-212-555-1212:subject</code>
 * 
 * @author pawlidim
 *
 */
public class SMS {

	public static final String SMS = "sms";
	private String number;
	private String subject;

	public SMS() {
		super();
	}

	public SMS(String number, String subject) {
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

	public static SMS parse(final String smsCode) {
		if (smsCode == null || !smsCode.trim().toLowerCase().startsWith(SMS)) {
			throw new IllegalArgumentException("this is not a valid sms code: " + smsCode);
		}
		SMS sms = new SMS();
		Map<String, String> parameters = getParameters(smsCode.trim().toLowerCase());
		if (parameters.containsKey(SMS)) {
			sms.setNumber(parameters.get(SMS));
		}
		if (sms.getNumber() != null && parameters.containsKey(sms.getNumber())) {
			sms.setSubject(parameters.get(sms.getNumber()));
		}
		return sms;
	}

	@Override
	public String toString() {
		return SMS + ":" + number + (subject != null ? ":" + subject : "");
	}
}

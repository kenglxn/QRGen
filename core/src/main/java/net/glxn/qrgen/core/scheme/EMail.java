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
 * Encodes a e-mail address, format is: <code>mailto:mail@address.com</code>
 * 
 * @author pawlidim
 *
 */
public class EMail {

	public static final String MAILTO = "mailto";
	private String email;

	/**
	 * Default constructor to construct new e-mail object.
	 */
	public EMail() {
		super();
	}

	public EMail(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static EMail parse(final String email) {
		if (email == null || !email.toLowerCase().startsWith(MAILTO)) {
			throw new IllegalArgumentException("this is not a valid email code: " + email);
		}
		EMail mail = new EMail();
		Map<String, String> parameters = getParameters(email.toLowerCase());
		if (parameters.containsKey(MAILTO)) {
			mail.setEmail(parameters.get(MAILTO));
		}
		return mail;
	}

	@Override
	public String toString() {
		return MAILTO + ":" + email;
	}

}

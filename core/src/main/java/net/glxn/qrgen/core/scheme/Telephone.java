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
 * Encodes a telephone number, format is: <code>tel:+1-212-555-1212</code>
 * 
 * @author pawlidim
 *
 */
public class Telephone {
	public static final String TEL = "tel";
	private String telephone;

	/**
	 * Default constructor to construct new telephone object.
	 */
	public Telephone() {
		super();
	}

	public Telephone(final String telephone) {
		super();
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static Telephone parse(final String telephone) {
		if (telephone == null || !telephone.trim().toLowerCase().startsWith(TEL)) {
			throw new IllegalArgumentException("this is not a valid telephone code: " + telephone);
		}
		Telephone tel = new Telephone();
		Map<String, String> parameters = getParameters(telephone.trim().toLowerCase());
		if (parameters.containsKey(TEL)) {
			tel.setTelephone(parameters.get(TEL));
		}
		return tel;
	}

	@Override
	public String toString() {
		return TEL + ":" + telephone;
	}

}

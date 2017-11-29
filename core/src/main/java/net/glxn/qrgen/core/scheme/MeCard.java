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
 * 
 * @author pawlidim
 *
 */
public final class MeCard {

	private static final String BEGIN_MECARD = "MECARD";
	private static final String NAME = "N";
	private static final String ADDRESS = "ADR";
	private static final String TEL = "TEL";
	private static final String EMAIL = "EMAIL";
	private static final String LINE_SEPARATOR = ";";

	private String name;
	private String address;
	private String telephone;
	private String email;

	public MeCard() {
		super();
	}

	public MeCard(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static MeCard parse(final String meCardCode) {
		if (meCardCode == null || !meCardCode.startsWith(BEGIN_MECARD)) {
			throw new IllegalArgumentException("this is not a valid MeCard code: " + meCardCode);
		}
		MeCard meCard = new MeCard();
		Map<String, String> parameters = getParameters(meCardCode.replaceFirst(BEGIN_MECARD + ":", ""), LINE_SEPARATOR,
				":");
		if (parameters.containsKey(NAME)) {
			meCard.setName(parameters.get(NAME));
		}
		if (parameters.containsKey(ADDRESS)) {
			meCard.setAddress(parameters.get(ADDRESS));
		}
		if (parameters.containsKey(TEL)) {
			meCard.setTelephone(parameters.get(TEL));
		}
		if (parameters.containsKey(EMAIL)) {
			meCard.setEmail(parameters.get(EMAIL));
		}
		return meCard;
	}

	/**
	 * Returns the textual representation of this mecard of the form
	 * <p>
	 * MECARD:N:Doe,John;TEL:13035551212;EMAIL:john.doe@example.com;;
	 * </p>
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BEGIN_MECARD).append(":");
		if (name != null) {
			sb.append(NAME).append(":").append(name).append(LINE_SEPARATOR);
		}
		if (address != null) {
			sb.append(ADDRESS).append(":").append(address).append(LINE_SEPARATOR);
		}
		if (telephone != null) {
			sb.append(TEL).append(":").append(telephone).append(LINE_SEPARATOR);
		}
		if (email != null) {
			sb.append(EMAIL).append(":").append(email).append(LINE_SEPARATOR);
		}
		sb.append(LINE_SEPARATOR);
		return sb.toString();
	}
}

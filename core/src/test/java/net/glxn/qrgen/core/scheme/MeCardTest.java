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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MeCardTest {

	private static final String MECARD = "MECARD:N:Owen,Sean;ADR:76 9th Avenue, 4th Floor, New York, NY 10011;TEL:12125551212;EMAIL:srowen@example.com;;";

	@Test
	public void testParse() {
		MeCard meCard = MeCard.parse(MECARD);
		assertEquals("Owen,Sean", meCard.getName());
		assertEquals("76 9th Avenue, 4th Floor, New York, NY 10011", meCard.getAddress());
		assertEquals("12125551212", meCard.getTelephone());
		assertEquals("srowen@example.com", meCard.getEmail());
	}

	@Test
	public void testToString() {
		MeCard meCard = new MeCard();
		meCard.setName("Owen,Sean");
		meCard.setAddress("76 9th Avenue, 4th Floor, New York, NY 10011");
		meCard.setTelephone("12125551212");
		meCard.setEmail("srowen@example.com");
		assertEquals(MECARD, meCard.toString());
	}

}

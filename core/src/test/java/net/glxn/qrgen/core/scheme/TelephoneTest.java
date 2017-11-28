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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TelephoneTest {

	private static final String TEL = "+1-212-555-1212";

	@Test
	public void testParse() {
		assertTrue(Telephone.parse(Telephone.TEL + ":" + TEL).getTelephone().equals(TEL));
	}

	@Test
	public void testToString() {
		assertTrue(Telephone.parse(Telephone.TEL + ":" + TEL).toString().equals(Telephone.TEL + ":" + TEL));
	}

}

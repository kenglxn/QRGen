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

public class YouTubeTest {

	private static final String VIDEO = "w3jLJU7DT5E";

	@Test
	public void testParse() {
		assertTrue(YouTube.parse(YouTube.YOUTUBE + ":" + VIDEO).getVideoId().equals(VIDEO));
	}

	@Test
	public void testToString() {
		assertTrue(YouTube.parse(YouTube.YOUTUBE + ":" + VIDEO).toString().equals(YouTube.YOUTUBE + ":" + VIDEO));
	}
}

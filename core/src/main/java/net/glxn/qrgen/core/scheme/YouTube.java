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
 * Encodes a YouTube video, format is: <code>youtube://[video ID]</code>
 * 
 * @author pawlidim
 *
 */
public class YouTube {

	public static final String YOUTUBE = "youtube";
	private String videoId;

	/**
	 * Default constructor to construct new YouTube object.
	 */
	public YouTube() {
		super();
	}

	public YouTube(String videoId) {
		super();
		this.videoId = videoId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public static YouTube parse(final String youTubeCode) {
		if (youTubeCode == null || !youTubeCode.toLowerCase().startsWith(YOUTUBE)) {
			throw new IllegalArgumentException("this is not a valid you tube code: " + youTubeCode);
		}
		YouTube youTube = new YouTube();
		Map<String, String> parameters = getParameters(youTubeCode);
		if (parameters.containsKey(YOUTUBE)) {
			youTube.setVideoId(parameters.get(YOUTUBE));
		}
		return youTube;
	}

	@Override
	public String toString() {
		return YOUTUBE + ":" + videoId;
	}

}

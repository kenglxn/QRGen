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

/**
 * 
 * Encodes a Google Play direct link, format is:
 * <code>{{{market://details?id=de.pawlidi.android}}}</code>
 * 
 * @author pawlidim
 *
 */
public class GooglePlay {

	public static final String GPLAY = "{{{market://details?id=%s}}}";
	private String appPackage;

	/**
	 * Default constructor to construct the GooglePlay obeject.
	 */
	public GooglePlay() {
		super();
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public static GooglePlay parse(final String gplayCode) {
		if (gplayCode == null || !gplayCode.trim().toLowerCase().startsWith("{{{market:")) {
			throw new IllegalArgumentException("this is not a google play code: " + gplayCode);
		}
		String[] paths = gplayCode.trim().toLowerCase().replace("}}}", "").split("=");
		GooglePlay googlePlay = new GooglePlay();
		if (paths.length > 1) {
			googlePlay.setAppPackage(paths[1]);
		}
		return googlePlay;
	}

	@Override
	public String toString() {
		return String.format(GPLAY, appPackage);
	}

}

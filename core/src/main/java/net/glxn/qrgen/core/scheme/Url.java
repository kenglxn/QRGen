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

import java.net.URL;

/**
 * Encodes a url connection, format is: <code>HTTP://URL</code>
 * 
 * @author pawlidim
 *
 */
public class Url {

	public static final String HTTP_PROTOCOL = "HTTP://";
	public static final String HTTPS_PROTOCOL = "HTTPS://";
	private String url;

	public Url() {
		super();
	}

	public Url(String url) {
		super();
		init(url);
	}

	public Url(URL url) {
		this(url.toString());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		init(url);
	}

	private void init(String u) {
		if (u != null) {
			url = u.trim();
			if (!url.isEmpty()) {
				url = url.toUpperCase();
				if (!url.startsWith(HTTP_PROTOCOL) && !url.startsWith(HTTPS_PROTOCOL)) {
					url = HTTP_PROTOCOL + url;
				}
			}
		}
	}

	public static Url parse(URL url) {
		return new Url(url);
	}

	public static Url parse(final String url) {
		return new Url(url);
	}

	@Override
	public String toString() {
		return url;
	}

}

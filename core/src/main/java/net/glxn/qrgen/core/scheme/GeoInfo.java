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

import java.util.ArrayList;
import java.util.List;

/**
 * @author pawlidim
 *
 */
public class GeoInfo {

	public static final String GEO = "geo";
	private List<String> points;

	/**
	 * Default constructor to construct new geo info object.
	 */
	public GeoInfo() {
		super();
		this.points = new ArrayList<>();
	}

	public GeoInfo(String... points) {
		this();
		if (points != null && points.length > 0) {
			for (String point : points) {
				this.points.add(point);
			}
		}
	}

	public List<String> getPoints() {
		return points;
	}

	public void setPoints(List<String> points) {
		this.points = points;
	}

	public static GeoInfo parse(final String geoInfoCode) {
		if (geoInfoCode == null || !geoInfoCode.toLowerCase().startsWith(GEO)) {
			throw new IllegalArgumentException("this is not a geo info code: " + geoInfoCode);
		}
		String[] points = geoInfoCode.toLowerCase().replaceAll(GEO + ":", "").split(",");
		return new GeoInfo(points);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (points != null) {
			int s = points.size();
			for (int i = 0; i < s; i++) {
				builder.append(points.get(i));
				if (i < s - 1) {
					builder.append(",");
				}
			}
		}
		return GEO + ":" + builder.toString();
	}
}

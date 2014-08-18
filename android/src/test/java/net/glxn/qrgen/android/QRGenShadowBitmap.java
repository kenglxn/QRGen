package net.glxn.qrgen.android;

import org.robolectric.Robolectric;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowBitmap;

import android.graphics.Bitmap;

import static org.robolectric.Robolectric.shadowOf;

@Implements(Bitmap.class)
public class QRGenShadowBitmap extends ShadowBitmap {

	@Implementation
	public static Bitmap createBitmap(int width, int height,
			Bitmap.Config config) {
		Bitmap scaledBitmap = Robolectric.newInstanceOf(Bitmap.class);
		ShadowBitmap shadowBitmap = shadowOf(scaledBitmap);
		shadowBitmap.setMutable(true);
		shadowBitmap.setDescription("Bitmap (" + width + " x " + height + ")");
		shadowBitmap.setWidth(width);
		shadowBitmap.setHeight(height);
		shadowBitmap.setConfig(config);
		return scaledBitmap;
	}
}

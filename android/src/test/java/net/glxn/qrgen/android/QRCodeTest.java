package net.glxn.qrgen.android;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.exception.QRGenerationException;
import net.glxn.qrgen.core.image.ImageType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class QRCodeTest {

    @Test
    public void shouldBeAbleToSupplyErrorCorrectionHint() throws Exception {
        ErrorCorrectionLevel expected = ErrorCorrectionLevel.L;
        final Object[] capture = new Object[1];
        try {
            final QRCode from = QRCode.from("Jour férié");
            from.setQrWriter(writerWithCapture(capture));
            from.to(ImageType.PNG).withErrorCorrection(ErrorCorrectionLevel.L)
                    .stream();
        } catch (QRGenerationException ignored) {
        }
        assertCapturedHint(expected, capture, EncodeHintType.ERROR_CORRECTION);
    }

    @Test
    public void shouldBeAbleToSupplyAnyHint() throws Exception {
        String expected = "a hint";
        EncodeHintType[] hintTypes = EncodeHintType.values();
        for (EncodeHintType type : hintTypes) {
            final Object[] capture = new Object[1];
            try {
                final QRCode from = QRCode.from("Jour férié");
                from.setQrWriter(writerWithCapture(capture));
                from.to(ImageType.PNG).withHint(type, expected).stream();
            } catch (QRGenerationException ignored) {
            }
            assertCapturedHint(expected, capture, type);
        }
    }

    @Test
    public void shouldBeAbleToSupplyEncodingHint() throws Exception {
        String expected = "UTF-8";
        final Object[] capture = new Object[1];
        try {
            final QRCode from = QRCode.from("Jour férié");
            from.setQrWriter(writerWithCapture(capture));
            from.to(ImageType.PNG).withCharset(expected).stream();
        } catch (QRGenerationException ignored) {
        }
        assertCapturedHint(expected, capture, EncodeHintType.CHARACTER_SET);
    }

    @SuppressWarnings("unchecked")
    private void assertCapturedHint(Object expected, Object[] capture, EncodeHintType type) {
        Assert.assertEquals(expected, ((Map<EncodeHintType, ?>) capture[0]).get(type));
    }

    private Writer writerWithCapture(final Object[] capture) {
        return new Writer() {
            @Override
            public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
                throw new UnsupportedOperationException("not implemented");
            }

            @Override
            public BitMatrix encode(String c, BarcodeFormat f, int w, int h, Map<EncodeHintType, ?> hs) throws WriterException {
                capture[0] = hs;
                return new BitMatrix(0);
            }
        };
    }
}

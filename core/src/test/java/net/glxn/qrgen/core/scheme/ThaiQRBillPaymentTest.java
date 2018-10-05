package net.glxn.qrgen.core.scheme;

import junit.framework.Assert;
import org.junit.Test;

public class ThaiQRBillPaymentTest {

    @Test
    public void generateStringShouldCorrect() {
        ThaiQRBillPayment schema = new ThaiQRBillPayment()
                .setBiller("123456789012345", "12345678901234567890", "012345012345")
                .setAmount(100.00)
                .setTerminalId("BPK01");
        String expected = "0002010102025802TH6205BPK0130790016A0000006770101120115123456789012345022012345678901234567890031201234501234553037645406100.0063043037";
        Assert.assertEquals(expected, schema.generateString());
    }

    @Test(expected = RuntimeException.class)
    public void toStringShouldTrowRuntimeExceptionWhenBillerIDIsNotEqual15() {
        ThaiQRBillPayment schema = new ThaiQRBillPayment()
                .setBiller("", "", "")
                .setAmount(100.00)
                .setTerminalId("");
    }


}
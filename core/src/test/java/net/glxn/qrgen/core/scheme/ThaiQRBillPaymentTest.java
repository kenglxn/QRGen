package net.glxn.qrgen.core.scheme;

import junit.framework.Assert;
import org.junit.Test;

public class ThaiQRBillPaymentTest {

    @Test
    public void generateStringShouldCorrect() {
        ThaiQRBillPayment schema = new ThaiQRBillPayment()
                .setBiller("012345678901234", "18100000000001213737", "78000000010000000001")
                .setAmount(1.00)
                .setTerminalId("BBB0000002");
        String expected = "0002010102025802TH62140710BBB000000230870016A0000006770101120115012345678901234022018100000000001213737032078000000010000000001530376454041.0063040858";
        Assert.assertEquals(expected, schema.generateString());
    }

    @Test(expected = RuntimeException.class)
    public void toStringShouldTrowRuntimeExceptionWhenBillerIDIsNotEqual15() {
        new ThaiQRBillPayment()
                .setBiller("", "", "")
                .setAmount(100.00)
                .setTerminalId("");
    }


}
package net.glxn.qrgen.core.scheme;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ThaiQRBillPayment extends Schema {

    private final String AID = "0016A000000677010112";
    private final String MAGIC = "6304";

    Map<String, String> data = new HashMap<>();

    public ThaiQRBillPayment() {
        this.data.put("00", "01"); // Payload Format Indicator.
        this.data.put("01", "02"); // Point Of Initiation.
        this.data.put("53", "764"); // Currency Code.
        this.data.put("58", "TH"); // Country Code.
    }

    @Override
    public Schema parseSchema(String code) {
        return null;
    }

    @Override
    public String generateString() {
        String qrCode = "";
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            qrCode = qrCode.concat(key).concat(strLength(value)).concat(value);
        }
        qrCode += MAGIC;
        return qrCode + checkSum(qrCode);
    }

    private String checkSum(String data) {

        int crc = 0xFFFF;
        int polynomial = 0x1021;
        byte[] bytes = data.getBytes();

        for (byte b : bytes) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) crc ^= polynomial;
            }
        }

        crc &= 0xffff;

        StringBuilder crcString = new StringBuilder(Integer.toHexString(crc));

        for (int index = 0; index < 4 - crcString.length(); index++) {
            crcString.insert(0, "0");
        }

        return crcString.toString();

    }

    public ThaiQRBillPayment setBiller(String billerId, String ref1, String ref2) {

        String data = AID;

        if (15 != billerId.length()) {
            throw new RuntimeException();
        }

        data = data.concat("01").concat(strLength(billerId)).concat(billerId);
        data = data.concat("02").concat(strLength(ref1)).concat(ref1);
        data = data.concat("03").concat(strLength(ref2)).concat(ref2);

        this.data.put("30", data);
        return this;

    }

    public ThaiQRBillPayment setAmount(Double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###.00");
        this.data.put("54", decimalFormat.format(amount));
        return this;
    }

    public ThaiQRBillPayment setTerminalId(String terminalId) {
        this.data.put("62", "07".concat(strLength(terminalId)).concat(terminalId));
        return this;
    }

    private String strLength(String billerId) {
        String s = String.valueOf(billerId.length());
        return s.length() == 1 ? "0" + s : s;
    }

}

package net.glxn.qrgen.core.scheme;

import static net.glxn.qrgen.core.scheme.SchemeUtil.LINE_FEED;
import static net.glxn.qrgen.core.scheme.SchemeUtil.getParameters;

import java.util.Map;

public class MatMsg extends Schema {

    private static final String BEGIN_MATMSG = "BEGIN:MATMSG";
    private static final String TO = "TO";
    private static final String CC = "CC";
    private static final String BCC = "BCC";
    private static final String BODY = "BODY";
    private static final String SUBJECT = "SUB";

    private String to;
    private String cc;
    private String bcc;
    private String body;
    private String subject;

    public MatMsg() {

    }

    public MatMsg(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public Schema parseSchema(String code) {
        if (code == null || !code.startsWith(BEGIN_MATMSG)) {
            throw new IllegalArgumentException("this is not a valid MATMSG code: " + code);
        }
        Map<String, String> parameters = getParameters(code);
        if (parameters.containsKey(TO)) {
            setTo(parameters.get(TO));
        }
        if (parameters.containsKey(CC)) {
            setCc(parameters.get(CC));
        }
        if (parameters.containsKey(BCC)) {
            setBcc(parameters.get(BCC));
        }
        if (parameters.containsKey(BODY)) {
            setBody(parameters.get(BODY));
        }

        if (parameters.containsKey(SUBJECT)) {
            setSubject(parameters.get(SUBJECT));
        }

        return this;
    }

    @Override
    public String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BEGIN_MATMSG).append(LINE_FEED);
        if (to != null) {
            sb.append(LINE_FEED).append(TO).append(":").append(to);
        }
        if (cc != null) {
            sb.append(LINE_FEED).append(CC).append(":").append(cc);
        }
        if (bcc != null) {
            sb.append(LINE_FEED).append(BCC).append(":").append(bcc);
        }
        if (subject != null) {
            sb.append(LINE_FEED).append(SUBJECT).append(":").append(body);
        }
        if (body != null) {
            sb.append(LINE_FEED).append(BODY).append(":").append(body);
        }
        sb.append(LINE_FEED).append("END:MATMSG");
        return sb.toString();
    }

    @Override
    public String toString() {
        return generateString();
    }

    public static MatMsg parse(final String MatMsgCode) {
        MatMsg matMsg = new MatMsg();
        matMsg.parseSchema(MatMsgCode);
        return matMsg;
    }
}

/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.DecodeUtil;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerOctetString;
import com.beanit.asn1bean.ber.types.BerType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class InitialiseSecureChannelRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 35);

	private byte[] code = null;
	private RemoteOpId remoteOpId = null;
	private TransactionId transactionId = null;
	private ControlRefTemplate controlRefTemplate = null;
	private BerOctetString smdpOtpk = null;
	private BerOctetString smdpSign = null;

	public InitialiseSecureChannelRequest() {
	}

	public InitialiseSecureChannelRequest(byte[] code) {
		this.code = code;
	}

	public void setRemoteOpId(RemoteOpId remoteOpId) {
		this.remoteOpId = remoteOpId;
	}

	public RemoteOpId getRemoteOpId() {
		return remoteOpId;
	}

	public void setTransactionId(TransactionId transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionId getTransactionId() {
		return transactionId;
	}

	public void setControlRefTemplate(ControlRefTemplate controlRefTemplate) {
		this.controlRefTemplate = controlRefTemplate;
	}

	public ControlRefTemplate getControlRefTemplate() {
		return controlRefTemplate;
	}

	public void setSmdpOtpk(BerOctetString smdpOtpk) {
		this.smdpOtpk = smdpOtpk;
	}

	public BerOctetString getSmdpOtpk() {
		return smdpOtpk;
	}

	public void setSmdpSign(BerOctetString smdpSign) {
		this.smdpSign = smdpSign;
	}

	public BerOctetString getSmdpSign() {
		return smdpSign;
	}

	@Override
	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += smdpSign.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;

		codeLength += smdpOtpk.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 73
		reverseOS.write(0x49);
		reverseOS.write(0x5F);
		codeLength += 2;

		codeLength += controlRefTemplate.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
		reverseOS.write(0xA6);
		codeLength += 1;

		codeLength += transactionId.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		reverseOS.write(0x80);
		codeLength += 1;

		codeLength += remoteOpId.encode(reverseOS, true);

		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override
	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(RemoteOpId.tag)) {
			remoteOpId = new RemoteOpId();
			vByteCount += remoteOpId.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			vByteCount += transactionId.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
			controlRefTemplate = new ControlRefTemplate();
			vByteCount += controlRefTemplate.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 73)) {
			smdpOtpk = new BerOctetString();
			vByteCount += smdpOtpk.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			smdpSign = new BerOctetString();
			vByteCount += smdpSign.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (lengthVal < 0) {
			while (!berTag.equals(0, 0, 0)) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				vByteCount += berTag.decode(is);
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}
		else {
			while (vByteCount < lengthVal) {
				vByteCount += DecodeUtil.decodeUnknownComponent(is);
				if (vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (remoteOpId != null) {
			sb.append("remoteOpId: ").append(remoteOpId);
		}
		else {
			sb.append("remoteOpId: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (transactionId != null) {
			sb.append("transactionId: ").append(transactionId);
		}
		else {
			sb.append("transactionId: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (controlRefTemplate != null) {
			sb.append("controlRefTemplate: ");
			controlRefTemplate.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("controlRefTemplate: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpOtpk != null) {
			sb.append("smdpOtpk: ").append(smdpOtpk);
		}
		else {
			sb.append("smdpOtpk: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpSign != null) {
			sb.append("smdpSign: ").append(smdpSign);
		}
		else {
			sb.append("smdpSign: <empty-required-field>");
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

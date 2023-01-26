/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.DecodeUtil;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import com.beanit.asn1bean.ber.types.string.BerUTF8String;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class EuiccSigned1 implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private TransactionId transactionId = null;
	private BerUTF8String serverAddress = null;
	private Octet16 serverChallenge = null;
	private EUICCInfo2 euiccInfo2 = null;
	private CtxParams1 ctxParams1 = null;

	public EuiccSigned1() {
	}

	public EuiccSigned1(byte[] code) {
		this.code = code;
	}

	public void setTransactionId(TransactionId transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionId getTransactionId() {
		return transactionId;
	}

	public void setServerAddress(BerUTF8String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public BerUTF8String getServerAddress() {
		return serverAddress;
	}

	public void setServerChallenge(Octet16 serverChallenge) {
		this.serverChallenge = serverChallenge;
	}

	public Octet16 getServerChallenge() {
		return serverChallenge;
	}

	public void setEuiccInfo2(EUICCInfo2 euiccInfo2) {
		this.euiccInfo2 = euiccInfo2;
	}

	public EUICCInfo2 getEuiccInfo2() {
		return euiccInfo2;
	}

	public void setCtxParams1(CtxParams1 ctxParams1) {
		this.ctxParams1 = ctxParams1;
	}

	public CtxParams1 getCtxParams1() {
		return ctxParams1;
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
		codeLength += ctxParams1.encode(reverseOS);

		codeLength += euiccInfo2.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 34
		reverseOS.write(0x22);
		reverseOS.write(0xBF);
		codeLength += 2;

		codeLength += serverChallenge.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 4
		reverseOS.write(0x84);
		codeLength += 1;

		codeLength += serverAddress.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 3
		reverseOS.write(0x83);
		codeLength += 1;

		codeLength += transactionId.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		reverseOS.write(0x80);
		codeLength += 1;

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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			vByteCount += transactionId.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			serverAddress = new BerUTF8String();
			vByteCount += serverAddress.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			serverChallenge = new Octet16();
			vByteCount += serverChallenge.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 34)) {
			euiccInfo2 = new EUICCInfo2();
			vByteCount += euiccInfo2.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		ctxParams1 = new CtxParams1();
		numDecodedBytes = ctxParams1.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
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
		if (serverAddress != null) {
			sb.append("serverAddress: ").append(serverAddress);
		}
		else {
			sb.append("serverAddress: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverChallenge != null) {
			sb.append("serverChallenge: ").append(serverChallenge);
		}
		else {
			sb.append("serverChallenge: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccInfo2 != null) {
			sb.append("euiccInfo2: ");
			euiccInfo2.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("euiccInfo2: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (ctxParams1 != null) {
			sb.append("ctxParams1: ");
			ctxParams1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("ctxParams1: <empty-required-field>");
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}


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

public class CancelSessionResponseOk implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private EuiccCancelSessionSigned euiccCancelSessionSigned = null;
	private BerOctetString euiccCancelSessionSignature = null;

	public CancelSessionResponseOk() {
	}

	public CancelSessionResponseOk(byte[] code) {
		this.code = code;
	}

	public void setEuiccCancelSessionSigned(EuiccCancelSessionSigned euiccCancelSessionSigned) {
		this.euiccCancelSessionSigned = euiccCancelSessionSigned;
	}

	public EuiccCancelSessionSigned getEuiccCancelSessionSigned() {
		return euiccCancelSessionSigned;
	}

	public void setEuiccCancelSessionSignature(BerOctetString euiccCancelSessionSignature) {
		this.euiccCancelSessionSignature = euiccCancelSessionSignature;
	}

	public BerOctetString getEuiccCancelSessionSignature() {
		return euiccCancelSessionSignature;
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
		codeLength += euiccCancelSessionSignature.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;

		codeLength += euiccCancelSessionSigned.encode(reverseOS, true);

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

		if (berTag.equals(EuiccCancelSessionSigned.tag)) {
			euiccCancelSessionSigned = new EuiccCancelSessionSigned();
			vByteCount += euiccCancelSessionSigned.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			euiccCancelSessionSignature = new BerOctetString();
			vByteCount += euiccCancelSessionSignature.decode(is, false);
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
		if (euiccCancelSessionSigned != null) {
			sb.append("euiccCancelSessionSigned: ");
			euiccCancelSessionSigned.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("euiccCancelSessionSigned: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccCancelSessionSignature != null) {
			sb.append("euiccCancelSessionSignature: ").append(euiccCancelSessionSignature);
		}
		else {
			sb.append("euiccCancelSessionSignature: <empty-required-field>");
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}


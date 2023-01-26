/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class AuthenticateServerResponse implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 56);

	private AuthenticateResponseOk authenticateResponseOk = null;
	private AuthenticateResponseError authenticateResponseError = null;

	public AuthenticateServerResponse() {
	}

	public AuthenticateServerResponse(byte[] code) {
		this.code = code;
	}

	public void setAuthenticateResponseOk(AuthenticateResponseOk authenticateResponseOk) {
		this.authenticateResponseOk = authenticateResponseOk;
	}

	public AuthenticateResponseOk getAuthenticateResponseOk() {
		return authenticateResponseOk;
	}

	public void setAuthenticateResponseError(AuthenticateResponseError authenticateResponseError) {
		this.authenticateResponseError = authenticateResponseError;
	}

	public AuthenticateResponseError getAuthenticateResponseError() {
		return authenticateResponseError;
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
		if (authenticateResponseError != null) {
			codeLength += authenticateResponseError.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			reverseOS.write(0xA1);
			codeLength += 1;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}

		if (authenticateResponseOk != null) {
			codeLength += authenticateResponseOk.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}

		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	@Override
	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlvByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlvByteCount += tag.decodeAndCheck(is);
		}

		BerLength explicitTagLength = new BerLength();
		tlvByteCount += explicitTagLength.decode(is);
		tlvByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			authenticateResponseOk = new AuthenticateResponseOk();
			tlvByteCount += authenticateResponseOk.decode(is, false);
			tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
			return tlvByteCount;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			authenticateResponseError = new AuthenticateResponseError();
			tlvByteCount += authenticateResponseError.decode(is, false);
			tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
			return tlvByteCount;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
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

		if (authenticateResponseOk != null) {
			sb.append("authenticateResponseOk: ");
			authenticateResponseOk.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (authenticateResponseError != null) {
			sb.append("authenticateResponseError: ");
			authenticateResponseError.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}


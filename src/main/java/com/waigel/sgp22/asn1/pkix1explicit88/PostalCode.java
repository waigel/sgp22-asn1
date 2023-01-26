/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1explicit88;

import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import com.beanit.asn1bean.ber.types.string.BerNumericString;
import com.beanit.asn1bean.ber.types.string.BerPrintableString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class PostalCode implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	private BerNumericString numericCode = null;
	private BerPrintableString printableCode = null;

	public PostalCode() {
	}

	public PostalCode(byte[] code) {
		this.code = code;
	}

	public void setNumericCode(BerNumericString numericCode) {
		this.numericCode = numericCode;
	}

	public BerNumericString getNumericCode() {
		return numericCode;
	}

	public void setPrintableCode(BerPrintableString printableCode) {
		this.printableCode = printableCode;
	}

	public BerPrintableString getPrintableCode() {
		return printableCode;
	}

	@Override
	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			return code.length;
		}

		int codeLength = 0;
		if (printableCode != null) {
			codeLength += printableCode.encode(reverseOS, true);
			return codeLength;
		}

		if (numericCode != null) {
			codeLength += numericCode.encode(reverseOS, true);
			return codeLength;
		}

		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	@Override
	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int tlvByteCount = 0;
		boolean tagWasPassed = (berTag != null);

		if (berTag == null) {
			berTag = new BerTag();
			tlvByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerNumericString.tag)) {
			numericCode = new BerNumericString();
			tlvByteCount += numericCode.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerPrintableString.tag)) {
			printableCode = new BerPrintableString();
			tlvByteCount += printableCode.decode(is, false);
			return tlvByteCount;
		}

		if (tagWasPassed) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (numericCode != null) {
			sb.append("numericCode: ").append(numericCode);
			return;
		}

		if (printableCode != null) {
			sb.append("printableCode: ").append(printableCode);
			return;
		}

		sb.append("<none>");
	}

}


/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1implicit88;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerBoolean;
import com.beanit.asn1bean.ber.types.BerType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class IssuingDistributionPoint implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private DistributionPointName distributionPoint = null;
	private BerBoolean onlyContainsUserCerts = null;
	private BerBoolean onlyContainsCACerts = null;
	private ReasonFlags onlySomeReasons = null;
	private BerBoolean indirectCRL = null;
	private BerBoolean onlyContainsAttributeCerts = null;

	public IssuingDistributionPoint() {
	}

	public IssuingDistributionPoint(byte[] code) {
		this.code = code;
	}

	public void setDistributionPoint(DistributionPointName distributionPoint) {
		this.distributionPoint = distributionPoint;
	}

	public DistributionPointName getDistributionPoint() {
		return distributionPoint;
	}

	public void setOnlyContainsUserCerts(BerBoolean onlyContainsUserCerts) {
		this.onlyContainsUserCerts = onlyContainsUserCerts;
	}

	public BerBoolean getOnlyContainsUserCerts() {
		return onlyContainsUserCerts;
	}

	public void setOnlyContainsCACerts(BerBoolean onlyContainsCACerts) {
		this.onlyContainsCACerts = onlyContainsCACerts;
	}

	public BerBoolean getOnlyContainsCACerts() {
		return onlyContainsCACerts;
	}

	public void setOnlySomeReasons(ReasonFlags onlySomeReasons) {
		this.onlySomeReasons = onlySomeReasons;
	}

	public ReasonFlags getOnlySomeReasons() {
		return onlySomeReasons;
	}

	public void setIndirectCRL(BerBoolean indirectCRL) {
		this.indirectCRL = indirectCRL;
	}

	public BerBoolean getIndirectCRL() {
		return indirectCRL;
	}

	public void setOnlyContainsAttributeCerts(BerBoolean onlyContainsAttributeCerts) {
		this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
	}

	public BerBoolean getOnlyContainsAttributeCerts() {
		return onlyContainsAttributeCerts;
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
		int sublength;

		if (onlyContainsAttributeCerts != null) {
			codeLength += onlyContainsAttributeCerts.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 5
			reverseOS.write(0x85);
			codeLength += 1;
		}

		if (indirectCRL != null) {
			codeLength += indirectCRL.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			reverseOS.write(0x84);
			codeLength += 1;
		}

		if (onlySomeReasons != null) {
			codeLength += onlySomeReasons.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			reverseOS.write(0x83);
			codeLength += 1;
		}

		if (onlyContainsCACerts != null) {
			codeLength += onlyContainsCACerts.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}

		if (onlyContainsUserCerts != null) {
			codeLength += onlyContainsUserCerts.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
		}

		if (distributionPoint != null) {
			sublength = distributionPoint.encode(reverseOS);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
		}

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
		if (lengthVal == 0) {
			return tlByteCount;
		}
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			vByteCount += length.decode(is);
			distributionPoint = new DistributionPointName();
			vByteCount += distributionPoint.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			onlyContainsUserCerts = new BerBoolean();
			vByteCount += onlyContainsUserCerts.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			onlyContainsCACerts = new BerBoolean();
			vByteCount += onlyContainsCACerts.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			onlySomeReasons = new ReasonFlags();
			vByteCount += onlySomeReasons.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			indirectCRL = new BerBoolean();
			vByteCount += indirectCRL.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			onlyContainsAttributeCerts = new BerBoolean();
			vByteCount += onlyContainsAttributeCerts.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
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
		boolean firstSelectedElement = true;
		if (distributionPoint != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("distributionPoint: ");
			distributionPoint.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}

		if (onlyContainsUserCerts != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("onlyContainsUserCerts: ").append(onlyContainsUserCerts);
			firstSelectedElement = false;
		}

		if (onlyContainsCACerts != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("onlyContainsCACerts: ").append(onlyContainsCACerts);
			firstSelectedElement = false;
		}

		if (onlySomeReasons != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("onlySomeReasons: ").append(onlySomeReasons);
			firstSelectedElement = false;
		}

		if (indirectCRL != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("indirectCRL: ").append(indirectCRL);
			firstSelectedElement = false;
		}

		if (onlyContainsAttributeCerts != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("onlyContainsAttributeCerts: ").append(onlyContainsAttributeCerts);
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}


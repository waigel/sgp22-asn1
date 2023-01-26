/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1explicit88;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class TBSCertificate implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private Version version = null;
	private CertificateSerialNumber serialNumber = null;
	private AlgorithmIdentifier signature = null;
	private Name issuer = null;
	private Validity validity = null;
	private Name subject = null;
	private SubjectPublicKeyInfo subjectPublicKeyInfo = null;
	private UniqueIdentifier issuerUniqueID = null;
	private UniqueIdentifier subjectUniqueID = null;
	private Extensions extensions = null;

	public TBSCertificate() {
	}

	public TBSCertificate(byte[] code) {
		this.code = code;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Version getVersion() {
		return version;
	}

	public void setSerialNumber(CertificateSerialNumber serialNumber) {
		this.serialNumber = serialNumber;
	}

	public CertificateSerialNumber getSerialNumber() {
		return serialNumber;
	}

	public void setSignature(AlgorithmIdentifier signature) {
		this.signature = signature;
	}

	public AlgorithmIdentifier getSignature() {
		return signature;
	}

	public void setIssuer(Name issuer) {
		this.issuer = issuer;
	}

	public Name getIssuer() {
		return issuer;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	public Validity getValidity() {
		return validity;
	}

	public void setSubject(Name subject) {
		this.subject = subject;
	}

	public Name getSubject() {
		return subject;
	}

	public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
		this.subjectPublicKeyInfo = subjectPublicKeyInfo;
	}

	public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
		return subjectPublicKeyInfo;
	}

	public void setIssuerUniqueID(UniqueIdentifier issuerUniqueID) {
		this.issuerUniqueID = issuerUniqueID;
	}

	public UniqueIdentifier getIssuerUniqueID() {
		return issuerUniqueID;
	}

	public void setSubjectUniqueID(UniqueIdentifier subjectUniqueID) {
		this.subjectUniqueID = subjectUniqueID;
	}

	public UniqueIdentifier getSubjectUniqueID() {
		return subjectUniqueID;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public Extensions getExtensions() {
		return extensions;
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

		if (extensions != null) {
			sublength = extensions.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
		}

		if (subjectUniqueID != null) {
			codeLength += subjectUniqueID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}

		if (issuerUniqueID != null) {
			codeLength += issuerUniqueID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
		}

		codeLength += subjectPublicKeyInfo.encode(reverseOS, true);

		codeLength += subject.encode(reverseOS);

		codeLength += validity.encode(reverseOS, true);

		codeLength += issuer.encode(reverseOS);

		codeLength += signature.encode(reverseOS, true);

		codeLength += serialNumber.encode(reverseOS, true);

		if (version != null) {
			sublength = version.encode(reverseOS, true);
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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			vByteCount += length.decode(is);
			version = new Version();
			vByteCount += version.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(CertificateSerialNumber.tag)) {
			serialNumber = new CertificateSerialNumber();
			vByteCount += serialNumber.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(AlgorithmIdentifier.tag)) {
			signature = new AlgorithmIdentifier();
			vByteCount += signature.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		issuer = new Name();
		numDecodedBytes = issuer.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(Validity.tag)) {
			validity = new Validity();
			vByteCount += validity.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		subject = new Name();
		numDecodedBytes = subject.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(SubjectPublicKeyInfo.tag)) {
			subjectPublicKeyInfo = new SubjectPublicKeyInfo();
			vByteCount += subjectPublicKeyInfo.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			issuerUniqueID = new UniqueIdentifier();
			vByteCount += issuerUniqueID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			subjectUniqueID = new UniqueIdentifier();
			vByteCount += subjectUniqueID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			vByteCount += length.decode(is);
			extensions = new Extensions();
			vByteCount += extensions.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
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
		if (version != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("version: ").append(version);
			firstSelectedElement = false;
		}

		if (!firstSelectedElement) {
			sb.append(",\n");
		}
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serialNumber != null) {
			sb.append("serialNumber: ").append(serialNumber);
		}
		else {
			sb.append("serialNumber: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (signature != null) {
			sb.append("signature: ");
			signature.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("signature: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (issuer != null) {
			sb.append("issuer: ");
			issuer.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("issuer: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (validity != null) {
			sb.append("validity: ");
			validity.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("validity: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subject != null) {
			sb.append("subject: ");
			subject.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subject: <empty-required-field>");
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subjectPublicKeyInfo != null) {
			sb.append("subjectPublicKeyInfo: ");
			subjectPublicKeyInfo.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subjectPublicKeyInfo: <empty-required-field>");
		}

		if (issuerUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("issuerUniqueID: ").append(issuerUniqueID);
		}

		if (subjectUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("subjectUniqueID: ").append(subjectUniqueID);
		}

		if (extensions != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("extensions: ");
			extensions.appendAsString(sb, indentLevel + 1);
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

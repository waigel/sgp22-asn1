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
import com.waigel.sgp22.asn1.pkix1explicit88.Certificate;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class AuthenticateResponseOk implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  private byte[] code = null;
  private EuiccSigned1 euiccSigned1 = null;
  private BerOctetString euiccSignature1 = null;
  private Certificate euiccCertificate = null;
  private Certificate eumCertificate = null;

  public AuthenticateResponseOk() {}

  public AuthenticateResponseOk(byte[] code) {
    this.code = code;
  }

  public void setEuiccSigned1(EuiccSigned1 euiccSigned1) {
    this.euiccSigned1 = euiccSigned1;
  }

  public EuiccSigned1 getEuiccSigned1() {
    return euiccSigned1;
  }

  public void setEuiccSignature1(BerOctetString euiccSignature1) {
    this.euiccSignature1 = euiccSignature1;
  }

  public BerOctetString getEuiccSignature1() {
    return euiccSignature1;
  }

  public void setEuiccCertificate(Certificate euiccCertificate) {
    this.euiccCertificate = euiccCertificate;
  }

  public Certificate getEuiccCertificate() {
    return euiccCertificate;
  }

  public void setEumCertificate(Certificate eumCertificate) {
    this.eumCertificate = eumCertificate;
  }

  public Certificate getEumCertificate() {
    return eumCertificate;
  }

  public byte[] getRaw() {
    return code;
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
    codeLength += eumCertificate.encode(reverseOS, true);

    codeLength += euiccCertificate.encode(reverseOS, true);

    codeLength += euiccSignature1.encode(reverseOS, false);
    // write tag: APPLICATION_CLASS, PRIMITIVE, 55
    reverseOS.write(0x37);
    reverseOS.write(0x5F);
    codeLength += 2;

    codeLength += euiccSigned1.encode(reverseOS, true);

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

    if (berTag.equals(EuiccSigned1.tag)) {
      euiccSigned1 = new EuiccSigned1();
      vByteCount += euiccSigned1.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
      euiccSignature1 = new BerOctetString();
      vByteCount += euiccSignature1.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(Certificate.tag)) {
      euiccCertificate = new Certificate();
      vByteCount += euiccCertificate.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(Certificate.tag)) {
      eumCertificate = new Certificate();
      vByteCount += eumCertificate.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (lengthVal < 0) {
      while (!berTag.equals(0, 0, 0)) {
        vByteCount += DecodeUtil.decodeUnknownComponent(is);
        vByteCount += berTag.decode(is);
      }
      vByteCount += BerLength.readEocByte(is);
      return tlByteCount + vByteCount;
    } else {
      while (vByteCount < lengthVal) {
        vByteCount += DecodeUtil.decodeUnknownComponent(is);
        if (vByteCount == lengthVal) {
          return tlByteCount + vByteCount;
        }
        vByteCount += berTag.decode(is);
      }
    }
    throw new IOException(
        "Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);
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
    if (euiccSigned1 != null) {
      sb.append("euiccSigned1: ");
      euiccSigned1.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("euiccSigned1: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccSignature1 != null) {
      sb.append("euiccSignature1: ").append(euiccSignature1);
    } else {
      sb.append("euiccSignature1: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccCertificate != null) {
      sb.append("euiccCertificate: ");
      euiccCertificate.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("euiccCertificate: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (eumCertificate != null) {
      sb.append("eumCertificate: ");
      eumCertificate.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("eumCertificate: <empty-required-field>");
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1implicit88;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import com.waigel.sgp22.asn1.pkix1explicit88.CertificateSerialNumber;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class AuthorityKeyIdentifier implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  private byte[] code = null;
  private KeyIdentifier keyIdentifier = null;
  private GeneralNames authorityCertIssuer = null;
  private CertificateSerialNumber authorityCertSerialNumber = null;

  public AuthorityKeyIdentifier() {}

  public AuthorityKeyIdentifier(byte[] code) {
    this.code = code;
  }

  public void setKeyIdentifier(KeyIdentifier keyIdentifier) {
    this.keyIdentifier = keyIdentifier;
  }

  public KeyIdentifier getKeyIdentifier() {
    return keyIdentifier;
  }

  public void setAuthorityCertIssuer(GeneralNames authorityCertIssuer) {
    this.authorityCertIssuer = authorityCertIssuer;
  }

  public GeneralNames getAuthorityCertIssuer() {
    return authorityCertIssuer;
  }

  public void setAuthorityCertSerialNumber(CertificateSerialNumber authorityCertSerialNumber) {
    this.authorityCertSerialNumber = authorityCertSerialNumber;
  }

  public CertificateSerialNumber getAuthorityCertSerialNumber() {
    return authorityCertSerialNumber;
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
    if (authorityCertSerialNumber != null) {
      codeLength += authorityCertSerialNumber.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 2
      reverseOS.write(0x82);
      codeLength += 1;
    }

    if (authorityCertIssuer != null) {
      codeLength += authorityCertIssuer.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, CONSTRUCTED, 1
      reverseOS.write(0xA1);
      codeLength += 1;
    }

    if (keyIdentifier != null) {
      codeLength += keyIdentifier.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 0
      reverseOS.write(0x80);
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

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
      keyIdentifier = new KeyIdentifier();
      vByteCount += keyIdentifier.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
      authorityCertIssuer = new GeneralNames();
      vByteCount += authorityCertIssuer.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
      authorityCertSerialNumber = new CertificateSerialNumber();
      vByteCount += authorityCertSerialNumber.decode(is, false);
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
    boolean firstSelectedElement = true;
    if (keyIdentifier != null) {
      sb.append("\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("keyIdentifier: ").append(keyIdentifier);
      firstSelectedElement = false;
    }

    if (authorityCertIssuer != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("authorityCertIssuer: ");
      authorityCertIssuer.appendAsString(sb, indentLevel + 1);
      firstSelectedElement = false;
    }

    if (authorityCertSerialNumber != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("authorityCertSerialNumber: ").append(authorityCertSerialNumber);
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

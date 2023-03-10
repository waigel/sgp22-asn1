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

public class PrepareDownloadRequest implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 33);

  private byte[] code = null;
  private SmdpSigned2 smdpSigned2 = null;
  private BerOctetString smdpSignature2 = null;
  private Octet32 hashCc = null;
  private Certificate smdpCertificate = null;

  public PrepareDownloadRequest() {}

  public PrepareDownloadRequest(byte[] code) {
    this.code = code;
  }

  public void setSmdpSigned2(SmdpSigned2 smdpSigned2) {
    this.smdpSigned2 = smdpSigned2;
  }

  public SmdpSigned2 getSmdpSigned2() {
    return smdpSigned2;
  }

  public void setSmdpSignature2(BerOctetString smdpSignature2) {
    this.smdpSignature2 = smdpSignature2;
  }

  public BerOctetString getSmdpSignature2() {
    return smdpSignature2;
  }

  public void setHashCc(Octet32 hashCc) {
    this.hashCc = hashCc;
  }

  public Octet32 getHashCc() {
    return hashCc;
  }

  public void setSmdpCertificate(Certificate smdpCertificate) {
    this.smdpCertificate = smdpCertificate;
  }

  public Certificate getSmdpCertificate() {
    return smdpCertificate;
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
    codeLength += smdpCertificate.encode(reverseOS, true);

    if (hashCc != null) {
      codeLength += hashCc.encode(reverseOS, true);
    }

    codeLength += smdpSignature2.encode(reverseOS, false);
    // write tag: APPLICATION_CLASS, PRIMITIVE, 55
    reverseOS.write(0x37);
    reverseOS.write(0x5F);
    codeLength += 2;

    codeLength += smdpSigned2.encode(reverseOS, true);

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

    if (berTag.equals(SmdpSigned2.tag)) {
      smdpSigned2 = new SmdpSigned2();
      vByteCount += smdpSigned2.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
      smdpSignature2 = new BerOctetString();
      vByteCount += smdpSignature2.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(Octet32.tag)) {
      hashCc = new Octet32();
      vByteCount += hashCc.decode(is, false);
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(Certificate.tag)) {
      smdpCertificate = new Certificate();
      vByteCount += smdpCertificate.decode(is, false);
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
    if (smdpSigned2 != null) {
      sb.append("smdpSigned2: ");
      smdpSigned2.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("smdpSigned2: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (smdpSignature2 != null) {
      sb.append("smdpSignature2: ").append(smdpSignature2);
    } else {
      sb.append("smdpSignature2: <empty-required-field>");
    }

    if (hashCc != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("hashCc: ").append(hashCc);
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (smdpCertificate != null) {
      sb.append("smdpCertificate: ");
      smdpCertificate.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("smdpCertificate: <empty-required-field>");
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

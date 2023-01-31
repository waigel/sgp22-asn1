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

public class InitiateAuthenticationRequest implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 57);

  private byte[] code = null;
  private Octet16 euiccChallenge = null;
  private BerUTF8String smdpAddress = null;
  private EUICCInfo1 euiccInfo1 = null;

  public InitiateAuthenticationRequest() {}

  public InitiateAuthenticationRequest(byte[] code) {
    this.code = code;
  }

  public void setEuiccChallenge(Octet16 euiccChallenge) {
    this.euiccChallenge = euiccChallenge;
  }

  public Octet16 getEuiccChallenge() {
    return euiccChallenge;
  }

  public void setSmdpAddress(BerUTF8String smdpAddress) {
    this.smdpAddress = smdpAddress;
  }

  public BerUTF8String getSmdpAddress() {
    return smdpAddress;
  }

  public void setEuiccInfo1(EUICCInfo1 euiccInfo1) {
    this.euiccInfo1 = euiccInfo1;
  }

  public EUICCInfo1 getEuiccInfo1() {
    return euiccInfo1;
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
    codeLength += euiccInfo1.encode(reverseOS, true);

    codeLength += smdpAddress.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 3
    reverseOS.write(0x83);
    codeLength += 1;

    codeLength += euiccChallenge.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 1
    reverseOS.write(0x81);
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
    BerTag berTag = new BerTag();

    if (withTag) {
      tlByteCount += tag.decodeAndCheck(is);
    }

    BerLength length = new BerLength();
    tlByteCount += length.decode(is);
    int lengthVal = length.val;
    vByteCount += berTag.decode(is);

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
      euiccChallenge = new Octet16();
      vByteCount += euiccChallenge.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
      smdpAddress = new BerUTF8String();
      vByteCount += smdpAddress.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(EUICCInfo1.tag)) {
      euiccInfo1 = new EUICCInfo1();
      vByteCount += euiccInfo1.decode(is, false);
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
    if (euiccChallenge != null) {
      sb.append("euiccChallenge: ").append(euiccChallenge);
    } else {
      sb.append("euiccChallenge: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (smdpAddress != null) {
      sb.append("smdpAddress: ").append(smdpAddress);
    } else {
      sb.append("smdpAddress: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccInfo1 != null) {
      sb.append("euiccInfo1: ");
      euiccInfo1.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("euiccInfo1: <empty-required-field>");
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

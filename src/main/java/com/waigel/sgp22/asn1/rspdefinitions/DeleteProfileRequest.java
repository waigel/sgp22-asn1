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

public class DeleteProfileRequest implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  private byte[] code = null;
  public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 51);

  private OctetTo16 isdpAid = null;
  private Iccid iccid = null;

  public DeleteProfileRequest() {}

  public DeleteProfileRequest(byte[] code) {
    this.code = code;
  }

  public void setIsdpAid(OctetTo16 isdpAid) {
    this.isdpAid = isdpAid;
  }

  public OctetTo16 getIsdpAid() {
    return isdpAid;
  }

  public void setIccid(Iccid iccid) {
    this.iccid = iccid;
  }

  public Iccid getIccid() {
    return iccid;
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
    if (iccid != null) {
      codeLength += iccid.encode(reverseOS, true);
      codeLength += BerLength.encodeLength(reverseOS, codeLength);
      if (withTag) {
        codeLength += tag.encode(reverseOS);
      }
      return codeLength;
    }

    if (isdpAid != null) {
      codeLength += isdpAid.encode(reverseOS, false);
      // write tag: APPLICATION_CLASS, PRIMITIVE, 15
      reverseOS.write(0x4F);
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

    if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
      isdpAid = new OctetTo16();
      tlvByteCount += isdpAid.decode(is, false);
      tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
      return tlvByteCount;
    }

    if (berTag.equals(Iccid.tag)) {
      iccid = new Iccid();
      tlvByteCount += iccid.decode(is, false);
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

    if (isdpAid != null) {
      sb.append("isdpAid: ").append(isdpAid);
      return;
    }

    if (iccid != null) {
      sb.append("iccid: ").append(iccid);
      return;
    }

    sb.append("<none>");
  }
}

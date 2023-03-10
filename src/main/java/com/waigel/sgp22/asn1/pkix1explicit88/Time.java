/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1explicit88;

import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerGeneralizedTime;
import com.beanit.asn1bean.ber.types.BerType;
import com.beanit.asn1bean.ber.types.BerUtcTime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Time implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  private byte[] code = null;
  private BerUtcTime utcTime = null;
  private BerGeneralizedTime generalTime = null;

  public Time() {}

  public Time(byte[] code) {
    this.code = code;
  }

  public void setUtcTime(BerUtcTime utcTime) {
    this.utcTime = utcTime;
  }

  public BerUtcTime getUtcTime() {
    return utcTime;
  }

  public void setGeneralTime(BerGeneralizedTime generalTime) {
    this.generalTime = generalTime;
  }

  public BerGeneralizedTime getGeneralTime() {
    return generalTime;
  }

  public byte[] getRaw() {
    return code;
  }

  @Override
  public int encode(OutputStream reverseOS) throws IOException {

    if (code != null) {
      reverseOS.write(code);
      return code.length;
    }

    int codeLength = 0;
    if (generalTime != null) {
      codeLength += generalTime.encode(reverseOS, true);
      return codeLength;
    }

    if (utcTime != null) {
      codeLength += utcTime.encode(reverseOS, true);
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

    if (berTag.equals(BerUtcTime.tag)) {
      utcTime = new BerUtcTime();
      tlvByteCount += utcTime.decode(is, false);
      return tlvByteCount;
    }

    if (berTag.equals(BerGeneralizedTime.tag)) {
      generalTime = new BerGeneralizedTime();
      tlvByteCount += generalTime.decode(is, false);
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

    if (utcTime != null) {
      sb.append("utcTime: ").append(utcTime);
      return;
    }

    if (generalTime != null) {
      sb.append("generalTime: ").append(generalTime);
      return;
    }

    sb.append("<none>");
  }
}

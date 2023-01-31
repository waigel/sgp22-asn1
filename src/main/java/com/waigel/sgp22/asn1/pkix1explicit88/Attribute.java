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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Attribute implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static class Values implements BerType, Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 17);
    private byte[] code = null;
    private List<AttributeValue> seqOf = null;

    public Values() {
      seqOf = new ArrayList<>();
    }

    public Values(byte[] code) {
      this.code = code;
    }

    public List<AttributeValue> getAttributeValue() {
      if (seqOf == null) {
        seqOf = new ArrayList<>();
      }
      return seqOf;
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
      for (int i = (seqOf.size() - 1); i >= 0; i--) {
        codeLength += seqOf.get(i).encode(reverseOS);
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

      while (vByteCount < lengthVal || lengthVal < 0) {
        vByteCount += berTag.decode(is);

        if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
          vByteCount += BerLength.readEocByte(is);
          break;
        }

        AttributeValue element = new AttributeValue();
        numDecodedBytes = element.decode(is, berTag);
        if (numDecodedBytes == 0) {
          throw new IOException("Tag did not match");
        }
        vByteCount += numDecodedBytes;
        seqOf.add(element);
      }
      if (lengthVal >= 0 && vByteCount != lengthVal) {
        throw new IOException(
            "Decoded SequenceOf or SetOf has wrong length. Expected "
                + lengthVal
                + " but has "
                + vByteCount);
      }
      return tlByteCount + vByteCount;
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

      sb.append("{\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      if (seqOf == null) {
        sb.append("null");
      } else {
        Iterator<AttributeValue> it = seqOf.iterator();
        if (it.hasNext()) {
          sb.append(it.next());
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            sb.append(it.next());
          }
        }
      }

      sb.append("\n");
      for (int i = 0; i < indentLevel; i++) {
        sb.append("\t");
      }
      sb.append("}");
    }
  }

  public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

  private byte[] code = null;
  private AttributeType type = null;
  private Values values = null;

  public Attribute() {}

  public Attribute(byte[] code) {
    this.code = code;
  }

  public void setType(AttributeType type) {
    this.type = type;
  }

  public AttributeType getType() {
    return type;
  }

  public void setValues(Values values) {
    this.values = values;
  }

  public Values getValues() {
    return values;
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
    codeLength += values.encode(reverseOS, true);

    codeLength += type.encode(reverseOS, true);

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

    if (berTag.equals(AttributeType.tag)) {
      type = new AttributeType();
      vByteCount += type.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(Values.tag)) {
      values = new Values();
      vByteCount += values.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
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
    sb.append("\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (type != null) {
      sb.append("type: ").append(type);
    } else {
      sb.append("type: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (values != null) {
      sb.append("values: ");
      values.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("values: <empty-required-field>");
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

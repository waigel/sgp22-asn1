/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.BerLength;
import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.DecodeUtil;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerInteger;
import com.beanit.asn1bean.ber.types.BerOctetString;
import com.beanit.asn1bean.ber.types.BerType;
import com.beanit.asn1bean.ber.types.string.BerUTF8String;
import com.waigel.sgp22.asn1.pkix1implicit88.SubjectKeyIdentifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EUICCInfo2 implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static class EuiccCiPKIdListForVerification implements BerType, Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    private byte[] code = null;
    private List<SubjectKeyIdentifier> seqOf = null;

    public EuiccCiPKIdListForVerification() {
      seqOf = new ArrayList<>();
    }

    public EuiccCiPKIdListForVerification(byte[] code) {
      this.code = code;
    }

    public List<SubjectKeyIdentifier> getSubjectKeyIdentifier() {
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
        codeLength += seqOf.get(i).encode(reverseOS, true);
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

      while (vByteCount < lengthVal || lengthVal < 0) {
        vByteCount += berTag.decode(is);

        if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
          vByteCount += BerLength.readEocByte(is);
          break;
        }

        if (!berTag.equals(SubjectKeyIdentifier.tag)) {
          throw new IOException("Tag does not match mandatory sequence of/set of component.");
        }
        SubjectKeyIdentifier element = new SubjectKeyIdentifier();
        vByteCount += element.decode(is, false);
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
        Iterator<SubjectKeyIdentifier> it = seqOf.iterator();
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

  public static class EuiccCiPKIdListForSigning implements BerType, Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    private byte[] code = null;
    private List<SubjectKeyIdentifier> seqOf = null;

    public EuiccCiPKIdListForSigning() {
      seqOf = new ArrayList<>();
    }

    public EuiccCiPKIdListForSigning(byte[] code) {
      this.code = code;
    }

    public List<SubjectKeyIdentifier> getSubjectKeyIdentifier() {
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
        codeLength += seqOf.get(i).encode(reverseOS, true);
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

      while (vByteCount < lengthVal || lengthVal < 0) {
        vByteCount += berTag.decode(is);

        if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
          vByteCount += BerLength.readEocByte(is);
          break;
        }

        if (!berTag.equals(SubjectKeyIdentifier.tag)) {
          throw new IOException("Tag does not match mandatory sequence of/set of component.");
        }
        SubjectKeyIdentifier element = new SubjectKeyIdentifier();
        vByteCount += element.decode(is, false);
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
        Iterator<SubjectKeyIdentifier> it = seqOf.iterator();
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

  public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 34);

  private byte[] code = null;
  private VersionType profileVersion = null;
  private VersionType svn = null;
  private VersionType euiccFirmwareVer = null;
  private BerOctetString extCardResource = null;
  private UICCCapability uiccCapability = null;
  private VersionType javacardVersion = null;
  private VersionType globalplatformVersion = null;
  private RspCapability rspCapability = null;
  private EuiccCiPKIdListForVerification euiccCiPKIdListForVerification = null;
  private EuiccCiPKIdListForSigning euiccCiPKIdListForSigning = null;
  private BerInteger euiccCategory = null;
  private PprIds forbiddenProfilePolicyRules = null;
  private VersionType ppVersion = null;
  private BerUTF8String sasAcreditationNumber = null;
  private CertificationDataObject certificationDataObject = null;

  public EUICCInfo2() {}

  public EUICCInfo2(byte[] code) {
    this.code = code;
  }

  public void setProfileVersion(VersionType profileVersion) {
    this.profileVersion = profileVersion;
  }

  public VersionType getProfileVersion() {
    return profileVersion;
  }

  public void setSvn(VersionType svn) {
    this.svn = svn;
  }

  public VersionType getSvn() {
    return svn;
  }

  public void setEuiccFirmwareVer(VersionType euiccFirmwareVer) {
    this.euiccFirmwareVer = euiccFirmwareVer;
  }

  public VersionType getEuiccFirmwareVer() {
    return euiccFirmwareVer;
  }

  public void setExtCardResource(BerOctetString extCardResource) {
    this.extCardResource = extCardResource;
  }

  public BerOctetString getExtCardResource() {
    return extCardResource;
  }

  public void setUiccCapability(UICCCapability uiccCapability) {
    this.uiccCapability = uiccCapability;
  }

  public UICCCapability getUiccCapability() {
    return uiccCapability;
  }

  public void setJavacardVersion(VersionType javacardVersion) {
    this.javacardVersion = javacardVersion;
  }

  public VersionType getJavacardVersion() {
    return javacardVersion;
  }

  public void setGlobalplatformVersion(VersionType globalplatformVersion) {
    this.globalplatformVersion = globalplatformVersion;
  }

  public VersionType getGlobalplatformVersion() {
    return globalplatformVersion;
  }

  public void setRspCapability(RspCapability rspCapability) {
    this.rspCapability = rspCapability;
  }

  public RspCapability getRspCapability() {
    return rspCapability;
  }

  public void setEuiccCiPKIdListForVerification(
      EuiccCiPKIdListForVerification euiccCiPKIdListForVerification) {
    this.euiccCiPKIdListForVerification = euiccCiPKIdListForVerification;
  }

  public EuiccCiPKIdListForVerification getEuiccCiPKIdListForVerification() {
    return euiccCiPKIdListForVerification;
  }

  public void setEuiccCiPKIdListForSigning(EuiccCiPKIdListForSigning euiccCiPKIdListForSigning) {
    this.euiccCiPKIdListForSigning = euiccCiPKIdListForSigning;
  }

  public EuiccCiPKIdListForSigning getEuiccCiPKIdListForSigning() {
    return euiccCiPKIdListForSigning;
  }

  public void setEuiccCategory(BerInteger euiccCategory) {
    this.euiccCategory = euiccCategory;
  }

  public BerInteger getEuiccCategory() {
    return euiccCategory;
  }

  public void setForbiddenProfilePolicyRules(PprIds forbiddenProfilePolicyRules) {
    this.forbiddenProfilePolicyRules = forbiddenProfilePolicyRules;
  }

  public PprIds getForbiddenProfilePolicyRules() {
    return forbiddenProfilePolicyRules;
  }

  public void setPpVersion(VersionType ppVersion) {
    this.ppVersion = ppVersion;
  }

  public VersionType getPpVersion() {
    return ppVersion;
  }

  public void setSasAcreditationNumber(BerUTF8String sasAcreditationNumber) {
    this.sasAcreditationNumber = sasAcreditationNumber;
  }

  public BerUTF8String getSasAcreditationNumber() {
    return sasAcreditationNumber;
  }

  public void setCertificationDataObject(CertificationDataObject certificationDataObject) {
    this.certificationDataObject = certificationDataObject;
  }

  public CertificationDataObject getCertificationDataObject() {
    return certificationDataObject;
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
    if (certificationDataObject != null) {
      codeLength += certificationDataObject.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, CONSTRUCTED, 12
      reverseOS.write(0xAC);
      codeLength += 1;
    }

    codeLength += sasAcreditationNumber.encode(reverseOS, true);

    codeLength += ppVersion.encode(reverseOS, true);

    if (forbiddenProfilePolicyRules != null) {
      codeLength += forbiddenProfilePolicyRules.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 25
      reverseOS.write(0x99);
      codeLength += 1;
    }

    if (euiccCategory != null) {
      codeLength += euiccCategory.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 11
      reverseOS.write(0x8B);
      codeLength += 1;
    }

    codeLength += euiccCiPKIdListForSigning.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, CONSTRUCTED, 10
    reverseOS.write(0xAA);
    codeLength += 1;

    codeLength += euiccCiPKIdListForVerification.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, CONSTRUCTED, 9
    reverseOS.write(0xA9);
    codeLength += 1;

    codeLength += rspCapability.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 8
    reverseOS.write(0x88);
    codeLength += 1;

    if (globalplatformVersion != null) {
      codeLength += globalplatformVersion.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 7
      reverseOS.write(0x87);
      codeLength += 1;
    }

    if (javacardVersion != null) {
      codeLength += javacardVersion.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 6
      reverseOS.write(0x86);
      codeLength += 1;
    }

    codeLength += uiccCapability.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 5
    reverseOS.write(0x85);
    codeLength += 1;

    codeLength += extCardResource.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 4
    reverseOS.write(0x84);
    codeLength += 1;

    codeLength += euiccFirmwareVer.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 3
    reverseOS.write(0x83);
    codeLength += 1;

    codeLength += svn.encode(reverseOS, false);
    // write tag: CONTEXT_CLASS, PRIMITIVE, 2
    reverseOS.write(0x82);
    codeLength += 1;

    codeLength += profileVersion.encode(reverseOS, false);
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
      profileVersion = new VersionType();
      vByteCount += profileVersion.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
      svn = new VersionType();
      vByteCount += svn.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
      euiccFirmwareVer = new VersionType();
      vByteCount += euiccFirmwareVer.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
      extCardResource = new BerOctetString();
      vByteCount += extCardResource.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
      uiccCapability = new UICCCapability();
      vByteCount += uiccCapability.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
      javacardVersion = new VersionType();
      vByteCount += javacardVersion.decode(is, false);
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
      globalplatformVersion = new VersionType();
      vByteCount += globalplatformVersion.decode(is, false);
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
      rspCapability = new RspCapability();
      vByteCount += rspCapability.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
      euiccCiPKIdListForVerification = new EuiccCiPKIdListForVerification();
      vByteCount += euiccCiPKIdListForVerification.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
      euiccCiPKIdListForSigning = new EuiccCiPKIdListForSigning();
      vByteCount += euiccCiPKIdListForSigning.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 11)) {
      euiccCategory = new BerInteger();
      vByteCount += euiccCategory.decode(is, false);
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 25)) {
      forbiddenProfilePolicyRules = new PprIds();
      vByteCount += forbiddenProfilePolicyRules.decode(is, false);
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(VersionType.tag)) {
      ppVersion = new VersionType();
      vByteCount += ppVersion.decode(is, false);
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerUTF8String.tag)) {
      sasAcreditationNumber = new BerUTF8String();
      vByteCount += sasAcreditationNumber.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    } else {
      throw new IOException("Tag does not match mandatory sequence component.");
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 12)) {
      certificationDataObject = new CertificationDataObject();
      vByteCount += certificationDataObject.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
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
    if (profileVersion != null) {
      sb.append("profileVersion: ").append(profileVersion);
    } else {
      sb.append("profileVersion: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (svn != null) {
      sb.append("svn: ").append(svn);
    } else {
      sb.append("svn: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccFirmwareVer != null) {
      sb.append("euiccFirmwareVer: ").append(euiccFirmwareVer);
    } else {
      sb.append("euiccFirmwareVer: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (extCardResource != null) {
      sb.append("extCardResource: ").append(extCardResource);
    } else {
      sb.append("extCardResource: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (uiccCapability != null) {
      sb.append("uiccCapability: ").append(uiccCapability);
    } else {
      sb.append("uiccCapability: <empty-required-field>");
    }

    if (javacardVersion != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("javacardVersion: ").append(javacardVersion);
    }

    if (globalplatformVersion != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("globalplatformVersion: ").append(globalplatformVersion);
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (rspCapability != null) {
      sb.append("rspCapability: ").append(rspCapability);
    } else {
      sb.append("rspCapability: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccCiPKIdListForVerification != null) {
      sb.append("euiccCiPKIdListForVerification: ");
      euiccCiPKIdListForVerification.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("euiccCiPKIdListForVerification: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (euiccCiPKIdListForSigning != null) {
      sb.append("euiccCiPKIdListForSigning: ");
      euiccCiPKIdListForSigning.appendAsString(sb, indentLevel + 1);
    } else {
      sb.append("euiccCiPKIdListForSigning: <empty-required-field>");
    }

    if (euiccCategory != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("euiccCategory: ").append(euiccCategory);
    }

    if (forbiddenProfilePolicyRules != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("forbiddenProfilePolicyRules: ").append(forbiddenProfilePolicyRules);
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (ppVersion != null) {
      sb.append("ppVersion: ").append(ppVersion);
    } else {
      sb.append("ppVersion: <empty-required-field>");
    }

    sb.append(",\n");
    for (int i = 0; i < indentLevel + 1; i++) {
      sb.append("\t");
    }
    if (sasAcreditationNumber != null) {
      sb.append("sasAcreditationNumber: ").append(sasAcreditationNumber);
    } else {
      sb.append("sasAcreditationNumber: <empty-required-field>");
    }

    if (certificationDataObject != null) {
      sb.append(",\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("certificationDataObject: ");
      certificationDataObject.appendAsString(sb, indentLevel + 1);
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

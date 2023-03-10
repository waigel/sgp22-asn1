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
import com.beanit.asn1bean.ber.types.string.BerUTF8String;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfileInfo implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  public static class NotificationConfigurationInfo implements BerType, Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    private byte[] code = null;
    private List<NotificationConfigurationInformation> seqOf = null;

    public NotificationConfigurationInfo() {
      seqOf = new ArrayList<>();
    }

    public NotificationConfigurationInfo(byte[] code) {
      this.code = code;
    }

    public List<NotificationConfigurationInformation> getNotificationConfigurationInformation() {
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

        if (!berTag.equals(NotificationConfigurationInformation.tag)) {
          throw new IOException("Tag does not match mandatory sequence of/set of component.");
        }
        NotificationConfigurationInformation element = new NotificationConfigurationInformation();
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
        Iterator<NotificationConfigurationInformation> it = seqOf.iterator();
        if (it.hasNext()) {
          it.next().appendAsString(sb, indentLevel + 1);
          while (it.hasNext()) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
              sb.append("\t");
            }
            it.next().appendAsString(sb, indentLevel + 1);
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

  public static final BerTag tag = new BerTag(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 3);

  private byte[] code = null;
  private Iccid iccid = null;
  private OctetTo16 isdpAid = null;
  private ProfileState profileState = null;
  private BerUTF8String profileNickname = null;
  private BerUTF8String serviceProviderName = null;
  private BerUTF8String profileName = null;
  private IconType iconType = null;
  private BerOctetString icon = null;
  private ProfileClass profileClass = null;
  private NotificationConfigurationInfo notificationConfigurationInfo = null;
  private OperatorID profileOwner = null;
  private DpProprietaryData dpProprietaryData = null;
  private PprIds profilePolicyRules = null;

  public ProfileInfo() {}

  public ProfileInfo(byte[] code) {
    this.code = code;
  }

  public void setIccid(Iccid iccid) {
    this.iccid = iccid;
  }

  public Iccid getIccid() {
    return iccid;
  }

  public void setIsdpAid(OctetTo16 isdpAid) {
    this.isdpAid = isdpAid;
  }

  public OctetTo16 getIsdpAid() {
    return isdpAid;
  }

  public void setProfileState(ProfileState profileState) {
    this.profileState = profileState;
  }

  public ProfileState getProfileState() {
    return profileState;
  }

  public void setProfileNickname(BerUTF8String profileNickname) {
    this.profileNickname = profileNickname;
  }

  public BerUTF8String getProfileNickname() {
    return profileNickname;
  }

  public void setServiceProviderName(BerUTF8String serviceProviderName) {
    this.serviceProviderName = serviceProviderName;
  }

  public BerUTF8String getServiceProviderName() {
    return serviceProviderName;
  }

  public void setProfileName(BerUTF8String profileName) {
    this.profileName = profileName;
  }

  public BerUTF8String getProfileName() {
    return profileName;
  }

  public void setIconType(IconType iconType) {
    this.iconType = iconType;
  }

  public IconType getIconType() {
    return iconType;
  }

  public void setIcon(BerOctetString icon) {
    this.icon = icon;
  }

  public BerOctetString getIcon() {
    return icon;
  }

  public void setProfileClass(ProfileClass profileClass) {
    this.profileClass = profileClass;
  }

  public ProfileClass getProfileClass() {
    return profileClass;
  }

  public void setNotificationConfigurationInfo(
      NotificationConfigurationInfo notificationConfigurationInfo) {
    this.notificationConfigurationInfo = notificationConfigurationInfo;
  }

  public NotificationConfigurationInfo getNotificationConfigurationInfo() {
    return notificationConfigurationInfo;
  }

  public void setProfileOwner(OperatorID profileOwner) {
    this.profileOwner = profileOwner;
  }

  public OperatorID getProfileOwner() {
    return profileOwner;
  }

  public void setDpProprietaryData(DpProprietaryData dpProprietaryData) {
    this.dpProprietaryData = dpProprietaryData;
  }

  public DpProprietaryData getDpProprietaryData() {
    return dpProprietaryData;
  }

  public void setProfilePolicyRules(PprIds profilePolicyRules) {
    this.profilePolicyRules = profilePolicyRules;
  }

  public PprIds getProfilePolicyRules() {
    return profilePolicyRules;
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
    if (profilePolicyRules != null) {
      codeLength += profilePolicyRules.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 25
      reverseOS.write(0x99);
      codeLength += 1;
    }

    if (dpProprietaryData != null) {
      codeLength += dpProprietaryData.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, CONSTRUCTED, 24
      reverseOS.write(0xB8);
      codeLength += 1;
    }

    if (profileOwner != null) {
      codeLength += profileOwner.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, CONSTRUCTED, 23
      reverseOS.write(0xB7);
      codeLength += 1;
    }

    if (notificationConfigurationInfo != null) {
      codeLength += notificationConfigurationInfo.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, CONSTRUCTED, 22
      reverseOS.write(0xB6);
      codeLength += 1;
    }

    if (profileClass != null) {
      codeLength += profileClass.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 21
      reverseOS.write(0x95);
      codeLength += 1;
    }

    if (icon != null) {
      codeLength += icon.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 20
      reverseOS.write(0x94);
      codeLength += 1;
    }

    if (iconType != null) {
      codeLength += iconType.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 19
      reverseOS.write(0x93);
      codeLength += 1;
    }

    if (profileName != null) {
      codeLength += profileName.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 18
      reverseOS.write(0x92);
      codeLength += 1;
    }

    if (serviceProviderName != null) {
      codeLength += serviceProviderName.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 17
      reverseOS.write(0x91);
      codeLength += 1;
    }

    if (profileNickname != null) {
      codeLength += profileNickname.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 16
      reverseOS.write(0x90);
      codeLength += 1;
    }

    if (profileState != null) {
      codeLength += profileState.encode(reverseOS, false);
      // write tag: CONTEXT_CLASS, PRIMITIVE, 112
      reverseOS.write(0x70);
      reverseOS.write(0x9F);
      codeLength += 2;
    }

    if (isdpAid != null) {
      codeLength += isdpAid.encode(reverseOS, false);
      // write tag: APPLICATION_CLASS, PRIMITIVE, 15
      reverseOS.write(0x4F);
      codeLength += 1;
    }

    if (iccid != null) {
      codeLength += iccid.encode(reverseOS, true);
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

    if (berTag.equals(Iccid.tag)) {
      iccid = new Iccid();
      vByteCount += iccid.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
      isdpAid = new OctetTo16();
      vByteCount += isdpAid.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 112)) {
      profileState = new ProfileState();
      vByteCount += profileState.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 16)) {
      profileNickname = new BerUTF8String();
      vByteCount += profileNickname.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 17)) {
      serviceProviderName = new BerUTF8String();
      vByteCount += serviceProviderName.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 18)) {
      profileName = new BerUTF8String();
      vByteCount += profileName.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 19)) {
      iconType = new IconType();
      vByteCount += iconType.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 20)) {
      icon = new BerOctetString();
      vByteCount += icon.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 21)) {
      profileClass = new ProfileClass();
      vByteCount += profileClass.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 22)) {
      notificationConfigurationInfo = new NotificationConfigurationInfo();
      vByteCount += notificationConfigurationInfo.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 23)) {
      profileOwner = new OperatorID();
      vByteCount += profileOwner.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 24)) {
      dpProprietaryData = new DpProprietaryData();
      vByteCount += dpProprietaryData.decode(is, false);
      if (lengthVal >= 0 && vByteCount == lengthVal) {
        return tlByteCount + vByteCount;
      }
      vByteCount += berTag.decode(is);
    }

    if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 25)) {
      profilePolicyRules = new PprIds();
      vByteCount += profilePolicyRules.decode(is, false);
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
    boolean firstSelectedElement = true;
    if (iccid != null) {
      sb.append("\n");
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("iccid: ").append(iccid);
      firstSelectedElement = false;
    }

    if (isdpAid != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("isdpAid: ").append(isdpAid);
      firstSelectedElement = false;
    }

    if (profileState != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profileState: ").append(profileState);
      firstSelectedElement = false;
    }

    if (profileNickname != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profileNickname: ").append(profileNickname);
      firstSelectedElement = false;
    }

    if (serviceProviderName != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("serviceProviderName: ").append(serviceProviderName);
      firstSelectedElement = false;
    }

    if (profileName != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profileName: ").append(profileName);
      firstSelectedElement = false;
    }

    if (iconType != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("iconType: ").append(iconType);
      firstSelectedElement = false;
    }

    if (icon != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("icon: ").append(icon);
      firstSelectedElement = false;
    }

    if (profileClass != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profileClass: ").append(profileClass);
      firstSelectedElement = false;
    }

    if (notificationConfigurationInfo != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("notificationConfigurationInfo: ");
      notificationConfigurationInfo.appendAsString(sb, indentLevel + 1);
      firstSelectedElement = false;
    }

    if (profileOwner != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profileOwner: ");
      profileOwner.appendAsString(sb, indentLevel + 1);
      firstSelectedElement = false;
    }

    if (dpProprietaryData != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("dpProprietaryData: ");
      dpProprietaryData.appendAsString(sb, indentLevel + 1);
      firstSelectedElement = false;
    }

    if (profilePolicyRules != null) {
      if (!firstSelectedElement) {
        sb.append(",\n");
      }
      for (int i = 0; i < indentLevel + 1; i++) {
        sb.append("\t");
      }
      sb.append("profilePolicyRules: ").append(profilePolicyRules);
    }

    sb.append("\n");
    for (int i = 0; i < indentLevel; i++) {
      sb.append("\t");
    }
    sb.append("}");
  }
}

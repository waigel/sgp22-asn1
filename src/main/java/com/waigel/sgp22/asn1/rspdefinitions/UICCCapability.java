/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.types.BerBitString;

public class UICCCapability extends BerBitString {

  private static final long serialVersionUID = 1L;

  public UICCCapability() {}

  public UICCCapability(byte[] code) {
    super(code);
  }

  public UICCCapability(byte[] value, int numBits) {
    super(value, numBits);
  }

  public UICCCapability(boolean[] value) {
    super(value);
  }
}

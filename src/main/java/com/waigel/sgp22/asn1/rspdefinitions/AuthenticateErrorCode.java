/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.rspdefinitions;

import com.beanit.asn1bean.ber.types.BerInteger;
import java.math.BigInteger;

public class AuthenticateErrorCode extends BerInteger {

  private static final long serialVersionUID = 1L;

  public AuthenticateErrorCode() {}

  public AuthenticateErrorCode(byte[] code) {
    super(code);
  }

  public AuthenticateErrorCode(BigInteger value) {
    super(value);
  }

  public AuthenticateErrorCode(long value) {
    super(value);
  }
}

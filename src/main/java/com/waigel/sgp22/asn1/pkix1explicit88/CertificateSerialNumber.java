/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.waigel.sgp22.asn1.pkix1explicit88;

import com.beanit.asn1bean.ber.types.BerInteger;
import java.math.BigInteger;


public class CertificateSerialNumber extends BerInteger {

	private static final long serialVersionUID = 1L;

	public CertificateSerialNumber() {
	}

	public CertificateSerialNumber(byte[] code) {
		super(code);
	}

	public CertificateSerialNumber(BigInteger value) {
		super(value);
	}

	public CertificateSerialNumber(long value) {
		super(value);
	}

}
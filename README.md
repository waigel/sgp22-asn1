## ASN.1 Classes for SGP-22 V2.2 Specification

This library contains generated ASN.1 classes for the SGP-22 V2.2 Specification. The classes were generated using the tool `ASN1bean`.

The ASN.1 classes in this library can be used to encode and decode messages according to the SGP-22 V2.2 specification. 
The library provides a set of classes that can be used to construct, encode and decode messages as specified in the SGP-22 V2.2 specification.

## Installation
```gradle
implementation("com.waigel.sgp22.asn1:sgp22-asn1")
```
## Example 

Example in kotlin:

```kotlin
val base64EncodedString = "vyA1ggMCAgKpFgQUgTcPUSXQsdQI1MOyMubSXnlb6/uqFgQUgTcPUSXQsdQI1MOyMubSXnlb6/s=";
val encodedBytes = Base64.getDecoder().decode(base64EncodedString)
val eUICCInfo1 = EUICCInfo1();
eUICCInfo1.decode(encodedBytes.inputStream());
println(eUICCInfo1.svn)
```

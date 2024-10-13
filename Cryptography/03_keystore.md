# Generate keystore file

> A keystore is a secure storage mechanism used to manage cryptographic keys and certificates. It is typically employed in applications and services that require encryption, secure communications, or identity verification.

## Types of keystore

1. **Java keystore (JKS)**
    - A default keystore format in Java applications, often used for SSL/TLS configuration.
    - File should be stored as *.jks* extension.
2. **PKCS#12**
    - A binary format for storing private keys and certificates, commonly used for exporting and importing keys and certificates between different applications and platforms.
    - File should be stored as *.p12* extension.

## Pre-requisties

1. [Generate RSA key pair](./01_RSA.md)
1. [Generate certificate](./02_self_signed_certificate.md)

## Steps

### Step 1: Generate PKCS format keystore

Run below command to generate keystore file. Enter a password for the new keystore file.

```shell
openssl pkcs12 -export -in vpk_self_signed_certificate.crt -inkey vpk_private_key.key -out vpk_keystore.p12 -name vpkalias
```

### Step 2: Generate JKS format keystore (Optional)

For java application, consider *.jks* instead of *.p12*. Enter a password for the new keystore file.

```shell
keytool -importkeystore -srckeystore vpk_keystore.p12 -srcstoretype PKCS12 -destkeystore vpk_keystore.jks -deststoretype JKS
```
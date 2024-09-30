# FAQ's

## What is PEM file format?
<a id="what-is-pem-file-format"></a>

PEM stands for Privacy-Enhanced Mail, widely used for storing cryptographic data like private keys, certificates etc. These files have header (-----BEGIN PRIVATE KEY-----) and footer (-----END PRIVATE KEY-----) along with base64 encoded data. Below is an example PEM file.

```bash
-----BEGIN PRIVATE KEY-----
MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDMRghA
-----END PRIVATE KEY-----
```

## What is keystore?
<a id="what-is-keystore"></a>

A keystore is a repository or storage location for cryptographic keys and certificates. It is used to manage and store keys securely, which are used for various cryptographic operations such as encryption, decryption, digital signatures, and authentication. There are two most common types of keystore file.

- JKS (Java keystore)
- PKCS12

## What is Root CA?
<a id="what-is-root-ca"></a>

A Root CA is the top-most certificate authority in a PKI hierarchy. It is a trusted entity that issues digital certificates. The Root CA signs certificates for Intermediate CAs, which in turn issue certificates to end entities (like websites, email users, etc.). Root CA is self-signed. Below are some popular Root CA.

1. DigiCert
2. Let's Encrypt

### Steps to create own CA
<a id="steps-to-create-own-ca"></a>

As CA is nothing but a self-signed entity, we can create our own CA. Creating our own Certificate Authority (CA) involves generating a self-signed entity. However, browsers such as Chrome do not recognize these self-signed certificates, resulting in an insecure lock icon appearing on websites that use them. Certificates signed by above established vendors, on the other hand, are globally trusted by browsers, ensuring no such issues with security indicators.

1. Run below command to create `ca.key` and `ca.csr` file.
    ```bash
    openssl req -new -newkey rsa:2048 -nodes -keyout ca.key -out ca.csr
    ```
2. Use the `ca.key` itself to sign `ca.csr` file.
    ```bash
    openssl x509 -req -in ca.csr -signkey ca.key -out ca.crt -days 3650 -sha256
    ```
   This command signs the CSR (ca.csr) with the private key (ca.key) to create a self-signed CA certificate (ca.crt) valid for 10 years (-days 3650) using the SHA-256 hash algorithm (-sha256).

## What is Intermediate CA?
<a id="what-is-intermediate-ca"></a>

Intermediate CAs issue certificates to end entities or to other intermediate CAs, creating a certificate chain that traces back to the Root CA. Intermediate CAs are signed by the [Root CA](#what-is-root-ca). Below are some intermediate CA.

1. GoDaddy Secure Certificate Authority
2. DigiCert Intermediate CA
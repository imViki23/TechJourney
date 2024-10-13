# Generate self signed certificate

> A self-signed certificate is a digital certificate created and signed by the issuing individual or organization, not by a trusted Certificate Authority (CA). These certificates are mainly utilized for testing purposes, internal network communications, or specific applications where the user or organization can authenticate the certificate themselves.

## Pre-requisties

1. [Generate RSA key pair](./01_RSA.md)

## Steps

### Step 1. Generate self-signed certificate

Run below command to generate self-signed certificate. You will be asked to enter information that will be incorporated into your certificate request.

Output of the certificate file contains Base64 encoded data of components like certificate version, serial number, signature algorithm, issuer, validatity period, public key etc. in PEM file format. <sup>[(What is PEM file format?)](./FAQ.md#what-is-pem-file-format)</sup>

```shell
openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout vpk_private_key.key -out vpk_self_signed_certificate.crt
```
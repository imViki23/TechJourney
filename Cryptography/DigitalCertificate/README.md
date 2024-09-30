# Digital Certificate

Digital certificates, also known as SSL/TLS certificates or X.509 certificates, are electronic credentials that validate the identity of a website, server, device, or user over the internet. They play a critical role in ensuring secure communication, data integrity, and authentication in various online transactions and interactions.

## Steps to generate a digital certificate

Generating a digital certificate typically involves a [Certificate Authority (CA)](../FAQ.md#what-is-root-ca) verifying your identity and then issuing a certificate to you.

### Step 1: Create a Certificate Signing Request (CSR) file

Run below command and fill in details like organization data, email id etc.

```bash
openssl req -new -newkey rsa:2048 -nodes -keyout server.key -out server.csr
```

This command generates a private key `server.key` and a CSR `server.csr`.

### Step 2: Submit CSR to CA

Go to your chosen CA’s website and follow their instructions to submit the CSR and complete the validation process. Here CA will use its private key and certificate file to sign your CSR file.

But for this tutorial, [I created my own CA](../FAQ.md#steps-to-create-own-ca). CA will run the below command.

```bash
openssl x509 -req -in server.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out server.crt -days 365 -sha256
```

This command signs the CSR `server.csr` using your CA’s private key `ca.key` and CA certificate `ca.crt`, creating a signed *digital certificate `server.crt`* valid for 1 year (-days 365).

### Step 3: Store the `server.key` and the digital certificate `server.crt` securely.

## Common Use cases

1. *HTTPS*: Websites use certificates to enable HTTPS (HTTP Secure), encrypting data between web browsers and servers to protect user privacy and data integrity.


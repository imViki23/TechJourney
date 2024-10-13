# RSA (Rivest-Shamir-Adleman)

> - RSA (Rivest-Shamir-Adleman) is a widely used asymmetric cryptographic algorithm. RSA keys are typically 1024, 2048, or 4096 bits long. The longer the key, the more secure the encryption, but at the cost of slower encryption and decryption speeds.
> - RSA is used in secure web browsing (SSL/TLS), digital signatures, email encryption (PGP), and other secure communications.

## Steps to generate RSA keys

### Step 1: Generate a private key using openssl

```bash
openssl genrsa -out vpk_private_key.key 2048
```

Output of the private key contains Base64 encoded data of RSA components like modulus and exponents in PEM file format. <sup>[(What is PEM file format?)](./FAQ.md#what-is-pem-file-format)</sup>

### Step 2: Generate a public key using openssl

```bash
openssl rsa -in vpk_private_key.key -pubout -out vpk_public_key.key
```

This command too generates key in PEM file format.
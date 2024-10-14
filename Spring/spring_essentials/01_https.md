# Setting up HTTPS for secure communication

## 1. Pre-requisites

1. [Generate JKS keystore file](../../Cryptography/03_keystore.md)

## 2. Steps

### Step 1: Copy jks file

Copy jks file generated from following pre-requisites to resources folder.

### Step 2: Configure *application.properties*

```yaml
server:
  port: 8443
  ssl:
    key-store: classpath:vpk_keystore.jks
    key-store-password: password123
    key-store-type: JKS
    key-alias: vpkalias
```

## Testing

Now you can access the API's using https://localhost:8443 instead of default http://localhost:8080
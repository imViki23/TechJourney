# Spring boot project setup

> As mentioned in the [problem statement](./README.md#problem-statement), the goal is to create multiple Spring Boot projects that handles the inventory, cart, and other components as separate services, following the microservice architecture pattern.

## 1. Generate projects

Open https://start.spring.io/ and select below options.

- ***Build tools*** - Gradle (or Maven of your choice)
- ***Language*** - Java
- ***Spring boot version*** - 3.2.5 (or any of your choice)
- ***Group*** - com.vpk (vpk is the name of organization)
- ***Artifact*** - inventoryservice
- ***Name*** - vpk-inventory-service
- ***Packaging*** - Jar
- ***Dependencies***
    - Spring Web
    - Lombok

Click ***Generate*** to download the project as zip. Extract and open it in your favourite editor.

Repeat above for other services like ***vpk-cart-service*** etc.

## 2. Run project in IntelliJ IDEA

For our example, lets take ***vpk-inventory-service*** as an example and IDE as Intellij IDEA.

### Step 1: Open project

Open ***`vpk-inventory-service/build.gradle`*** file in Intellij IDEA.

### Step 2: Choose Java version

In IntelliJ IDEA, you can configure your project to use a specific Java version without modifying your JAVA_HOME or the global IDE settings. This is useful when you want to work with a particular Java version for a project while leaving your system's default configuration unchanged. Here's how you can achieve this:

- Navigate to ***`File > Project Structure > Project`***.
- In the Project SDK dropdown, select the appropriate Java version (e.g., Java 11, Java 17).
- The Project language level should correspond to the selected SDK

### Step 3: Configuring Gradle to Use a Specific Java Version

- Go to ***`File > Settings`***.
- Navigate to ***`Build, Execution, Deployment > Build Tools > Gradle`***.
- In Gradle settings, under Gradle JVM, choose the specific JDK you want Gradle to use.

### Step 4: Run vpk-inventory-service application

- On the right-hand side of the IntelliJ window, open ***`Gradle`*** tab.
- Expand your project folder under ***`Tasks > application`***.
- Double click to run gradle ***`bootRun`*** task which should start the vpk-inventory-service.
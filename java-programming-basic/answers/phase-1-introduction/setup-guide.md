# Java & IDE Setup Guide

## 1. What is Java?
Java is a high-level, object-oriented programming language known for its portability ("write once, run anywhere"). Java code is compiled into bytecode, which runs on the Java Virtual Machine (JVM) on any platform.

## 2. Java Editions
- **Java SE (Standard Edition):** Core language and libraries for desktop/server apps
- **Java EE (Enterprise Edition):** Adds APIs for web, enterprise, and distributed systems
- **Java ME (Micro Edition):** For embedded and mobile devices

## 3. Install the JDK
- Download the latest JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [Adoptium](https://adoptium.net/)
- Follow the installer instructions for your OS (Windows, macOS, Linux)
- Verify installation:
  ```sh
  java -version
  javac -version
  ```

## 4. Set Up Your IDE
- **IntelliJ IDEA (recommended for beginners):**
  - Download: https://www.jetbrains.com/idea/download/
  - Install and open
  - Create a new Java project
- **Eclipse:**
  - Download: https://www.eclipse.org/downloads/
  - Install and open
  - Create a new Java project
- **VS Code:**
  - Download: https://code.visualstudio.com/
  - Install the "Extension Pack for Java"
  - Create a new Java project

## 5. Write Your First Program
- Create a file named `HelloWorld.java`:
  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello, World!");
      }
  }
  ```

## 6. Compile and Run
- Open a terminal/command prompt in the project directory
- Compile:
  ```sh
  javac HelloWorld.java
  ```
- Run:
  ```sh
  java HelloWorld
  ```
- Output should be:
  ```
  Hello, World!
  ```

## 7. Troubleshooting
- If `javac` or `java` is not found, check your PATH environment variable
- Make sure you saved the file as `HelloWorld.java` (case-sensitive)
- The class name must match the filename

---

**You are now ready to start coding in Java!** 
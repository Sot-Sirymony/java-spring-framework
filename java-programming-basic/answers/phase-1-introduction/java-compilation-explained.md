# How Java Code is Compiled and Run

## 1. Write Java Source Code
- You write code in a `.java` file (e.g., `HelloWorld.java`).

## 2. Compile with `javac`
- The Java compiler (`javac`) translates your source code into **bytecode**.
- Bytecode is saved in a `.class` file (e.g., `HelloWorld.class`).
- Example:
  ```sh
  javac HelloWorld.java
  ```

## 3. Run with `java`
- The Java Virtual Machine (JVM) executes the bytecode.
- You run the program using the `java` command:
  ```sh
  java HelloWorld
  ```
- The JVM loads `HelloWorld.class`, interprets the bytecode, and runs your program.

## 4. Why is Java Platform-Independent?
- Bytecode is not specific to any OS or hardware.
- Any device with a JVM can run the same `.class` file.
- This is called "write once, run anywhere".

## 5. Compilation Flow Diagram

```
Your Code (HelloWorld.java)
        |
        v
javac (Compiler)
        |
        v
Bytecode (HelloWorld.class)
        |
        v
java (JVM)
        |
        v
Output: Hello, World!
```

## 6. Common Compilation Errors
- **Syntax errors:** Misspelled keywords, missing semicolons, etc.
- **Class name mismatch:** The filename and public class name must match.
- **Case sensitivity:** Java is case-sensitive (`HelloWorld` ≠ `helloworld`).

---

**Summary:**
- Write code → Compile to bytecode → Run on JVM → Output
- This process makes Java portable and secure. 
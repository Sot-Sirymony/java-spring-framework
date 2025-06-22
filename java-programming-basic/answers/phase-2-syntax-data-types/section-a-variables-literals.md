# Section A: Variables and Literals (Tasks 1–20)

This section covers the basics of variable declaration, initialization, literals, and basic input/output in Java.

---

## 1. Declare and print an `int` variable named `age`.
```java
int age = 20;
System.out.println(age); // Output: 20
```

## 2. Create a `String` variable `name` and print it.
```java
String name = "Alice";
System.out.println(name); // Output: Alice
```

## 3. Declare three variables in one line: `x`, `y`, and `z`.
```java
int x = 1, y = 2, z = 3;
System.out.println(x + ", " + y + ", " + z); // Output: 1, 2, 3
```

## 4. Store your height in a `double` and print it.
```java
double height = 1.75;
System.out.println(height); // Output: 1.75
```

## 5. Declare a `char` variable with initial letter of your name.
```java
char initial = 'A';
System.out.println(initial); // Output: A
```

## 6. Create a `boolean` flag `isStudent` and set to `true`.
```java
boolean isStudent = true;
System.out.println(isStudent); // Output: true
```

## 7. Concatenate string and integer (`"Age: " + age`) and print.
```java
int age = 20;
System.out.println("Age: " + age); // Output: Age: 20
```

## 8. Assign hexadecimal and binary literal to `int` variables.
```java
int hexValue = 0x1A; // Hexadecimal for 26
int binValue = 0b1101; // Binary for 13
System.out.println(hexValue); // Output: 26
System.out.println(binValue); // Output: 13
```

## 9. Use underscore in large `int` literal: `int salary = 100_000`.
```java
int salary = 100_000;
System.out.println(salary); // Output: 100000
```

## 10. Create and print all 8 primitive types in Java.
```java
byte b = 10;
short s = 1000;
int i = 100000;
long l = 10000000000L;
float f = 3.14f;
double d = 2.71828;
char c = 'J';
boolean bool = false;
System.out.println(b + ", " + s + ", " + i + ", " + l + ", " + f + ", " + d + ", " + c + ", " + bool);
```

## 11. Try reassigning a variable and observe the result.
```java
int num = 5;
num = 10;
System.out.println(num); // Output: 10
```

## 12. Use a variable before initializing (note compiler error).
```java
// int uninitialized;
// System.out.println(uninitialized); // Error: variable uninitialized might not have been initialized
```

## 13. Declare a constant using `final` for pi = 3.14159.
```java
final double PI = 3.14159;
System.out.println(PI); // Output: 3.14159
```

## 14. Store ASCII value of 'A' in an `int` and print.
```java
int asciiA = 'A';
System.out.println(asciiA); // Output: 65
```

## 15. Print the `char` value of ASCII 65.
```java
char letter = 65;
System.out.println(letter); // Output: A
```

## 16. Read and print an integer from user input (Scanner).
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = sc.nextInt();
System.out.println("You entered: " + number);
```

## 17. Read and print a float from user input.
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Enter a float: ");
float value = sc.nextFloat();
System.out.println("You entered: " + value);
```

## 18. Read a full sentence using `Scanner.nextLine()`.
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Enter a sentence: ");
String sentence = sc.nextLine();
System.out.println("You entered: " + sentence);
```

## 19. Declare `String name = null` and print it.
```java
String name = null;
System.out.println(name); // Output: null
```

## 20. Use `System.out.printf()` to format output.
```java
int age = 25;
double score = 95.5;
System.out.printf("Age: %d, Score: %.2f\n", age, score); // Output: Age: 25, Score: 95.50
```

---

**Practice Tip:** Try typing each code snippet in your IDE and experiment with different values! 
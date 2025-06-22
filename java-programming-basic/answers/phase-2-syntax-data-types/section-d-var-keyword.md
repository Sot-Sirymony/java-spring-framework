# Section D: var Keyword (Java 10+) (Tasks 61–75)

This section covers the use of the `var` keyword for local variable type inference in Java 10 and above.

---

## 61. Declare an `int` using `var`.
```java
var number = 10; // Inferred as int
System.out.println(number); // Output: 10
```

## 62. Declare a `String` using `var`.
```java
var message = "Hello, Java!"; // Inferred as String
System.out.println(message); // Output: Hello, Java!
```

## 63. Try declaring `var` without initialization.
```java
// var x; // Error: cannot use 'var' on variable without initializer
```

## 64. Use `var` in a for-loop.
```java
for (var i = 0; i < 3; i++) {
    System.out.println(i);
}
```

## 65. Assign a lambda expression to a `var`.
```java
var runnable = (Runnable) () -> System.out.println("Running");
runnable.run(); // Output: Running
```

## 66. Use `var` with arrays.
```java
var numbers = new int[] {1, 2, 3}; // Inferred as int[]
System.out.println(numbers.length); // Output: 3
```

## 67. Use `var` with `Scanner`.
```java
import java.util.Scanner;
var sc = new Scanner(System.in);
System.out.print("Enter your name: ");
var name = sc.nextLine();
System.out.println("Hello, " + name);
```

## 68. Compare performance between `var` and explicit typing.
- There is **no performance difference** at runtime; `var` is only for compile-time type inference.

## 69. Assign a method return value to `var`.
```java
String greet() { return "Hi!"; }
var greeting = greet(); // Inferred as String
System.out.println(greeting); // Output: Hi!
```

## 70. Assign a complex expression to `var` and check inferred type.
```java
var result = 3.14 * 2; // Inferred as double
System.out.println(result); // Output: 6.28
```

## 71. Use `var` in enhanced for-loop.
```java
var list = java.util.List.of("A", "B", "C");
for (var item : list) {
    System.out.println(item);
}
```

## 72. Declare a `Map` using `var`.
```java
var map = new java.util.HashMap<String, Integer>();
map.put("one", 1);
System.out.println(map);
```

## 73. Try using `var` as method return type (invalid).
```java
// var getValue() { return 42; } // Error: 'var' is not allowed as a method return type
```

## 74. Use `var` in try-with-resources block.
```java
import java.io.*;
try (var reader = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

## 75. Discuss when not to use `var`.
- When it reduces code clarity (e.g., for complex or ambiguous types)
- When explicit type improves readability or documentation
- For public fields, method parameters, or return types (not allowed)

---

**Practice Tip:** Use `var` for local variables when the type is obvious, but prefer explicit types for clarity in complex code! 
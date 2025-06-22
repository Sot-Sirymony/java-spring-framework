# Section E: Constants & Final (Tasks 76–90)

This section covers the use of the `final` keyword, constants, and immutability in Java.

---

## 76. Create a `final int MAX_AGE = 100`.
```java
final int MAX_AGE = 100;
System.out.println(MAX_AGE); // Output: 100
```

## 77. Try to reassign a `final` variable.
```java
final int x = 10;
// x = 20; // Error: cannot assign a value to final variable x
```

## 78. Use a `final` variable in a method.
```java
void printValue(final int value) {
    System.out.println(value);
}
```

## 79. Create a `final` variable inside a loop.
```java
for (int i = 0; i < 3; i++) {
    final int loopConst = i;
    System.out.println(loopConst);
}
```

## 80. Use `final` with a `String`.
```java
final String greeting = "Hello";
System.out.println(greeting);
```

## 81. Declare a `final` array and modify its contents.
```java
final int[] arr = {1, 2, 3};
arr[0] = 10; // Allowed: modifying contents
System.out.println(arr[0]); // Output: 10
// arr = new int[5]; // Error: cannot assign a new array to final reference
```

## 82. Declare a `final` reference type (e.g. `List`) and try reassigning.
```java
final java.util.List<String> list = new java.util.ArrayList<>();
list.add("A"); // Allowed
// list = new java.util.ArrayList<>(); // Error: cannot assign a new object to final reference
```

## 83. Declare class-level constants using `static final`.
```java
public class AppConfig {
    public static final String APP_NAME = "MyApp";
    public static final int VERSION = 1;
}
System.out.println(AppConfig.APP_NAME);
```

## 84. Create a constant class `AppConfig` with constants.
```java
public class AppConfig {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    public static final int MAX_USERS = 100;
}
```

## 85. Use constant in conditional logic.
```java
if (age > AppConfig.MAX_USERS) {
    System.out.println("Too many users!");
}
```

## 86. Use `final` parameters in method signature.
```java
void printMessage(final String msg) {
    System.out.println(msg);
}
```

## 87. Use `final` in a constructor.
```java
public class Person {
    private final String name;
    public Person(String name) {
        this.name = name;
    }
}
```

## 88. Demonstrate the immutability of `final` primitive vs reference types.
```java
final int a = 5;
// a = 10; // Error: cannot assign
final int[] arr = {1, 2};
arr[0] = 10; // Allowed: contents mutable
// arr = new int[3]; // Error: cannot reassign reference
```

## 89. Use `final` with method arguments in recursion.
```java
int factorial(final int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

## 90. Try `final` variable inside a lambda expression.
```java
int x = 5;
final int y = 10;
Runnable r = () -> System.out.println(x + y); // x must be effectively final
r.run();
```

---

**Practice Tip:** Use `final` for constants and to prevent accidental modification of variables! 
# Section B: Primitive Data Types (Tasks 21–40)

This section covers all 8 primitive types in Java, their ranges, operations, and related concepts.

---

## 21. Declare a `byte` and assign it the max value.
```java
byte maxByte = 127; // Max value for byte
System.out.println(maxByte); // Output: 127
```

## 22. Declare a `short` and assign it the min value.
```java
short minShort = -32768; // Min value for short
System.out.println(minShort); // Output: -32768
```

## 23. Try exceeding `byte` limit and observe error.
```java
// byte b = 128; // Error: incompatible types: possible lossy conversion from int to byte
```

## 24. Assign `long` with `L` suffix.
```java
long bigNumber = 1234567890123L;
System.out.println(bigNumber);
```

## 25. Assign `float` with `f` suffix.
```java
float pi = 3.14f;
System.out.println(pi);
```

## 26. Print the max and min value of all primitives using `WrapperClass.MAX_VALUE`.
```java
System.out.println("byte: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
System.out.println("short: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
System.out.println("int: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
System.out.println("long: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
System.out.println("float: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
System.out.println("double: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
System.out.println("char: " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);
System.out.println("boolean: " + Boolean.FALSE + ", " + Boolean.TRUE);
```

## 27. Check default values of uninitialized local variables (observe compiler error).
```java
// int x;
// System.out.println(x); // Error: variable x might not have been initialized
```

## 28. Use arithmetic with `char`: `'A' + 1`
```java
char c = 'A';
int result = c + 1;
System.out.println(result); // Output: 66
System.out.println((char) result); // Output: B
```

## 29. Compare `float` vs `double` precision.
```java
float f = 1.123456789f;
double d = 1.1234567890123456;
System.out.println(f); // Output: 1.1234568 (7 decimal digits)
System.out.println(d); // Output: 1.1234567890123457 (15+ decimal digits)
```

## 30. Use `boolean` in a conditional.
```java
boolean isJavaFun = true;
if (isJavaFun) {
    System.out.println("Java is fun!");
}
```

## 31. Create a boolean expression using `>` and `==`.
```java
int a = 5, b = 10;
boolean greater = b > a;
boolean equal = a == b;
System.out.println(greater); // Output: true
System.out.println(equal);   // Output: false
```

## 32. Use `char` to print a heart symbol `\u2764`.
```java
char heart = '\u2764';
System.out.println(heart); // Output: ❤
```

## 33. Demonstrate integer overflow and underflow.
```java
int max = Integer.MAX_VALUE;
System.out.println(max + 1); // Output: -2147483648 (overflow)
int min = Integer.MIN_VALUE;
System.out.println(min - 1); // Output: 2147483647 (underflow)
```

## 34. Print size in bits and bytes of all primitives.
```java
System.out.println("byte: " + Byte.SIZE + " bits, " + (Byte.SIZE/8) + " bytes");
System.out.println("short: " + Short.SIZE + " bits, " + (Short.SIZE/8) + " bytes");
System.out.println("int: " + Integer.SIZE + " bits, " + (Integer.SIZE/8) + " bytes");
System.out.println("long: " + Long.SIZE + " bits, " + (Long.SIZE/8) + " bytes");
System.out.println("float: " + Float.SIZE + " bits, " + (Float.SIZE/8) + " bytes");
System.out.println("double: " + Double.SIZE + " bits, " + (Double.SIZE/8) + " bytes");
System.out.println("char: " + Character.SIZE + " bits, " + (Character.SIZE/8) + " bytes");
System.out.println("boolean: 1 bit (size not precisely defined)");
```

## 35. Try assigning large numbers to small data types.
```java
// byte b = 200; // Error: possible lossy conversion from int to byte
// short s = 40000; // Error: possible lossy conversion from int to short
```

## 36. Compare two `String` values using `==` and `.equals()`.
```java
String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2); // Output: false (different objects)
System.out.println(s1.equals(s2)); // Output: true (same value)
```

## 37. Store Unicode character in a `char` using escape code.
```java
char yen = '\u00A5';
System.out.println(yen); // Output: ¥
```

## 38. Round a float to two decimal places.
```java
float value = 3.14159f;
System.out.printf("%.2f\n", value); // Output: 3.14
```

## 39. Print PI using `Math.PI`.
```java
System.out.println(Math.PI); // Output: 3.141592653589793
```

## 40. Add two variables of different types (`int` + `double`).
```java
int i = 5;
double d = 2.5;
double sum = i + d;
System.out.println(sum); // Output: 7.5
```

---

**Practice Tip:** Try changing values and observe how Java handles type limits and conversions! 
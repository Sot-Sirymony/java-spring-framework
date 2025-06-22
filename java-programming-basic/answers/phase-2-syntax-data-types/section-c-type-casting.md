# Section C: Type Casting (Tasks 41–60)

Covers implicit and explicit type conversions, data loss, and string/number conversions in Java.

---

## 41. Implicitly convert `int` to `long`.
```java
int i = 100;
long l = i; // Implicit widening
System.out.println(l); // Output: 100
```

## 42. Implicitly convert `float` to `double`.
```java
float f = 3.14f;
double d = f; // Implicit widening
System.out.println(d); // Output: 3.140000104904175
```

## 43. Explicitly cast `double` to `int`.
```java
double d = 9.99;
int i = (int) d; // Explicit narrowing
System.out.println(i); // Output: 9
```

## 44. Convert `int` to `byte` and check truncation.
```java
int i = 130;
byte b = (byte) i; // Truncation occurs
System.out.println(b); // Output: -126
```

## 45. Cast `char` to `int` and back.
```java
char c = 'A';
int ascii = (int) c;
char c2 = (char) ascii;
System.out.println(ascii); // Output: 65
System.out.println(c2);   // Output: A
```

## 46. Cast `float` to `int` and observe data loss.
```java
float f = 5.99f;
int i = (int) f;
System.out.println(i); // Output: 5
```

## 47. Multiply an `int` with a `float` and store in `double`.
```java
int i = 4;
float f = 2.5f;
double result = i * f;
System.out.println(result); // Output: 10.0
```

## 48. Convert a string `"123"` to `int` using `Integer.parseInt()`.
```java
String s = "123";
int num = Integer.parseInt(s);
System.out.println(num); // Output: 123
```

## 49. Convert `int` to `String` using `String.valueOf()`.
```java
int i = 456;
String s = String.valueOf(i);
System.out.println(s); // Output: 456
```

## 50. Try invalid casting (e.g. `String` to `int` without parsing).
```java
// String s = "abc";
// int i = (int) s; // Error: incompatible types: String cannot be converted to int
```

## 51. Cast `long` to `short` and observe.
```java
long l = 32768L;
short s = (short) l;
System.out.println(s); // Output: -32768 (overflow)
```

## 52. Cast `boolean` to `int` (see why it's not allowed).
```java
// boolean b = true;
// int i = (int) b; // Error: incompatible types: boolean cannot be converted to int
```

## 53. Cast `double` to `byte` and print.
```java
double d = 257.99;
byte b = (byte) d;
System.out.println(b); // Output: 1 (257 % 256)
```

## 54. Cast `char` to `short`.
```java
char c = 'Z';
short s = (short) c;
System.out.println(s); // Output: 90
```

## 55. Add `int` and `double` then cast to `int`.
```java
int i = 7;
double d = 2.8;
int sum = (int) (i + d);
System.out.println(sum); // Output: 9
```

## 56. Cast `int` to `char` to print a Unicode symbol.
```java
int code = 9731;
char snowman = (char) code;
System.out.println(snowman); // Output: ☃
```

## 57. Convert a numeric `String` to `double`.
```java
String s = "3.14159";
double d = Double.parseDouble(s);
System.out.println(d); // Output: 3.14159
```

## 58. Use `Double.toString()` to convert `double` to `String`.
```java
double d = 42.42;
String s = Double.toString(d);
System.out.println(s); // Output: 42.42
```

## 59. Convert `String` `"true"` to `boolean` using `Boolean.parseBoolean()`.
```java
String s = "true";
boolean b = Boolean.parseBoolean(s);
System.out.println(b); // Output: true
```

## 60. Create a method that accepts a double and returns it as an `int`.
```java
public static int doubleToInt(double value) {
    return (int) value;
}
// Usage:
System.out.println(doubleToInt(5.99)); // Output: 5
```

---

**Practice Tip:** Try casting between different types and see what happens with edge values! 
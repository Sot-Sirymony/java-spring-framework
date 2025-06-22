# Section F: Mini Challenges (Tasks 91–100)

This section contains practical programming problems to reinforce your understanding of Java syntax and data types.

---

## 91. Calculate area of a circle using `final double PI`.
```java
final double PI = 3.14159;
double radius = 5.0;
double area = PI * radius * radius;
System.out.println("Area: " + area); // Output: Area: 78.53975
```

## 92. Create a BMI calculator using `double`, `int`.
```java
int weight = 70; // kg
double height = 1.75; // meters
double bmi = weight / (height * height);
System.out.println("BMI: " + bmi); // Output: BMI: 22.857142857142858
```

## 93. Swap two variables using a third variable.
```java
int a = 5, b = 10, temp;
temp = a;
a = b;
b = temp;
System.out.println("a=" + a + ", b=" + b); // Output: a=10, b=5
```

## 94. Swap two variables without using third variable.
```java
int a = 5, b = 10;
a = a + b;
b = a - b;
a = a - b;
System.out.println("a=" + a + ", b=" + b); // Output: a=10, b=5
```

## 95. Print whether a number is even or odd using `boolean`.
```java
int num = 7;
boolean isEven = num % 2 == 0;
System.out.println(num + (isEven ? " is even" : " is odd")); // Output: 7 is odd
```

## 96. Write a program to convert Fahrenheit to Celsius.
```java
double fahrenheit = 98.6;
double celsius = (fahrenheit - 32) * 5 / 9;
System.out.println("Celsius: " + celsius); // Output: Celsius: 37.0
```

## 97. Check if a character is a vowel or consonant.
```java
char ch = 'e';
boolean isVowel = "aeiouAEIOU".indexOf(ch) != -1;
System.out.println(ch + (isVowel ? " is a vowel" : " is a consonant")); // Output: e is a vowel
```

## 98. Create a program that uses all 8 primitive types.
```java
byte b = 1;
short s = 2;
int i = 3;
long l = 4L;
float f = 5.5f;
double d = 6.6;
char c = 'J';
boolean bool = true;
System.out.println(b + ", " + s + ", " + i + ", " + l + ", " + f + ", " + d + ", " + c + ", " + bool);
```

## 99. Create a program that accepts age and prints category (child, teen, adult).
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Enter age: ");
int age = sc.nextInt();
if (age < 13) {
    System.out.println("Child");
} else if (age < 20) {
    System.out.println("Teen");
} else {
    System.out.println("Adult");
}
```

## 100. Build a "Hello User" app: ask name, age, and greet with type-safe output.
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
System.out.print("Enter your name: ");
String name = sc.nextLine();
System.out.print("Enter your age: ");
int age = sc.nextInt();
System.out.printf("Hello, %s! You are %d years old.\n", name, age);
```

---

**Practice Tip:** Try combining multiple concepts from previous sections in these mini challenges! 
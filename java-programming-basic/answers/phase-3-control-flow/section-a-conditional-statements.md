# Section A: Conditional Statements (Tasks 1-25)

## Overview
This section covers basic conditional statements in Java including if, if-else, and switch statements. These are fundamental building blocks for decision-making in programs.

---

## Tasks 1-5: Basic if Statements

### Task 1: Check if a number is positive
**Problem**: Write a program that checks if a given number is positive and prints a message.

```java
public class Task1 {
    public static void main(String[] args) {
        int number = 15;
        
        if (number > 0) {
            System.out.println(number + " is a positive number.");
        }
    }
}
```

**Output**:
```
15 is a positive number.
```

**Explanation**: The `if` statement checks if `number` is greater than 0. If true, it executes the code block inside the curly braces.

---

### Task 2: Check if a number is even
**Problem**: Write a program that checks if a given number is even.

```java
public class Task2 {
    public static void main(String[] args) {
        int number = 24;
        
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        }
    }
}
```

**Output**:
```
24 is an even number.
```

**Explanation**: We use the modulo operator `%` to check if the remainder when dividing by 2 is 0, which indicates an even number.

---

### Task 3: Check if a person is eligible to vote
**Problem**: Write a program that checks if a person's age makes them eligible to vote (18 or older).

```java
public class Task3 {
    public static void main(String[] args) {
        int age = 20;
        
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        }
    }
}
```

**Output**:
```
You are eligible to vote!
```

**Explanation**: The condition `age >= 18` checks if the person is 18 years old or older.

---

### Task 4: Check if a number is divisible by 5
**Problem**: Write a program that checks if a number is divisible by 5.

```java
public class Task4 {
    public static void main(String[] args) {
        int number = 25;
        
        if (number % 5 == 0) {
            System.out.println(number + " is divisible by 5.");
        }
    }
}
```

**Output**:
```
25 is divisible by 5.
```

**Explanation**: Using modulo operator to check if remainder is 0 when divided by 5.

---

### Task 5: Check if a string is not empty
**Problem**: Write a program that checks if a string is not empty.

```java
public class Task5 {
    public static void main(String[] args) {
        String text = "Hello World";
        
        if (!text.isEmpty()) {
            System.out.println("The string is not empty: " + text);
        }
    }
}
```

**Output**:
```
The string is not empty: Hello World
```

**Explanation**: The `isEmpty()` method returns true if the string has no characters, so we use `!` to negate it.

---

## Tasks 6-10: if-else Statements

### Task 6: Check if number is positive or negative
**Problem**: Write a program that determines if a number is positive or negative.

```java
public class Task6 {
    public static void main(String[] args) {
        int number = -7;
        
        if (number > 0) {
            System.out.println(number + " is positive.");
        } else {
            System.out.println(number + " is negative or zero.");
        }
    }
}
```

**Output**:
```
-7 is negative or zero.
```

**Explanation**: The `if-else` structure provides two different execution paths based on the condition.

---

### Task 7: Check if number is even or odd
**Problem**: Write a program that determines if a number is even or odd.

```java
public class Task7 {
    public static void main(String[] args) {
        int number = 17;
        
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}
```

**Output**:
```
17 is odd.
```

**Explanation**: If the number is not even (remainder not 0), it must be odd.

---

### Task 8: Check if person is adult or minor
**Problem**: Write a program that determines if a person is an adult (18+) or minor.

```java
public class Task8 {
    public static void main(String[] args) {
        int age = 16;
        
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
    }
}
```

**Output**:
```
You are a minor.
```

**Explanation**: Simple age-based classification using if-else.

---

### Task 9: Check if number is greater than 100
**Problem**: Write a program that checks if a number is greater than 100 or not.

```java
public class Task9 {
    public static void main(String[] args) {
        int number = 150;
        
        if (number > 100) {
            System.out.println(number + " is greater than 100.");
        } else {
            System.out.println(number + " is not greater than 100.");
        }
    }
}
```

**Output**:
```
150 is greater than 100.
```

**Explanation**: Direct comparison with 100 using if-else structure.

---

### Task 10: Check if string contains "Java"
**Problem**: Write a program that checks if a string contains the word "Java".

```java
public class Task10 {
    public static void main(String[] args) {
        String text = "I love Java programming";
        
        if (text.contains("Java")) {
            System.out.println("The string contains 'Java'.");
        } else {
            System.out.println("The string does not contain 'Java'.");
        }
    }
}
```

**Output**:
```
The string contains 'Java'.
```

**Explanation**: The `contains()` method checks if the substring exists in the main string.

---

## Tasks 11-15: Multiple if-else Statements

### Task 11: Grade classification
**Problem**: Write a program that assigns a grade based on a score (A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60).

```java
public class Task11 {
    public static void main(String[] args) {
        int score = 85;
        
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
```

**Output**:
```
Grade: B
```

**Explanation**: Multiple `if-else if` statements check conditions in order until one is true.

---

### Task 12: Number range classification
**Problem**: Write a program that classifies a number into ranges (0-25, 26-50, 51-75, 76-100).

```java
public class Task12 {
    public static void main(String[] args) {
        int number = 65;
        
        if (number >= 0 && number <= 25) {
            System.out.println(number + " is in range 0-25");
        } else if (number >= 26 && number <= 50) {
            System.out.println(number + " is in range 26-50");
        } else if (number >= 51 && number <= 75) {
            System.out.println(number + " is in range 51-75");
        } else if (number >= 76 && number <= 100) {
            System.out.println(number + " is in range 76-100");
        } else {
            System.out.println(number + " is out of range");
        }
    }
}
```

**Output**:
```
65 is in range 51-75
```

**Explanation**: Using logical AND (`&&`) to check if number falls within specific ranges.

---

### Task 13: Day of week classification
**Problem**: Write a program that classifies days as weekday or weekend based on day number (1-7).

```java
public class Task13 {
    public static void main(String[] args) {
        int day = 6; // 1=Monday, 7=Sunday
        
        if (day >= 1 && day <= 5) {
            System.out.println("Weekday");
        } else if (day == 6 || day == 7) {
            System.out.println("Weekend");
        } else {
            System.out.println("Invalid day");
        }
    }
}
```

**Output**:
```
Weekend
```

**Explanation**: Days 1-5 are weekdays, 6-7 are weekends. Using logical OR (`||`) for weekend check.

---

### Task 14: Temperature classification
**Problem**: Write a program that classifies temperature (Freezing: <0, Cold: 0-15, Warm: 16-25, Hot: >25).

```java
public class Task14 {
    public static void main(String[] args) {
        int temperature = 22;
        
        if (temperature < 0) {
            System.out.println("Freezing");
        } else if (temperature >= 0 && temperature <= 15) {
            System.out.println("Cold");
        } else if (temperature >= 16 && temperature <= 25) {
            System.out.println("Warm");
        } else {
            System.out.println("Hot");
        }
    }
}
```

**Output**:
```
Warm
```

**Explanation**: Temperature ranges are checked in order from coldest to hottest.

---

### Task 15: Age group classification
**Problem**: Write a program that classifies age groups (Child: 0-12, Teen: 13-19, Adult: 20-59, Senior: 60+).

```java
public class Task15 {
    public static void main(String[] args) {
        int age = 25;
        
        if (age >= 0 && age <= 12) {
            System.out.println("Child");
        } else if (age >= 13 && age <= 19) {
            System.out.println("Teen");
        } else if (age >= 20 && age <= 59) {
            System.out.println("Adult");
        } else if (age >= 60) {
            System.out.println("Senior");
        } else {
            System.out.println("Invalid age");
        }
    }
}
```

**Output**:
```
Adult
```

**Explanation**: Age ranges are checked systematically from youngest to oldest.

---

## Tasks 16-20: Switch Statements

### Task 16: Day of week using switch
**Problem**: Write a program that prints the day name based on day number (1-7) using switch.

```java
public class Task16 {
    public static void main(String[] args) {
        int day = 3;
        
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
```

**Output**:
```
Wednesday
```

**Explanation**: Switch statement matches the day number to corresponding day names. `break` prevents fall-through.

---

### Task 17: Month name using switch
**Problem**: Write a program that prints the month name based on month number (1-12) using switch.

```java
public class Task17 {
    public static void main(String[] args) {
        int month = 8;
        
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid month");
        }
    }
}
```

**Output**:
```
August
```

**Explanation**: Switch statement efficiently handles multiple discrete values.

---

### Task 18: Calculator using switch
**Problem**: Write a simple calculator using switch statement for basic operations.

```java
public class Task18 {
    public static void main(String[] args) {
        char operator = '+';
        int num1 = 10, num2 = 5;
        
        switch (operator) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
}
```

**Output**:
```
10 + 5 = 15
```

**Explanation**: Switch statement handles different arithmetic operators with appropriate calculations.

---

### Task 19: Season classification using switch
**Problem**: Write a program that determines the season based on month number using switch.

```java
public class Task19 {
    public static void main(String[] args) {
        int month = 12;
        
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Fall");
                break;
            default:
                System.out.println("Invalid month");
        }
    }
}
```

**Output**:
```
Winter
```

**Explanation**: Multiple cases can share the same code block (fall-through without break).

---

### Task 20: Traffic light using switch
**Problem**: Write a program that simulates a traffic light using switch statement.

```java
public class Task20 {
    public static void main(String[] args) {
        String light = "yellow";
        
        switch (light.toLowerCase()) {
            case "red":
                System.out.println("Stop!");
                break;
            case "yellow":
                System.out.println("Prepare to stop");
                break;
            case "green":
                System.out.println("Go!");
                break;
            default:
                System.out.println("Invalid light color");
        }
    }
}
```

**Output**:
```
Prepare to stop
```

**Explanation**: Using `toLowerCase()` to handle case-insensitive string matching.

---

## Tasks 21-25: Complex Conditional Logic

### Task 21: Leap year checker
**Problem**: Write a program that checks if a year is a leap year.

```java
public class Task21 {
    public static void main(String[] args) {
        int year = 2024;
        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
```

**Output**:
```
2024 is a leap year
```

**Explanation**: Leap year rules: divisible by 4 but not 100, OR divisible by 400.

---

### Task 22: Triangle type checker
**Problem**: Write a program that determines the type of triangle based on three sides.

```java
public class Task22 {
    public static void main(String[] args) {
        int a = 5, b = 5, c = 5;
        
        if (a + b > c && b + c > a && a + c > b) {
            if (a == b && b == c) {
                System.out.println("Equilateral triangle");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles triangle");
            } else {
                System.out.println("Scalene triangle");
            }
        } else {
            System.out.println("Not a valid triangle");
        }
    }
}
```

**Output**:
```
Equilateral triangle
```

**Explanation**: First check triangle inequality, then determine type based on side equality.

---

### Task 23: Number properties checker
**Problem**: Write a program that checks multiple properties of a number (positive/negative, even/odd, single/double digit).

```java
public class Task23 {
    public static void main(String[] args) {
        int number = 25;
        
        System.out.println("Number: " + number);
        
        // Check positive/negative
        if (number > 0) {
            System.out.println("Positive number");
        } else if (number < 0) {
            System.out.println("Negative number");
        } else {
            System.out.println("Zero");
        }
        
        // Check even/odd
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
        
        // Check digit count
        if (number >= 0 && number <= 9) {
            System.out.println("Single digit");
        } else if (number >= 10 && number <= 99) {
            System.out.println("Double digit");
        } else {
            System.out.println("Multiple digits");
        }
    }
}
```

**Output**:
```
Number: 25
Positive number
Odd number
Double digit
```

**Explanation**: Multiple independent checks provide comprehensive number analysis.

---

### Task 24: Password strength checker
**Problem**: Write a program that checks password strength based on length and character types.

```java
public class Task24 {
    public static void main(String[] args) {
        String password = "MyPass123!";
        
        boolean hasLength = password.length() >= 8;
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");
        
        if (hasLength && hasUpperCase && hasLowerCase && hasDigit && hasSpecial) {
            System.out.println("Strong password");
        } else if (hasLength && hasUpperCase && hasLowerCase && hasDigit) {
            System.out.println("Medium password");
        } else if (hasLength && (hasUpperCase || hasLowerCase)) {
            System.out.println("Weak password");
        } else {
            System.out.println("Very weak password");
        }
    }
}
```

**Output**:
```
Strong password
```

**Explanation**: Multiple boolean checks evaluate different password criteria.

---

### Task 25: Time period classifier
**Problem**: Write a program that classifies time periods (Morning: 6-11, Afternoon: 12-17, Evening: 18-21, Night: 22-5).

```java
public class Task25 {
    public static void main(String[] args) {
        int hour = 14;
        
        if (hour >= 6 && hour <= 11) {
            System.out.println("Morning");
        } else if (hour >= 12 && hour <= 17) {
            System.out.println("Afternoon");
        } else if (hour >= 18 && hour <= 21) {
            System.out.println("Evening");
        } else if ((hour >= 22 && hour <= 23) || (hour >= 0 && hour <= 5)) {
            System.out.println("Night");
        } else {
            System.out.println("Invalid hour");
        }
    }
}
```

**Output**:
```
Afternoon
```

**Explanation**: Note the special handling for night hours (22-23 and 0-5) using logical OR.

---

## Summary
This section covered fundamental conditional statements in Java:
- **Basic if statements**: Simple condition checking
- **if-else statements**: Two-way decision making
- **Multiple if-else**: Complex decision trees
- **Switch statements**: Efficient multi-way branching
- **Complex logic**: Combining multiple conditions and operators

Key concepts learned:
- Comparison operators (`==`, `!=`, `<`, `>`, `<=`, `>=`)
- Logical operators (`&&`, `||`, `!`)
- String methods (`isEmpty()`, `contains()`, `toLowerCase()`)
- Switch statement syntax and fall-through behavior
- Complex conditional logic with multiple criteria

These skills form the foundation for more advanced control flow structures in the next sections. 
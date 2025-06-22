# Section B: Loops (Tasks 26-50)

## Overview
This section covers different types of loops in Java: for loops, while loops, and do-while loops. Loops are essential for repetitive tasks and iterating through data structures.

---

## Tasks 26-30: for Loops

### Task 26: Print numbers from 1 to 10
**Problem**: Write a program that prints numbers from 1 to 10 using a for loop.

```java
public class Task26 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
```

**Output**:
```
1
2
3
4
5
6
7
8
9
10
```

**Explanation**: The for loop has three parts: initialization (`int i = 1`), condition (`i <= 10`), and increment (`i++`). It executes the loop body while the condition is true.

---

### Task 27: Print even numbers from 2 to 20
**Problem**: Write a program that prints even numbers from 2 to 20 using a for loop.

```java
public class Task27 {
    public static void main(String[] args) {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
    }
}
```

**Output**:
```
2
4
6
8
10
12
14
16
18
20
```

**Explanation**: Using `i += 2` increments by 2 each time, ensuring we only get even numbers.

---

### Task 28: Print numbers in reverse from 10 to 1
**Problem**: Write a program that prints numbers from 10 down to 1 using a for loop.

```java
public class Task28 {
    public static void main(String[] args) {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
```

**Output**:
```
10
9
8
7
6
5
4
3
2
1
```

**Explanation**: Starting from 10 and decrementing by 1 (`i--`) until we reach 1.

---

### Task 29: Calculate sum of numbers from 1 to 100
**Problem**: Write a program that calculates and prints the sum of numbers from 1 to 100.

```java
public class Task29 {
    public static void main(String[] args) {
        int sum = 0;
        
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        
        System.out.println("Sum of numbers from 1 to 100: " + sum);
    }
}
```

**Output**:
```
Sum of numbers from 1 to 100: 5050
```

**Explanation**: We initialize `sum` to 0 and add each number from 1 to 100 to it. The mathematical formula for this sum is `n*(n+1)/2` where n=100.

---

### Task 30: Print multiplication table for 5
**Problem**: Write a program that prints the multiplication table for 5 (5 × 1 to 5 × 10).

```java
public class Task30 {
    public static void main(String[] args) {
        int number = 5;
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " × " + i + " = " + (number * i));
        }
    }
}
```

**Output**:
```
5 × 1 = 5
5 × 2 = 10
5 × 3 = 15
5 × 4 = 20
5 × 5 = 25
5 × 6 = 30
5 × 7 = 35
5 × 8 = 40
5 × 9 = 45
5 × 10 = 50
```

**Explanation**: The loop iterates from 1 to 10, multiplying the number by each iteration value.

---

## Tasks 31-35: while Loops

### Task 31: Print numbers from 1 to 10 using while
**Problem**: Write a program that prints numbers from 1 to 10 using a while loop.

```java
public class Task31 {
    public static void main(String[] args) {
        int i = 1;
        
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
}
```

**Output**:
```
1
2
3
4
5
6
7
8
9
10
```

**Explanation**: The while loop continues as long as the condition `i <= 10` is true. We manually increment `i` inside the loop.

---

### Task 32: Count down from 10 to 1 using while
**Problem**: Write a program that counts down from 10 to 1 using a while loop.

```java
public class Task32 {
    public static void main(String[] args) {
        int i = 10;
        
        while (i >= 1) {
            System.out.println(i);
            i--;
        }
    }
}
```

**Output**:
```
10
9
8
7
6
5
4
3
2
1
```

**Explanation**: Starting from 10 and decrementing until we reach 1.

---

### Task 33: Find factorial of a number using while
**Problem**: Write a program that calculates the factorial of a number using a while loop.

```java
public class Task33 {
    public static void main(String[] args) {
        int number = 5;
        int factorial = 1;
        int i = 1;
        
        while (i <= number) {
            factorial *= i;
            i++;
        }
        
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
```

**Output**:
```
Factorial of 5 is: 120
```

**Explanation**: Factorial is the product of all positive integers up to the given number. 5! = 5 × 4 × 3 × 2 × 1 = 120.

---

### Task 34: Print Fibonacci series using while
**Problem**: Write a program that prints the first 10 numbers of the Fibonacci series using a while loop.

```java
public class Task34 {
    public static void main(String[] args) {
        int n = 10;
        int first = 0, second = 1;
        int count = 0;
        
        System.out.println("Fibonacci Series:");
        
        while (count < n) {
            System.out.print(first + " ");
            
            int next = first + second;
            first = second;
            second = next;
            count++;
        }
    }
}
```

**Output**:
```
Fibonacci Series:
0 1 1 2 3 5 8 13 21 34
```

**Explanation**: Each number is the sum of the two preceding ones. We use three variables to keep track of the current and previous numbers.

---

### Task 35: Check if number is prime using while
**Problem**: Write a program that checks if a number is prime using a while loop.

```java
public class Task35 {
    public static void main(String[] args) {
        int number = 17;
        int i = 2;
        boolean isPrime = true;
        
        while (i <= number / 2) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }
        
        if (isPrime && number > 1) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}
```

**Output**:
```
17 is a prime number
```

**Explanation**: We check if the number is divisible by any number from 2 to half of itself. If no divisor is found, it's prime.

---

## Tasks 36-40: do-while Loops

### Task 36: Print numbers from 1 to 10 using do-while
**Problem**: Write a program that prints numbers from 1 to 10 using a do-while loop.

```java
public class Task36 {
    public static void main(String[] args) {
        int i = 1;
        
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
}
```

**Output**:
```
1
2
3
4
5
6
7
8
9
10
```

**Explanation**: The do-while loop executes the body at least once before checking the condition.

---

### Task 37: Menu-driven program using do-while
**Problem**: Write a simple menu-driven program using do-while loop.

```java
import java.util.Scanner;

public class Task37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Print Hello");
            System.out.println("2. Print World");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Hello!");
                    break;
                case 2:
                    System.out.println("World!");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
        
        scanner.close();
    }
}
```

**Output** (example interaction):
```
Menu:
1. Print Hello
2. Print World
3. Exit
Enter your choice (1-3): 1
Hello!

Menu:
1. Print Hello
2. Print World
3. Exit
Enter your choice (1-3): 2
World!

Menu:
1. Print Hello
2. Print World
3. Exit
Enter your choice (1-3): 3
Goodbye!
```

**Explanation**: The do-while loop ensures the menu is displayed at least once, and continues until the user chooses to exit.

---

### Task 38: Sum of digits using do-while
**Problem**: Write a program that calculates the sum of digits of a number using a do-while loop.

```java
public class Task38 {
    public static void main(String[] args) {
        int number = 12345;
        int sum = 0;
        int temp = number;
        
        do {
            sum += temp % 10;  // Get last digit
            temp /= 10;        // Remove last digit
        } while (temp > 0);
        
        System.out.println("Sum of digits of " + number + " is: " + sum);
    }
}
```

**Output**:
```
Sum of digits of 12345 is: 15
```

**Explanation**: We repeatedly extract the last digit using modulo 10 and remove it by integer division by 10.

---

### Task 39: Reverse a number using do-while
**Problem**: Write a program that reverses a number using a do-while loop.

```java
public class Task39 {
    public static void main(String[] args) {
        int number = 12345;
        int reversed = 0;
        int temp = number;
        
        do {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        } while (temp > 0);
        
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reversed);
    }
}
```

**Output**:
```
Original number: 12345
Reversed number: 54321
```

**Explanation**: We build the reversed number by multiplying by 10 and adding each digit from right to left.

---

### Task 40: Check palindrome using do-while
**Problem**: Write a program that checks if a number is a palindrome using a do-while loop.

```java
public class Task40 {
    public static void main(String[] args) {
        int number = 12321;
        int reversed = 0;
        int temp = number;
        
        do {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        } while (temp > 0);
        
        if (number == reversed) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
    }
}
```

**Output**:
```
12321 is a palindrome
```

**Explanation**: A palindrome reads the same forwards and backwards. We reverse the number and compare it with the original.

---

## Tasks 41-45: Loops with User Input

### Task 41: Print table of user input number
**Problem**: Write a program that takes a number from user and prints its multiplication table.

```java
import java.util.Scanner;

public class Task41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        System.out.println("Multiplication table for " + number + ":");
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " × " + i + " = " + (number * i));
        }
        
        scanner.close();
    }
}
```

**Output** (example):
```
Enter a number: 7
Multiplication table for 7:
7 × 1 = 7
7 × 2 = 14
7 × 3 = 21
7 × 4 = 28
7 × 5 = 35
7 × 6 = 42
7 × 7 = 49
7 × 8 = 56
7 × 9 = 63
7 × 10 = 70
```

**Explanation**: We get user input and then use a for loop to generate the multiplication table.

---

### Task 42: Sum of n numbers from user
**Problem**: Write a program that takes n numbers from user and calculates their sum.

```java
import java.util.Scanner;

public class Task42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many numbers do you want to enter? ");
        int n = scanner.nextInt();
        
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int number = scanner.nextInt();
            sum += number;
        }
        
        System.out.println("Sum of all numbers: " + sum);
        scanner.close();
    }
}
```

**Output** (example):
```
How many numbers do you want to enter? 3
Enter number 1: 10
Enter number 2: 20
Enter number 3: 30
Sum of all numbers: 60
```

**Explanation**: We use a for loop to get n numbers from the user and accumulate their sum.

---

### Task 43: Find largest number from user input
**Problem**: Write a program that finds the largest number among n numbers entered by user.

```java
import java.util.Scanner;

public class Task43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many numbers do you want to enter? ");
        int n = scanner.nextInt();
        
        System.out.print("Enter number 1: ");
        int largest = scanner.nextInt();
        
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int number = scanner.nextInt();
            
            if (number > largest) {
                largest = number;
            }
        }
        
        System.out.println("Largest number is: " + largest);
        scanner.close();
    }
}
```

**Output** (example):
```
How many numbers do you want to enter? 4
Enter number 1: 15
Enter number 2: 8
Enter number 3: 22
Enter number 4: 12
Largest number is: 22
```

**Explanation**: We assume the first number is the largest, then compare each subsequent number and update if larger.

---

### Task 44: Count positive and negative numbers
**Problem**: Write a program that counts positive and negative numbers from user input.

```java
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many numbers do you want to enter? ");
        int n = scanner.nextInt();
        
        int positiveCount = 0;
        int negativeCount = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int number = scanner.nextInt();
            
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            }
        }
        
        System.out.println("Positive numbers: " + positiveCount);
        System.out.println("Negative numbers: " + negativeCount);
        scanner.close();
    }
}
```

**Output** (example):
```
How many numbers do you want to enter? 5
Enter number 1: 10
Enter number 2: -5
Enter number 3: 0
Enter number 4: -8
Enter number 5: 15
Positive numbers: 2
Negative numbers: 2
```

**Explanation**: We use counters to track positive and negative numbers, ignoring zeros.

---

### Task 45: Calculate average of numbers
**Problem**: Write a program that calculates the average of n numbers entered by user.

```java
import java.util.Scanner;

public class Task45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many numbers do you want to enter? ");
        int n = scanner.nextInt();
        
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int number = scanner.nextInt();
            sum += number;
        }
        
        double average = (double) sum / n;
        System.out.println("Average: " + average);
        scanner.close();
    }
}
```

**Output** (example):
```
How many numbers do you want to enter? 4
Enter number 1: 10
Enter number 2: 20
Enter number 3: 30
Enter number 4: 40
Average: 25.0
```

**Explanation**: We cast the sum to double before division to get a decimal result.

---

## Tasks 46-50: Loop Patterns and Sequences

### Task 46: Print star pattern
**Problem**: Write a program that prints a right triangle pattern using asterisks.

```java
public class Task46 {
    public static void main(String[] args) {
        int rows = 5;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

**Output**:
```
* 
* * 
* * * 
* * * * 
* * * * * 
```

**Explanation**: Nested for loops - outer loop controls rows, inner loop controls columns in each row.

---

### Task 47: Print number pattern
**Problem**: Write a program that prints a number pattern where each row contains numbers from 1 to row number.

```java
public class Task47 {
    public static void main(String[] args) {
        int rows = 5;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
```

**Output**:
```
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 
```

**Explanation**: The inner loop prints numbers from 1 to the current row number.

---

### Task 48: Print pyramid pattern
**Problem**: Write a program that prints a pyramid pattern using asterisks.

```java
public class Task48 {
    public static void main(String[] args) {
        int rows = 5;
        
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}
```

**Output**:
```
    *
   ***
  *****
 *******
*********
```

**Explanation**: We print spaces first (decreasing with each row), then stars (increasing by 2 each row).

---

### Task 49: Print diamond pattern
**Problem**: Write a program that prints a diamond pattern using asterisks.

```java
public class Task49 {
    public static void main(String[] args) {
        int rows = 5;
        
        // Upper half
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        // Lower half
        for (int i = rows - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}
```

**Output**:
```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

**Explanation**: We create the upper half (increasing stars) and lower half (decreasing stars) separately.

---

### Task 50: Print Floyd's triangle
**Problem**: Write a program that prints Floyd's triangle (consecutive numbers in each row).

```java
public class Task50 {
    public static void main(String[] args) {
        int rows = 5;
        int number = 1;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
```

**Output**:
```
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
```

**Explanation**: We use a single counter that increments for each number printed, regardless of row.

---

## Summary
This section covered different types of loops in Java:
- **for loops**: Best for known number of iterations
- **while loops**: Best when condition is checked before execution
- **do-while loops**: Best when body must execute at least once
- **Nested loops**: For creating patterns and complex iterations
- **User input with loops**: Interactive programs

Key concepts learned:
- Loop initialization, condition, and increment/decrement
- Loop control flow and termination
- Pattern printing with nested loops
- User input processing in loops
- Mathematical sequences and calculations

These skills are essential for handling repetitive tasks and data processing in Java programs. 
Here are **100 Java practice tasks** for mastering **Phase 8: Exception Handling**, covering `try-catch-finally`, `throw`, `throws`, checked vs unchecked exceptions, and custom exception creation. These tasks are grouped to progress from basics to advanced exception handling patterns.

---

### 🔹 A. `try-catch-finally` Basics (Tasks 1–25)

1. Write a program that divides two numbers using `try-catch`.
2. Handle `ArithmeticException` for division by zero.
3. Handle `ArrayIndexOutOfBoundsException` with a fixed-size array.
4. Use `try-catch` when parsing invalid `int` from `String`.
5. Handle `NullPointerException` when accessing null reference.
6. Write a method that catches any exception and prints the message.
7. Catch multiple exceptions using multi-catch block (`catch (A | B e)`).
8. Use `finally` block to always print “Execution Completed”.
9. Place return statement in both `try` and `finally` and observe behavior.
10. Handle `NumberFormatException` using `try-catch`.
11. Handle user input errors using `Scanner` + `try-catch`.
12. Access a file that doesn't exist and catch the exception.
13. Read an integer from user input and handle incorrect type input.
14. Catch `InputMismatchException` when reading from `Scanner`.
15. Handle exceptions inside a loop gracefully.
16. Handle array access in loop with wrong index range.
17. Handle string operations that cause `StringIndexOutOfBoundsException`.
18. Nest `try-catch` blocks and print which one catches the exception.
19. Use `finally` to release a resource (e.g., closing a scanner).
20. Try accessing an element from an empty list using `get()`.
21. Catch `ClassCastException` when casting improperly.
22. Handle `IllegalArgumentException` in method input.
23. Catch exceptions thrown by `Integer.parseInt()` with invalid string.
24. Create a simple calculator with exception handling.
25. Write a method that always executes `finally` regardless of exception.

---

### 🔹 B. `throw` and `throws` (Tasks 26–50)

1. Create a method that throws `IllegalArgumentException` manually.
2. Create a method that throws `IOException` and handle it in caller.
3. Write a method that throws `ArithmeticException` using `throw`.
4. Create a method that validates age and throws if < 18.
5. Use `throws` in method declaration for `InterruptedException`.
6. Call `Thread.sleep()` and handle the exception using `throws`.
7. Demonstrate that unchecked exceptions don't need `throws`.
8. Demonstrate use of `throw` with custom error message.
9. Create method `divide(a, b)` and `throw` if b is 0.
10. Use `throws` for a method that reads a file.
11. Catch an exception in main that’s thrown from another method.
12. Build a validator method that throws `IllegalStateException` when invalid.
13. Throw exception if username length < 5.
14. Throw exception if file extension isn’t `.txt`.
15. Create a login function that throws for empty username/password.
16. Chain a `throw` from one method to another using `throws`.
17. Demonstrate `throw new NullPointerException("custom message")`.
18. Call a method using `throws` in a try-catch in `main()`.
19. Compare behavior of throwing `RuntimeException` vs `IOException`.
20. Create a `calculateTax()` method that throws when income < 0.
21. Create a method that only throws and never catches (let main catch it).
22. Create a `FileReader` method that uses `throws FileNotFoundException`.
23. Write a method that throws `IllegalAccessException` and is called safely.
24. Demonstrate calling a `throws` method from another `throws` method.
25. Write a simple CLI tool that uses `throw` to validate inputs.

---

### 🔹 C. Checked vs Unchecked Exceptions (Tasks 51–65)

1. List 5 checked and 5 unchecked exceptions (write code examples).
2. Write a method that throws a checked exception (`IOException`).
3. Write a method that throws an unchecked exception (`NullPointerException`).
4. Demonstrate that checked exceptions **must** be handled or declared.
5. Show that unchecked exceptions compile even without handling.
6. Try to compile a method throwing `SQLException` without `throws`.
7. Handle `IOException` when reading a non-existent file.
8. Catch `FileNotFoundException` separately and observe behavior.
9. Write code that shows `IndexOutOfBoundsException` vs `FileNotFoundException`.
10. Simulate a network API call with a checked exception (`SocketException`).
11. Simulate a data parsing error with unchecked exception.
12. Try reading from a closed file stream and handle the exception.
13. Use `throws` to forward a checked exception from helper method.
14. Explain with code why `RuntimeException` is unchecked.
15. Demonstrate checked exception bubbling up multiple method calls.

---

### 🔹 D. Custom Exception Classes (Tasks 66–85)

1. Create a custom exception class `InvalidAgeException`.
2. Throw `InvalidAgeException` in age validator method.
3. Create `LowBalanceException` and throw when withdrawing too much.
4. Create `NegativeSalaryException` in `Employee` class.
5. Extend `RuntimeException` for a custom unchecked exception.
6. Extend `Exception` for a custom checked exception.
7. Create `InvalidGradeException` for student grading system.
8. Create `InvalidLoginException` with custom error message.
9. Use constructor overloading in your custom exception.
10. Include custom fields (e.g., code) in your exception class.
11. Throw custom exception if name is null or blank.
12. Create `InvalidFileFormatException` and test with wrong extension.
13. Create `InvalidInputException` and throw from multiple methods.
14. Throw custom exception for incorrect password length.
15. Create `TooManyRequestsException` for simulated API rate limit.
16. Add custom logging to your custom exception.
17. Use try-catch-finally with your custom exception.
18. Create a method that catches and rethrows your custom exception.
19. Use a parent class to catch multiple child custom exceptions.
20. Create an exception class hierarchy (base + 2 subclasses).

---

### 🔹 E. Mini Projects & Challenges (Tasks 86–100)

1. Build a user registration form and handle invalid inputs with exceptions.
2. Create a simple banking system with withdrawal, deposit & validations.
3. Develop a library management system that throws for unavailable books.
4. Build a file reader utility that handles all file-related exceptions.
5. Create a form validator (name, age, email) using custom exceptions.
6. Write a number parser that throws exception for invalid formats.
7. Simulate an e-commerce checkout with stock exception.
8. Develop an ATM simulation using custom and built-in exceptions.
9. Create a grading system with exception on invalid score.
10. Build a command-line calculator with `try-catch` on invalid inputs.
11. Implement retry logic for file read with `try-catch` inside a loop.
12. Build login system that throws after 3 failed attempts.
13. Create a recursive method that handles stack overflow with caution.
14. Build a CLI "form filler" where all fields validate with exceptions.
15. Integrate all concepts in a mini project: `StudentPortal` with exception-safe methods and custom exceptions.

---

Would you like this formatted into a:

- ✅ Notion task board?
- 📘 PDF workbook?
- 💻 IntelliJ project template with TODOs?

Let me know and I’ll generate it.
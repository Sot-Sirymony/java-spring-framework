Here are **100 hands-on tasks** to practice **Clean Code in Java – Phase 2: Functions, Classes & Objects (Week 3–4)**. These are grouped by topic and aligned with *Clean Code* Chapters 6–10, with emphasis on writing maintainable and testable code.

---

## ✅ 1. Clean Functions (Do One Thing, Command-Query Separation) – *25 tasks*

1. Refactor a method that performs multiple operations into separate methods.
2. Split a `validateAndSave()` method into two distinct methods.
3. Extract logic from a loop inside a method into a helper function.
4. Refactor a method with embedded queries and commands into two functions.
5. Write a method that only returns data (query).
6. Write a method that only performs an action (command).
7. Rename mixed-purpose methods to better reflect their primary role.
8. Convert imperative logic to smaller declarative helper methods.
9. Review a method with multiple return types and simplify.
10. Practice writing functions that return early (guard clauses).
11. Refactor a function to remove temporary flags or booleans.
12. Break a function that reads and writes data into two separate methods.
13. Use functional decomposition to reduce large method size.
14. Avoid side effects in a method and log them separately.
15. Convert a method with inline conditions to a clearly named function.
16. Identify functions that hide behavior (e.g., “get” methods that change state).
17. Apply the "One Level of Abstraction per Function" rule to a method.
18. Refactor a function that takes too many responsibilities.
19. Replace a nested loop with helper methods.
20. Inline intermediate variables when they're redundant.
21. Rename a function to better express its *intention*, not *implementation*.
22. Replace multiple `if` blocks with polymorphic function calls.
23. Write a unit test for a function that clearly separates input/output.
24. Compare two versions of a method: one clean, one messy.
25. Measure cyclomatic complexity before and after refactoring.

---

## 🧩 2. Clean Classes (SRP, Cohesion) – *25 tasks*

26. Review a class with too many responsibilities and identify logical separations.
27. Refactor a God Object into multiple smaller classes.
28. Split a class that handles both I/O and business logic.
29. Break a utility class into meaningful domain-specific classes.
30. Apply SRP by moving unrelated methods to new classes.
31. Design a `UserService` class with strict SRP.
32. Implement a cohesive class that only deals with one concept (e.g., `InvoicePrinter`).
33. Remove unrelated methods from a model class (e.g., `User` doing too much).
34. Group related fields and methods together in a class.
35. Design a `Logger` class that delegates actual logging to strategy implementations.
36. Implement a small domain model with 3 tightly cohesive classes.
37. Rename a class that violates its original intent.
38. Analyze cohesion in a legacy class and suggest improvements.
39. Create a service class that delegates responsibilities to helper classes.
40. Eliminate static methods that act on object data—move them inside objects.
41. Avoid using DTOs for logic—convert DTOs to domain objects before processing.
42. Move helper methods from client classes to appropriate domain classes.
43. Write a class diagram before refactoring a messy object structure.
44. Encapsulate field access in a class—replace public fields with private and getters.
45. Create a cohesive class using only final fields and constructor injection.
46. Use Object Calisthenics rule: one level of indentation per class.
47. Refactor a builder class to improve method chaining and readability.
48. Convert procedural code with multiple functions to a well-structured object.
49. Refactor switch-heavy classes into polymorphic subclasses.
50. Test for class cohesion using LCOM metric (if tools are available).

---

## 🧯 3. Error Handling (Clean Try-Catch, Avoid Null) – *20 tasks*

51. Replace a method that returns null with `Optional<T>`.
52. Refactor `try-catch` blocks into a centralized error handler.
53. Avoid catching `Exception`—catch specific exceptions only.
54. Write a method that throws meaningful custom exceptions.
55. Create an exception hierarchy for a domain (e.g., `PaymentException`, `ValidationException`).
56. Remove nested `try-catch` blocks by extracting functions.
57. Avoid logging and throwing in the same place—delegate one responsibility.
58. Wrap a third-party API call in a safe try-catch block with clear error messages.
59. Use `try-with-resources` for resource cleanup (e.g., file, DB).
60. Convert error-prone return codes to exceptions.
61. Use `Optional` chaining and `orElseThrow()` for cleaner null handling.
62. Refactor legacy null-checking code to use `Objects.requireNonNull`.
63. Extract error-handling logic from main business logic.
64. Document thrown exceptions using JavaDoc.
65. Validate arguments in constructors with meaningful error messages.
66. Create a fail-fast validation layer for inputs.
67. Remove catch blocks that do nothing or swallow exceptions silently.
68. Replace `null` map values with `Optional` or default objects.
69. Use custom exceptions for rule violations instead of boolean return values.
70. Refactor a class to support both checked and unchecked exception strategies.

---

## 🔁 4. DRY vs WET – *15 tasks*

71. Identify duplicate code blocks across multiple methods.
72. Extract common logic into reusable private methods.
73. Consolidate repeated validation logic into a `Validator` class.
74. Create a reusable utility method for date formatting.
75. Replace repeated constant values with named constants.
76. Create a base class or interface to eliminate redundant logic.
77. Refactor test cases with duplicate setup logic using `@BeforeEach`.
78. Use templates or strategies for repeated patterns (e.g., logging, error reporting).
79. Avoid copy-pasting across classes—use composition or inheritance.
80. DRY up service layer methods using generic patterns.
81. Group similar configuration keys and values in one place.
82. Identify repeated SQL or JPQL fragments and abstract them.
83. Extract repeated loop logic into a higher-order function.
84. Use annotations (e.g., Lombok) to reduce boilerplate safely.
85. Review your past project and refactor top 5 WET areas.

---

## 🚫 5. Avoiding Side Effects – *15 tasks*

86. Write a pure function with no side effects.
87. Refactor a function that mutates global state.
88. Use immutable objects for value types (e.g., `Money`, `DateRange`).
89. Separate calculation logic from persistence.
90. Identify and remove hidden side effects in functions.
91. Replace mutable collections with immutable versions (`List.of()`).
92. Avoid method calls in constructors that modify external state.
93. Avoid static variables unless they’re constants.
94. Refactor method chains that change internal object state.
95. Write a test to detect side effects by comparing object states before/after.
96. Use defensive copies when exposing internal collections.
97. Eliminate method parameters that are mutated.
98. Return new objects instead of modifying inputs.
99. Use builder patterns instead of setters for object creation.
100. Explain how side effects can break testability and refactor one example.

---

Would you like this in a **Notion tracking board**, **PDF printout**, or **Google Sheet format** to manage your progress through the 100 tasks?

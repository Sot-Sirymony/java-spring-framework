Here are **100 practice tasks** for **Phase 3: SOLID Principles & Design Patterns (Week 5–6)**, focused on writing extensible, maintainable, and flexible Java code.

These are grouped into categories aligned with your curriculum: **SOLID principles**, **Clean Design Mindsets (YAGNI, KISS, TDD)**, and **Intro Design Patterns**.

---

## ✅ 1. SOLID Principles (50 tasks — 10 per principle)

### 🧱 SRP – Single Responsibility Principle

1. Identify and list multiple responsibilities in a class.
2. Refactor a `UserController` that handles business logic and validation.
3. Move logging functionality out of a domain class.
4. Split a `ReportGenerator` class into `ReportFetcher` and `ReportRenderer`.
5. Refactor a method that mixes data transformation and I/O.
6. Ensure service, repository, and model classes each do only one thing.
7. Create a `UserService` class that delegates validation to a `UserValidator`.
8. Extract calculation logic from a controller.
9. Write JUnit tests that validate SRP: fail when too many responsibilities are in one class.
10. Comment the role of each method in a class—SRP violations should be evident.

### 🔓 OCP – Open/Closed Principle

11. Refactor `if-else` or `switch` logic to use polymorphism.
12. Implement a `Shape` interface with `draw()` method and extend without modifying base logic.
13. Add a new behavior to an app without changing existing code (use Strategy or Decorator).
14. Use inheritance to extend a formatter without touching the original class.
15. Refactor a `PaymentProcessor` to support new methods via OCP.
16. Use a plugin pattern where new behaviors can be registered dynamically.
17. Write a class where adding new functionality only requires creating a subclass.
18. Replace conditionals in a calculation class with a `CalculationStrategy`.
19. Show before/after of a system redesigned for OCP.
20. Write tests verifying you can extend the logic without changing tested components.

### 🧬 LSP – Liskov Substitution Principle

21. Create a `Bird` superclass and show how `Penguin extends Bird` can violate LSP.
22. Refactor so subclasses never override behavior in a breaking way.
23. Add assertions in superclass methods and see if subclass breaks them.
24. Design a valid inheritance hierarchy for geometric shapes (`Rectangle`, `Square`).
25. Identify violations in a legacy class hierarchy.
26. Write a test: replace subclass with superclass and assert behavior.
27. Use composition instead of inheritance to fix LSP issues.
28. Replace subclass if it changes method contract or throws more exceptions.
29. Refactor an overridden method that violates the parent method’s intent.
30. Write a class hierarchy where each subclass behaves transparently under polymorphism.

### ⚖ ISP – Interface Segregation Principle

31. Create a `Machine` interface with `print()`, `scan()`, `fax()`—split it into separate interfaces.
32. Identify a fat interface and break it into smaller cohesive ones.
33. Write a `Workable` interface and split it into `Eater`, `Worker`, `Sleeper`.
34. Use multiple interfaces with default methods in Java 8+.
35. Design a system where clients depend only on what they use.
36. Add a new feature (like `pay()`) without modifying existing interfaces.
37. Use abstract classes + multiple interfaces for cleaner separation.
38. Refactor a method that accepts an interface but uses only a subset of it.
39. Use adapter pattern to conform legacy interface to a smaller one.
40. Show how ISP improves readability and maintainability.

### 🔌 DIP – Dependency Inversion Principle

41. Replace direct instantiation (`new`) with dependency injection.
42. Use constructor injection in a service class.
43. Create a `NotificationService` that depends on an `INotificationSender` interface.
44. Inject dependencies using a factory or DI framework like Spring.
45. Replace low-level modules with abstractions.
46. Use inversion of control to delegate resource management.
47. Make a class testable by injecting mocks instead of real dependencies.
48. Write a class where high-level policy and low-level details are decoupled.
49. Use `@Autowired` or manual injection for a Logger dependency.
50. Build a config-driven dependency setup (e.g., choosing a DB driver via config).

---

## 🧠 2. Clean Design Mindsets – YAGNI, KISS, TDD (20 tasks)

### ✂️ YAGNI – You Aren’t Gonna Need It

51. Remove unused method stubs or config that anticipates future features.
52. Refactor over-engineered interfaces that aren’t used yet.
53. Avoid creating abstract classes “just in case.”
54. Document 3 examples in your own code where YAGNI was violated.
55. Limit your first implementation to core functionality only.

### 💡 KISS – Keep It Simple, Stupid

56. Rewrite a method to remove overengineering or clever tricks.
57. Replace recursion with a simple loop if recursion adds no clarity.
58. Remove unnecessary patterns like unnecessary factories.
59. Choose a simple solution over an “ideal” but overly complex one.
60. Use POJOs for simple data transfer rather than DTO frameworks.

### 🧪 TDD – Test-Driven Development

61. Write unit tests *before* implementation.
62. Use red-green-refactor on a simple calculator class.
63. Add a failing test, write just enough code to pass, then refactor.
64. Practice TDD for a small CLI task tracker app.
65. Write tests using mocks for behavior validation.
66. Use JUnit5 with parameterized tests.
67. Set up test coverage tracking (e.g., JaCoCo).
68. Refactor a method while ensuring 100% test coverage.
69. Delete legacy code and rewrite it using TDD.
70. Use TDD to write a parser or simple expression evaluator.

---

## 🧰 3. Design Patterns Intro (30 tasks)

### 🧠 Strategy Pattern

71. Implement a `PaymentStrategy` interface (`CreditCard`, `Paypal`, `Cash`).
72. Refactor conditionals into strategy pattern logic.
73. Replace a hardcoded algorithm with a plug-in strategy.
74. Inject strategy via constructor.
75. Write unit tests for each strategy.

### 🏭 Factory Pattern

76. Implement a `NotificationFactory` that creates email/SMS/push instances.
77. Replace `new` operators with factory methods.
78. Use a static method `createLogger()` that returns different implementations.
79. Apply factory with config-based selection (e.g., `type=pdf`).
80. Refactor a switch-case instantiation block into a factory.

### 🧍 Singleton Pattern

81. Create a thread-safe Singleton using `synchronized`.
82. Use `enum` to implement a Singleton in Java.
83. Ensure lazy initialization in a logging utility.
84. Write a unit test to verify singleton is enforced.
85. Refactor a globally used utility into a singleton service.

### 🧬 Dependency Injection (DI)

86. Manually inject services in a small app using constructor injection.
87. Replace hardcoded dependency with Spring’s `@Autowired`.
88. Build a `UserController` that gets `UserService` from DI container.
89. Use configuration class to register beans manually.
90. Create a simple DI container from scratch (for learning).

---

## 🎯 Final Review & Application Tasks (10 tasks)

91. Build a mini CRUD app applying all 5 SOLID principles.
92. Refactor an old project to use DI and Factory patterns.
93. Document all design decisions in a simple architecture doc.
94. Draw a UML class diagram showing pattern usage.
95. Perform code review of a peer’s app based on SOLID & patterns.
96. Record a short video refactoring legacy code using Strategy.
97. Write a blog post or internal note summarizing your lessons.
98. Create a checklist for SOLID compliance before pushing code.
99. Share your clean code project with the community for feedback.
100. Reflect: How has your approach to writing Java code changed after Week 6?

---

Would you like this turned into a **trackable Notion board**, **Kanban format**, or **printable checklist** to manage progress visually?

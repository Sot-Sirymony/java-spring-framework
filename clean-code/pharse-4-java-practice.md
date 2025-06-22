Here are **100 Clean Code Java tasks for Phase 4: Refactoring & Code Smells (Week 7–8)**. These tasks will sharpen your ability to **detect, document, and refactor bad code** systematically using modern techniques and tools.

---

## 🔍 1. Identify & Analyze Common Code Smells (20 tasks)

### 🔬 General Detection

1. Analyze a legacy Java file and list all code smells.
2. Annotate 10 lines of smelly code with a `// SMELL:` comment.
3. List and define the top 10 most frequent code smells in your codebase.
4. Read a GitHub project and identify 5 smell types with code examples.
5. Review 3 methods that violate clean code principles.

### 🧱 Long Method

6. Find a method with >30 lines and break it into smaller methods.
7. Use IntelliJ/VSCode’s "Extract Method" to reduce method length.
8. Rename extracted methods to express their behavior clearly.
9. Comment on why long methods make code harder to test.
10. Replace deeply nested logic with early returns or strategy.

### 🏢 Large Class

11. Find a class with >500 lines and identify all its responsibilities.
12. Split a large class into multiple SRP-compliant ones.
13. Apply encapsulation to hide internal logic from other classes.
14. Create a utility class from shared logic in a large class.
15. Visualize cohesion by grouping related fields + methods.

### 🧮 Primitive Obsession

16. Refactor a method with too many primitives (e.g., String, int) into a Value Object.
17. Replace magic numbers with constants.
18. Create a `Money`, `Address`, or `Email` object instead of using strings.
19. Write tests comparing primitive-style and object-style approaches.
20. Avoid using primitives for domain concepts (e.g., `int status` → `enum Status`).

---

## 🛠 2. Apply Refactoring Techniques (40 tasks)

### 🪄 Extract Method / Class

21. Refactor a large block into an expressive private method.
22. Move repeated code across methods into a shared helper.
23. Create a class just for a specific feature (e.g., `OrderValidator`).
24. Split a file with multiple nested classes into separate files.
25. Extract a deeply nested logic branch into its own method.
26. Extract logic from constructor into a `create()` static factory.
27. Extract string-building logic into a `toStringHelper()` class.
28. Move formatting logic into its own formatter class.
29. Group multiple logging calls into a single method.
30. Create a `ResultWrapper` class instead of duplicating result formatting.

### 🧼 Replace Temp with Query

31. Refactor a temporary variable by replacing it with a method call.
32. Refactor a `tempTotal = price * qty` to a `getTotalPrice()` method.
33. Remove reused temp variables that clutter method bodies.
34. Create getters instead of using intermediate local variables.
35. Ensure query methods don’t introduce side effects.

### ⚖ Decompose Conditional

36. Replace a complex `if-else` with smaller Boolean-returning methods.
37. Use `guard clauses` to simplify nested conditionals.
38. Replace ternary chains with expressive conditional blocks.
39. Extract the conditional expression into a separate method.
40. Use `Polymorphism` or `Strategy` to avoid repeated condition checks.

### 🧼 Other Techniques

41. Replace a loop with Java Streams (if cleaner).
42. Refactor duplicate logic in different classes into a shared utility.
43. Replace `StringBuilder` usage with a templating approach.
44. Use `Map.of()` or Java 14+ records to clean up data-heavy logic.
45. Refactor try-catch blocks to a centralized error handler.
46. Use Optional to eliminate null-check clutter.
47. Remove `else` after `return` statements.
48. Eliminate deeply nested `if-else` branches using Strategy pattern.
49. Remove dead/commented-out code.
50. Replace `switch-case` with enum-based dispatching.

---

## 🏛 3. Legacy Code Refactoring (20 tasks)

51. Open a legacy project and list high-risk areas to refactor.
52. Add unit tests to a legacy class before making changes.
53. Use IntelliJ’s structural search to detect duplicate code snippets.
54. Refactor a method that hasn’t been touched in >1 year.
55. Use Git Blame to trace who wrote/last touched the smelly code.
56. Add assertions and logging to understand legacy flow.
57. Replace deprecated APIs or Java patterns in legacy code.
58. Document 3 successful refactorings from a legacy codebase.
59. Identify a file with outdated comments and rewrite it with clean code.
60. Safely rename a variable used in >10 places using refactoring tools.
61. Move logic from JSP/HTML into controller/service layer.
62. Refactor a legacy DAO to use JPA or JDBC templates.
63. Replace inline SQL queries with named methods.
64. Refactor a `main()` method into a proper service layer.
65. Extract one legacy class into an independent testable unit.
66. Simplify a legacy class with too many static methods.
67. Move business logic out of UI components.
68. Use version control (e.g., Git diff) to track your refactoring safely.
69. Create a test harness for an old untested class.
70. Comment your refactor with a before/after explanation.

---

## 📐 4. Refactoring Tools & Best Practices (20 tasks)

71. Learn and practice using IntelliJ "Refactor → Rename".
72. Practice “Extract Method” with keyboard shortcuts.
73. Use "Inline Variable" and "Inline Method" features.
74. Explore IntelliJ or Eclipse code analysis tools (e.g., SonarLint).
75. Run a static analysis tool (e.g., PMD, SpotBugs) and fix top 5 issues.
76. Configure code inspections and fix red flags in a file.
77. Set up Prettier or Checkstyle for consistent formatting.
78. Practice “Change Signature” safely in IDE.
79. Refactor using “Move Class to New Package”.
80. Analyze complexity metrics before and after refactoring.
81. Reorganize a project by package structure (by layer or domain).
82. Use Git branches to isolate refactor work safely.
83. Document code smells using markdown checklists.
84. Create a small CLI that scans for large methods in Java files.
85. Refactor one feature each day for a week in a legacy project.
86. Practice commit messages with conventional naming: `refactor: split invoice logic`.
87. Use version control diff tools to explain what you changed and why.
88. Compare automated refactoring vs. manual — evaluate pros/cons.
89. Write a postmortem: what refactoring introduced a bug and how was it fixed.
90. Create a refactoring plan for a smelly class with >300 lines.

---

## 🧠 5. Review & Final Reflection Tasks (10 tasks)

91. Write a blog post about 3 useful refactoring techniques.
92. Compare pre-refactor vs. post-refactor versions of a class.
93. Share a Pull Request with detailed refactoring notes.
94. Create a checklist of “smells” to catch in future code reviews.
95. Run SonarQube or Codacy on your project and document top smells.
96. Refactor code with 3+ smell types in one pass.
97. Create a 5-minute video refactoring walkthrough for peers.
98. Practice doing a live refactor + explanation session (mock interview style).
99. Mentor a junior dev on identifying and fixing one code smell.
100. Reflect: How has your understanding of **maintainable code** changed since Phase 1?

---

Would you like this turned into a **Notion template**, **Google Sheets tracker**, or **Refactoring Diary PDF** to organize your progress visually?

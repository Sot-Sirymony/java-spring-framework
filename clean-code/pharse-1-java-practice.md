Here are **100 clean code practice tasks** for **Phase 1: Foundation of Clean Code (Week 1–2)**. These tasks are grouped by topic for focused practice.

---

### ✅ 1. Why Clean Code Matters (10 tasks)

1. Write a short essay on “Why clean code matters” (max 200 words).
2. Identify 5 benefits of writing clean code.
3. Find 3 GitHub Java projects with messy code; write why they are hard to read.
4. Find 3 open-source Java projects with clean code and explain why they are easy to maintain.
5. Refactor a Java file with bad structure and comment what was improved.
6. Write two versions of a function: one messy, one clean. Compare.
7. Pair-review a class with a peer and comment only on readability.
8. List 5 long-term issues caused by unclean code.
9. Interview a developer (or simulate) asking how clean code helped in a past project.
10. Explain the cost of technical debt due to messy code in a paragraph.

---

### 🚨 2. Code Smells Overview (10 tasks)

11. List 10 common Java code smells.
12. Review a Java class with at least 3 code smells.
13. Refactor a method that has a long parameter list.
14. Refactor a class with feature envy.
15. Rewrite a function suffering from “duplicated code” smell.
16. Find “switch” or “if-else” chains and refactor to polymorphism or strategy.
17. Refactor a method longer than 50 lines.
18. Rename misleading variable names.
19. Convert a data clump into a class.
20. Convert a “god class” into multiple cohesive classes.

---

### 🏷️ 3. Naming Conventions (Variables, Methods, Classes) (15 tasks)

21. Rename bad variable names to meaningful ones.
22. Rewrite a function with ambiguous parameter names.
23. Rename classes from vague names like `DataProcessor` to specific ones like `InvoiceCalculator`.
24. Make a list of naming do’s and don’ts.
25. Given 10 bad names, rewrite them better.
26. Convert Hungarian notation code to modern naming.
27. Change short names like `x`, `y` to descriptive ones.
28. Create a Java class using only expressive names—no comments needed.
29. Refactor a test case with misleading method names.
30. Identify a Java file with mixed naming styles and unify it.
31. Prefix Boolean variables with “is”/“has” correctly.
32. Refactor plural/singular mismatches in collection names.
33. Ensure all constants use uppercase with underscores.
34. Create a guide for naming variables in your team.
35. Create method names that express what the method does (e.g., `calculateTotal()` not `doWork()`).

---

### 🧩 4. Functions (Small, Single-purpose, Low Parameters) (20 tasks)

36. Split a long method into smaller ones.
37. Rewrite a function with more than 3 parameters to reduce the count.
38. Extract logic inside `if/else` into helper methods.
39. Turn procedural code into object-oriented functions.
40. Refactor a function that does multiple things into separate single-purpose methods.
41. Practice writing pure functions with no side effects.
42. Refactor a utility method to avoid unnecessary static behavior.
43. Use meaningful function names instead of comments.
44. Use early returns to avoid nested conditions.
45. Convert a method with boolean flags to two separate methods.
46. Remove duplicate logic by combining two similar methods.
47. Ensure each method has one logical level of abstraction.
48. Add JavaDoc to complex functions.
49. Write overloaded methods with descriptive names.
50. Extract switch logic into dedicated functions or classes.
51. Refactor deeply nested logic using guard clauses.
52. Inline trivial methods that don’t add value.
53. Eliminate temporary variables when they’re unnecessary.
54. Refactor a void method into one that returns meaningful value.
55. Create a chain of small methods using the fluent interface style.

---

### 💬 5. Comments (When to Write & When to Remove) (15 tasks)

56. Remove redundant comments that describe what code already says.
57. Replace comments with expressive function or variable names.
58. Add TODO/FIXME in meaningful places only.
59. Write a method with zero comments but high readability.
60. Remove history comments (e.g., who changed the file).
61. Convert a block comment into a log message (if relevant).
62. Refactor a method where a comment describes a hack—remove the hack instead.
63. Add meaningful JavaDoc for a public API.
64. Remove all commented-out legacy code in a file.
65. Practice writing summary comments only when the method involves tricky logic.
66. Replace comment blocks describing logic with a well-named helper function.
67. Write comments only where intent cannot be made clear via code.
68. Review and clean comments in a past project.
69. Explain why comments should not be used for versioning.
70. Document an interface with contract expectations clearly.

---

### 🧱 6. Formatting: Indentation, Spacing, Line Breaks (20 tasks)

71. Reformat a file to use 4-space indentation.
72. Break a method with 20+ lines into logically grouped blocks with line breaks.
73. Align chained method calls vertically.
74. Use consistent spacing around operators (`=`, `+`, `-`, etc.).
75. Fix spacing between methods (1 blank line).
76. Fix spacing after commas in method parameters.
77. Break long parameter lists into multiple lines.
78. Add vertical spacing to group logic sections in a long method.
79. Remove trailing whitespace from lines.
80. Ensure braces are used consistently (`{` on same line or next line—pick one).
81. Format long strings or SQL queries across multiple lines.
82. Use a formatter tool like `google-java-format`.
83. Refactor nested if-else with proper indentation and clarity.
84. Re-indent a file that mixes tabs and spaces.
85. Add consistent indentation to a multi-level class hierarchy.
86. Break down long return statements across multiple lines.
87. Clean up a class with inconsistent line breaks.
88. Limit each file to one class or one responsibility (if possible).
89. Reformat messy XML/JSON embedded in Java code.
90. Configure and use IntelliJ or Eclipse auto-format settings.

---

### 🎯 Final Review Tasks (10 tasks)

91. Pick a messy Java file and apply all principles you’ve learned.
92. Refactor an old school project using clean code techniques.
93. Conduct a peer code review using clean code as the criteria.
94. Submit a cleaned version of a file to GitHub with a before/after diff.
95. Write your own checklist for clean code before commits.
96. Build a small app (e.g., calculator, task manager) with strict clean code rules.
97. Record yourself refactoring and explaining why.
98. Review and critique your clean code after 1 week.
99. Identify which clean code rule you break most often.
100. Reflect: What changed in your coding mindset after these 2 weeks?

---

Would you like these tasks in a **Notion template**, **PDF**, or **Google Sheets format** for tracking progress?

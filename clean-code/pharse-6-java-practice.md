Here are **100 Clean Code Java tasks for Phase 6: Clean Code in Real Projects (Week 11–12)**. This phase is where you **apply all you've learned in a real or open-source project** with **tools, discipline, and strategy**.

These tasks are grouped into 6 categories: **Project Setup**, **Code Structure**, **Clean Practices**, **Testing**, **Tooling & Automation**, and **Documentation & Review**.

---

## 🚀 1. Project Setup & Planning (15 tasks)

1. Choose an open-source Java project or create your own from scratch.
2. Set up your project using Maven or Gradle.
3. Define your project’s domain and main use cases.
4. Apply package-by-feature structure (not package-by-layer).
5. Create a clean README with project goals, setup steps, and architecture plan.
6. Initialize Git with a clean commit history and .gitignore.
7. Plan and document feature modules following SRP and clean architecture.
8. Create a simple project roadmap in Notion or Markdown.
9. Design your initial domain models and DTOs.
10. Map dependencies between features and organize tasks by priority.
11. Choose a RESTful structure (or GraphQL if advanced).
12. Define naming conventions across services, entities, tests.
13. Create base classes/interfaces for consistent patterns (e.g., BaseResponse).
14. Break the app into bounded contexts (e.g., Auth, Product, Cart).
15. Set up environment profiles (`dev`, `test`, `prod`) cleanly.

---

## 🧱 2. Code Structure & Domain Design (20 tasks)

16. Define your domain model clearly: e.g., `Product`, `CartItem`, `User`.
17. Ensure all classes follow the Single Responsibility Principle.
18. Split controllers, services, and repositories into separate packages.
19. Refactor large services into smaller, focused ones.
20. Move validation logic into dedicated validator classes.
21. Apply object modeling: e.g., replace primitives with Value Objects.
22. Use enums instead of strings for things like status codes.
23. Encapsulate logic inside domain models when appropriate.
24. Avoid anemic domain models — give entities behavior, not just data.
25. Write factories for entity creation instead of using raw constructors.
26. Apply the Strategy pattern where different behaviors are needed (e.g., shipping methods).
27. Apply the Factory pattern for dynamic object creation.
28. Design clean DTOs separate from entities.
29. Use interface-driven development — depend on abstractions.
30. Create a clean, fluent API or service layer.
31. Separate configuration files from business logic.
32. Refactor service classes with >5 methods.
33. Use `@ConfigurationProperties` for application settings.
34. Eliminate utility classes that hold unrelated static methods.
35. Replace static method usage with injectable services.

---

## 🧽 3. Clean Code Practices in Action (25 tasks)

36. Refactor at least one class with code smells using Clean Code techniques.
37. Follow meaningful naming conventions for variables and methods.
38. Ensure method names express intent — no “doWork()” or “handleIt()”.
39. Apply Extract Method where logic is over 15 lines.
40. Remove all redundant comments — use expressive code instead.
41. Replace inline conditionals with well-named helper methods.
42. Avoid deep nesting — use guard clauses or return early.
43. Delete all commented-out code blocks.
44. Use logging responsibly — avoid cluttered log statements.
45. Apply DRY: remove 3+ duplicated blocks of code.
46. Write short functions (5–15 lines max).
47. Ensure low parameter count (refactor if >3).
48. Avoid magic numbers — use named constants.
49. Eliminate Boolean flags that control multiple responsibilities.
50. Apply the Law of Demeter (use less `.get().get()` chains).
51. Use Lombok with discipline — avoid hiding complexity.
52. Clean up `switch` statements — move to polymorphism or maps.
53. Use assertions for critical validations (e.g., `Objects.requireNonNull()`).
54. Eliminate unused variables, imports, and dead code.
55. Cleanly handle exceptions — no catch-all generic exceptions.
56. Use final wherever immutability is needed.
57. Avoid returning `null` — use Optional where applicable.
58. Add helpful error messages for thrown exceptions.
59. Separate read and write methods (Command-Query Separation).
60. Use records (Java 14+) or compact DTOs where possible.

---

## ✅ 4. Clean Testing in Real Projects (20 tasks)

61. Set up JUnit 5 and Mockito in your project.
62. Write clean unit tests with AAA (Arrange–Act–Assert) format.
63. Use TDD for one small feature (e.g., cart addition).
64. Mock external service calls in tests.
65. Write integration tests for REST endpoints.
66. Use `TestContainers` for database integration tests (optional).
67. Separate unit tests from integration tests in folders or by naming.
68. Use `@DataJpaTest` for JPA-level tests.
69. Avoid brittle tests — mock only what’s necessary.
70. Use `@BeforeEach` and `@AfterEach` for setup/teardown logic.
71. Avoid logic in test assertions.
72. Add parameterized tests to cover edge cases.
73. Maintain consistent test naming (`shouldDoX_whenY_givenZ()`).
74. Use `@MockBean` to inject mock services in Spring Boot.
75. Write test coverage for service and controller layers.
76. Capture behavior, not implementation, in your tests.
77. Don’t assert private fields — use public contract.
78. Use `@Nested` test classes to group related test cases.
79. Document your test structure in the README.
80. Track test coverage with JaCoCo or IntelliJ coverage tools.

---

## 🧰 5. Tooling, Automation & Quality Gates (15 tasks)

81. Install and configure SonarQube for code analysis.
82. Run SonarQube and fix top 5 critical issues.
83. Set up Checkstyle or PMD for code quality enforcement.
84. Automate lint checks in Git pre-commit hook.
85. Integrate CI (GitHub Actions, GitLab CI, Jenkins).
86. Ensure your CI pipeline runs tests and static analysis.
87. Set up a badge for build status or coverage in README.
88. Use Dependabot to track outdated dependencies (GitHub).
89. Configure logging levels (info, debug, error) cleanly.
90. Enable logging config through application.yml or logback.xml.
91. Automate deployment with clean code practices included.
92. Use Docker or Docker Compose for local clean testing.
93. Document environment setup with clean instructions.
94. Perform regular static code scans before merges.
95. Review 3 SonarQube recommendations and apply clean fixes.

---

## 📚 6. Documentation, Review & Reflection (5 tasks)

96. Document your clean code refactor before/after examples.
97. Write a short case study on your clean code journey in this project.
98. Record a short walkthrough of one clean code implementation (video or blog).
99. Share your clean code refactor with the community or mentor.
100. Reflect: How has this real project changed the way you think about code?

---

Would you like these tasks organized into a **Notion board**, **Kanban-style Trello**, or **trackable Google Sheets template** for weekly execution and reflection?

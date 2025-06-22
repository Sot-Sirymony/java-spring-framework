Here are **100 Java tasks** for **Phase 5: Writing Clean Test Code (Week 9–10)** — designed to help you build clean, structured, and maintainable test suites using **TDD**, **JUnit**, **Mockito**, and clean testing principles.

---

## ✅ 1. TDD (Test-Driven Development) – *25 tasks*

1. Write a failing test before writing the implementation.
2. Use red-green-refactor to develop a simple calculator class.
3. Build a `UserService` class entirely using TDD.
4. Refactor legacy code by first writing a test that breaks, then fixing it.
5. Create a `ToDoList` app using TDD from start to finish.
6. Use TDD to implement a feature with validation logic.
7. Avoid writing extra logic until a test requires it (YAGNI in TDD).
8. Refactor production code only when all tests are passing.
9. Apply TDD to an algorithm (e.g., palindrome checker).
10. Simulate an API call and write failing tests first.
11. Refactor code to remove duplication only after tests pass.
12. Use TDD to develop a domain class (e.g., `Invoice`, `BankAccount`).
13. Write tests using only interfaces, not implementations.
14. Add a new feature without breaking any existing tests.
15. Use parameterized tests to cover multiple scenarios in TDD.
16. Write a failing integration test, then make the system pass it.
17. Use TDD to add logging behavior only when required.
18. Track coverage increase after TDD-based changes.
19. Apply TDD to a collection class (`Stack`, `Queue`, etc.).
20. Use mocks/stubs within TDD to isolate dependencies.
21. Avoid "over-mocking" during TDD cycles.
22. Compare writing tests before vs. after: Which helped more?
23. Use TDD to validate exception-throwing behavior.
24. Log your red-green-refactor cycles for a feature.
25. Reflect: Did you write less or more code with TDD?

---

## 🔎 2. Unit vs Integration Testing – *20 tasks*

26. Write a unit test for a pure function (no side effects).
27. Write an integration test for a REST endpoint.
28. Compare test speed between unit and integration tests.
29. Refactor an integration test to isolate one dependency at a time.
30. Mock external service calls in integration tests.
31. Use an in-memory DB (e.g., H2) for integration tests.
32. Tag integration tests separately using `@Tag("integration")`.
33. Write a test suite that runs unit tests quickly and integration tests later.
34. Create an `OrderService` unit test that doesn't touch DB or network.
35. Create a `UserRegistrationIntegrationTest` that hits real DB + controller.
36. Use `@SpringBootTest` for integration setup.
37. Separate test source folders for unit vs integration tests.
38. Refactor tests to follow isolation principles.
39. Test a DAO layer with and without DB access.
40. Stub network responses for API tests.
41. Create a unit test for a class that throws exceptions on invalid input.
42. Measure execution time difference between unit and integration tests.
43. Refactor integration tests to use `TestContainers` or `MockWebServer`.
44. Write boundary tests for unit-level edge cases.
45. Apply the Pyramid Testing principle: more unit tests, fewer E2E tests.

---

## 🧱 3. Clean Test Structure (AAA: Arrange-Act-Assert) – *15 tasks*

46. Structure your test with clear sections: arrange, act, assert.
47. Comment each AAA block in 3 existing test cases.
48. Refactor a messy test into clean AAA format.
49. Use a helper method to arrange test data cleanly.
50. Avoid logic in `assert` statements — keep them clear.
51. Use the `Given/When/Then` structure if using BDD style.
52. Avoid using test data in the act/assert phases.
53. Write tests where each test case has one assert block (if possible).
54. Group similar assertions using `assertAll()`.
55. Use descriptive variables like `actual`, `expected`, `inputValue`.
56. Don’t assert implementation details (e.g., private fields).
57. Avoid unnecessary test setup—only arrange what you need.
58. Create a utility class for test fixtures.
59. Use builder patterns to create complex test inputs.
60. Highlight AAA visually in your code editor with formatting/comments.

---

## 🧪 4. Mocking and Stubbing (JUnit + Mockito) – *25 tasks*

61. Mock a repository using `Mockito.mock()`.
62. Stub a method to return specific values using `when(...).thenReturn(...)`.
63. Verify method calls using `Mockito.verify()`.
64. Write a test that stubs and asserts interactions.
65. Inject mocks using `@Mock` and `@InjectMocks`.
66. Use `MockitoAnnotations.openMocks()` in setup.
67. Mock a void method using `doNothing()` or `doThrow()`.
68. Stub a method to throw an exception.
69. Spy on a real object and stub one method only.
70. Replace service logic with a mock for fast testing.
71. Refactor a test to use `@ExtendWith(MockitoExtension.class)`.
72. Avoid over-mocking: only mock what you don't control.
73. Use `ArgumentCaptor` to capture passed arguments.
74. Test a class that has external dependencies (email, DB, etc.).
75. Use `thenThrow()` to simulate error conditions.
76. Mock a `RestTemplate` or HTTP client call.
77. Avoid mocking `List`, `Map`, or value objects.
78. Mock a static method using PowerMock (optional/advanced).
79. Assert interaction order using `InOrder`.
80. Create a helper method to configure common stubs.
81. Use `@MockBean` in Spring Boot tests.
82. Test retry behavior by mocking different responses.
83. Simulate delayed responses and timeout scenarios.
84. Avoid nulls in stubs—return dummy objects instead.
85. Write tests without mocks if possible—prefer real collaborators.

---

## 🏷 5. Test Naming & Readability – *15 tasks*

86. Use descriptive method names: `shouldReturnUser_whenUsernameExists()`.
87. Follow naming convention: `should_<expected>_when_<condition>()`.
88. Avoid vague names like `test1()`, `testABC()`.
89. Rename all test methods in a class using proper naming.
90. Add test display names using `@DisplayName`.
91. Create a naming template and share with your team.
92. Format test class names as `<ClassBeingTested>Test`.
93. Group related tests using nested classes or `@Nested`.
94. Highlight what the test covers in the name.
95. Use underscores to separate parts of the test name (if preferred).
96. Don’t encode implementation in test names.
97. Prefix integration test classes with `IT` (e.g., `UserServiceIT`).
98. Write test names that communicate behavior, not structure.
99. Review another dev’s test names and provide feedback.
100. Reflect: What’s the clearest test name you’ve ever written?

---

Would you like this converted into a **Notion board**, **Google Sheet tracker**, or **PDF printable checklist** to track your progress over these two weeks?

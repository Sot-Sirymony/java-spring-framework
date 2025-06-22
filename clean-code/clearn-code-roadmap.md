Here’s a structured **Clean Code Learning Roadmap** designed to help you go from beginner to advanced level, with practical skills and project-based learning.

---

## 🧭 **Clean Code Learning Roadmap**

---

### 📘 Phase 1: Foundation of Clean Code (Week 1–2)

**Goals**: Understand why clean code matters and basic clean coding principles.

### Topics:

- Why clean code matters
- Code smells overview
- Naming conventions (variables, methods, classes)
- Functions:
    - Small, single-purpose
    - Parameters (keep low count)
- Comments: when to write & when to remove
- Formatting: indentation, spacing, line breaks

### Resources:

- 📖 *Clean Code* by Robert C. Martin (Ch. 1–5)
- 📺 [Clean Code – JavaBrains](https://www.youtube.com/watch?v=7EmboKQH8lM)
- 🛠 Practice:
    - Refactor messy functions (from GitHub repos)
    - Rename bad variable names

---

### ⚙️ Phase 2: Functions, Classes & Objects (Week 3–4)

**Goals**: Master writing clean, maintainable, and testable functions and classes.

### Topics:

- Functions (detailed rules)
    - Do one thing
    - Command-query separation
- Classes:
    - SRP (Single Responsibility Principle)
    - Cohesion
- Error handling:
    - Clean try-catch blocks
    - Avoid returning null
- DRY vs WET
- Avoiding side effects

### Resources:

- 📖 *Clean Code* Ch. 6–10
- 🧑‍🏫 [Object Calisthenics](https://williamdurand.fr/2013/06/03/object-calisthenics/)
- 📺 [Clean Code Java Example – Amigoscode](https://www.youtube.com/watch?v=VV1JvU5zP5Y)
- 🛠 Practice:
    - Refactor legacy class-based code
    - Build a simple CLI tool with clean principles

---

### 🏗️ Phase 3: SOLID Principles & Design Patterns (Week 5–6)

**Goals**: Write extensible and flexible code using clean design principles.

### Topics:

- S.O.L.I.D. principles:
    - SRP, OCP, LSP, ISP, DIP
- YAGNI, KISS, and TDD
- Introduction to design patterns:
    - Strategy, Factory, Singleton, Dependency Injection

### Resources:

- 📖 *Clean Architecture* by Robert C. Martin (Intro sections)
- 📘 [Refactoring.Guru](https://refactoring.guru/)
- 📺 [SOLID Principles – TechWorld with Nana](https://www.youtube.com/watch?v=rtmFCcjEgEw)
- 🛠 Practice:
    - Build a mini CRUD app applying SOLID
    - Refactor using DI and Strategy

---

### 🔍 Phase 4: Refactoring & Code Smells (Week 7–8)

**Goals**: Identify bad code and systematically refactor it.

### Topics:

- Common code smells:
    - Long method, large class, primitive obsession
    - Duplicated code, long parameter list
- Refactoring techniques:
    - Extract method/class
    - Replace temp with query
    - Decompose conditional
- Working with legacy code

### Resources:

- 📖 *Refactoring* by Martin Fowler
- 🧰 IntelliJ/Eclipse/VSCode Refactoring Tools
- 📺 [Code Smells – JetBrains TV](https://www.youtube.com/watch?v=I9sx0fAEYgc)
- 🛠 Practice:
    - Refactor a legacy Java/Node.js project
    - Document refactoring choices

---

### 🧪 Phase 5: Writing Clean Test Code (Week 9–10)

**Goals**: Maintain code quality with clean test practices.

### Topics:

- TDD (Test Driven Development)
- Unit vs Integration tests
- Clean test structure: Arrange-Act-Assert
- Mocking and Stubbing
- Test naming conventions

### Resources:

- 📖 *Clean Code* Ch. 12 (Emergent Design)
- 📘 *Working Effectively with Legacy Code* by Michael Feathers
- 📺 [TDD & Clean Tests – Uncle Bob](https://www.youtube.com/watch?v=EZ05e7EMOLM)
- 🛠 Practice:
    - Write JUnit/Mockito tests for your app
    - Apply TDD for a small feature

---

### 🚀 Phase 6: Clean Code in Real Projects (Week 11–12)

**Goals**: Apply clean code in real-world applications.

### Activities:

- Choose 1 real-world open-source project or build your own
- Apply clean code principles from day 1
- Use tools like:
    - SonarQube
    - ESLint/Pylint
    - Java static analyzers

### Capstone Project Ideas:

- 🛒 E-commerce cart system (Java or Node.js)
- 📅 Task scheduler app (Spring Boot or Express)
- 🧠 API for personal knowledge base (clean architecture)

---

## 🧰 Tools & Libraries

- Java: IntelliJ, JUnit, Mockito
- JavaScript: ESLint, Jest
- Git: Use version control to track refactoring
- IDE Plugins: SonarLint, Checkstyle

---

## ✅ Bonus Tips:

- Join code review sessions
- Read clean open-source code (Spring, React)
- Refactor a project every 2–3 months

---

Would you like me to generate a **Notion template** or **PDF checklist** for this roadmap?
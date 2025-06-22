# Section 1: Identify & Analyze Common Code Smells

## 1. Analyze a legacy Java file and list all code smells

**Example (before refactoring):**
```java
// File: OrderProcessor.java
public class OrderProcessor {
    public void processOrder(String customer, String address, int itemCount, double price, int status) {
        if (status == 1) {
            // ...
        } else if (status == 2) {
            // ...
        }
        // 50+ lines of logic
    }
    // ... more methods ...
}
```
**Detected Smells:**
- Long Method
- Primitive Obsession
- Magic Numbers
- Large Class
- Duplicated Code (if similar logic elsewhere)

---

## 2. Annotate 10 lines of smelly code with `// SMELL:`
```java
public class UserManager {
    public void saveUser(String name, String email, int type) {
        if (type == 1) { // SMELL: Magic Number, Primitive Obsession
            // ...
        } else if (type == 2) { // SMELL: Magic Number
            // ...
        }
        // ...
    }
    // SMELL: Long Method
    public void doEverything() {
        // 40+ lines
    }
}
```

---

## 3. List and define the top 10 most frequent code smells

1. **Long Method**: Methods that are too long and do too much.
2. **Large Class**: Classes with too many responsibilities.
3. **Primitive Obsession**: Overuse of primitives instead of small objects.
4. **Magic Numbers/Strings**: Unexplained literals in code.
5. **Duplicated Code**: Same code in multiple places.
6. **Feature Envy**: Method that seems more interested in another class.
7. **Data Clumps**: Groups of variables that are always used together.
8. **Switch Statements**: Repeated switch/case logic instead of polymorphism.
9. **Speculative Generality**: Unused abstractions or code for future needs.
10. **Comments**: Excessive or misleading comments instead of clean code.

---

## 4. Read a GitHub project and identify 5 smell types with code examples

*(You would pick a real project, but here's a simulated example:)*
- **Long Method**: `processOrder()` in `OrderService.java` (80 lines)
- **Primitive Obsession**: `String status` used instead of `OrderStatus` enum
- **Magic Numbers**: `if (type == 3)`
- **Large Class**: `UserManager.java` (600 lines)
- **Duplicated Code**: Validation logic repeated in `UserService` and `AdminService`

---

## 5. Review 3 methods that violate clean code principles

**Example:**
```java
public void calculate(int a, int b, int c) { // SMELL: Primitive Obsession, unclear naming
    int x = a + b * c; // SMELL: Magic Numbers, unclear logic
    // ...
}

public void handle() { // SMELL: Long Method
    // 50+ lines
}

public void process(String s) { // SMELL: Unclear parameter, Primitive Obsession
    // ...
}
```

---

**Next:**
- For each smell, provide a before/after code example in the `examples/` directory.
- Continue with Long Method, Large Class, and Primitive Obsession refactoring tasks. 
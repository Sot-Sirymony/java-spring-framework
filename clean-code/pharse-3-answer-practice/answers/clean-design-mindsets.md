# Clean Design Mindsets — Phase 3 Answers

## 1. YAGNI (You Aren't Gonna Need It)

### Principle
Don't implement something until it is necessary. Avoid speculative generality.

---

### 1.1. Example of YAGNI Violation
```java
// YAGNI Violation: Adding export to XML before it's needed
public class ReportService {
    public void exportReport(String format) {
        if ("PDF".equals(format)) {
            // export as PDF
        } else if ("XML".equals(format)) {
            // export as XML (not needed yet)
        }
    }
}
```

**Explanation:**
Adding XML export before there is a requirement wastes time and adds maintenance burden.

---

### 1.2. YAGNI-Compliant Example
```java
public class ReportService {
    public void exportReport(String format) {
        if ("PDF".equals(format)) {
            // export as PDF
        }
        // Add XML support only when needed
    }
}
```

---

## 2. KISS (Keep It Simple, Stupid)

### Principle
Prefer simple, straightforward solutions. Avoid unnecessary complexity.

---

### 2.1. KISS Violation Example
```java
// Over-engineered solution
public class MathUtils {
    public int add(int a, int b) {
        return calculate(a, b, (x, y) -> x + y);
    }
    private int calculate(int a, int b, BiFunction<Integer, Integer, Integer> op) {
        return op.apply(a, b);
    }
}
```

**Explanation:**
Using a functional interface for simple addition is overkill.

---

### 2.2. KISS-Compliant Example
```java
public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }
}
```

---

## 3. TDD (Test-Driven Development)

### Principle
Write tests before writing the code. Red-Green-Refactor cycle.

---

### 3.1. TDD Example
```java
// Step 1: Write a failing test
@Test
void testSum() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.sum(2, 3));
}

// Step 2: Write minimal code to pass the test
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }
}

// Step 3: Refactor if needed
```

**Explanation:**
TDD ensures code is testable and requirements are met.

---

## 4. Avoid Premature Optimization

### Principle
Don't optimize code before it's clear where the bottlenecks are.

---

### 4.1. Violation Example
```java
// Premature optimization: using StringBuilder everywhere
public String concatNames(List<String> names) {
    StringBuilder sb = new StringBuilder();
    for (String name : names) {
        sb.append(name);
    }
    return sb.toString();
}
```

**Explanation:**
For small lists, simple string concatenation is clearer and fast enough.

---

### 4.2. Compliant Example
```java
public String concatNames(List<String> names) {
    String result = "";
    for (String name : names) {
        result += name;
    }
    return result;
}
```

---

## 5. DRY vs. WET

### Principle
DRY: Don't Repeat Yourself. WET: Write Everything Twice (or more). Favor DRY but avoid over-abstraction.

---

### 5.1. WET Example
```java
public class InvoiceService {
    public double calculateTotal(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public double calculateDiscountedTotal(List<Item> items, double discount) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total * (1 - discount);
    }
}
```

### 5.2. DRY Example
```java
public class InvoiceService {
    private double sumItems(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public double calculateTotal(List<Item> items) {
        return sumItems(items);
    }
    public double calculateDiscountedTotal(List<Item> items, double discount) {
        return sumItems(items) * (1 - discount);
    }
}
```

---

## 6. Checklist for Clean Design Mindsets

- [x] Only implement what is needed (YAGNI)
- [x] Keep solutions as simple as possible (KISS)
- [x] Write tests before code (TDD)
- [x] Avoid premature optimization
- [x] Eliminate duplication, but don't over-abstract (DRY)
- [x] Refactor regularly
- [x] Review code for unnecessary complexity
- [x] Prefer clarity over cleverness 
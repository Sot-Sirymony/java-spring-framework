# SOLID Principles — Tasks 1–50

## 🧱 SRP – Single Responsibility Principle (Tasks 1–10)

### Principle
A class should have only one reason to change. Each class or module should do one thing and do it well.

---

### 1. Identify and list multiple responsibilities in a class

**Example:**
```java
public class UserController {
    // Handles HTTP requests
    public void handleRequest(HttpServletRequest req) { ... }
    // Validates user input
    public boolean validateUser(User user) { ... }
    // Business logic
    public void registerUser(User user) { ... }
    // Logging
    public void logAction(String action) { ... }
}
```
**Responsibilities:**
- HTTP handling
- Validation
- Business logic
- Logging

---

### 2. Refactor a UserController that handles business logic and validation

**Before:**
```java
public class UserController {
    public void register(User user) {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        // ... business logic
    }
}
```
**After:**
```java
public class UserController {
    private final UserValidator validator;
    private final UserService userService;
    public UserController(UserValidator validator, UserService userService) {
        this.validator = validator;
        this.userService = userService;
    }
    public void register(User user) {
        validator.validate(user);
        userService.register(user);
    }
}

public class UserValidator {
    public void validate(User user) {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}
```

---

### 3. Move logging functionality out of a domain class

**Before:**
```java
public class Order {
    public void complete() {
        // ... business logic
        System.out.println("Order completed");
    }
}
```
**After:**
```java
public class Order {
    public void complete() {
        // ... business logic
    }
}

public class OrderLogger {
    public void logComplete(Order order) {
        System.out.println("Order completed: " + order.getId());
    }
}
```

---

### 4. Split a ReportGenerator class into ReportFetcher and ReportRenderer

**Before:**
```java
public class ReportGenerator {
    public Report fetchReport(String id) { ... }
    public String renderReport(Report report) { ... }
}
```
**After:**
```java
public class ReportFetcher {
    public Report fetchReport(String id) { ... }
}
public class ReportRenderer {
    public String renderReport(Report report) { ... }
}
```

---

### 5. Refactor a method that mixes data transformation and I/O

**Before:**
```java
public void exportUserData(List<User> users, String filePath) {
    String json = new Gson().toJson(users);
    Files.write(Paths.get(filePath), json.getBytes());
}
```
**After:**
```java
public class UserExporter {
    public String toJson(List<User> users) {
        return new Gson().toJson(users);
    }
    public void writeToFile(String data, String filePath) throws IOException {
        Files.write(Paths.get(filePath), data.getBytes());
    }
}
```

---

### 6. Ensure service, repository, and model classes each do only one thing

**Example:**
- `UserService`: Handles business logic
- `UserRepository`: Handles data persistence
- `User`: Represents the data model

---

### 7. Create a UserService class that delegates validation to a UserValidator

```java
public class UserService {
    private final UserValidator validator;
    public UserService(UserValidator validator) {
        this.validator = validator;
    }
    public void register(User user) {
        validator.validate(user);
        // ... registration logic
    }
}
```

---

### 8. Extract calculation logic from a controller

**Before:**
```java
public class InvoiceController {
    public double calculateTotal(Invoice invoice) {
        return invoice.getItems().stream().mapToDouble(Item::getPrice).sum();
    }
}
```
**After:**
```java
public class InvoiceCalculator {
    public double calculateTotal(Invoice invoice) {
        return invoice.getItems().stream().mapToDouble(Item::getPrice).sum();
    }
}
```

---

### 9. Write JUnit tests that validate SRP: fail when too many responsibilities are in one class

```java
@Test
void testUserControllerHasSingleResponsibility() {
    Class<?> clazz = UserController.class;
    long methodCount = Arrays.stream(clazz.getDeclaredMethods()).count();
    assertTrue(methodCount <= 3, "UserController should not have too many responsibilities");
}
```

---

### 10. Comment the role of each method in a class—SRP violations should be evident

```java
public class UserManager {
    // Handles user registration
    public void register(User user) { ... }
    // Handles user login
    public void login(User user) { ... }
    // Handles user validation (should be in a validator!)
    public boolean validate(User user) { ... }
    // Handles logging (should be in a logger!)
    public void log(String message) { ... }
}
// SRP violation: too many unrelated responsibilities
```

---

## 🔓 OCP – Open/Closed Principle (Tasks 11–20)

### Principle
Software entities should be open for extension but closed for modification.

---

### 11. Refactor `if-else` or `switch` logic to use polymorphism

**Before:**
```java
public class PaymentProcessor {
    public void process(String type, double amount) {
        if ("credit".equals(type)) {
            processCreditCard(amount);
        } else if ("paypal".equals(type)) {
            processPayPal(amount);
        } else if ("cash".equals(type)) {
            processCash(amount);
        }
    }
}
```

**After:**
```java
public interface PaymentStrategy {
    void pay(double amount);
}

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment: $" + amount);
    }
}

public class PaymentProcessor {
    public void process(PaymentStrategy strategy, double amount) {
        strategy.pay(amount);
    }
}
```

---

### 12. Implement a `Shape` interface with `draw()` method and extend without modifying base logic

```java
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

public class ShapeRenderer {
    public void render(Shape shape) {
        shape.draw(); // No modification needed to add new shapes
    }
}
```

---

### 13. Add a new behavior to an app without changing existing code (use Strategy or Decorator)

**Using Strategy Pattern:**
```java
public interface DiscountStrategy {
    double applyDiscount(double amount);
}

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;
    
    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - percentage / 100);
    }
}

public class OrderProcessor {
    private final DiscountStrategy discountStrategy;
    
    public OrderProcessor(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    public double processOrder(double amount) {
        return discountStrategy.applyDiscount(amount);
    }
}
```

---

### 14. Use inheritance to extend a formatter without touching the original class

```java
public abstract class BaseFormatter {
    public String format(String text) {
        return text.trim();
    }
}

public class UppercaseFormatter extends BaseFormatter {
    @Override
    public String format(String text) {
        return super.format(text).toUpperCase();
    }
}

public class LowercaseFormatter extends BaseFormatter {
    @Override
    public String format(String text) {
        return super.format(text).toLowerCase();
    }
}
```

---

### 15. Refactor a `PaymentProcessor` to support new methods via OCP

**Before:**
```java
public class PaymentProcessor {
    public void processCreditCard(double amount) { ... }
    public void processPayPal(double amount) { ... }
    public void processCash(double amount) { ... }
}
```

**After:**
```java
public interface PaymentMethod {
    void process(double amount);
}

public class PaymentProcessor {
    private final List<PaymentMethod> paymentMethods;
    
    public PaymentProcessor(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    
    public void process(PaymentMethod method, double amount) {
        method.process(amount);
    }
}
```

---

### 16. Use a plugin pattern where new behaviors can be registered dynamically

```java
public interface Plugin {
    String getName();
    void execute();
}

public class PluginManager {
    private final Map<String, Plugin> plugins = new HashMap<>();
    
    public void registerPlugin(Plugin plugin) {
        plugins.put(plugin.getName(), plugin);
    }
    
    public void executePlugin(String name) {
        Plugin plugin = plugins.get(name);
        if (plugin != null) {
            plugin.execute();
        }
    }
}

public class EmailPlugin implements Plugin {
    @Override
    public String getName() {
        return "email";
    }
    
    @Override
    public void execute() {
        System.out.println("Sending email...");
    }
}
```

---

### 17. Write a class where adding new functionality only requires creating a subclass

```java
public abstract class ReportGenerator {
    public final void generateReport() {
        fetchData();
        processData();
        formatReport();
        saveReport();
    }
    
    protected abstract void fetchData();
    protected abstract void processData();
    protected abstract void formatReport();
    protected abstract void saveReport();
}

public class SalesReportGenerator extends ReportGenerator {
    @Override
    protected void fetchData() {
        System.out.println("Fetching sales data");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing sales data");
    }
    
    @Override
    protected void formatReport() {
        System.out.println("Formatting sales report");
    }
    
    @Override
    protected void saveReport() {
        System.out.println("Saving sales report");
    }
}
```

---

### 18. Replace conditionals in a calculation class with a `CalculationStrategy`

**Before:**
```java
public class Calculator {
    public double calculate(String operation, double a, double b) {
        switch (operation) {
            case "add": return a + b;
            case "subtract": return a - b;
            case "multiply": return a * b;
            case "divide": return a / b;
            default: throw new IllegalArgumentException("Unknown operation");
        }
    }
}
```

**After:**
```java
public interface CalculationStrategy {
    double calculate(double a, double b);
}

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

public class SubtractionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

public class Calculator {
    private final Map<String, CalculationStrategy> strategies;
    
    public Calculator() {
        strategies = Map.of(
            "add", new AdditionStrategy(),
            "subtract", new SubtractionStrategy()
        );
    }
    
    public double calculate(String operation, double a, double b) {
        CalculationStrategy strategy = strategies.get(operation);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return strategy.calculate(a, b);
    }
}
```

---

### 19. Show before/after of a system redesigned for OCP

**Before (Violates OCP):**
```java
public class OrderProcessor {
    public double calculateDiscount(Order order) {
        if (order.getCustomerType().equals("VIP")) {
            return order.getTotal() * 0.15;
        } else if (order.getCustomerType().equals("REGULAR")) {
            return order.getTotal() * 0.05;
        } else {
            return 0;
        }
    }
}
```

**After (OCP Compliant):**
```java
public interface DiscountStrategy {
    double calculateDiscount(Order order);
}

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.15;
    }
}

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.05;
    }
}

public class OrderProcessor {
    private final Map<String, DiscountStrategy> strategies;
    
    public OrderProcessor() {
        strategies = Map.of(
            "VIP", new VipDiscountStrategy(),
            "REGULAR", new RegularDiscountStrategy()
        );
    }
    
    public double calculateDiscount(Order order) {
        DiscountStrategy strategy = strategies.get(order.getCustomerType());
        return strategy != null ? strategy.calculateDiscount(order) : 0;
    }
}
```

---

### 20. Write tests verifying you can extend the logic without changing tested components

```java
@Test
void testCanAddNewPaymentMethodWithoutChangingProcessor() {
    PaymentProcessor processor = new PaymentProcessor();
    
    // Test existing payment method
    PaymentStrategy creditCard = new CreditCardPayment();
    assertDoesNotThrow(() -> processor.process(creditCard, 100.0));
    
    // Test new payment method (added without changing PaymentProcessor)
    PaymentStrategy crypto = new CryptoPayment();
    assertDoesNotThrow(() -> processor.process(crypto, 100.0));
}

public class CryptoPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing crypto payment: $" + amount);
    }
}
```

---

## 🧬 LSP – Liskov Substitution Principle (Tasks 21–30)

### Principle
Subtypes must be substitutable for their base types without breaking the application.

---

### 21. Create a `Bird` superclass and show how `Penguin extends Bird` can violate LSP

**LSP Violation Example:**
```java
public class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

// This breaks LSP because you can't substitute Penguin for Bird
public class BirdWatcher {
    public void watchBird(Bird bird) {
        bird.fly(); // This will fail for Penguin!
    }
}
```

**LSP Compliant Solution:**
```java
public interface Flyable {
    void fly();
}

public class Bird {
    // Base bird functionality
}

public class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Penguin extends Bird {
    // No fly method - penguins don't fly
}
```

---

### 22. Refactor so subclasses never override behavior in a breaking way

**Before (LSP Violation):**
```java
public class Rectangle {
    protected int width;
    protected int height;
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Breaks LSP - changes behavior
    }
    
    @Override
    public void setHeight(int height) {
        this.width = height; // Breaks LSP - changes behavior
        this.height = height;
    }
}
```

**After (LSP Compliant):**
```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getArea() {
        return width * height;
    }
}

public class Square implements Shape {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    @Override
    public int getArea() {
        return side * side;
    }
}
```

---

### 23. Add assertions in superclass methods and see if subclass breaks them

```java
public class BankAccount {
    protected double balance;
    
    public void deposit(double amount) {
        assert amount > 0 : "Deposit amount must be positive";
        balance += amount;
        assert balance >= 0 : "Balance cannot be negative";
    }
    
    public void withdraw(double amount) {
        assert amount > 0 : "Withdrawal amount must be positive";
        assert balance >= amount : "Insufficient funds";
        balance -= amount;
        assert balance >= 0 : "Balance cannot be negative";
    }
}

public class CheckingAccount extends BankAccount {
    @Override
    public void withdraw(double amount) {
        // This might break the assertion if overdraft is allowed
        balance -= amount; // No check for sufficient funds!
    }
}
```

---

### 24. Design a valid inheritance hierarchy for geometric shapes

```java
public interface Shape {
    double getArea();
    double getPerimeter();
}

public class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class Square implements Shape {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return side * side;
    }
    
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

public class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

---

### 25. Identify violations in a legacy class hierarchy

**Example of LSP Violations:**
```java
// Violation 1: Subclass throws more exceptions
public class BaseProcessor {
    public void process() throws IOException {
        // process logic
    }
}

public class SpecialProcessor extends BaseProcessor {
    @Override
    public void process() throws IOException, SQLException { // More exceptions!
        // process logic
    }
}

// Violation 2: Subclass changes return type
public class BaseCalculator {
    public Number calculate() {
        return 0;
    }
}

public class SpecialCalculator extends BaseCalculator {
    @Override
    public Integer calculate() { // Different return type!
        return 0;
    }
}

// Violation 3: Subclass has stronger preconditions
public class BaseValidator {
    public void validate(String input) {
        // accepts any string
    }
}

public class SpecialValidator extends BaseValidator {
    @Override
    public void validate(String input) {
        if (input == null || input.isEmpty()) { // Stronger precondition!
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }
}
```

---

### 26. Write a test: replace subclass with superclass and assert behavior

```java
@Test
void testLiskovSubstitution() {
    // Test with base class
    Shape rectangle = new Rectangle(5, 3);
    assertEquals(15, rectangle.getArea());
    
    // Test with subclass - should work the same way
    Shape square = new Square(4);
    assertEquals(16, square.getArea());
    
    // Test in a method that expects Shape
    List<Shape> shapes = Arrays.asList(rectangle, square);
    double totalArea = shapes.stream()
        .mapToDouble(Shape::getArea)
        .sum();
    assertEquals(31, totalArea);
}
```

---

### 27. Use composition instead of inheritance to fix LSP issues

**Before (Inheritance causing LSP issues):**
```java
public class Bird {
    public void fly() { ... }
    public void eat() { ... }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Can't fly!");
    }
}
```

**After (Composition):**
```java
public interface Flyable {
    void fly();
}

public interface Eatable {
    void eat();
}

public class Bird {
    private final Eatable eater;
    
    public Bird(Eatable eater) {
        this.eater = eater;
    }
    
    public void eat() {
        eater.eat();
    }
}

public class Sparrow extends Bird implements Flyable {
    public Sparrow() {
        super(new BirdEater());
    }
    
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Penguin extends Bird {
    public Penguin() {
        super(new BirdEater());
        // No fly method - penguins don't fly
    }
}
```

---

### 28. Replace subclass if it changes method contract or throws more exceptions

**Before:**
```java
public class FileProcessor {
    public void process(String filename) throws IOException {
        // process file
    }
}

public class NetworkFileProcessor extends FileProcessor {
    @Override
    public void process(String filename) throws IOException, NetworkException { // More exceptions!
        // process network file
    }
}
```

**After:**
```java
public interface FileProcessor {
    void process(String filename) throws IOException;
}

public class LocalFileProcessor implements FileProcessor {
    @Override
    public void process(String filename) throws IOException {
        // process local file
    }
}

public class NetworkFileProcessor implements FileProcessor {
    @Override
    public void process(String filename) throws IOException {
        try {
            // process network file
        } catch (NetworkException e) {
            throw new IOException("Network error", e);
        }
    }
}
```

---

### 29. Refactor an overridden method that violates the parent method's intent

**Before:**
```java
public class DatabaseConnection {
    public void connect() {
        // establish connection
    }
    
    public void disconnect() {
        // close connection
    }
}

public class MockDatabaseConnection extends DatabaseConnection {
    @Override
    public void connect() {
        // do nothing - violates intent
    }
    
    @Override
    public void disconnect() {
        // do nothing - violates intent
    }
}
```

**After:**
```java
public interface DatabaseConnection {
    void connect();
    void disconnect();
}

public class RealDatabaseConnection implements DatabaseConnection {
    @Override
    public void connect() {
        // establish real connection
    }
    
    @Override
    public void disconnect() {
        // close real connection
    }
}

public class MockDatabaseConnection implements DatabaseConnection {
    @Override
    public void connect() {
        // simulate connection
        System.out.println("Mock connection established");
    }
    
    @Override
    public void disconnect() {
        // simulate disconnection
        System.out.println("Mock connection closed");
    }
}
```

---

### 30. Write a class hierarchy where each subclass behaves transparently under polymorphism

```java
public interface PaymentMethod {
    void pay(double amount);
    String getPaymentType();
}

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
    
    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}

public class PaypalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
    
    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment: $" + amount);
    }
    
    @Override
    public String getPaymentType() {
        return "Cash";
    }
}

// All implementations can be used interchangeably
public class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {
        method.pay(amount);
        System.out.println("Payment type: " + method.getPaymentType());
    }
}
```

---

**Key Takeaways for LSP:**
- Subtypes must be substitutable for their base types
- Don't override methods in ways that break the contract
- Use composition over inheritance when LSP is hard to maintain
- Preconditions cannot be strengthened in subtypes
- Postconditions cannot be weakened in subtypes
- Exceptions thrown by subtypes must be the same or more specific 
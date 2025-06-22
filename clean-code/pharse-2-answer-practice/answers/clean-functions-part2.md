# Clean Functions - Tasks 11-25 (Part 2)

---

## Task 11: Remove temporary flags or booleans

**Before:**
```java
public void processOrder(Order order) {
    boolean hasError = false;
    String errorMessage = "";
    
    if (order.getItems().isEmpty()) {
        hasError = true;
        errorMessage = "Order has no items";
    }
    
    if (order.getCustomer() == null) {
        hasError = true;
        errorMessage = "Order has no customer";
    }
    
    if (hasError) {
        throw new InvalidOrderException(errorMessage);
    }
    
    // Process order...
}
```

**After:**
```java
public void processOrder(Order order) {
    validateOrder(order);
    // Process order...
}

private void validateOrder(Order order) {
    if (order.getItems().isEmpty()) {
        throw new InvalidOrderException("Order has no items");
    }
    if (order.getCustomer() == null) {
        throw new InvalidOrderException("Order has no customer");
    }
}
```

---

## Task 12: Break read/write functions

**Before:**
```java
public double updateBalanceAndGetNewBalance(String accountId, double amount) {
    Account account = accountRepository.findById(accountId);
    account.setBalance(account.getBalance() + amount);
    accountRepository.save(account);
    return account.getBalance();
}
```

**After:**
```java
public void updateBalance(String accountId, double amount) {
    Account account = accountRepository.findById(accountId);
    account.setBalance(account.getBalance() + amount);
    accountRepository.save(account);
}

public double getBalance(String accountId) {
    Account account = accountRepository.findById(accountId);
    return account.getBalance();
}
```

---

## Task 13: Functional decomposition

**Before:**
```java
public void processCustomerOrder(Customer customer, Order order) {
    // 50+ lines of mixed logic
    if (customer.getStatus().equals("ACTIVE")) {
        if (order.getTotal() < customer.getCreditLimit()) {
            if (order.getItems().size() > 0) {
                // Process order logic...
                for (OrderItem item : order.getItems()) {
                    if (item.getQuantity() > 0) {
                        if (inventoryService.hasStock(item.getProductId(), item.getQuantity())) {
                            // More processing...
                        }
                    }
                }
            }
        }
    }
}
```

**After:**
```java
public void processCustomerOrder(Customer customer, Order order) {
    if (!isCustomerEligible(customer)) return;
    if (!isOrderValid(order)) return;
    if (!hasSufficientCredit(customer, order)) return;
    if (!hasInventory(order)) return;
    
    processOrder(order);
}

private boolean isCustomerEligible(Customer customer) {
    return customer.getStatus().equals("ACTIVE");
}

private boolean isOrderValid(Order order) {
    return order.getItems().size() > 0;
}

private boolean hasSufficientCredit(Customer customer, Order order) {
    return order.getTotal() < customer.getCreditLimit();
}

private boolean hasInventory(Order order) {
    return order.getItems().stream()
        .allMatch(item -> inventoryService.hasStock(item.getProductId(), item.getQuantity()));
}
```

---

## Task 14: Avoid side effects and log separately

**Before:**
```java
public double calculateTotal(Order order) {
    double total = order.getItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();
    
    logger.info("Calculated total for order {}: {}", order.getId(), total);
    return total;
}
```

**After:**
```java
public double calculateTotal(Order order) {
    return order.getItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();
}

public void logOrderCalculation(Order order, double total) {
    logger.info("Calculated total for order {}: {}", order.getId(), total);
}
```

---

## Task 15: Convert inline conditions to named functions

**Before:**
```java
public List<Order> getUrgentOrders(List<Order> orders) {
    return orders.stream()
        .filter(order -> order.getPriority().equals("HIGH") && 
                        order.getStatus().equals("PENDING") &&
                        order.getCreatedDate().isBefore(LocalDateTime.now().minusHours(24)))
        .collect(Collectors.toList());
}
```

**After:**
```java
public List<Order> getUrgentOrders(List<Order> orders) {
    return orders.stream()
        .filter(this::isUrgentOrder)
        .collect(Collectors.toList());
}

private boolean isUrgentOrder(Order order) {
    return isHighPriority(order) && isPending(order) && isOverdue(order);
}

private boolean isHighPriority(Order order) {
    return order.getPriority().equals("HIGH");
}

private boolean isPending(Order order) {
    return order.getStatus().equals("PENDING");
}

private boolean isOverdue(Order order) {
    return order.getCreatedDate().isBefore(LocalDateTime.now().minusHours(24));
}
```

---

## Task 16: Identify functions that hide behavior

**Bad Examples:**
```java
public String getCustomerName() {
    // This "getter" actually sends an email!
    emailService.sendWelcomeEmail(this);
    return this.name;
}

public boolean isValid() {
    // This "validator" actually saves to database!
    userRepository.save(this);
    return this.name != null && this.email != null;
}
```

**Good Examples:**
```java
public String getCustomerName() {
    return this.name;  // Just returns data
}

public boolean isValid() {
    return this.name != null && this.email != null;  // Just validates
}

public void sendWelcomeEmail() {
    emailService.sendWelcomeEmail(this);  // Clear action
}

public void save() {
    userRepository.save(this);  // Clear action
}
```

---

## Task 17: One Level of Abstraction per Function

**Before:**
```java
public void processOrder(Order order) {
    // High level: Process order
    validateOrder(order);
    
    // Low level: Database details
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orders");
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (id, total) VALUES (?, ?)");
    stmt.setString(1, order.getId());
    stmt.setDouble(2, order.getTotal());
    stmt.executeUpdate();
    
    // High level: Send notification
    sendConfirmation(order);
}
```

**After:**
```java
public void processOrder(Order order) {
    validateOrder(order);
    saveOrder(order);
    sendConfirmation(order);
}

private void saveOrder(Order order) {
    orderRepository.save(order);
}
```

---

## Task 18: Refactor function with too many responsibilities

**Before:**
```java
public void handleUserRegistration(String name, String email, String password) {
    // Validation
    if (name == null || name.trim().isEmpty()) {
        throw new ValidationException("Name is required");
    }
    if (email == null || !email.contains("@")) {
        throw new ValidationException("Valid email required");
    }
    if (password == null || password.length() < 8) {
        throw new ValidationException("Password must be at least 8 characters");
    }
    
    // Business logic
    String hashedPassword = passwordEncoder.encode(password);
    User user = new User(name, email, hashedPassword);
    
    // Persistence
    userRepository.save(user);
    
    // Notification
    emailService.sendWelcomeEmail(email);
    
    // Logging
    logger.info("User registered: {}", email);
    
    // Analytics
    analyticsService.trackRegistration(email);
}
```

**After:**
```java
public void handleUserRegistration(String name, String email, String password) {
    User user = createUser(name, email, password);
    saveUser(user);
    notifyUser(user);
    logRegistration(user);
    trackAnalytics(user);
}

private User createUser(String name, String email, String password) {
    validateRegistrationData(name, email, password);
    String hashedPassword = passwordEncoder.encode(password);
    return new User(name, email, hashedPassword);
}

private void validateRegistrationData(String name, String email, String password) {
    if (name == null || name.trim().isEmpty()) {
        throw new ValidationException("Name is required");
    }
    if (email == null || !email.contains("@")) {
        throw new ValidationException("Valid email required");
    }
    if (password == null || password.length() < 8) {
        throw new ValidationException("Password must be at least 8 characters");
    }
}

private void saveUser(User user) {
    userRepository.save(user);
}

private void notifyUser(User user) {
    emailService.sendWelcomeEmail(user.getEmail());
}

private void logRegistration(User user) {
    logger.info("User registered: {}", user.getEmail());
}

private void trackAnalytics(User user) {
    analyticsService.trackRegistration(user.getEmail());
}
```

---

## Task 19: Replace nested loops with helper methods

**Before:**
```java
public List<Order> getOrdersWithOutOfStockItems(List<Order> orders) {
    List<Order> result = new ArrayList<>();
    for (Order order : orders) {
        for (OrderItem item : order.getItems()) {
            if (!inventoryService.hasStock(item.getProductId(), item.getQuantity())) {
                result.add(order);
                break;
            }
        }
    }
    return result;
}
```

**After:**
```java
public List<Order> getOrdersWithOutOfStockItems(List<Order> orders) {
    return orders.stream()
        .filter(this::hasOutOfStockItems)
        .collect(Collectors.toList());
}

private boolean hasOutOfStockItems(Order order) {
    return order.getItems().stream()
        .anyMatch(this::isOutOfStock);
}

private boolean isOutOfStock(OrderItem item) {
    return !inventoryService.hasStock(item.getProductId(), item.getQuantity());
}
```

---

## Task 20: Inline redundant intermediate variables

**Before:**
```java
public double calculateFinalPrice(Order order) {
    double subtotal = calculateSubtotal(order);
    double tax = calculateTax(subtotal);
    double discount = calculateDiscount(order);
    double finalPrice = subtotal + tax - discount;
    return finalPrice;
}
```

**After:**
```java
public double calculateFinalPrice(Order order) {
    double subtotal = calculateSubtotal(order);
    return subtotal + calculateTax(subtotal) - calculateDiscount(order);
}
```

---

## Task 21: Rename function to express intention

**Before:**
```java
public void process(String data)           // Unclear what it does
public boolean check(User user)            // Unclear what it checks
public double calc(List<Double> values)    // Unclear calculation type
```

**After:**
```java
public void validateAndSaveOrder(String orderData)  // Clear intention
public boolean isUserEligibleForDiscount(User user) // Clear intention
public double calculateOrderTotal(List<Double> prices) // Clear intention
```

---

## Task 22: Replace multiple if blocks with polymorphism

**Before:**
```java
public double calculateDiscount(Order order) {
    if (order.getCustomerType().equals("VIP")) {
        return order.getTotal() * 0.15;
    } else if (order.getCustomerType().equals("REGULAR")) {
        return order.getTotal() * 0.05;
    } else if (order.getCustomerType().equals("PREMIUM")) {
        return order.getTotal() * 0.10;
    } else {
        return 0;
    }
}
```

**After:**
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

public class PremiumDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() * 0.10;
    }
}

public class DiscountCalculator {
    private final Map<String, DiscountStrategy> strategies;
    
    public DiscountCalculator() {
        strategies = Map.of(
            "VIP", new VipDiscountStrategy(),
            "REGULAR", new RegularDiscountStrategy(),
            "PREMIUM", new PremiumDiscountStrategy()
        );
    }
    
    public double calculateDiscount(Order order) {
        DiscountStrategy strategy = strategies.get(order.getCustomerType());
        return strategy != null ? strategy.calculateDiscount(order) : 0;
    }
}
```

---

## Task 23: Write unit test with clear input/output

```java
@Test
public void calculateOrderTotal_WithMultipleItems_ReturnsCorrectTotal() {
    // Arrange
    Order order = new Order();
    order.addItem(new OrderItem("Product1", 10.0, 2));  // 20.0
    order.addItem(new OrderItem("Product2", 15.0, 1));  // 15.0
    order.addItem(new OrderItem("Product3", 5.0, 3));   // 15.0
    // Expected total: 50.0
    
    // Act
    double result = orderCalculator.calculateTotal(order);
    
    // Assert
    assertEquals(50.0, result, 0.01);
}

@Test
public void calculateDiscount_VipCustomerWithHighValueOrder_ReturnsFifteenPercent() {
    // Arrange
    Customer vipCustomer = new Customer("VIP");
    Order highValueOrder = new Order(vipCustomer);
    highValueOrder.addItem(new OrderItem("Product", 1000.0, 1));
    
    // Act
    double discount = discountCalculator.calculateDiscount(highValueOrder);
    
    // Assert
    assertEquals(150.0, discount, 0.01);  // 15% of 1000
}
```

---

## Task 24: Compare clean vs messy versions

**Messy Version:**
```java
public double calc(int x, int y, int z, String op, boolean flag, List<Double> data) {
    double result = 0;
    if (op.equals("add")) {
        result = x + y + z;
    } else if (op.equals("multiply")) {
        result = x * y * z;
    } else if (op.equals("divide")) {
        if (z != 0) {
            result = x / y / z;
        } else {
            System.out.println("Error: Division by zero");
            return -1;
        }
    }
    
    if (flag) {
        for (int i = 0; i < data.size(); i++) {
            result = result + data.get(i);
        }
    }
    
    return result;
}
```

**Clean Version:**
```java
public double performCalculation(CalculationRequest request) {
    double result = calculateBasicOperation(request);
    return addAdditionalValues(result, request.getAdditionalValues());
}

private double calculateBasicOperation(CalculationRequest request) {
    return switch (request.getOperation()) {
        case ADD -> addValues(request.getValues());
        case MULTIPLY -> multiplyValues(request.getValues());
        case DIVIDE -> divideValues(request.getValues());
    };
}

private double addValues(List<Double> values) {
    return values.stream().mapToDouble(Double::doubleValue).sum();
}

private double multiplyValues(List<Double> values) {
    return values.stream().mapToDouble(Double::doubleValue).reduce(1, (a, b) -> a * b);
}

private double divideValues(List<Double> values) {
    if (values.size() < 2) {
        throw new IllegalArgumentException("At least two values required for division");
    }
    
    double result = values.get(0);
    for (int i = 1; i < values.size(); i++) {
        if (values.get(i) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        result /= values.get(i);
    }
    return result;
}

private double addAdditionalValues(double baseResult, List<Double> additionalValues) {
    return additionalValues.stream().mapToDouble(Double::doubleValue).sum() + baseResult;
}
```

---

## Task 25: Measure cyclomatic complexity

**Before (Complexity: 8):**
```java
public double calculateDiscount(Order order) {
    double discount = 0;
    if (order.getCustomerType().equals("VIP")) {
        if (order.getTotal() > 1000) {
            discount = order.getTotal() * 0.15;
        } else if (order.getTotal() > 500) {
            discount = order.getTotal() * 0.10;
        } else {
            discount = order.getTotal() * 0.05;
        }
    } else if (order.getCustomerType().equals("REGULAR")) {
        if (order.getTotal() > 500) {
            discount = order.getTotal() * 0.05;
        }
    }
    return discount;
}
```

**After (Complexity: 2):**
```java
public double calculateDiscount(Order order) {
    DiscountStrategy strategy = discountStrategyFactory.createStrategy(order.getCustomerType());
    return strategy.calculateDiscount(order);
}

public interface DiscountStrategy {
    double calculateDiscount(Order order);
}

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        if (order.getTotal() > 1000) return order.getTotal() * 0.15;
        if (order.getTotal() > 500) return order.getTotal() * 0.10;
        return order.getTotal() * 0.05;
    }
}

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal() > 500 ? order.getTotal() * 0.05 : 0;
    }
}
```

## Summary for Tasks 11-25

Key principles demonstrated:

1. **Eliminate Flags**: Remove temporary boolean variables
2. **Command-Query Separation**: Split read/write operations
3. **Functional Decomposition**: Break complex logic into smaller functions
4. **Pure Functions**: Separate side effects from calculations
5. **Named Conditions**: Extract complex conditions into readable methods
6. **Single Abstraction Level**: Keep functions at consistent abstraction levels
7. **Strategy Pattern**: Replace switch statements with polymorphism
8. **Testable Design**: Write functions that are easy to test
9. **Reduced Complexity**: Lower cyclomatic complexity through refactoring
10. **Clear Intent**: Function names should express what they do

## Complete Function Design Checklist

- [ ] Function does one thing
- [ ] Function is small (< 20 lines)
- [ ] Function has a descriptive name
- [ ] Function has no side effects (or they're explicit)
- [ ] Function follows command-query separation
- [ ] Function uses early returns
- [ ] Function has low cyclomatic complexity
- [ ] Function is testable
- [ ] Function reads like prose
- [ ] Function has consistent abstraction level 
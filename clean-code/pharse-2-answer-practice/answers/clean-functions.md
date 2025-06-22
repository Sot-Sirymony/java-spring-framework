# Clean Functions - Tasks 1-25

## Overview
Clean functions are the building blocks of maintainable code. They should do one thing, do it well, and be easy to understand and test.

## Key Principles
1. **Single Responsibility**: Each function should have one reason to change
2. **Command-Query Separation**: Functions should either do something OR return something, not both
3. **Small Size**: Functions should be small (ideally < 20 lines)
4. **Descriptive Names**: Function names should reveal intent
5. **No Side Effects**: Functions should not modify external state unexpectedly

---

## Task 1: Refactor a method that performs multiple operations

**Before:**
```java
public void processOrder(Order order) {
    // Validate order
    if (order.getItems().isEmpty()) {
        throw new InvalidOrderException("Order must have items");
    }
    if (order.getCustomer() == null) {
        throw new InvalidOrderException("Order must have customer");
    }
    
    // Calculate total
    double total = 0;
    for (OrderItem item : order.getItems()) {
        total += item.getPrice() * item.getQuantity();
    }
    order.setTotal(total);
    
    // Apply discount
    if (order.getCustomer().isVip()) {
        double discount = total * 0.1;
        order.setDiscount(discount);
        order.setFinalTotal(total - discount);
    } else {
        order.setFinalTotal(total);
    }
    
    // Save to database
    orderRepository.save(order);
    
    // Send confirmation email
    emailService.sendConfirmation(order);
    
    // Log the action
    logger.info("Order processed: {}", order.getId());
}
```

**After:**
```java
public void processOrder(Order order) {
    validateOrder(order);
    calculateOrderTotal(order);
    applyDiscounts(order);
    saveOrder(order);
    sendConfirmation(order);
    logOrderProcessing(order);
}

private void validateOrder(Order order) {
    if (order.getItems().isEmpty()) {
        throw new InvalidOrderException("Order must have items");
    }
    if (order.getCustomer() == null) {
        throw new InvalidOrderException("Order must have customer");
    }
}

private void calculateOrderTotal(Order order) {
    double total = order.getItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();
    order.setTotal(total);
}

private void applyDiscounts(Order order) {
    if (order.getCustomer().isVip()) {
        double discount = order.getTotal() * 0.1;
        order.setDiscount(discount);
        order.setFinalTotal(order.getTotal() - discount);
    } else {
        order.setFinalTotal(order.getTotal());
    }
}

private void saveOrder(Order order) {
    orderRepository.save(order);
}

private void sendConfirmation(Order order) {
    emailService.sendConfirmation(order);
}

private void logOrderProcessing(Order order) {
    logger.info("Order processed: {}", order.getId());
}
```

---

## Task 2: Split validateAndSave() into two distinct methods

**Before:**
```java
public void validateAndSave(User user) {
    // Validation logic
    if (user.getName() == null || user.getName().trim().isEmpty()) {
        throw new ValidationException("Name is required");
    }
    if (user.getEmail() == null || !user.getEmail().contains("@")) {
        throw new ValidationException("Valid email is required");
    }
    
    // Save logic
    userRepository.save(user);
    logger.info("User saved: {}", user.getEmail());
}
```

**After:**
```java
public void saveUser(User user) {
    validateUser(user);
    persistUser(user);
}

private void validateUser(User user) {
    if (user.getName() == null || user.getName().trim().isEmpty()) {
        throw new ValidationException("Name is required");
    }
    if (user.getEmail() == null || !user.getEmail().contains("@")) {
        throw new ValidationException("Valid email is required");
    }
}

private void persistUser(User user) {
    userRepository.save(user);
    logger.info("User saved: {}", user.getEmail());
}
```

---

## Task 3: Extract logic from a loop into a helper function

**Before:**
```java
public List<Order> getHighValueOrders(List<Order> orders) {
    List<Order> highValueOrders = new ArrayList<>();
    for (Order order : orders) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        if (total > 1000) {
            highValueOrders.add(order);
        }
    }
    return highValueOrders;
}
```

**After:**
```java
public List<Order> getHighValueOrders(List<Order> orders) {
    return orders.stream()
        .filter(this::isHighValueOrder)
        .collect(Collectors.toList());
}

private boolean isHighValueOrder(Order order) {
    return calculateOrderTotal(order) > 1000;
}

private double calculateOrderTotal(Order order) {
    return order.getItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();
}
```

---

## Task 4: Refactor embedded queries and commands

**Before:**
```java
public double processPaymentAndGetBalance(Payment payment) {
    // Command: Process payment
    paymentProcessor.process(payment);
    accountRepository.updateBalance(payment.getAccountId(), payment.getAmount());
    
    // Query: Get balance
    Account account = accountRepository.findById(payment.getAccountId());
    return account.getBalance();
}
```

**After:**
```java
public void processPayment(Payment payment) {
    paymentProcessor.process(payment);
    accountRepository.updateBalance(payment.getAccountId(), payment.getAmount());
}

public double getAccountBalance(String accountId) {
    Account account = accountRepository.findById(accountId);
    return account.getBalance();
}
```

---

## Task 5: Write a method that only returns data (query)

```java
public double calculateOrderTotal(Order order) {
    return order.getItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum();
}

public boolean isEligibleForDiscount(Customer customer) {
    return customer.getOrderCount() > 10 && customer.getTotalSpent() > 1000;
}

public List<Order> getOrdersByCustomer(String customerId) {
    return orderRepository.findByCustomerId(customerId);
}
```

---

## Task 6: Write a method that only performs an action (command)

```java
public void saveOrder(Order order) {
    orderRepository.save(order);
}

public void sendEmailNotification(String email, String subject, String content) {
    emailService.send(email, subject, content);
}

public void logUserActivity(String userId, String action) {
    logger.info("User {} performed action: {}", userId, action);
}
```

---

## Task 7: Rename mixed-purpose methods

**Before:**
```java
public double processAndGetTotal(Order order)  // Mixed purpose
public void validateAndSave(User user)         // Mixed purpose
public boolean checkAndUpdate(Product product) // Mixed purpose
```

**After:**
```java
public double calculateOrderTotal(Order order)  // Query only
public void saveUser(User user)                 // Command only
public boolean isProductAvailable(Product product) // Query only
```

---

## Task 8: Convert imperative logic to declarative helper methods

**Before:**
```java
public List<Order> getUrgentOrders(List<Order> orders) {
    List<Order> urgentOrders = new ArrayList<>();
    for (Order order : orders) {
        if (order.getPriority().equals("HIGH") && 
            order.getStatus().equals("PENDING") &&
            order.getCreatedDate().isBefore(LocalDateTime.now().minusHours(24))) {
            urgentOrders.add(order);
        }
    }
    return urgentOrders;
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

## Task 9: Review methods with multiple return types

**Before:**
```java
public Object processOrder(Order order) {
    if (order.getItems().isEmpty()) {
        return "ERROR: Order has no items";
    }
    if (order.getTotal() > 10000) {
        return new ApprovalRequest(order);
    }
    return orderRepository.save(order);
}
```

**After:**
```java
public OrderProcessingResult processOrder(Order order) {
    if (order.getItems().isEmpty()) {
        return OrderProcessingResult.error("Order has no items");
    }
    if (order.getTotal() > 10000) {
        return OrderProcessingResult.requiresApproval(order);
    }
    Order savedOrder = orderRepository.save(order);
    return OrderProcessingResult.success(savedOrder);
}
```

---

## Task 10: Practice early returns (guard clauses)

**Before:**
```java
public double calculateDiscount(Order order) {
    double discount = 0;
    if (order != null) {
        if (order.getCustomer() != null) {
            if (order.getCustomer().isVip()) {
                if (order.getTotal() > 1000) {
                    discount = order.getTotal() * 0.15;
                } else {
                    discount = order.getTotal() * 0.10;
                }
            } else {
                if (order.getTotal() > 500) {
                    discount = order.getTotal() * 0.05;
                }
            }
        }
    }
    return discount;
}
```

**After:**
```java
public double calculateDiscount(Order order) {
    if (order == null) return 0;
    if (order.getCustomer() == null) return 0;
    
    if (order.getCustomer().isVip()) {
        return calculateVipDiscount(order);
    }
    
    return calculateRegularDiscount(order);
}

private double calculateVipDiscount(Order order) {
    return order.getTotal() > 1000 ? order.getTotal() * 0.15 : order.getTotal() * 0.10;
}

private double calculateRegularDiscount(Order order) {
    return order.getTotal() > 500 ? order.getTotal() * 0.05 : 0;
}
```

## Key Takeaways for Tasks 1-10

1. **Single Responsibility**: Each function should do one thing well
2. **Command-Query Separation**: Separate actions from queries
3. **Extract Helpers**: Break complex logic into smaller functions
4. **Early Returns**: Use guard clauses to reduce nesting
5. **Descriptive Names**: Function names should reveal intent
6. **Stream API**: Use functional programming for cleaner loops
7. **Result Objects**: Use proper return types instead of mixed types
8. **Validation First**: Validate inputs early and fail fast

Remember: Clean functions make clean classes, and clean classes make clean systems! 
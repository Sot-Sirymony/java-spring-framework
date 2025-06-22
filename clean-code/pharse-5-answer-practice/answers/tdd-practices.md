# Section 1: TDD (Test-Driven Development) - 25 Tasks

## 🎯 TDD Core Principles

**Red-Green-Refactor Cycle:**
1. **Red**: Write a failing test
2. **Green**: Write minimal code to make test pass
3. **Refactor**: Clean up code while keeping tests green

---

## 1. Write a failing test before writing the implementation

**Example: Simple Calculator Addition**

```java
// Step 1: Write failing test first
@Test
void shouldReturnSum_whenAddingTwoNumbers() {
    // Arrange
    Calculator calculator = new Calculator();
    
    // Act
    int result = calculator.add(2, 3);
    
    // Assert
    assertEquals(5, result);
}
```

**Result:** Test fails because `Calculator` class doesn't exist yet.

---

## 2. Use red-green-refactor to develop a simple calculator class

**Step 1: Red (Failing Test)**
```java
@Test
void shouldReturnSum_whenAddingTwoNumbers() {
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
}
```

**Step 2: Green (Minimal Implementation)**
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

**Step 3: Refactor (Clean Code)**
```java
public class Calculator {
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
```

---

## 3. Build a UserService class entirely using TDD

**Test 1: User Creation**
```java
@Test
void shouldCreateUser_whenValidUserDataProvided() {
    // Arrange
    UserService userService = new UserService();
    String username = "john_doe";
    String email = "john@example.com";
    
    // Act
    User user = userService.createUser(username, email);
    
    // Assert
    assertNotNull(user);
    assertEquals(username, user.getUsername());
    assertEquals(email, user.getEmail());
}
```

**Implementation:**
```java
public class UserService {
    public User createUser(String username, String email) {
        return new User(username, email);
    }
}
```

**Test 2: User Validation**
```java
@Test
void shouldThrowException_whenUsernameIsEmpty() {
    // Arrange
    UserService userService = new UserService();
    
    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
        userService.createUser("", "john@example.com");
    });
}
```

---

## 4. Refactor legacy code by first writing a test that breaks, then fixing it

**Legacy Code:**
```java
public class LegacyCalculator {
    public int divide(int a, int b) {
        return a / b; // No null check, no division by zero handling
    }
}
```

**Test that breaks:**
```java
@Test
void shouldThrowException_whenDividingByZero() {
    LegacyCalculator calculator = new LegacyCalculator();
    
    assertThrows(ArithmeticException.class, () -> {
        calculator.divide(10, 0);
    });
}
```

**Fixed Implementation:**
```java
public class LegacyCalculator {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
```

---

## 5. Create a ToDoList app using TDD from start to finish

**Test 1: Add Todo Item**
```java
@Test
void shouldAddTodoItem_whenValidItemProvided() {
    // Arrange
    TodoList todoList = new TodoList();
    String item = "Buy groceries";
    
    // Act
    todoList.addItem(item);
    
    // Assert
    assertTrue(todoList.hasItem(item));
    assertEquals(1, todoList.getItemCount());
}
```

**Implementation:**
```java
public class TodoList {
    private List<String> items = new ArrayList<>();
    
    public void addItem(String item) {
        items.add(item);
    }
    
    public boolean hasItem(String item) {
        return items.contains(item);
    }
    
    public int getItemCount() {
        return items.size();
    }
}
```

**Test 2: Remove Todo Item**
```java
@Test
void shouldRemoveTodoItem_whenItemExists() {
    // Arrange
    TodoList todoList = new TodoList();
    String item = "Buy groceries";
    todoList.addItem(item);
    
    // Act
    todoList.removeItem(item);
    
    // Assert
    assertFalse(todoList.hasItem(item));
    assertEquals(0, todoList.getItemCount());
}
```

---

## 6. Use TDD to implement a feature with validation logic

**Test 1: Valid Email**
```java
@Test
void shouldReturnTrue_whenValidEmailProvided() {
    // Arrange
    EmailValidator validator = new EmailValidator();
    String validEmail = "test@example.com";
    
    // Act
    boolean isValid = validator.isValid(validEmail);
    
    // Assert
    assertTrue(isValid);
}
```

**Test 2: Invalid Email**
```java
@Test
void shouldReturnFalse_whenInvalidEmailProvided() {
    // Arrange
    EmailValidator validator = new EmailValidator();
    String invalidEmail = "invalid-email";
    
    // Act
    boolean isValid = validator.isValid(invalidEmail);
    
    // Assert
    assertFalse(isValid);
}
```

**Implementation:**
```java
public class EmailValidator {
    public boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
}
```

---

## 7. Avoid writing extra logic until a test requires it (YAGNI in TDD)

**Example: Don't add features until needed**

```java
// Only write tests for current requirements
@Test
void shouldCalculateBasicTax() {
    TaxCalculator calculator = new TaxCalculator();
    double tax = calculator.calculateTax(100.0);
    assertEquals(10.0, tax, 0.01);
}

// Don't write this test yet - it's not required
// @Test
// void shouldCalculateTaxWithDeductions() { ... }
```

---

## 8. Refactor production code only when all tests are passing

**Before Refactoring:**
```java
public class UserService {
    public User createUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        return user;
    }
}
```

**After Refactoring (with tests still passing):**
```java
public class UserService {
    public User createUser(String username, String email) {
        return User.builder()
                  .username(username)
                  .email(email)
                  .build();
    }
}
```

---

## 9. Apply TDD to an algorithm (e.g., palindrome checker)

**Test 1: Simple Palindrome**
```java
@Test
void shouldReturnTrue_whenPalindromeProvided() {
    // Arrange
    PalindromeChecker checker = new PalindromeChecker();
    
    // Act & Assert
    assertTrue(checker.isPalindrome("racecar"));
    assertTrue(checker.isPalindrome("mom"));
    assertTrue(checker.isPalindrome(""));
}
```

**Test 2: Non-Palindrome**
```java
@Test
void shouldReturnFalse_whenNonPalindromeProvided() {
    // Arrange
    PalindromeChecker checker = new PalindromeChecker();
    
    // Act & Assert
    assertFalse(checker.isPalindrome("hello"));
    assertFalse(checker.isPalindrome("java"));
}
```

**Implementation:**
```java
public class PalindromeChecker {
    public boolean isPalindrome(String text) {
        if (text == null) return false;
        
        String cleaned = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);
    }
}
```

---

## 10. Simulate an API call and write failing tests first

**Test: API Response Handling**
```java
@Test
void shouldReturnUserData_whenApiCallSucceeds() {
    // Arrange
    UserApiClient apiClient = new UserApiClient();
    
    // Act
    User user = apiClient.getUserById(1);
    
    // Assert
    assertNotNull(user);
    assertEquals("John Doe", user.getName());
}
```

**Implementation:**
```java
public class UserApiClient {
    public User getUserById(int id) {
        // Simulate API call
        if (id == 1) {
            return new User("John Doe", "john@example.com");
        }
        throw new UserNotFoundException("User not found");
    }
}
```

---

## 11. Refactor code to remove duplication only after tests pass

**Before Refactoring (with duplication):**
```java
public class OrderProcessor {
    public double calculateTax(Order order) {
        double subtotal = order.getSubtotal();
        return subtotal * 0.1; // 10% tax
    }
    
    public double calculateTotal(Order order) {
        double subtotal = order.getSubtotal();
        double tax = subtotal * 0.1; // Duplicated tax calculation
        return subtotal + tax;
    }
}
```

**After Refactoring (tests still pass):**
```java
public class OrderProcessor {
    private static final double TAX_RATE = 0.1;
    
    public double calculateTax(Order order) {
        return order.getSubtotal() * TAX_RATE;
    }
    
    public double calculateTotal(Order order) {
        double subtotal = order.getSubtotal();
        double tax = calculateTax(order); // Reuse existing method
        return subtotal + tax;
    }
}
```

---

## 12. Use TDD to develop a domain class (e.g., Invoice, BankAccount)

**Test: Bank Account Operations**
```java
@Test
void shouldDepositMoney_whenValidAmountProvided() {
    // Arrange
    BankAccount account = new BankAccount("12345", 100.0);
    
    // Act
    account.deposit(50.0);
    
    // Assert
    assertEquals(150.0, account.getBalance(), 0.01);
}
```

**Test: Insufficient Funds**
```java
@Test
void shouldThrowException_whenWithdrawingMoreThanBalance() {
    // Arrange
    BankAccount account = new BankAccount("12345", 100.0);
    
    // Act & Assert
    assertThrows(InsufficientFundsException.class, () -> {
        account.withdraw(150.0);
    });
}
```

**Implementation:**
```java
public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
}
```

---

## 13. Write tests using only interfaces, not implementations

**Interface:**
```java
public interface UserRepository {
    User findById(int id);
    void save(User user);
    List<User> findAll();
}
```

**Test using interface:**
```java
@Test
void shouldReturnUser_whenUserExists() {
    // Arrange
    UserRepository repository = new InMemoryUserRepository(); // Implementation
    User expectedUser = new User("John", "john@example.com");
    repository.save(expectedUser);
    
    // Act
    User actualUser = repository.findById(1);
    
    // Assert
    assertEquals(expectedUser.getName(), actualUser.getName());
}
```

---

## 14. Add a new feature without breaking any existing tests

**Existing Test:**
```java
@Test
void shouldCalculateBasicTax() {
    TaxCalculator calculator = new TaxCalculator();
    double tax = calculator.calculateTax(100.0);
    assertEquals(10.0, tax, 0.01);
}
```

**New Feature Test:**
```java
@Test
void shouldApplyDiscount_whenEligible() {
    TaxCalculator calculator = new TaxCalculator();
    double total = calculator.calculateTotalWithDiscount(100.0, true);
    assertEquals(95.0, total, 0.01); // 5% discount
}
```

**Implementation (existing method unchanged):**
```java
public class TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.1; // Existing method unchanged
    }
    
    public double calculateTotalWithDiscount(double amount, boolean eligibleForDiscount) {
        double tax = calculateTax(amount);
        double total = amount + tax;
        
        if (eligibleForDiscount) {
            total *= 0.95; // 5% discount
        }
        
        return total;
    }
}
```

---

## 15. Use parameterized tests to cover multiple scenarios in TDD

```java
@ParameterizedTest
@CsvSource({
    "racecar, true",
    "mom, true",
    "hello, false",
    "A man a plan a canal Panama, true",
    "'', true"
})
void shouldCheckPalindrome(String input, boolean expected) {
    // Arrange
    PalindromeChecker checker = new PalindromeChecker();
    
    // Act
    boolean result = checker.isPalindrome(input);
    
    // Assert
    assertEquals(expected, result);
}
```

---

## 16. Write a failing integration test, then make the system pass it

**Integration Test:**
```java
@Test
void shouldProcessOrderEndToEnd() {
    // Arrange
    OrderService orderService = new OrderService();
    UserService userService = new UserService();
    PaymentService paymentService = new PaymentService();
    
    User user = userService.createUser("john", "john@example.com");
    Order order = new Order(user.getId(), Arrays.asList("item1", "item2"));
    
    // Act
    OrderResult result = orderService.processOrder(order);
    
    // Assert
    assertTrue(result.isSuccess());
    assertNotNull(result.getOrderId());
}
```

---

## 17. Use TDD to add logging behavior only when required

**Test: Logging Requirement**
```java
@Test
void shouldLogUserCreation_whenUserIsCreated() {
    // Arrange
    Logger mockLogger = mock(Logger.class);
    UserService userService = new UserService(mockLogger);
    
    // Act
    userService.createUser("john", "john@example.com");
    
    // Assert
    verify(mockLogger).info("User created: john");
}
```

---

## 18. Track coverage increase after TDD-based changes

**Before TDD:**
- Line Coverage: 45%
- Branch Coverage: 30%

**After TDD:**
- Line Coverage: 95%
- Branch Coverage: 90%

**Tools:**
- JaCoCo for coverage reporting
- IDE coverage tools
- CI/CD pipeline integration

---

## 19. Apply TDD to a collection class (Stack, Queue, etc.)

**Test: Stack Operations**
```java
@Test
void shouldPushAndPopElements() {
    // Arrange
    Stack<String> stack = new Stack<>();
    
    // Act
    stack.push("first");
    stack.push("second");
    
    // Assert
    assertEquals("second", stack.pop());
    assertEquals("first", stack.pop());
    assertTrue(stack.isEmpty());
}
```

**Implementation:**
```java
public class Stack<T> {
    private List<T> elements = new ArrayList<>();
    
    public void push(T element) {
        elements.add(element);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
```

---

## 20. Use mocks/stubs within TDD to isolate dependencies

**Test with Mock:**
```java
@Test
void shouldSendEmail_whenUserRegisters() {
    // Arrange
    EmailService mockEmailService = mock(EmailService.class);
    UserService userService = new UserService(mockEmailService);
    
    // Act
    userService.registerUser("john", "john@example.com");
    
    // Assert
    verify(mockEmailService).sendWelcomeEmail("john@example.com");
}
```

---

## 21. Avoid "over-mocking" during TDD cycles

**Good (minimal mocking):**
```java
@Test
void shouldCalculateTotalWithTax() {
    // Arrange
    TaxCalculator calculator = new TaxCalculator();
    Order order = new Order(100.0);
    
    // Act
    double total = calculator.calculateTotal(order);
    
    // Assert
    assertEquals(110.0, total, 0.01);
}
```

**Bad (over-mocking):**
```java
@Test
void shouldCalculateTotalWithTax() {
    // Arrange
    Order mockOrder = mock(Order.class);
    when(mockOrder.getSubtotal()).thenReturn(100.0);
    TaxCalculator calculator = new TaxCalculator();
    
    // Act
    double total = calculator.calculateTotal(mockOrder);
    
    // Assert
    assertEquals(110.0, total, 0.01);
}
```

---

## 22. Compare writing tests before vs. after: Which helped more?

**Writing Tests Before (TDD):**
- ✅ Forces you to think about the interface first
- ✅ Ensures 100% test coverage
- ✅ Prevents over-engineering
- ✅ Makes refactoring safer

**Writing Tests After:**
- ❌ May miss edge cases
- ❌ Tests might be biased toward implementation
- ❌ Risk of not writing tests at all

---

## 23. Use TDD to validate exception-throwing behavior

```java
@Test
void shouldThrowException_whenInvalidInputProvided() {
    // Arrange
    Calculator calculator = new Calculator();
    
    // Act & Assert
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.divide(10, 0)
    );
    
    assertEquals("Cannot divide by zero", exception.getMessage());
}
```

---

## 24. Log your red-green-refactor cycles for a feature

**Example Log:**
```
Feature: User Registration
- Red: Test for user creation fails
- Green: Basic user creation works
- Refactor: Extract validation logic
- Red: Test for email validation fails
- Green: Email validation implemented
- Refactor: Clean up validation methods
```

---

## 25. Reflect: Did you write less or more code with TDD?

**TDD Benefits:**
- **Less Code**: Only write what's needed (YAGNI)
- **Better Design**: Interface-first approach
- **Higher Quality**: Tests catch bugs early
- **Easier Maintenance**: Tests serve as documentation

**TDD Challenges:**
- **Learning Curve**: Takes time to master
- **Initial Slower**: Writing tests first takes time
- **Discipline Required**: Must follow the cycle consistently

---

## 🎯 TDD Best Practices Summary

1. **Always write the test first**
2. **Keep tests simple and focused**
3. **Refactor only when tests are green**
4. **Use descriptive test names**
5. **Avoid over-engineering**
6. **Mock external dependencies, not internal collaborators**
7. **Keep the red-green-refactor cycle short**
8. **Write tests that express intent, not implementation**

---

**Next Section: Unit vs Integration Testing** 
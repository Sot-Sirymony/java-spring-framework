# Section 3: Clean Test Structure (AAA: Arrange-Act-Assert) - 15 Tasks

## 🎯 AAA Pattern Overview

**AAA (Arrange-Act-Assert)** is a pattern for organizing test code:
- **Arrange**: Set up test data and conditions
- **Act**: Execute the method being tested
- **Assert**: Verify the results

---

## 46. Structure your test with clear sections: arrange, act, assert

```java
@Test
void shouldReturnUser_whenValidIdProvided() {
    // Arrange
    UserRepository userRepository = new InMemoryUserRepository();
    User expectedUser = new User("john_doe", "john@example.com");
    userRepository.save(expectedUser);
    UserService userService = new UserService(userRepository);
    
    // Act
    User actualUser = userService.findById(expectedUser.getId());
    
    // Assert
    assertNotNull(actualUser);
    assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    assertEquals(expectedUser.getEmail(), actualUser.getEmail());
}
```

---

## 47. Comment each AAA block in 3 existing test cases

```java
@Test
void shouldCalculateTotal_whenValidOrderProvided() {
    // Arrange - Set up test data
    Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
    TaxCalculator calculator = new TaxCalculator();
    
    // Act - Execute the method under test
    double total = calculator.calculateTotal(order);
    
    // Assert - Verify the expected result
    assertEquals(110.0, total, 0.01);
}

@Test
void shouldThrowException_whenInvalidEmailProvided() {
    // Arrange - Set up invalid test data
    EmailValidator validator = new EmailValidator();
    String invalidEmail = "invalid-email";
    
    // Act & Assert - Execute and verify exception
    assertThrows(IllegalArgumentException.class, () -> {
        validator.validate(invalidEmail);
    });
}

@Test
void shouldSendEmail_whenUserRegisters() {
    // Arrange - Set up mocks and test data
    EmailService mockEmailService = mock(EmailService.class);
    UserService userService = new UserService(mockEmailService);
    String email = "john@example.com";
    
    // Act - Execute the method under test
    userService.registerUser("john_doe", email);
    
    // Assert - Verify the expected behavior
    verify(mockEmailService).sendWelcomeEmail(email);
}
```

---

## 48. Refactor a messy test into clean AAA format

**Before (Messy Test):**
```java
@Test
void testUserCreation() {
    UserService service = new UserService();
    User user = service.createUser("john", "john@example.com");
    assertNotNull(user);
    assertEquals("john", user.getUsername());
    assertEquals("john@example.com", user.getEmail());
    User anotherUser = service.createUser("jane", "jane@example.com");
    assertNotNull(anotherUser);
    assertEquals("jane", anotherUser.getUsername());
}
```

**After (Clean AAA Format):**
```java
@Test
void shouldCreateUser_whenValidDataProvided() {
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

@Test
void shouldCreateMultipleUsers_whenValidDataProvided() {
    // Arrange
    UserService userService = new UserService();
    String username1 = "john_doe";
    String email1 = "john@example.com";
    String username2 = "jane_doe";
    String email2 = "jane@example.com";
    
    // Act
    User user1 = userService.createUser(username1, email1);
    User user2 = userService.createUser(username2, email2);
    
    // Assert
    assertNotNull(user1);
    assertEquals(username1, user1.getUsername());
    assertEquals(email1, user1.getEmail());
    
    assertNotNull(user2);
    assertEquals(username2, user2.getUsername());
    assertEquals(email2, user2.getEmail());
}
```

---

## 49. Use a helper method to arrange test data cleanly

```java
class UserServiceTest {
    
    private UserService userService;
    private UserRepository userRepository;
    
    @BeforeEach
    void setUp() {
        userRepository = new InMemoryUserRepository();
        userService = new UserService(userRepository);
    }
    
    // Helper method for arranging test data
    private User createTestUser(String username, String email) {
        User user = new User(username, email);
        return userRepository.save(user);
    }
    
    // Helper method for creating multiple test users
    private List<User> createTestUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(createTestUser("user" + i, "user" + i + "@example.com"));
        }
        return users;
    }
    
    @Test
    void shouldFindUser_whenUserExists() {
        // Arrange - Using helper method
        User expectedUser = createTestUser("john_doe", "john@example.com");
        
        // Act
        User actualUser = userService.findById(expectedUser.getId());
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }
    
    @Test
    void shouldReturnAllUsers_whenMultipleUsersExist() {
        // Arrange - Using helper method
        List<User> expectedUsers = createTestUsers(3);
        
        // Act
        List<User> actualUsers = userService.findAll();
        
        // Assert
        assertEquals(expectedUsers.size(), actualUsers.size());
    }
}
```

---

## 50. Avoid logic in `assert` statements — keep them clear

**Bad (Logic in Assert):**
```java
@Test
void shouldCalculateTotal() {
    // Arrange
    Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
    TaxCalculator calculator = new TaxCalculator();
    
    // Act
    double total = calculator.calculateTotal(order);
    
    // Assert - Logic in assertion
    assertTrue(total == order.getSubtotal() * 1.1);
}
```

**Good (Clear Assertions):**
```java
@Test
void shouldCalculateTotal_whenValidOrderProvided() {
    // Arrange
    Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
    TaxCalculator calculator = new TaxCalculator();
    double expectedTotal = 110.0; // 100 + 10% tax
    
    // Act
    double actualTotal = calculator.calculateTotal(order);
    
    // Assert - Clear, simple assertions
    assertEquals(expectedTotal, actualTotal, 0.01);
}

@Test
void shouldCalculateTax_whenValidOrderProvided() {
    // Arrange
    Order order = new Order(Arrays.asList("item1"), 100.0);
    TaxCalculator calculator = new TaxCalculator();
    double expectedTax = 10.0; // 10% of 100
    
    // Act
    double actualTax = calculator.calculateTax(order);
    
    // Assert - Clear, simple assertions
    assertEquals(expectedTax, actualTax, 0.01);
}
```

---

## 51. Use the `Given/When/Then` structure if using BDD style

```java
@Test
void shouldCreateUser_whenValidDataProvided() {
    // Given - A user service and valid user data
    UserService userService = new UserService();
    String username = "john_doe";
    String email = "john@example.com";
    
    // When - Creating a user
    User user = userService.createUser(username, email);
    
    // Then - The user should be created with correct data
    assertNotNull(user);
    assertEquals(username, user.getUsername());
    assertEquals(email, user.getEmail());
}

@Test
void shouldThrowException_whenInvalidEmailProvided() {
    // Given - A user service and invalid email
    UserService userService = new UserService();
    String invalidEmail = "invalid-email";
    
    // When & Then - Creating user should throw exception
    assertThrows(IllegalArgumentException.class, () -> {
        userService.createUser("john_doe", invalidEmail);
    });
}
```

---

## 52. Avoid using test data in the act/assert phases

**Bad (Test Data in Act/Assert):**
```java
@Test
void shouldCalculateTotal() {
    // Arrange
    Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
    TaxCalculator calculator = new TaxCalculator();
    
    // Act - Creating new data during execution
    double total = calculator.calculateTotal(order);
    
    // Assert - Using magic numbers
    assertEquals(110.0, total, 0.01);
}
```

**Good (All Test Data in Arrange):**
```java
@Test
void shouldCalculateTotal_whenValidOrderProvided() {
    // Arrange - All test data defined here
    List<String> items = Arrays.asList("item1", "item2");
    double subtotal = 100.0;
    double taxRate = 0.1;
    double expectedTotal = subtotal * (1 + taxRate);
    
    Order order = new Order(items, subtotal);
    TaxCalculator calculator = new TaxCalculator();
    
    // Act - Only execution, no new data
    double actualTotal = calculator.calculateTotal(order);
    
    // Assert - Using arranged data
    assertEquals(expectedTotal, actualTotal, 0.01);
}
```

---

## 53. Write tests where each test case has one assert block (if possible)

```java
class UserServiceTest {
    
    @Test
    void shouldCreateUser_whenValidDataProvided() {
        // Arrange
        UserService userService = new UserService();
        String username = "john_doe";
        String email = "john@example.com";
        
        // Act
        User user = userService.createUser(username, email);
        
        // Assert - Single assertion block
        assertAll(
            () -> assertNotNull(user),
            () -> assertEquals(username, user.getUsername()),
            () -> assertEquals(email, user.getEmail())
        );
    }
    
    @Test
    void shouldReturnNotNull_whenUserCreated() {
        // Arrange
        UserService userService = new UserService();
        
        // Act
        User user = userService.createUser("john", "john@example.com");
        
        // Assert - Single assertion
        assertNotNull(user);
    }
    
    @Test
    void shouldSetCorrectUsername_whenUserCreated() {
        // Arrange
        UserService userService = new UserService();
        String expectedUsername = "john_doe";
        
        // Act
        User user = userService.createUser(expectedUsername, "john@example.com");
        
        // Assert - Single assertion
        assertEquals(expectedUsername, user.getUsername());
    }
}
```

---

## 54. Group similar assertions using `assertAll()`

```java
@Test
void shouldCreateUserWithAllProperties_whenValidDataProvided() {
    // Arrange
    UserService userService = new UserService();
    String username = "john_doe";
    String email = "john@example.com";
    
    // Act
    User user = userService.createUser(username, email);
    
    // Assert - Grouped assertions
    assertAll("User creation",
        () -> assertNotNull(user, "User should not be null"),
        () -> assertEquals(username, user.getUsername(), "Username should match"),
        () -> assertEquals(email, user.getEmail(), "Email should match"),
        () -> assertNotNull(user.getId(), "User ID should be generated"),
        () -> assertNotNull(user.getCreatedAt(), "Created date should be set")
    );
}

@Test
void shouldValidateOrder_whenValidOrderProvided() {
    // Arrange
    Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
    OrderValidator validator = new OrderValidator();
    
    // Act
    ValidationResult result = validator.validate(order);
    
    // Assert - Grouped assertions
    assertAll("Order validation",
        () -> assertTrue(result.isValid(), "Order should be valid"),
        () -> assertTrue(result.getErrors().isEmpty(), "No errors should be present"),
        () -> assertEquals("VALID", result.getStatus(), "Status should be VALID")
    );
}
```

---

## 55. Use descriptive variables like `actual`, `expected`, `inputValue`

```java
@Test
void shouldCalculateTax_whenValidAmountProvided() {
    // Arrange
    double inputAmount = 100.0;
    double expectedTax = 10.0; // 10% tax rate
    TaxCalculator calculator = new TaxCalculator();
    
    // Act
    double actualTax = calculator.calculateTax(inputAmount);
    
    // Assert
    assertEquals(expectedTax, actualTax, 0.01);
}

@Test
void shouldReturnUser_whenValidIdProvided() {
    // Arrange
    UserRepository userRepository = new InMemoryUserRepository();
    User expectedUser = new User("john_doe", "john@example.com");
    userRepository.save(expectedUser);
    UserService userService = new UserService(userRepository);
    
    // Act
    User actualUser = userService.findById(expectedUser.getId());
    
    // Assert
    assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    assertEquals(expectedUser.getEmail(), actualUser.getEmail());
}

@Test
void shouldValidateEmail_whenValidEmailProvided() {
    // Arrange
    String inputEmail = "test@example.com";
    boolean expectedResult = true;
    EmailValidator validator = new EmailValidator();
    
    // Act
    boolean actualResult = validator.isValid(inputEmail);
    
    // Assert
    assertEquals(expectedResult, actualResult);
}
```

---

## 56. Don't assert implementation details (e.g., private fields)

**Bad (Asserting Implementation Details):**
```java
@Test
void shouldCreateUser() {
    // Arrange
    UserService userService = new UserService();
    
    // Act
    User user = userService.createUser("john", "john@example.com");
    
    // Assert - Testing implementation details
    assertNotNull(user.getId()); // Implementation detail
    assertNotNull(user.getCreatedAt()); // Implementation detail
    assertEquals("ACTIVE", user.getStatus()); // Implementation detail
}
```

**Good (Asserting Behavior):**
```java
@Test
void shouldCreateUser_whenValidDataProvided() {
    // Arrange
    UserService userService = new UserService();
    String username = "john_doe";
    String email = "john@example.com";
    
    // Act
    User user = userService.createUser(username, email);
    
    // Assert - Testing behavior, not implementation
    assertNotNull(user);
    assertEquals(username, user.getUsername());
    assertEquals(email, user.getEmail());
}

@Test
void shouldReturnUser_whenUserExists() {
    // Arrange
    UserService userService = new UserService();
    User createdUser = userService.createUser("john", "john@example.com");
    
    // Act
    User retrievedUser = userService.findById(createdUser.getId());
    
    // Assert - Testing behavior
    assertNotNull(retrievedUser);
    assertEquals(createdUser.getUsername(), retrievedUser.getUsername());
}
```

---

## 57. Avoid unnecessary test setup—only arrange what you need

**Bad (Unnecessary Setup):**
```java
@Test
void shouldCalculateTax() {
    // Arrange - Unnecessary setup
    UserRepository userRepository = new InMemoryUserRepository();
    EmailService emailService = new EmailService();
    PaymentService paymentService = new PaymentService();
    UserService userService = new UserService(userRepository, emailService, paymentService);
    
    // Create unnecessary test data
    userService.createUser("john", "john@example.com");
    userService.createUser("jane", "jane@example.com");
    
    // Actual test
    TaxCalculator calculator = new TaxCalculator();
    double tax = calculator.calculateTax(100.0);
    
    assertEquals(10.0, tax, 0.01);
}
```

**Good (Minimal Setup):**
```java
@Test
void shouldCalculateTax_whenValidAmountProvided() {
    // Arrange - Only what's needed
    TaxCalculator calculator = new TaxCalculator();
    double inputAmount = 100.0;
    double expectedTax = 10.0;
    
    // Act
    double actualTax = calculator.calculateTax(inputAmount);
    
    // Assert
    assertEquals(expectedTax, actualTax, 0.01);
}
```

---

## 58. Create a utility class for test fixtures

```java
public class TestFixtures {
    
    public static User createValidUser() {
        return new User("john_doe", "john@example.com");
    }
    
    public static User createValidUser(String username, String email) {
        return new User(username, email);
    }
    
    public static Order createValidOrder() {
        return new Order(Arrays.asList("item1", "item2"), 100.0);
    }
    
    public static Order createValidOrder(double total) {
        return new Order(Arrays.asList("item1"), total);
    }
    
    public static List<User> createMultipleUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User("user" + i, "user" + i + "@example.com"));
        }
        return users;
    }
    
    public static CreateUserRequest createValidUserRequest() {
        return new CreateUserRequest("john_doe", "john@example.com");
    }
    
    public static CreateUserRequest createValidUserRequest(String username, String email) {
        return new CreateUserRequest(username, email);
    }
}
```

**Using Test Fixtures:**
```java
class UserServiceTest {
    
    @Test
    void shouldCreateUser_whenValidDataProvided() {
        // Arrange - Using test fixtures
        UserService userService = new UserService();
        User expectedUser = TestFixtures.createValidUser();
        
        // Act
        User actualUser = userService.createUser(
            expectedUser.getUsername(), 
            expectedUser.getEmail()
        );
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }
    
    @Test
    void shouldCreateMultipleUsers_whenValidDataProvided() {
        // Arrange - Using test fixtures
        UserService userService = new UserService();
        List<User> expectedUsers = TestFixtures.createMultipleUsers(3);
        
        // Act
        List<User> actualUsers = new ArrayList<>();
        for (User expectedUser : expectedUsers) {
            actualUsers.add(userService.createUser(
                expectedUser.getUsername(), 
                expectedUser.getEmail()
            ));
        }
        
        // Assert
        assertEquals(expectedUsers.size(), actualUsers.size());
    }
}
```

---

## 59. Use builder patterns to create complex test inputs

```java
public class UserBuilder {
    private String username = "default_user";
    private String email = "default@example.com";
    private String firstName = "Default";
    private String lastName = "User";
    private boolean active = true;
    
    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }
    
    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    
    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public UserBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }
    
    public User build() {
        return new User(username, email, firstName, lastName, active);
    }
}
```

**Using Builder Pattern:**
```java
class UserServiceTest {
    
    @Test
    void shouldCreateUser_whenValidDataProvided() {
        // Arrange - Using builder pattern
        User expectedUser = new UserBuilder()
            .withUsername("john_doe")
            .withEmail("john@example.com")
            .withFirstName("John")
            .withLastName("Doe")
            .withActive(true)
            .build();
            
        UserService userService = new UserService();
        
        // Act
        User actualUser = userService.createUser(
            expectedUser.getUsername(), 
            expectedUser.getEmail()
        );
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }
    
    @Test
    void shouldCreateInactiveUser_whenInactiveFlagSet() {
        // Arrange - Using builder pattern
        User expectedUser = new UserBuilder()
            .withUsername("inactive_user")
            .withEmail("inactive@example.com")
            .withActive(false)
            .build();
            
        UserService userService = new UserService();
        
        // Act
        User actualUser = userService.createUser(
            expectedUser.getUsername(), 
            expectedUser.getEmail()
        );
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertFalse(actualUser.isActive());
    }
}
```

---

## 60. Highlight AAA visually in your code editor with formatting/comments

```java
@Test
void shouldCalculateTotalWithTax_whenValidOrderProvided() {
    // ==================== ARRANGE ====================
    List<String> items = Arrays.asList("item1", "item2");
    double subtotal = 100.0;
    double taxRate = 0.1;
    double expectedTotal = subtotal * (1 + taxRate);
    
    Order order = new Order(items, subtotal);
    TaxCalculator calculator = new TaxCalculator();
    
    // ===================== ACT =====================
    double actualTotal = calculator.calculateTotal(order);
    
    // ==================== ASSERT ====================
    assertEquals(expectedTotal, actualTotal, 0.01);
}

@Test
void shouldCreateUser_whenValidDataProvided() {
    // ARRANGE
    UserService userService = new UserService();
    String username = "john_doe";
    String email = "john@example.com";
    
    // ACT
    User user = userService.createUser(username, email);
    
    // ASSERT
    assertAll("User creation",
        () -> assertNotNull(user),
        () -> assertEquals(username, user.getUsername()),
        () -> assertEquals(email, user.getEmail())
    );
}

@Test
void shouldValidateEmail_whenValidEmailProvided() {
    /* ARRANGE */
    EmailValidator validator = new EmailValidator();
    String validEmail = "test@example.com";
    
    /* ACT */
    boolean isValid = validator.isValid(validEmail);
    
    /* ASSERT */
    assertTrue(isValid);
}
```

---

## 🎯 AAA Pattern Best Practices Summary

### Arrange:
- ✅ Set up all test data and conditions
- ✅ Use helper methods for complex setup
- ✅ Use builder patterns for complex objects
- ✅ Keep setup minimal and focused

### Act:
- ✅ Execute only the method being tested
- ✅ Avoid creating new data during execution
- ✅ Keep it simple and clear

### Assert:
- ✅ Verify the expected behavior
- ✅ Use descriptive variable names
- ✅ Group related assertions with `assertAll()`
- ✅ Avoid testing implementation details
- ✅ Keep assertions simple and clear

### General:
- ✅ Use consistent formatting and comments
- ✅ Follow naming conventions
- ✅ Keep tests focused on one behavior
- ✅ Make tests readable and maintainable

---

**Next Section: Mocking and Stubbing (JUnit + Mockito)** 
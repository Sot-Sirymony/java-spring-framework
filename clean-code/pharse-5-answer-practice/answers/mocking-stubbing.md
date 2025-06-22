# Section 4: Mocking and Stubbing (JUnit + Mockito) - 25 Tasks

## 🎯 Mocking Fundamentals

**Mocking** allows you to create fake objects that simulate real dependencies.

---

## 61. Mock a repository using `Mockito.mock()`

```java
@Test
void shouldReturnUser_whenUserExists() {
    // Arrange
    UserRepository mockRepository = Mockito.mock(UserRepository.class);
    User expectedUser = new User("john", "john@example.com");
    when(mockRepository.findById(1)).thenReturn(Optional.of(expectedUser));
    
    UserService userService = new UserService(mockRepository);
    
    // Act
    User actualUser = userService.findById(1);
    
    // Assert
    assertEquals(expectedUser.getUsername(), actualUser.getUsername());
}
```

---

## 62. Stub a method to return specific values using `when(...).thenReturn(...)`

```java
@Test
void shouldCalculateTotalWithTax() {
    // Arrange
    TaxService mockTaxService = mock(TaxService.class);
    when(mockTaxService.calculateTax(100.0)).thenReturn(10.0);
    
    OrderService orderService = new OrderService(mockTaxService);
    Order order = new Order(100.0);
    
    // Act
    double total = orderService.calculateTotal(order);
    
    // Assert
    assertEquals(110.0, total, 0.01);
}
```

---

## 63. Verify method calls using `Mockito.verify()`

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

## 64. Write a test that stubs and asserts interactions

```java
@Test
void shouldProcessOrderAndSendEmail() {
    // Arrange
    EmailService mockEmailService = mock(EmailService.class);
    PaymentService mockPaymentService = mock(PaymentService.class);
    
    when(mockPaymentService.processPayment(any(PaymentRequest.class)))
        .thenReturn(new PaymentResult("SUCCESS"));
    
    OrderService orderService = new OrderService(mockEmailService, mockPaymentService);
    Order order = new Order(100.0);
    
    // Act
    OrderResult result = orderService.processOrder(order);
    
    // Assert
    assertTrue(result.isSuccess());
    verify(mockPaymentService).processPayment(any(PaymentRequest.class));
    verify(mockEmailService).sendOrderConfirmation(order);
}
```

---

## 65. Inject mocks using `@Mock` and `@InjectMocks`

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private EmailService emailService;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    void shouldCreateUser_whenValidDataProvided() {
        // Arrange
        User expectedUser = new User("john", "john@example.com");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);
        
        // Act
        User actualUser = userService.createUser("john", "john@example.com");
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        verify(emailService).sendWelcomeEmail("john@example.com");
    }
}
```

---

## 66. Use `MockitoAnnotations.openMocks()` in setup

```java
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void shouldFindUser_whenUserExists() {
        // Arrange
        User expectedUser = new User("john", "john@example.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(expectedUser));
        
        // Act
        User actualUser = userService.findById(1);
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }
}
```

---

## 67. Mock a void method using `doNothing()` or `doThrow()`

```java
@Test
void shouldLogUserCreation_whenUserIsCreated() {
    // Arrange
    Logger mockLogger = mock(Logger.class);
    doNothing().when(mockLogger).info(anyString());
    
    UserService userService = new UserService(mockLogger);
    
    // Act
    userService.createUser("john", "john@example.com");
    
    // Assert
    verify(mockLogger).info("User created: john");
}

@Test
void shouldHandleLoggerFailure_whenLoggingFails() {
    // Arrange
    Logger mockLogger = mock(Logger.class);
    doThrow(new RuntimeException("Logging failed")).when(mockLogger).info(anyString());
    
    UserService userService = new UserService(mockLogger);
    
    // Act & Assert
    assertDoesNotThrow(() -> {
        userService.createUser("john", "john@example.com");
    });
}
```

---

## 68. Stub a method to throw an exception

```java
@Test
void shouldHandleRepositoryException_whenUserNotFound() {
    // Arrange
    UserRepository mockRepository = mock(UserRepository.class);
    when(mockRepository.findById(999)).thenThrow(new UserNotFoundException("User not found"));
    
    UserService userService = new UserService(mockRepository);
    
    // Act & Assert
    assertThrows(UserNotFoundException.class, () -> {
        userService.findById(999);
    });
}
```

---

## 69. Spy on a real object and stub one method only

```java
@Test
void shouldUseRealCalculationButMockedValidation() {
    // Arrange
    TaxCalculator realCalculator = new TaxCalculator();
    TaxCalculator spyCalculator = spy(realCalculator);
    
    // Stub only the validation method
    doReturn(true).when(spyCalculator).isValidAmount(anyDouble());
    
    // Act
    double tax = spyCalculator.calculateTax(100.0);
    
    // Assert
    assertEquals(10.0, tax, 0.01);
    verify(spyCalculator).isValidAmount(100.0);
}
```

---

## 70. Replace service logic with a mock for fast testing

```java
@Test
void shouldProcessOrderWithoutExternalServices() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    EmailService mockEmailService = mock(EmailService.class);
    InventoryService mockInventoryService = mock(InventoryService.class);
    
    when(mockPaymentService.processPayment(any())).thenReturn(new PaymentResult("SUCCESS"));
    when(mockInventoryService.checkAvailability(any())).thenReturn(true);
    
    OrderService orderService = new OrderService(
        mockPaymentService, 
        mockEmailService, 
        mockInventoryService
    );
    
    Order order = new Order(100.0);
    
    // Act
    OrderResult result = orderService.processOrder(order);
    
    // Assert
    assertTrue(result.isSuccess());
}
```

---

## 71. Refactor a test to use `@ExtendWith(MockitoExtension.class)`

```java
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    
    @Mock
    private PaymentService paymentService;
    
    @Mock
    private EmailService emailService;
    
    @InjectMocks
    private OrderService orderService;
    
    @Test
    void shouldProcessOrderSuccessfully() {
        // Arrange
        when(paymentService.processPayment(any())).thenReturn(new PaymentResult("SUCCESS"));
        Order order = new Order(100.0);
        
        // Act
        OrderResult result = orderService.processOrder(order);
        
        // Assert
        assertTrue(result.isSuccess());
        verify(emailService).sendOrderConfirmation(order);
    }
}
```

---

## 72. Avoid over-mocking: only mock what you don't control

**Good (Minimal Mocking):**
```java
@Test
void shouldCalculateTotalWithTax() {
    // Arrange
    TaxService mockTaxService = mock(TaxService.class); // External service
    when(mockTaxService.calculateTax(100.0)).thenReturn(10.0);
    
    OrderService orderService = new OrderService(mockTaxService);
    Order order = new Order(100.0); // Real object
    
    // Act
    double total = orderService.calculateTotal(order);
    
    // Assert
    assertEquals(110.0, total, 0.01);
}
```

**Bad (Over-Mocking):**
```java
@Test
void shouldCalculateTotalWithTax() {
    // Arrange
    TaxService mockTaxService = mock(TaxService.class);
    Order mockOrder = mock(Order.class); // Unnecessary mock
    when(mockOrder.getSubtotal()).thenReturn(100.0);
    when(mockTaxService.calculateTax(100.0)).thenReturn(10.0);
    
    OrderService orderService = new OrderService(mockTaxService);
    
    // Act
    double total = orderService.calculateTotal(mockOrder);
    
    // Assert
    assertEquals(110.0, total, 0.01);
}
```

---

## 73. Use `ArgumentCaptor` to capture passed arguments

```java
@Test
void shouldSendEmailWithCorrectContent() {
    // Arrange
    EmailService mockEmailService = mock(EmailService.class);
    ArgumentCaptor<EmailRequest> emailCaptor = ArgumentCaptor.forClass(EmailRequest.class);
    
    UserService userService = new UserService(mockEmailService);
    
    // Act
    userService.registerUser("john", "john@example.com");
    
    // Assert
    verify(mockEmailService).sendEmail(emailCaptor.capture());
    EmailRequest capturedEmail = emailCaptor.getValue();
    
    assertEquals("john@example.com", capturedEmail.getTo());
    assertEquals("Welcome!", capturedEmail.getSubject());
    assertTrue(capturedEmail.getBody().contains("john"));
}
```

---

## 74. Test a class that has external dependencies (email, DB, etc.)

```java
@Test
void shouldProcessOrderWithExternalDependencies() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    EmailService mockEmailService = mock(EmailService.class);
    DatabaseService mockDatabaseService = mock(DatabaseService.class);
    
    when(mockPaymentService.processPayment(any())).thenReturn(new PaymentResult("SUCCESS"));
    when(mockDatabaseService.saveOrder(any())).thenReturn("ORDER_123");
    
    OrderService orderService = new OrderService(
        mockPaymentService, 
        mockEmailService, 
        mockDatabaseService
    );
    
    Order order = new Order(100.0);
    
    // Act
    OrderResult result = orderService.processOrder(order);
    
    // Assert
    assertTrue(result.isSuccess());
    verify(mockDatabaseService).saveOrder(order);
    verify(mockEmailService).sendOrderConfirmation(order);
}
```

---

## 75. Use `thenThrow()` to simulate error conditions

```java
@Test
void shouldHandlePaymentFailure() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    when(mockPaymentService.processPayment(any()))
        .thenThrow(new PaymentFailedException("Insufficient funds"));
    
    OrderService orderService = new OrderService(mockPaymentService);
    Order order = new Order(100.0);
    
    // Act & Assert
    assertThrows(PaymentFailedException.class, () -> {
        orderService.processOrder(order);
    });
}
```

---

## 76. Mock a `RestTemplate` or HTTP client call

```java
@Test
void shouldCallExternalApi() {
    // Arrange
    RestTemplate mockRestTemplate = mock(RestTemplate.class);
    ApiResponse expectedResponse = new ApiResponse("SUCCESS", "Data retrieved");
    
    when(mockRestTemplate.getForObject(anyString(), eq(ApiResponse.class)))
        .thenReturn(expectedResponse);
    
    ExternalApiClient apiClient = new ExternalApiClient(mockRestTemplate);
    
    // Act
    ApiResponse actualResponse = apiClient.getData("endpoint");
    
    // Assert
    assertEquals("SUCCESS", actualResponse.getStatus());
    verify(mockRestTemplate).getForObject("endpoint", ApiResponse.class);
}
```

---

## 77. Avoid mocking `List`, `Map`, or value objects

**Good (No Mocking of Collections):**
```java
@Test
void shouldProcessOrderItems() {
    // Arrange
    List<String> items = Arrays.asList("item1", "item2"); // Real list
    Order order = new Order(items, 100.0);
    OrderService orderService = new OrderService();
    
    // Act
    int itemCount = orderService.getItemCount(order);
    
    // Assert
    assertEquals(2, itemCount);
}
```

**Bad (Unnecessary Mocking):**
```java
@Test
void shouldProcessOrderItems() {
    // Arrange
    List<String> mockItems = mock(List.class); // Unnecessary mock
    when(mockItems.size()).thenReturn(2);
    when(mockItems.get(0)).thenReturn("item1");
    when(mockItems.get(1)).thenReturn("item2");
    
    Order order = new Order(mockItems, 100.0);
    OrderService orderService = new OrderService();
    
    // Act
    int itemCount = orderService.getItemCount(order);
    
    // Assert
    assertEquals(2, itemCount);
}
```

---

## 78. Mock a static method using PowerMock (optional/advanced)

```java
@PrepareForTest(UtilityClass.class)
@PowerMockIgnore("javax.management.*")
class StaticMethodTest {
    
    @Test
    void shouldMockStaticMethod() {
        // Arrange
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.generateId()).thenReturn("MOCK_ID_123");
        
        // Act
        String result = UtilityClass.generateId();
        
        // Assert
        assertEquals("MOCK_ID_123", result);
    }
}
```

---

## 79. Assert interaction order using `InOrder`

```java
@Test
void shouldProcessOrderInCorrectSequence() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    EmailService mockEmailService = mock(EmailService.class);
    DatabaseService mockDatabaseService = mock(DatabaseService.class);
    
    when(mockPaymentService.processPayment(any())).thenReturn(new PaymentResult("SUCCESS"));
    
    OrderService orderService = new OrderService(
        mockPaymentService, 
        mockEmailService, 
        mockDatabaseService
    );
    
    Order order = new Order(100.0);
    
    // Act
    orderService.processOrder(order);
    
    // Assert - Verify correct order
    InOrder inOrder = inOrder(mockPaymentService, mockDatabaseService, mockEmailService);
    inOrder.verify(mockPaymentService).processPayment(any());
    inOrder.verify(mockDatabaseService).saveOrder(order);
    inOrder.verify(mockEmailService).sendOrderConfirmation(order);
}
```

---

## 80. Create a helper method to configure common stubs

```java
class TestHelper {
    
    public static void configurePaymentServiceStub(PaymentService mockPaymentService) {
        when(mockPaymentService.processPayment(any()))
            .thenReturn(new PaymentResult("SUCCESS"));
    }
    
    public static void configureEmailServiceStub(EmailService mockEmailService) {
        doNothing().when(mockEmailService).sendEmail(any(EmailRequest.class));
    }
    
    public static void configureDatabaseServiceStub(DatabaseService mockDatabaseService) {
        when(mockDatabaseService.saveOrder(any())).thenReturn("ORDER_123");
    }
}

class OrderServiceTest {
    
    @Test
    void shouldProcessOrderWithHelperStubs() {
        // Arrange
        PaymentService mockPaymentService = mock(PaymentService.class);
        EmailService mockEmailService = mock(EmailService.class);
        DatabaseService mockDatabaseService = mock(DatabaseService.class);
        
        // Use helper methods
        TestHelper.configurePaymentServiceStub(mockPaymentService);
        TestHelper.configureEmailServiceStub(mockEmailService);
        TestHelper.configureDatabaseServiceStub(mockDatabaseService);
        
        OrderService orderService = new OrderService(
            mockPaymentService, 
            mockEmailService, 
            mockDatabaseService
        );
        
        Order order = new Order(100.0);
        
        // Act
        OrderResult result = orderService.processOrder(order);
        
        // Assert
        assertTrue(result.isSuccess());
    }
}
```

---

## 81. Use `@MockBean` in Spring Boot tests

```java
@SpringBootTest
class UserServiceSpringTest {
    
    @MockBean
    private UserRepository userRepository;
    
    @MockBean
    private EmailService emailService;
    
    @Autowired
    private UserService userService;
    
    @Test
    void shouldCreateUser_whenValidDataProvided() {
        // Arrange
        User expectedUser = new User("john", "john@example.com");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);
        
        // Act
        User actualUser = userService.createUser("john", "john@example.com");
        
        // Assert
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        verify(emailService).sendWelcomeEmail("john@example.com");
    }
}
```

---

## 82. Test retry behavior by mocking different responses

```java
@Test
void shouldRetryOnFailure() {
    // Arrange
    ExternalService mockExternalService = mock(ExternalService.class);
    when(mockExternalService.call())
        .thenThrow(new ServiceException("Service unavailable"))
        .thenThrow(new ServiceException("Service unavailable"))
        .thenReturn("SUCCESS");
    
    RetryService retryService = new RetryService(mockExternalService);
    
    // Act
    String result = retryService.callWithRetry();
    
    // Assert
    assertEquals("SUCCESS", result);
    verify(mockExternalService, times(3)).call();
}
```

---

## 83. Simulate delayed responses and timeout scenarios

```java
@Test
void shouldHandleTimeout() {
    // Arrange
    ExternalService mockExternalService = mock(ExternalService.class);
    when(mockExternalService.call()).thenAnswer(invocation -> {
        Thread.sleep(5000); // Simulate delay
        return "SUCCESS";
    });
    
    TimeoutService timeoutService = new TimeoutService(mockExternalService);
    
    // Act & Assert
    assertThrows(TimeoutException.class, () -> {
        timeoutService.callWithTimeout(1000); // 1 second timeout
    });
}
```

---

## 84. Avoid nulls in stubs—return dummy objects instead

**Good (Dummy Objects):**
```java
@Test
void shouldProcessOrder() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    PaymentResult dummyResult = new PaymentResult("SUCCESS", "txn_123");
    when(mockPaymentService.processPayment(any())).thenReturn(dummyResult);
    
    OrderService orderService = new OrderService(mockPaymentService);
    Order order = new Order(100.0);
    
    // Act
    OrderResult result = orderService.processOrder(order);
    
    // Assert
    assertTrue(result.isSuccess());
}
```

**Bad (Null Returns):**
```java
@Test
void shouldProcessOrder() {
    // Arrange
    PaymentService mockPaymentService = mock(PaymentService.class);
    when(mockPaymentService.processPayment(any())).thenReturn(null); // Bad
    
    OrderService orderService = new OrderService(mockPaymentService);
    Order order = new Order(100.0);
    
    // Act & Assert
    assertThrows(NullPointerException.class, () -> {
        orderService.processOrder(order);
    });
}
```

---

## 85. Write tests without mocks if possible—prefer real collaborators

```java
@Test
void shouldCalculateTaxWithRealCalculator() {
    // Arrange - No mocks needed
    TaxCalculator calculator = new TaxCalculator();
    Order order = new Order(100.0);
    
    // Act
    double tax = calculator.calculateTax(order);
    
    // Assert
    assertEquals(10.0, tax, 0.01);
}

@Test
void shouldValidateEmailWithRealValidator() {
    // Arrange - No mocks needed
    EmailValidator validator = new EmailValidator();
    
    // Act & Assert
    assertTrue(validator.isValid("test@example.com"));
    assertFalse(validator.isValid("invalid-email"));
}
```

---

## 🎯 Mocking Best Practices Summary

### When to Mock:
- ✅ External services (APIs, databases)
- ✅ Slow or unreliable dependencies
- ✅ Dependencies you don't control
- ✅ To isolate the unit under test

### When NOT to Mock:
- ❌ Value objects (String, Integer, etc.)
- ❌ Collections (List, Map, etc.)
- ❌ Simple utility classes
- ❌ Dependencies you control and are fast

### Mocking Guidelines:
- ✅ Use descriptive mock names
- ✅ Verify only important interactions
- ✅ Keep mocks simple and focused
- ✅ Prefer real objects when possible
- ✅ Use argument captors sparingly

---

**Next Section: Test Naming & Readability** 
# Section 2: Unit vs Integration Testing - 20 Tasks

## 🎯 Understanding Test Types

**Unit Tests:** Fast, isolated, test single units
**Integration Tests:** Slower, test component interactions

---

## 26. Write a unit test for a pure function (no side effects)

```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

@Test
void shouldReturnSum_whenAddingTwoNumbers() {
    // Arrange
    int a = 5, b = 3;
    
    // Act
    int result = MathUtils.add(a, b);
    
    // Assert
    assertEquals(8, result);
}
```

---

## 27. Write an integration test for a REST endpoint

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void shouldCreateUser_whenValidRequestProvided() {
        // Arrange
        CreateUserRequest request = new CreateUserRequest("john", "john@example.com");
        
        // Act
        ResponseEntity<User> response = restTemplate.postForEntity(
            "/api/users", request, User.class);
        
        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
```

---

## 28. Compare test speed between unit and integration tests

```java
@Test
void unitTestSpeed() {
    long startTime = System.currentTimeMillis();
    
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
    
    long duration = System.currentTimeMillis() - startTime;
    assertTrue(duration < 100, "Unit test should be fast");
}

@Test
void integrationTestSpeed() {
    long startTime = System.currentTimeMillis();
    
    UserService userService = new UserService(userRepository, emailService);
    User user = userService.createUser("test", "test@example.com");
    
    long duration = System.currentTimeMillis() - startTime;
    assertTrue(duration < 5000, "Integration test should complete within 5 seconds");
}
```

---

## 29. Refactor integration test to isolate one dependency at a time

**Before (Multiple Dependencies):**
```java
@Test
void shouldProcessOrder_whenAllServicesAvailable() {
    OrderService orderService = new OrderService(
        orderRepository, emailService, paymentService);
    
    OrderResult result = orderService.processOrder(order);
    assertTrue(result.isSuccess());
}
```

**After (Isolated Dependencies):**
```java
@Test
void shouldProcessOrder_whenDatabaseAvailable() {
    OrderService orderService = new OrderService(
        orderRepository, mockEmailService, mockPaymentService);
    
    OrderResult result = orderService.processOrder(order);
    assertTrue(result.isSuccess());
}

@Test
void shouldSendEmail_whenOrderProcessed() {
    EmailService mockEmailService = mock(EmailService.class);
    OrderService orderService = new OrderService(
        mockOrderRepository, mockEmailService, mockPaymentService);
    
    orderService.processOrder(order);
    verify(mockEmailService).sendOrderConfirmation(order);
}
```

---

## 30. Mock external service calls in integration tests

```java
@SpringBootTest
class PaymentServiceIntegrationTest {
    
    @MockBean
    private RestTemplate restTemplate;
    
    @Autowired
    private PaymentService paymentService;
    
    @Test
    void shouldProcessPayment_whenExternalServiceResponds() {
        // Arrange
        PaymentRequest request = new PaymentRequest(100.0, "USD");
        PaymentResult expectedResult = new PaymentResult("SUCCESS", "txn_123");
        
        when(restTemplate.postForObject(anyString(), eq(request), eq(PaymentResult.class)))
            .thenReturn(expectedResult);
        
        // Act
        PaymentResult result = paymentService.processPayment(request);
        
        // Assert
        assertEquals("SUCCESS", result.getStatus());
    }
}
```

---

## 31. Use an in-memory DB (e.g., H2) for integration tests

```java
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driver-class-name=org.h2.Driver"
})
class UserRepositoryIntegrationTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void shouldSaveAndRetrieveUser() {
        User user = new User("john_doe", "john@example.com");
        User savedUser = userRepository.save(user);
        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);
        
        assertNotNull(retrievedUser);
        assertEquals("john_doe", retrievedUser.getUsername());
    }
}
```

---

## 32. Tag integration tests separately using `@Tag("integration")`

```java
@Tag("integration")
@SpringBootTest
class UserServiceIntegrationTest {
    
    @Test
    @Tag("slow")
    void shouldCreateUserWithDatabase() {
        // Integration test that hits the database
    }
    
    @Test
    @Tag("fast")
    void shouldValidateUserData() {
        // Fast integration test
    }
}
```

---

## 33. Write a test suite that runs unit tests quickly and integration tests later

```java
@Suite
@SelectClasses({
    CalculatorTest.class,
    MathUtilsTest.class,
    EmailValidatorTest.class
})
@SuiteDisplayName("Unit Test Suite")
class UnitTestSuite {
    // Runs in < 1 second
}

@Suite
@SelectClasses({
    UserServiceIntegrationTest.class,
    OrderControllerIntegrationTest.class
})
@SuiteDisplayName("Integration Test Suite")
@Tag("integration")
class IntegrationTestSuite {
    // Runs in 30+ seconds
}
```

---

## 34. Create an OrderService unit test that doesn't touch DB or network

```java
class OrderServiceUnitTest {
    
    private OrderService orderService;
    
    @BeforeEach
    void setUp() {
        orderService = new OrderService(null, null, null);
    }
    
    @Test
    void shouldValidateOrder_whenValidOrderProvided() {
        Order order = new Order(Arrays.asList("item1", "item2"), 100.0);
        OrderResult result = orderService.processOrder(order);
        assertTrue(result.isSuccess());
    }
    
    @Test
    void shouldThrowException_whenOrderTotalIsZero() {
        Order order = new Order(Arrays.asList("item1"), 0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.processOrder(order);
        });
    }
}
```

---

## 35. Create a UserRegistrationIntegrationTest that hits real DB + controller

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@Transactional
class UserRegistrationIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void shouldRegisterUser_whenValidDataProvided() {
        CreateUserRequest request = new CreateUserRequest("john_doe", "john@example.com");
        
        ResponseEntity<User> response = restTemplate.postForEntity(
            "/api/users/register", request, User.class);
        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        
        User savedUser = userRepository.findByUsername("john_doe").orElse(null);
        assertNotNull(savedUser);
        assertEquals("john@example.com", savedUser.getEmail());
    }
}
```

---

## 36. Use `@SpringBootTest` for integration setup

```java
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
    }
)
@AutoConfigureTestDatabase
class SpringBootIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
    void shouldStartApplicationContext() {
        assertNotNull(applicationContext);
    }
    
    @Test
    void shouldHaveAllRequiredBeans() {
        assertNotNull(applicationContext.getBean(UserService.class));
        assertNotNull(applicationContext.getBean(UserRepository.class));
    }
}
```

---

## 37. Separate test source folders for unit vs integration tests

**Project Structure:**
```
src/
├── main/java/
├── test/java/                    # Unit tests
│   └── com/example/
│       ├── service/
│       │   └── UserServiceTest.java
│       └── util/
│           └── MathUtilsTest.java
└── integrationTest/java/         # Integration tests
    └── com/example/
        ├── controller/
        │   └── UserControllerIT.java
        └── repository/
            └── UserRepositoryIT.java
```

---

## 38. Refactor tests to follow isolation principles

**Before (Not Isolated):**
```java
@Test
void shouldProcessMultipleOrders() {
    OrderService orderService = new OrderService();
    orderService.processOrder(order1);
    orderService.processOrder(order2);
    // State persists between tests
}
```

**After (Isolated):**
```java
@Test
void shouldProcessOrder() {
    OrderService orderService = new OrderService();
    OrderResult result = orderService.processOrder(order);
    assertTrue(result.isSuccess());
}

@AfterEach
void tearDown() {
    orderRepository.deleteAll();
}
```

---

## 39. Test a DAO layer with and without DB access

**Unit Test (No DB):**
```java
class UserDaoUnitTest {
    
    @Test
    void shouldReturnUser_whenUserExists() {
        UserDao userDao = new InMemoryUserDao(); // No real DB
        User expectedUser = new User("john", "john@example.com");
        userDao.save(expectedUser);
        
        User actualUser = userDao.findById(1);
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }
}
```

**Integration Test (With DB):**
```java
@SpringBootTest
@AutoConfigureTestDatabase
class UserDaoIntegrationTest {
    
    @Autowired
    private UserDao userDao;
    
    @Test
    void shouldPersistUserToDatabase() {
        User user = new User("john", "john@example.com");
        userDao.save(user);
        
        User savedUser = userDao.findById(user.getId());
        assertNotNull(savedUser);
        assertEquals("john", savedUser.getUsername());
    }
}
```

---

## 40. Stub network responses for API tests

```java
@SpringBootTest
class WeatherApiClientTest {
    
    @MockBean
    private RestTemplate restTemplate;
    
    @Autowired
    private WeatherApiClient weatherApiClient;
    
    @Test
    void shouldReturnWeatherData_whenApiResponds() {
        WeatherData expectedWeather = new WeatherData("Sunny", 25.0);
        
        when(restTemplate.getForObject(anyString(), eq(WeatherData.class)))
            .thenReturn(expectedWeather);
        
        WeatherData actualWeather = weatherApiClient.getWeather("London");
        
        assertEquals("Sunny", actualWeather.getCondition());
        assertEquals(25.0, actualWeather.getTemperature(), 0.1);
    }
}
```

---

## 41. Create a unit test for a class that throws exceptions on invalid input

```java
class EmailServiceUnitTest {
    
    private EmailService emailService;
    
    @BeforeEach
    void setUp() {
        emailService = new EmailService();
    }
    
    @Test
    void shouldThrowException_whenRecipientEmailIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            emailService.sendEmail(null, "Subject", "Body");
        });
    }
    
    @Test
    void shouldThrowException_whenEmailFormatIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            emailService.sendEmail("invalid-email", "Subject", "Body");
        });
    }
}
```

---

## 42. Measure execution time difference between unit and integration tests

```java
@Test
void unitTestExecutionTime() {
    long startTime = System.nanoTime();
    
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
    
    long durationMs = (System.nanoTime() - startTime) / 1_000_000;
    System.out.println("Unit test execution time: " + durationMs + "ms");
    assertTrue(durationMs < 100, "Unit test should be fast");
}

@Test
void integrationTestExecutionTime() {
    long startTime = System.nanoTime();
    
    UserService userService = new UserService(userRepository, emailService);
    User user = userService.createUser("test", "test@example.com");
    
    long durationMs = (System.nanoTime() - startTime) / 1_000_000;
    System.out.println("Integration test execution time: " + durationMs + "ms");
    assertTrue(durationMs < 5000, "Integration test should complete within 5 seconds");
}
```

---

## 43. Refactor integration tests to use TestContainers or MockWebServer

**Using TestContainers:**
```java
@Testcontainers
@SpringBootTest
class UserRepositoryTestContainersTest {
    
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");
    
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void shouldSaveAndRetrieveUser() {
        User user = new User("john", "john@example.com");
        User savedUser = userRepository.save(user);
        
        assertNotNull(savedUser.getId());
        assertEquals("john", savedUser.getUsername());
    }
}
```

---

## 44. Write boundary tests for unit-level edge cases

```java
class BoundaryTest {
    
    @Test
    void shouldHandleEmptyString() {
        StringProcessor processor = new StringProcessor();
        String result = processor.process("");
        assertEquals("", result);
    }
    
    @Test
    void shouldHandleNullInput() {
        StringProcessor processor = new StringProcessor();
        assertThrows(IllegalArgumentException.class, () -> {
            processor.process(null);
        });
    }
    
    @Test
    void shouldHandleMaximumValue() {
        Calculator calculator = new Calculator();
        int result = calculator.add(Integer.MAX_VALUE, 0);
        assertEquals(Integer.MAX_VALUE, result);
    }
    
    @Test
    void shouldHandleZeroValue() {
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        assertEquals(0, result);
    }
}
```

---

## 45. Apply the Pyramid Testing principle: more unit tests, fewer E2E tests

**Testing Pyramid:**
```
        /\
       /  \     E2E Tests (10%)
      /____\    
     /      \   Integration Tests (20%)
    /________\  
   /          \ Unit Tests (70%)
  /____________\
```

**Example Distribution:**
```java
// 70% Unit Tests (Fast, isolated)
class UserServiceUnitTest {
    @Test void shouldValidateEmail() { }
    @Test void shouldCalculateAge() { }
    @Test void shouldFormatName() { }
    // ... many more unit tests
}

// 20% Integration Tests (Medium speed, test interactions)
class UserServiceIntegrationTest {
    @Test void shouldSaveUserToDatabase() { }
    @Test void shouldSendWelcomeEmail() { }
    // ... some integration tests
}

// 10% E2E Tests (Slow, test complete workflows)
class UserRegistrationE2ETest {
    @Test void shouldRegisterUserEndToEnd() { }
    // ... few E2E tests
}
```

---

## 🎯 Unit vs Integration Testing Best Practices

### Unit Tests:
- ✅ Test one thing at a time
- ✅ Use descriptive names
- ✅ Keep tests fast (< 1 second)
- ✅ Mock external dependencies
- ✅ Test edge cases and boundaries

### Integration Tests:
- ✅ Test component interactions
- ✅ Use real databases when needed
- ✅ Mock external services
- ✅ Test complete workflows
- ✅ Focus on business scenarios

### Test Organization:
- ✅ Separate unit and integration test folders
- ✅ Use tags to categorize tests
- ✅ Run unit tests frequently
- ✅ Run integration tests less frequently
- ✅ Use CI/CD to automate test execution

---

**Next Section: Clean Test Structure (AAA Pattern)** 
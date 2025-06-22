# SOLID Principles — Tasks 31–50 (Part 2)

## ⚖ ISP – Interface Segregation Principle (Tasks 31–40)

### Principle
Clients should not be forced to depend on interfaces they do not use. Many client-specific interfaces are better than one general-purpose interface.

---

### 31. Create a `Machine` interface with `print()`, `scan()`, `fax()`—split it into separate interfaces

**Before (Fat Interface):**
```java
public interface Machine {
    void print();
    void scan();
    void fax();
}

public class Printer implements Machine {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
    
    @Override
    public void scan() {
        throw new UnsupportedOperationException("Printer cannot scan");
    }
    
    @Override
    public void fax() {
        throw new UnsupportedOperationException("Printer cannot fax");
    }
}
```

**After (Segregated Interfaces):**
```java
public interface Printer {
    void print();
}

public interface Scanner {
    void scan();
}

public interface Fax {
    void fax();
}

public interface MultiFunctionDevice extends Printer, Scanner, Fax {
    // Combines all capabilities
}

public class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
}

public class AllInOnePrinter implements MultiFunctionDevice {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
    
    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
    
    @Override
    public void fax() {
        System.out.println("Faxing...");
    }
}
```

---

### 32. Identify a fat interface and break it into smaller cohesive ones

**Before:**
```java
public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    User getUser(String id);
    List<User> getAllUsers();
    void sendEmail(User user, String message);
    void generateReport(List<User> users);
    void backupUsers();
}
```

**After:**
```java
public interface UserRepository {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    User getUser(String id);
    List<User> getAllUsers();
}

public interface EmailService {
    void sendEmail(User user, String message);
}

public interface ReportService {
    void generateReport(List<User> users);
}

public interface BackupService {
    void backupUsers();
}

public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final ReportService reportService;
    private final BackupService backupService;
    
    public UserService(UserRepository userRepository, EmailService emailService,
                      ReportService reportService, BackupService backupService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.reportService = reportService;
        this.backupService = backupService;
    }
    
    public void createUser(User user) {
        userRepository.createUser(user);
        emailService.sendEmail(user, "Welcome!");
    }
}
```

---

### 33. Write a `Workable` interface and split it into `Eater`, `Worker`, `Sleeper`

**Before:**
```java
public interface Workable {
    void eat();
    void work();
    void sleep();
}

public class Robot implements Workable {
    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat");
    }
    
    @Override
    public void work() {
        System.out.println("Working...");
    }
    
    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Robots don't sleep");
    }
}
```

**After:**
```java
public interface Eater {
    void eat();
}

public interface Worker {
    void work();
}

public interface Sleeper {
    void sleep();
}

public interface Human extends Eater, Worker, Sleeper {
    // Humans can do all three
}

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }
}

public class Person implements Human {
    @Override
    public void eat() {
        System.out.println("Eating...");
    }
    
    @Override
    public void work() {
        System.out.println("Working...");
    }
    
    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
```

---

### 34. Use multiple interfaces with default methods in Java 8+

```java
public interface Logger {
    default void log(String message) {
        System.out.println("Log: " + message);
    }
}

public interface Metrics {
    default void recordMetric(String name, double value) {
        System.out.println("Metric: " + name + " = " + value);
    }
}

public interface Cache {
    default void put(String key, Object value) {
        System.out.println("Caching: " + key + " = " + value);
    }
    
    default Object get(String key) {
        return null;
    }
}

public class UserService implements Logger, Metrics, Cache {
    public void createUser(User user) {
        log("Creating user: " + user.getName());
        recordMetric("users.created", 1);
        put("user." + user.getId(), user);
    }
}
```

---

### 35. Design a system where clients depend only on what they use

```java
// Client 1: Only needs to read users
public class UserReader {
    private final UserRepository userRepository;
    
    public UserReader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUser(String id) {
        return userRepository.findById(id);
    }
}

// Client 2: Only needs to write users
public class UserWriter {
    private final UserRepository userRepository;
    
    public UserWriter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
}

// Segregated interfaces
public interface UserReader {
    User findById(String id);
    List<User> findAll();
}

public interface UserWriter {
    void save(User user);
    void delete(String id);
}

public interface UserRepository extends UserReader, UserWriter {
    // Combines read and write capabilities
}
```

---

### 36. Add a new feature (like `pay()`) without modifying existing interfaces

```java
// Existing interfaces
public interface UserReader {
    User findById(String id);
}

public interface UserWriter {
    void save(User user);
}

// New interface for payment functionality
public interface PaymentProcessor {
    void pay(User user, double amount);
}

// Existing service only depends on what it needs
public class UserService {
    private final UserReader userReader;
    private final UserWriter userWriter;
    
    public UserService(UserReader userReader, UserWriter userWriter) {
        this.userReader = userReader;
        this.userWriter = userWriter;
    }
    
    public User getUser(String id) {
        return userReader.findById(id);
    }
    
    public void saveUser(User user) {
        userWriter.save(user);
    }
}

// New service can use payment functionality
public class PaymentService {
    private final PaymentProcessor paymentProcessor;
    
    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    public void processPayment(String userId, double amount) {
        // Process payment logic
        paymentProcessor.pay(user, amount);
    }
}
```

---

### 37. Use abstract classes + multiple interfaces for cleaner separation

```java
public interface Readable {
    Object read();
}

public interface Writable {
    void write(Object data);
}

public interface Deletable {
    void delete();
}

public abstract class BaseRepository {
    protected String connectionString;
    
    public BaseRepository(String connectionString) {
        this.connectionString = connectionString;
    }
    
    protected abstract void connect();
    protected abstract void disconnect();
}

public class UserRepository extends BaseRepository implements Readable, Writable, Deletable {
    public UserRepository(String connectionString) {
        super(connectionString);
    }
    
    @Override
    protected void connect() {
        System.out.println("Connecting to user database...");
    }
    
    @Override
    protected void disconnect() {
        System.out.println("Disconnecting from user database...");
    }
    
    @Override
    public Object read() {
        return new User("John Doe");
    }
    
    @Override
    public void write(Object data) {
        System.out.println("Writing user: " + data);
    }
    
    @Override
    public void delete() {
        System.out.println("Deleting user...");
    }
}

// Client can depend only on what it needs
public class UserReader {
    private final Readable repository;
    
    public UserReader(Readable repository) {
        this.repository = repository;
    }
    
    public Object readUser() {
        return repository.read();
    }
}
```

---

### 38. Refactor a method that accepts an interface but uses only a subset of it

**Before:**
```java
public interface DataProcessor {
    void processData();
    void validateData();
    void transformData();
    void saveData();
    void sendNotification();
}

public class DataValidator {
    public void validate(DataProcessor processor) {
        processor.validateData(); // Only uses one method!
    }
}
```

**After:**
```java
public interface DataValidator {
    void validateData();
}

public interface DataTransformer {
    void transformData();
}

public interface DataSaver {
    void saveData();
}

public interface NotificationSender {
    void sendNotification();
}

public interface DataProcessor extends DataValidator, DataTransformer, DataSaver, NotificationSender {
    void processData();
}

public class DataValidator {
    public void validate(DataValidator validator) {
        validator.validateData(); // Only depends on what it uses
    }
}
```

---

### 39. Use adapter pattern to conform legacy interface to a smaller one

```java
// Legacy fat interface
public interface LegacyPrinter {
    void print();
    void scan();
    void fax();
    void copy();
    void staple();
}

// New segregated interfaces
public interface Printer {
    void print();
}

public interface Scanner {
    void scan();
}

// Adapter to make legacy printer work with new interface
public class LegacyPrinterAdapter implements Printer {
    private final LegacyPrinter legacyPrinter;
    
    public LegacyPrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }
    
    @Override
    public void print() {
        legacyPrinter.print();
    }
}

// Client only depends on Printer interface
public class PrintService {
    private final Printer printer;
    
    public PrintService(Printer printer) {
        this.printer = printer;
    }
    
    public void printDocument() {
        printer.print();
    }
}
```

---

### 40. Show how ISP improves readability and maintainability

**Before (Violates ISP):**
```java
public interface Worker {
    void work();
    void eat();
    void sleep();
    void getPaid();
    void takeVacation();
}

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }
    
    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat");
    }
    
    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Robots don't sleep");
    }
    
    @Override
    public void getPaid() {
        throw new UnsupportedOperationException("Robots don't get paid");
    }
    
    @Override
    public void takeVacation() {
        throw new UnsupportedOperationException("Robots don't take vacation");
    }
}
```

**After (ISP Compliant):**
```java
public interface Worker {
    void work();
}

public interface Eater {
    void eat();
}

public interface Sleeper {
    void sleep();
}

public interface PaidWorker extends Worker {
    void getPaid();
}

public interface VacationTaker {
    void takeVacation();
}

public class Human implements Worker, Eater, Sleeper, PaidWorker, VacationTaker {
    @Override
    public void work() {
        System.out.println("Working...");
    }
    
    @Override
    public void eat() {
        System.out.println("Eating...");
    }
    
    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
    
    @Override
    public void getPaid() {
        System.out.println("Getting paid...");
    }
    
    @Override
    public void takeVacation() {
        System.out.println("Taking vacation...");
    }
}

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working...");
    }
    // No need to implement methods it doesn't use
}
```

---

## 🔌 DIP – Dependency Inversion Principle (Tasks 41–50)

### Principle
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

---

### 41. Replace direct instantiation (`new`) with dependency injection

**Before:**
```java
public class UserService {
    private final UserRepository userRepository;
    
    public UserService() {
        this.userRepository = new UserRepository(); // Direct instantiation
    }
    
    public void createUser(User user) {
        userRepository.save(user);
    }
}
```

**After:**
```java
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) { // Dependency injection
        this.userRepository = userRepository;
    }
    
    public void createUser(User user) {
        userRepository.save(user);
    }
}

// Usage
UserRepository repository = new UserRepository();
UserService service = new UserService(repository);
```

---

### 42. Use constructor injection in a service class

```java
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentProcessor paymentProcessor;
    private final EmailService emailService;
    private final Logger logger;
    
    public OrderService(OrderRepository orderRepository,
                       PaymentProcessor paymentProcessor,
                       EmailService emailService,
                       Logger logger) {
        this.orderRepository = orderRepository;
        this.paymentProcessor = paymentProcessor;
        this.emailService = emailService;
        this.logger = logger;
    }
    
    public void processOrder(Order order) {
        orderRepository.save(order);
        paymentProcessor.processPayment(order);
        emailService.sendConfirmation(order);
        logger.log("Order processed: " + order.getId());
    }
}
```

---

### 43. Create a `NotificationService` that depends on an `INotificationSender` interface

```java
public interface NotificationSender {
    void send(String recipient, String message);
}

public class EmailSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

public class SMSSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

public class PushNotificationSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }
}

public class NotificationService {
    private final NotificationSender notificationSender;
    
    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }
    
    public void notifyUser(String userId, String message) {
        notificationSender.send(userId, message);
    }
}

// Usage
NotificationSender emailSender = new EmailSender();
NotificationService notificationService = new NotificationService(emailSender);
notificationService.notifyUser("user@example.com", "Welcome!");
```

---

### 44. Inject dependencies using a factory or DI framework like Spring

**Using Spring Framework:**
```java
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    
    @Autowired
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    
    public void createUser(User user) {
        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }
}

@Repository
public class UserRepository {
    // Implementation
}

@Service
public class EmailService {
    // Implementation
}
```

**Using Manual Factory:**
```java
public class ServiceFactory {
    public static UserService createUserService() {
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();
        return new UserService(userRepository, emailService);
    }
}

// Usage
UserService userService = ServiceFactory.createUserService();
```

---

### 45. Replace low-level modules with abstractions

**Before:**
```java
public class UserService {
    private final MySQLDatabase database; // Depends on concrete implementation
    
    public UserService() {
        this.database = new MySQLDatabase();
    }
    
    public void saveUser(User user) {
        database.execute("INSERT INTO users VALUES (?, ?)", user.getId(), user.getName());
    }
}
```

**After:**
```java
public interface UserRepository {
    void save(User user);
    User findById(String id);
}

public class MySQLUserRepository implements UserRepository {
    private final MySQLDatabase database;
    
    public MySQLUserRepository(MySQLDatabase database) {
        this.database = database;
    }
    
    @Override
    public void save(User user) {
        database.execute("INSERT INTO users VALUES (?, ?)", user.getId(), user.getName());
    }
    
    @Override
    public User findById(String id) {
        // Implementation
        return null;
    }
}

public class UserService {
    private final UserRepository userRepository; // Depends on abstraction
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
```

---

### 46. Use inversion of control to delegate resource management

**Before:**
```java
public class FileProcessor {
    public void processFile(String filename) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            // Process file
        } catch (IOException e) {
            // Handle exception
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // Handle exception
                }
            }
        }
    }
}
```

**After:**
```java
public interface FileReader {
    String read(String filename) throws IOException;
}

public class FileProcessor {
    private final FileReader fileReader;
    
    public FileProcessor(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    
    public void processFile(String filename) {
        try {
            String content = fileReader.read(filename);
            // Process content
        } catch (IOException e) {
            // Handle exception
        }
    }
}

public class DefaultFileReader implements FileReader {
    @Override
    public String read(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            // Read and return content
            return "file content";
        }
    }
}
```

---

### 47. Make a class testable by injecting mocks instead of real dependencies

```java
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentProcessor paymentProcessor;
    private final InventoryService inventoryService;
    
    public OrderService(OrderRepository orderRepository,
                       PaymentProcessor paymentProcessor,
                       InventoryService inventoryService) {
        this.orderRepository = orderRepository;
        this.paymentProcessor = paymentProcessor;
        this.inventoryService = inventoryService;
    }
    
    public boolean processOrder(Order order) {
        if (!inventoryService.hasStock(order.getProductId(), order.getQuantity())) {
            return false;
        }
        
        if (paymentProcessor.processPayment(order.getAmount())) {
            orderRepository.save(order);
            inventoryService.reduceStock(order.getProductId(), order.getQuantity());
            return true;
        }
        
        return false;
    }
}

// Test with mocks
@Test
void testProcessOrder_Success() {
    // Arrange
    OrderRepository mockRepository = mock(OrderRepository.class);
    PaymentProcessor mockPayment = mock(PaymentProcessor.class);
    InventoryService mockInventory = mock(InventoryService.class);
    
    when(mockInventory.hasStock(anyString(), anyInt())).thenReturn(true);
    when(mockPayment.processPayment(anyDouble())).thenReturn(true);
    
    OrderService service = new OrderService(mockRepository, mockPayment, mockInventory);
    Order order = new Order("product1", 2, 100.0);
    
    // Act
    boolean result = service.processOrder(order);
    
    // Assert
    assertTrue(result);
    verify(mockRepository).save(order);
    verify(mockInventory).reduceStock("product1", 2);
}
```

---

### 48. Write a class where high-level policy and low-level details are decoupled

```java
// High-level policy
public class OrderProcessor {
    private final OrderValidator orderValidator;
    private final PaymentProcessor paymentProcessor;
    private final OrderRepository orderRepository;
    
    public OrderProcessor(OrderValidator orderValidator,
                         PaymentProcessor paymentProcessor,
                         OrderRepository orderRepository) {
        this.orderValidator = orderValidator;
        this.paymentProcessor = paymentProcessor;
        this.orderRepository = orderRepository;
    }
    
    public OrderResult processOrder(Order order) {
        // High-level business logic
        if (!orderValidator.isValid(order)) {
            return OrderResult.invalid("Invalid order");
        }
        
        if (!paymentProcessor.processPayment(order.getAmount())) {
            return OrderResult.failed("Payment failed");
        }
        
        orderRepository.save(order);
        return OrderResult.success(order);
    }
}

// Low-level details (implementations)
public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Credit card processing details
        return true;
    }
}

public class MySQLOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        // MySQL database details
    }
}
```

---

### 49. Use `@Autowired` or manual injection for a Logger dependency

**Using Spring's @Autowired:**
```java
@Service
public class UserService {
    private final Logger logger;
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(Logger logger, UserRepository userRepository) {
        this.logger = logger;
        this.userRepository = userRepository;
    }
    
    public void createUser(User user) {
        logger.info("Creating user: " + user.getName());
        userRepository.save(user);
        logger.info("User created successfully");
    }
}
```

**Manual Injection:**
```java
public class UserService {
    private final Logger logger;
    private final UserRepository userRepository;
    
    public UserService(Logger logger, UserRepository userRepository) {
        this.logger = logger;
        this.userRepository = userRepository;
    }
    
    public void createUser(User user) {
        logger.info("Creating user: " + user.getName());
        userRepository.save(user);
        logger.info("User created successfully");
    }
}

// Usage
Logger logger = new ConsoleLogger();
UserRepository repository = new UserRepository();
UserService service = new UserService(logger, repository);
```

---

### 50. Build a config-driven dependency setup (e.g., choosing a DB driver via config)

```java
public interface DatabaseConfig {
    String getDriver();
    String getUrl();
    String getUsername();
    String getPassword();
}

public class DatabaseFactory {
    public static Database createDatabase(DatabaseConfig config) {
        switch (config.getDriver()) {
            case "mysql":
                return new MySQLDatabase(config.getUrl(), config.getUsername(), config.getPassword());
            case "postgresql":
                return new PostgreSQLDatabase(config.getUrl(), config.getUsername(), config.getPassword());
            case "h2":
                return new H2Database(config.getUrl());
            default:
                throw new IllegalArgumentException("Unsupported database driver: " + config.getDriver());
        }
    }
}

public class ApplicationConfig {
    private final DatabaseConfig databaseConfig;
    
    public ApplicationConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }
    
    public UserService createUserService() {
        Database database = DatabaseFactory.createDatabase(databaseConfig);
        UserRepository userRepository = new UserRepository(database);
        return new UserService(userRepository);
    }
}

// Usage
DatabaseConfig config = new PropertiesDatabaseConfig("application.properties");
ApplicationConfig appConfig = new ApplicationConfig(config);
UserService userService = appConfig.createUserService();
```

---

**Key Takeaways for ISP:**
- Clients should not be forced to depend on methods they don't use
- Break large interfaces into smaller, focused ones
- Use multiple interfaces to compose functionality
- Default methods in Java 8+ help with interface evolution

**Key Takeaways for DIP:**
- Depend on abstractions, not concrete classes
- Use dependency injection to provide dependencies
- High-level modules should not depend on low-level modules
- Both should depend on abstractions
- Makes code more testable and flexible 
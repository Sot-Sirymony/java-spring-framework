import java.util.List;

/**
 * Examples of clean code practices
 * Demonstrates how to refactor bad code into clean, maintainable code
 */
public class CleanCodeExamples {
    
    // CLEAN: Single-purpose, well-named function
    // Task 36: Split a long method into smaller ones
    public double calculateTotal(List<Double> values) {
        return values.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }
    
    // CLEAN: Extracted calculation logic (Java 8 compatible)
    // Task 50: Extract switch logic into dedicated functions or classes
    public double performCalculation(CalculationRequest request) {
        switch (request.getOperation()) {
            case ADD:
                return addValues(request.getValues());
            case MULTIPLY:
                return multiplyValues(request.getValues());
            case DIVIDE:
                return divideValues(request.getValues());
            default:
                throw new IllegalArgumentException("Unknown operation: " + request.getOperation());
        }
    }
    
    // Task 36: Split a long method into smaller ones
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
    
    // CLEAN: Separated concerns into different classes
    // Task 20: Convert a "god class" into multiple cohesive classes
    public class UserRegistrationService {
        private final UserValidator validator;
        private final UserRepository repository;
        private final EmailService emailService;
        private final Logger logger;
        
        public UserRegistrationService(UserValidator validator, UserRepository repository, 
                                     EmailService emailService, Logger logger) {
            this.validator = validator;
            this.repository = repository;
            this.emailService = emailService;
            this.logger = logger;
        }
        
        public void registerUser(UserRegistrationRequest request) {
            validator.validate(request);
            User user = repository.save(request.toUser());
            emailService.sendWelcomeEmail(user);
            logger.info("User registered successfully: {}", user.getEmail());
        }
    }
    
    // CLEAN: Good naming conventions
    // Task 23: Rename classes from vague names to specific ones
    public class InvoiceCalculator {
        private int itemCount;
        private String customerName;
        private List<InvoiceItem> invoiceItems;
        
        public void calculateInvoiceTotal() {
            // Calculate invoice total
        }
        
        // Task 31: Prefix Boolean variables with "is"/"has" correctly
        public boolean hasValidItems() {
            return itemCount > 0;
        }
    }
    
    // CLEAN: No redundant comments, self-documenting code
    // Task 59: Write a method with zero comments but high readability
    public class OrderProcessor {
        public void processOrder(Order order) {
            validateOrder(order);
            calculateTotal(order);
            applyDiscounts(order);
            saveOrder(order);
            sendConfirmation(order);
        }
        
        private void validateOrder(Order order) {
            if (order.getItems().isEmpty()) {
                throw new InvalidOrderException("Order must contain at least one item");
            }
        }
        
        private void calculateTotal(Order order) {
            double subtotal = order.getItems().stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
            order.setSubtotal(subtotal);
        }
        
        private void applyDiscounts(Order order) {
            DiscountCalculator calculator = new DiscountCalculator();
            double discount = calculator.calculateDiscount(order);
            order.setDiscount(discount);
        }
        
        private void saveOrder(Order order) {
            // Database persistence logic
        }
        
        private void sendConfirmation(Order order) {
            // Email confirmation logic
        }
    }
} 
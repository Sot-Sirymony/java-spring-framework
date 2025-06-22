import java.util.List;

/**
 * Examples of bad code practices and code smells
 * Used for demonstrating what NOT to do in clean code
 */
public class BadCodeExamples {
    
    // BAD: Messy function with multiple issues
    // Task 6: Write two versions of a function: one messy, one clean
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
    
    // BAD: Long method with multiple responsibilities
    // Task 17: Refactor a method longer than 50 lines
    public void processUserData(String name, String email, String phone, String address, 
                               int age, String occupation, double salary, boolean isActive) {
        // Validate input
        if (name == null || name.isEmpty()) {
            System.out.println("Name is required");
            return;
        }
        if (email == null || email.isEmpty()) {
            System.out.println("Email is required");
            return;
        }
        if (phone == null || phone.isEmpty()) {
            System.out.println("Phone is required");
            return;
        }
        if (address == null || address.isEmpty()) {
            System.out.println("Address is required");
            return;
        }
        if (age < 0 || age > 150) {
            System.out.println("Invalid age");
            return;
        }
        if (salary < 0) {
            System.out.println("Invalid salary");
            return;
        }
        
        // Save to database
        String sql = "INSERT INTO users (name, email, phone, address, age, occupation, salary, is_active) " +
                    "VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + address + "', " + 
                    age + ", '" + occupation + "', " + salary + ", " + isActive + ")";
        // ... database code here
        
        // Send email notification
        String emailBody = "Hello " + name + ", your account has been created successfully.";
        // ... email sending code here
        
        // Log the action
        System.out.println("User " + name + " has been processed successfully");
    }
    
    // BAD: Poor naming conventions
    // Task 21: Rename bad variable names to meaningful ones
    public class DataProcessor {
        private int x;  // BAD: unclear what x represents
        private String s;  // BAD: unclear what s represents
        private List<Object> lst;  // BAD: unclear what lst contains
        
        public void doWork() {  // BAD: unclear what work is being done
            // Process data
        }
        
        public boolean check() {  // BAD: unclear what is being checked
            return x > 0;
        }
    }
    
    // BAD: Commented out legacy code
    // Task 64: Remove all commented-out legacy code in a file
    public void calculateTotal(List<Double> prices) {
        double total = 0;
        for (Double price : prices) {
            total += price;
        }
        
        // OLD CODE - REMOVE LATER
        // double tax = total * 0.1;
        // total = total + tax;
        
        System.out.println("Total: " + total);
    }
} 
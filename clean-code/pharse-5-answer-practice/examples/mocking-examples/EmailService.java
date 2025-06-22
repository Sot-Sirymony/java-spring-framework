public interface EmailService {
    
    void sendWelcomeEmail(String email);
    
    void sendOrderConfirmation(Order order);
    
    void sendEmail(EmailRequest emailRequest);
    
    boolean isEmailValid(String email);
} 
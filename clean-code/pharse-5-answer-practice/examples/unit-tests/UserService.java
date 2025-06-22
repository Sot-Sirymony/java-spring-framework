import java.util.List;
import java.util.Optional;

public class UserService {
    
    private final UserRepository userRepository;
    private final EmailService emailService;
    
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    
    public User createUser(String username, String email) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        User user = new User(username, email);
        User savedUser = userRepository.save(user);
        
        emailService.sendWelcomeEmail(email);
        
        return savedUser;
    }
    
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public void deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
    
    public User updateUser(int id, String username, String email) {
        User existingUser = findById(id);
        if (existingUser == null) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        
        if (username != null && !username.trim().isEmpty()) {
            existingUser.setUsername(username);
        }
        
        if (email != null && !email.trim().isEmpty()) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email format");
            }
            existingUser.setEmail(email);
        }
        
        return userRepository.save(existingUser);
    }
} 
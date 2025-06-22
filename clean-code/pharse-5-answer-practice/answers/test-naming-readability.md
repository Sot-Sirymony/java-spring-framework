# Section 5: Test Naming & Readability - 15 Tasks

## 🎯 Test Naming Principles

Good test names should be **descriptive**, **readable**, and **communicate intent**.

---

## 86. Use descriptive method names: `shouldReturnUser_whenUsernameExists()`

```java
@Test
void shouldReturnUser_whenUsernameExists() {
    // Test implementation
}

@Test
void shouldThrowException_whenInvalidEmailProvided() {
    // Test implementation
}

@Test
void shouldCalculateTotalWithTax_whenValidOrderProvided() {
    // Test implementation
}

@Test
void shouldSendWelcomeEmail_whenUserRegisters() {
    // Test implementation
}
```

---

## 87. Follow naming convention: `should_<expected>_when_<condition>()`

```java
@Test
void should_return_user_when_username_exists() {
    // Test implementation
}

@Test
void should_throw_exception_when_invalid_email_provided() {
    // Test implementation
}

@Test
void should_calculate_total_with_tax_when_valid_order_provided() {
    // Test implementation
}

@Test
void should_send_welcome_email_when_user_registers() {
    // Test implementation
}
```

---

## 88. Avoid vague names like `test1()`, `testABC()`

**Bad Names:**
```java
@Test
void test1() { }

@Test
void testABC() { }

@Test
void testUser() { }

@Test
void testCalculation() { }
```

**Good Names:**
```java
@Test
void shouldCreateUser_whenValidDataProvided() { }

@Test
void shouldCalculateTax_whenOrderAmountIsPositive() { }

@Test
void shouldThrowException_whenEmailIsInvalid() { }

@Test
void shouldReturnUserList_whenUsersExist() { }
```

---

## 89. Rename all test methods in a class using proper naming

**Before (Poor Naming):**
```java
class UserServiceTest {
    
    @Test
    void testCreateUser() { }
    
    @Test
    void testFindUser() { }
    
    @Test
    void testDeleteUser() { }
    
    @Test
    void testValidateEmail() { }
}
```

**After (Good Naming):**
```java
class UserServiceTest {
    
    @Test
    void shouldCreateUser_whenValidDataProvided() { }
    
    @Test
    void shouldReturnUser_whenUserExists() { }
    
    @Test
    void shouldDeleteUser_whenUserExists() { }
    
    @Test
    void shouldReturnTrue_whenValidEmailProvided() { }
    
    @Test
    void shouldReturnFalse_whenInvalidEmailProvided() { }
}
```

---

## 90. Add test display names using `@DisplayName`

```java
@Test
@DisplayName("Should create user when valid data is provided")
void shouldCreateUser_whenValidDataProvided() {
    // Test implementation
}

@Test
@DisplayName("Should throw exception when email is invalid")
void shouldThrowException_whenInvalidEmailProvided() {
    // Test implementation
}

@Test
@DisplayName("Should calculate total with tax for valid order")
void shouldCalculateTotalWithTax_whenValidOrderProvided() {
    // Test implementation
}

@Test
@DisplayName("Should send welcome email when user registers successfully")
void shouldSendWelcomeEmail_whenUserRegisters() {
    // Test implementation
}
```

---

## 91. Create a naming template and share with your team

**Naming Template:**
```
should_[expected_behavior]_when_[condition]
```

**Examples:**
```java
// Success scenarios
should_return_user_when_username_exists()
should_create_user_when_valid_data_provided()
should_calculate_tax_when_order_amount_is_positive()

// Error scenarios
should_throw_exception_when_invalid_email_provided()
should_return_null_when_user_not_found()
should_return_empty_list_when_no_users_exist()

// Business logic scenarios
should_send_welcome_email_when_user_registers()
should_apply_discount_when_user_is_premium()
should_validate_order_when_items_are_available()
```

---

## 92. Format test class names as `<ClassBeingTested>Test`

```java
// Good class names
class UserServiceTest { }
class OrderProcessorTest { }
class EmailValidatorTest { }
class TaxCalculatorTest { }
class PaymentServiceTest { }

// Integration test names
class UserServiceIntegrationTest { }
class OrderControllerIntegrationTest { }
class UserRepositoryIntegrationTest { }

// End-to-end test names
class UserRegistrationE2ETest { }
class OrderProcessingE2ETest { }
```

---

## 93. Group related tests using nested classes or `@Nested`

```java
class UserServiceTest {
    
    @Nested
    @DisplayName("User Creation")
    class UserCreation {
        
        @Test
        void shouldCreateUser_whenValidDataProvided() { }
        
        @Test
        void shouldThrowException_whenUsernameIsEmpty() { }
        
        @Test
        void shouldThrowException_whenEmailIsInvalid() { }
    }
    
    @Nested
    @DisplayName("User Retrieval")
    class UserRetrieval {
        
        @Test
        void shouldReturnUser_whenUserExists() { }
        
        @Test
        void shouldReturnNull_whenUserNotFound() { }
        
        @Test
        void shouldReturnAllUsers_whenUsersExist() { }
    }
    
    @Nested
    @DisplayName("User Update")
    class UserUpdate {
        
        @Test
        void shouldUpdateUser_whenValidDataProvided() { }
        
        @Test
        void shouldThrowException_whenUserNotFound() { }
    }
}
```

---

## 94. Highlight what the test covers in the name

```java
@Test
void shouldValidateEmailFormat_whenEmailContainsAtSymbol() { }

@Test
void shouldValidateEmailFormat_whenEmailContainsDomain() { }

@Test
void shouldValidateEmailFormat_whenEmailIsEmpty() { }

@Test
void shouldValidateEmailFormat_whenEmailIsNull() { }

@Test
void shouldCalculateTaxAt10Percent_whenOrderAmountIs100() { }

@Test
void shouldCalculateTaxAt15Percent_whenOrderAmountIsOver1000() { }

@Test
void shouldApplyNoTax_whenOrderAmountIsZero() { }
```

---

## 95. Use underscores to separate parts of the test name (if preferred)

```java
@Test
void should_return_user_when_username_exists() { }

@Test
void should_throw_exception_when_invalid_email_provided() { }

@Test
void should_calculate_total_with_tax_when_valid_order_provided() { }

@Test
void should_send_welcome_email_when_user_registers() { }

@Test
void should_return_null_when_user_not_found() { }

@Test
void should_return_empty_list_when_no_users_exist() { }
```

---

## 96. Don't encode implementation in test names

**Bad (Implementation Details):**
```java
@Test
void shouldCallRepositorySaveMethod() { }

@Test
void shouldUseHashMapForStorage() { }

@Test
void shouldInvokeEmailServiceSendMethod() { }

@Test
void shouldUseJdbcTemplateForQuery() { }
```

**Good (Behavior Focused):**
```java
@Test
void shouldCreateUser_whenValidDataProvided() { }

@Test
void shouldStoreUserData_whenUserIsCreated() { }

@Test
void shouldSendWelcomeEmail_whenUserRegisters() { }

@Test
void shouldRetrieveUserData_whenUserExists() { }
```

---

## 97. Prefix integration test classes with `IT` (e.g., `UserServiceIT`)

```java
// Integration test classes
class UserServiceIT { }
class OrderControllerIT { }
class UserRepositoryIT { }
class PaymentServiceIT { }
class EmailServiceIT { }

// Unit test classes (no prefix)
class UserServiceTest { }
class OrderControllerTest { }
class UserRepositoryTest { }
class PaymentServiceTest { }
class EmailServiceTest { }

// End-to-end test classes
class UserRegistrationE2ETest { }
class OrderProcessingE2ETest { }
class PaymentFlowE2ETest { }
```

---

## 98. Write test names that communicate behavior, not structure

**Bad (Structure Focused):**
```java
@Test
void testUserServiceCreateMethod() { }

@Test
void testRepositoryFindById() { }

@Test
void testControllerPostEndpoint() { }

@Test
void testValidatorIsValidMethod() { }
```

**Good (Behavior Focused):**
```java
@Test
void shouldCreateUser_whenValidDataProvided() { }

@Test
void shouldReturnUser_whenUserExists() { }

@Test
void shouldReturnCreatedStatus_whenUserIsCreated() { }

@Test
void shouldReturnTrue_whenEmailIsValid() { }
```

---

## 99. Review another dev's test names and provide feedback

**Example Review:**

**Original Test Names:**
```java
@Test
void test1() { }

@Test
void testUserCreation() { }

@Test
void testEmailValidation() { }

@Test
void testException() { }
```

**Feedback:**
- `test1()` → Too vague, doesn't describe what's being tested
- `testUserCreation()` → Better, but doesn't specify conditions
- `testEmailValidation()` → Good start, but missing expected outcome
- `testException()` → Too generic, doesn't specify when exception occurs

**Suggested Improvements:**
```java
@Test
void shouldCreateUser_whenValidDataProvided() { }

@Test
void shouldReturnTrue_whenValidEmailProvided() { }

@Test
void shouldReturnFalse_whenInvalidEmailProvided() { }

@Test
void shouldThrowException_whenInvalidDataProvided() { }
```

---

## 100. Reflect: What's the clearest test name you've ever written?

**Example Reflection:**

**Clearest Test Names:**
```java
@Test
void shouldReturnUser_whenUsernameExists() {
    // Clear: describes expected behavior and condition
}

@Test
void shouldThrowIllegalArgumentException_whenEmailIsNull() {
    // Clear: specifies exact exception type and condition
}

@Test
void shouldCalculateTaxAt10Percent_whenOrderAmountIs100() {
    // Clear: specifies exact calculation and input
}

@Test
void shouldSendWelcomeEmail_whenUserRegistersSuccessfully() {
    // Clear: describes business behavior and success condition
}
```

**Why These Are Clear:**
- **Specific**: They describe exactly what should happen
- **Conditional**: They specify when the behavior occurs
- **Readable**: They read like natural language
- **Complete**: They include both expected outcome and condition
- **Consistent**: They follow a predictable pattern

---

## 🎯 Test Naming Best Practices Summary

### Naming Conventions:
- ✅ Use `should_[expected]_when_[condition]` pattern
- ✅ Be descriptive and specific
- ✅ Focus on behavior, not implementation
- ✅ Use consistent naming across the team

### What to Avoid:
- ❌ Vague names like `test1()`, `testABC()`
- ❌ Implementation details in names
- ❌ Generic names that don't specify conditions
- ❌ Inconsistent naming patterns

### Naming Guidelines:
- ✅ Make names read like natural language
- ✅ Include both expected outcome and condition
- ✅ Be specific about exception types when testing errors
- ✅ Use underscores or camelCase consistently
- ✅ Group related tests with nested classes

### Class Naming:
- ✅ Use `[ClassName]Test` for unit tests
- ✅ Use `[ClassName]IT` for integration tests
- ✅ Use `[ClassName]E2ETest` for end-to-end tests
- ✅ Use `@DisplayName` for human-readable descriptions

---

## 🎯 Complete Test Naming Checklist

- [ ] Test name describes expected behavior
- [ ] Test name includes condition/context
- [ ] Test name is specific and descriptive
- [ ] Test name focuses on behavior, not implementation
- [ ] Test name follows consistent naming convention
- [ ] Test name is readable and natural
- [ ] Test class name follows `[ClassName]Test` pattern
- [ ] Integration tests use `IT` suffix
- [ ] E2E tests use `E2ETest` suffix
- [ ] Related tests are grouped with `@Nested`
- [ ] `@DisplayName` is used for human-readable descriptions

---

**Congratulations! You've completed Phase 5: Writing Clean Test Code!**

## 🎯 Phase 5 Summary

You've mastered:
1. **TDD (Test-Driven Development)** - Red-Green-Refactor cycle
2. **Unit vs Integration Testing** - Understanding test types and when to use each
3. **Clean Test Structure** - AAA pattern and best practices
4. **Mocking and Stubbing** - Using Mockito effectively
5. **Test Naming & Readability** - Writing clear, maintainable test code

These skills will help you write high-quality, maintainable tests that serve as living documentation for your code. 
public class Calculator {
    
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
    
    public int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
    
    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
    
    public double divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) firstNumber / secondNumber;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public boolean isPositive(int number) {
        return number > 0;
    }
} 
import java.util.List;

/**
 * Request object for mathematical calculations
 * Demonstrates clean data transfer object pattern
 */
public class CalculationRequest {
    private final Operation operation;
    private final List<Double> values;
    
    public CalculationRequest(Operation operation, List<Double> values) {
        this.operation = operation;
        this.values = values;
    }
    
    public Operation getOperation() {
        return operation;
    }
    
    public List<Double> getValues() {
        return values;
    }
} 
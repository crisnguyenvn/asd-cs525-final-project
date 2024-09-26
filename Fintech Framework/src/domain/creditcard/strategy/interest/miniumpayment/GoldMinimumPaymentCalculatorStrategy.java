package domain.creditcard.strategy.interest.miniumpayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.framework.strategy.interest.MinimumPaymentCalculatorStrategy;

public class GoldMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    @JsonCreator
    public GoldMinimumPaymentCalculatorStrategy(@JsonProperty("minimumPaymentRate") double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }
}

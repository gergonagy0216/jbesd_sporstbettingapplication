package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    private BigDecimal oddValue;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOdd(BigDecimal oddValue, LocalDateTime validFrom, LocalDateTime validUntil, Outcome outcome) {
        this.oddValue = oddValue;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.outcome = outcome;
    }

    public BigDecimal getOddValue() {
        return oddValue;
    }

    public void setOddValue(BigDecimal oddValue) {
        this.oddValue = oddValue;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return String.format("Actual odd: %.1f Valid between: %s and %s.",getOddValue(),getValidFrom().toString(),getValidUntil().toString());
    }
}

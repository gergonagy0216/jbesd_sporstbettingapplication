package entitybuilders;



import entities.Outcome;
import entities.OutcomeOdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOddBuilder extends BuilderBase<OutcomeOdd> {

    private BigDecimal oddValue;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOddBuilder setOddValue(BigDecimal oddValue) {
        this.oddValue = oddValue;
        return this;
    }

    public OutcomeOddBuilder setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public OutcomeOddBuilder setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public OutcomeOddBuilder setOutcome(Outcome outcome) {
        this.outcome = outcome;
        return this;
    }

    @Override
    public OutcomeOdd build() {
        return new OutcomeOdd(oddValue, validFrom, validUntil, outcome);
    }
}

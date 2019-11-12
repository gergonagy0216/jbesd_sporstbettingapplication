package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    private BigDecimal amount;
    private LocalDateTime timestampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd outcomeOdd;
    private Currency currency;
    private Player player;

    public Wager(BigDecimal amount, LocalDateTime timestampCreated, boolean processed, boolean win, OutcomeOdd outcomeOdd, Currency currency, Player player) {
        this.amount = amount;
        this.timestampCreated = timestampCreated;
        this.processed = processed;
        this.win = win;
        this.outcomeOdd = outcomeOdd;
        this.currency = currency;
        this.player = player;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return String.format("Wager '%s=%s' of %s [odd %.1f, amount %.1f], win: %b",getOutcomeOdd().getOutcome().getBet().getDescription(),getOutcomeOdd().getOutcome().getDescription(),
                getOutcomeOdd().getOutcome().getBet().getSportEvent().getTitle(),
                getOutcomeOdd().getOddValue(),getAmount(),isWin());
    }
}

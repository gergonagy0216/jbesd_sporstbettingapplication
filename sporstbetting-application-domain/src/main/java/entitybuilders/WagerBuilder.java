package entitybuilders;



import entities.Currency;
import entities.OutcomeOdd;
import entities.Player;
import entities.Wager;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WagerBuilder extends BuilderBase<Wager> {
    private BigDecimal amount;
    private LocalDateTime timestampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd outcomeOdd;
    private Currency currency;
    private Player player;

    public WagerBuilder setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public WagerBuilder setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
        return this;
    }

    public WagerBuilder setProcessed(boolean processed) {
        this.processed = processed;
        return this;
    }

    public WagerBuilder setWin(boolean win) {
        this.win = win;
        return this;
    }

    public WagerBuilder setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
        return this;
    }

    public WagerBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public WagerBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public Wager build() {
        return new Wager(amount, timestampCreated, processed, win, outcomeOdd, currency, player);
    }
}

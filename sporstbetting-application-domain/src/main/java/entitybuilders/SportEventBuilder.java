package entitybuilders;


import entities.Bet;
import entities.Result;
import entities.SportEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEventBuilder extends BuilderBase<SportEvent> {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Result result;
    private List<Bet> bets;

    public SportEventBuilder() {
        bets = new ArrayList<>();
    }

    public SportEventBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SportEventBuilder setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public SportEventBuilder setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public SportEventBuilder setResult(Result result) {
        this.result = result;
        return this;
    }

    public SportEventBuilder addBet(Bet bet) {
        this.bets.add(bet);
        return this;
    }

    @Override
    public SportEvent build() {
        return new SportEvent(title, startDate, endDate, result, bets);
    }
}

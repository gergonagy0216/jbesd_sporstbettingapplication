package entitybuilders;



import entities.Bet;
import entities.BetType;
import entities.Outcome;
import entities.SportEvent;

import java.util.ArrayList;
import java.util.List;

public class BetBuilder extends BuilderBase<Bet> {

    private SportEvent event;
    private String description;
    private BetType betType;
    private List<Outcome> outcomes;

    public BetBuilder() {
        outcomes = new ArrayList<>();
    }

    public BetBuilder setEvent(SportEvent event) {
        this.event = event;
        return this;
    }

    public BetBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BetBuilder setBetType(BetType betType) {
        this.betType = betType;
        return this;
    }

    public BetBuilder addOutcome(Outcome outcome) {
        this.outcomes.add(outcome);
        return this;
    }

    @Override
    public Bet build() {
        return new Bet(event, description, betType, outcomes);
    }
}

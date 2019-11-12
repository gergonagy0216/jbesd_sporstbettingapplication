package entities;

import java.util.List;

public class Bet {

    private SportEvent event;
    private String description;
    private BetType betType;
    private List<Outcome> outcomes;

    public Bet(SportEvent event, String description, BetType betType, List<Outcome> outcomes) {
        this.event = event;
        this.description = description;
        this.betType = betType;
        this.outcomes = outcomes;
    }

    public SportEvent getSportEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomeList(List<Outcome> outcomeList) {
        this.outcomes = outcomeList;
    }

    @Override
    public String toString() {
        return String.format("Bet: %s,", getDescription());
    }
}

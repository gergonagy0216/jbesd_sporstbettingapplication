package entities;

import java.util.List;

public class Outcome {
    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(String description, Bet bet, List<OutcomeOdd> outcomeOdds) {
        this.description = description;
        this.bet = bet;
        this.outcomeOdds = outcomeOdds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }

    @Override
    public String toString() {

        return String.format("Outcome: %s, ", getDescription());
    }
}

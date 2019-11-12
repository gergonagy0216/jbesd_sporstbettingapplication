package entities;

import java.time.LocalDateTime;
import java.util.List;

public class SportEvent {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Result result;
    private List<Bet> bets;

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, Result result, List<Bet> bets) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.result = result;
        this.bets = bets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return String.format("Sport event: %s (start: %s)", getTitle(), getStartDate().toString());

    }
}

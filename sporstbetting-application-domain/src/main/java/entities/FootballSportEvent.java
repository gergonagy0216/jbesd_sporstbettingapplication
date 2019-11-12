package entities;

import java.time.LocalDateTime;
import java.util.List;

public class FootballSportEvent extends SportEvent {

    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, Result result, List<Bet> bets) {
        super(title, startDate, endDate, result, bets);
    }
}

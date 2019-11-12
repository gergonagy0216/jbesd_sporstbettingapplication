package interfaces;




import entities.Player;
import entities.SportEvent;
import entities.Wager;

import java.util.List;

public interface SportsBettingService {
    void savePlayer(Player player);
    Player findPlayer();
    List<SportEvent> findAllSportEvents();
    void saveWager(Wager wager);
    List<Wager> findAllWagers();
    void calculateResults();

}

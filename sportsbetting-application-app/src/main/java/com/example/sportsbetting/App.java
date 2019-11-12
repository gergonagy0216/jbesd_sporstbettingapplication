package com.example.sportsbetting;




import com.example.sportsbetting.view.ApplicationView;
import com.example.sportsbetting.view.View;
import entities.OutcomeOdd;
import entities.Player;
import entities.SportEvent;
import entities.Wager;
import entitybuilders.*;
import exception.OutcomeNotFoundException;
import exception.UserWantsToQuitException;
import interfaces.SportsBettingService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private SportsBettingService sportsBettingService;
    private View view;

    private Player actualPlayer;
    private List<SportEvent> sportEvents;
    private List<Wager> wagers;

    public static void main(String[] args) {
        App app = new App(null, new ApplicationView());
        app.play();
    }

    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
        this.sportEvents = new ArrayList<>();
        this.sportEvents.add(buildSportEvent());
        this.wagers = new ArrayList<>();
    }

    private SportEvent buildSportEvent() {
        var sportEvent = new SportEventBuilder().setTitle("Arsenal vs Chelsea")
                .setStartDate(LocalDateTime.of(2020, Month.JANUARY, 01, 12, 00, 00)).build();

        var outcomeOdd1 = new OutcomeOddBuilder().setOddValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2000, Month.JANUARY, 01, 12, 00, 00))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 01, 12, 00, 00)).build();
        var outcomeOdd2 = new OutcomeOddBuilder().setOddValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000, Month.JANUARY, 01, 12, 00, 00))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 01, 12, 00, 00)).build();
        var outcomeOdd3 = new OutcomeOddBuilder().setOddValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2000, Month.JANUARY, 01, 12, 00, 00))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 01, 12, 00, 00)).build();
        var outcomeOdd4 = new OutcomeOddBuilder().setOddValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000, Month.JANUARY, 01, 12, 00, 00))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 01, 12, 00, 00)).build();


        var bet1 = new BetBuilder().setDescription("player Oliver Giroud score").setEvent(sportEvent).build();
        var bet2 = new BetBuilder().setDescription("number of scored goals").setEvent(sportEvent).build();
        var bet3 = new BetBuilder().setDescription("winner").setEvent(sportEvent).build();

        var outcome1 = new OutcomeBuilder().setDescription("Arsenal").addOutcomeOdd(outcomeOdd3).setBet(bet3).build();
        var outcome2 = new OutcomeBuilder().setDescription("Chelsea").addOutcomeOdd(outcomeOdd4).setBet(bet3).build();
        var outcome3 = new OutcomeBuilder().setDescription("3").addOutcomeOdd(outcomeOdd2).setBet(bet2).build();
        var outcome4 = new OutcomeBuilder().setDescription("1").addOutcomeOdd(outcomeOdd1).setBet(bet1).build();

        outcomeOdd1.setOutcome(outcome4);
        outcomeOdd2.setOutcome(outcome3);
        outcomeOdd3.setOutcome(outcome1);
        outcomeOdd4.setOutcome(outcome2);

        bet1.getOutcomes().add(outcome4);
        bet2.getOutcomes().add(outcome3);
        bet3.getOutcomes().add(outcome1);
        bet3.getOutcomes().add(outcome2);

        sportEvent.getBets().add(bet1);
        sportEvent.getBets().add(bet2);
        sportEvent.getBets().add(bet3);

        return sportEvent;

    }

    void play() {
        actualPlayer = view.readPlayerData();
        view.printWelcomeMessage(actualPlayer);
        view.printBalance(actualPlayer);
        doBetting();
        calculateResults();
        printResults();
    }

    void createPlayer() {

    }

    void doBetting() {
        boolean hasUserQuit = false;

        while (!hasUserQuit) {
            OutcomeOdd selectedOutcomeOdd = null;
            var isOutcomeNotFound = false;

            view.printOutcomeOdds(sportEvents);
            try {
                selectedOutcomeOdd = view.selectOutcomeOdd(sportEvents);
            } catch (UserWantsToQuitException e) {
                hasUserQuit = true;
            } catch (OutcomeNotFoundException e) {
                System.out.println(e.getMessage());
                isOutcomeNotFound = true;
            }

            if (!hasUserQuit && !isOutcomeNotFound) {
                var wagerAmount = view.readWagerAmount();
                if (actualPlayer.getBalance().subtract(wagerAmount).compareTo(BigDecimal.ZERO) > 0) {
                    var newWager = new WagerBuilder().setAmount(wagerAmount).setOutcomeOdd(selectedOutcomeOdd)
                            .setPlayer(actualPlayer).build();
                    wagers.add(newWager);
                    actualPlayer.setBalance(actualPlayer.getBalance().subtract(newWager.getAmount()));
                    view.printWagerSaved(newWager);
                } else {
                    view.printNotEnoughBalance(actualPlayer);
                }
            }

        }
    }

    void calculateResults() {
        for (var wager : this.wagers) {
            wager.setWin(new Random().nextBoolean());
            if (wager.isWin()) {
                actualPlayer.setBalance(actualPlayer.getBalance().add(wager.getAmount().multiply(wager.getOutcomeOdd().getOddValue())));
            }
        }
    }

    void printResults() {
        view.printResults(actualPlayer, wagers);
    }


}

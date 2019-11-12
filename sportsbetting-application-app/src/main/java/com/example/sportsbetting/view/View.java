package com.example.sportsbetting.view;

import entities.OutcomeOdd;
import entities.Player;
import entities.SportEvent;
import entities.Wager;
import exception.OutcomeNotFoundException;
import exception.UserWantsToQuitException;

import java.math.BigDecimal;
import java.util.List;

public interface View {
    Player readPlayerData();
    void printWelcomeMessage(Player player);
    void printBalance(Player player);
    void printOutcomeOdds(List<SportEvent> sportEvents);
    OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) throws UserWantsToQuitException, OutcomeNotFoundException;
    BigDecimal readWagerAmount();
    void printWagerSaved(Wager wager);
    void printNotEnoughBalance(Player player);
    void printResults(Player player,List<Wager> wagers);
}

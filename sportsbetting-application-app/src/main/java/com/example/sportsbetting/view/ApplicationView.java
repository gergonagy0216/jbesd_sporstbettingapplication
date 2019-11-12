package com.example.sportsbetting.view;


import entities.*;
import entitybuilders.PlayerBuilder;
import exception.OutcomeNotFoundException;
import exception.UserWantsToQuitException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationView implements View {

    @Override
    public Player readPlayerData() {
        var playerBuilder = new PlayerBuilder();
        var scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        playerBuilder.setName(scanner.nextLine());
        System.out.println("How much money do you have (more than 0)?");
        playerBuilder.setBalance(scanner.nextBigDecimal());
        System.out.println("What is your currency? (HUF,EUR or USD)");
        playerBuilder.setCurrency(Currency.valueOf(scanner.next()));

        return playerBuilder.build();
    }

    @Override
    public void printWelcomeMessage(Player player) {
        System.out.println(String.format("Welcome %s!", player.getName()));
    }

    @Override
    public void printBalance(Player player) {
        System.out.println(String.format("Your balance is %.0f %s.\n", player.getBalance(), player.getCurrency().toString()));
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        var countOfBets = sportEvents.stream().map(SportEvent::getBets).filter(Objects::nonNull)
                .mapToInt(List::size).sum();

        var map = new HashMap<Integer, Integer>();
        int rowNumber = 0;

        for (int j = 0; j < sportEvents.size(); j++) {
            for (int i = 0; i < countOfBets; i++) {
                map.put(i, sportEvents.get(j).getBets().get(i).getOutcomes().size());
            }
        }

        System.out.println("What are you want to bet on? (choose a number or press q for quit)");

        for (int k = 0; k < sportEvents.size(); k++) {
            for (int i = 0; i < countOfBets; i++) {
                for (int j = 0; j < map.get(i); j++) {
                    System.out.println(String.format("%d: %s, %s %s %s", rowNumber + 1, sportEvents.get(k), sportEvents.get(k).getBets().get(i), sportEvents.get(k).getBets().get(i).getOutcomes().get(j), sportEvents.get(k).getBets().get(i).getOutcomes().get(j).getOutcomeOdds().get(0)));
                    rowNumber++;
                }
            }
        }
    }

    private int readChosen() throws UserWantsToQuitException {
        var chosen = new Scanner(System.in).next();
        if (chosen.toLowerCase().equals("q")) {
            throw new UserWantsToQuitException();
        }
        return Integer.parseInt(chosen);
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) throws UserWantsToQuitException, OutcomeNotFoundException {
        var chosen = readChosen();
        int count = 0;

        for (var sportEvent : sportEvents) {
            for (var bet : sportEvent.getBets()) {
                for (var outcome : bet.getOutcomes()) {
                    if (chosen - 1 == count) {
                        return outcome.getOutcomeOdds().get(0);
                    }
                    count++;
                }
            }
        }
        throw new OutcomeNotFoundException("Outcome not found");
    }

    @Override
    public BigDecimal readWagerAmount() {
        System.out.println("What amount do you wish to bet on it?");
        return new Scanner(System.in).nextBigDecimal();
    }

    @Override
    public void printWagerSaved(Wager wager) {
        System.out.println(String.format("Wager '%s' of %s [odd: %.0f, amount %.0f]", wager.getOutcomeOdd().getOutcome().getBet().getDescription(),
                wager.getOutcomeOdd().getOutcome().getBet().getSportEvent().getTitle(), wager.getOutcomeOdd().getOddValue(), wager.getAmount()));

        System.out.println(String.format("Your balance is %.0f %s", wager.getPlayer().getBalance(), wager.getPlayer().getCurrency().toString()));
    }

    @Override
    public void printNotEnoughBalance(Player player) {
        System.out.println(String.format("You don't have enough money. Your balance is %.0f %s!", player.getBalance(), player.getCurrency().toString()));
    }

    @Override
    public void printResults(Player player, List<Wager> wagers) {
        System.out.println("Results:");
        for (var wager : wagers) {
            System.out.println(wager);
        }
        System.out.println(String.format("Your new balance is %.0f %s", player.getBalance(), player.getCurrency().toString()));
    }
}

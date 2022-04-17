package com.talan.kata.tennis.strategy.impl;

import com.talan.kata.tennis.Player;
import com.talan.kata.tennis.strategy.Result;

import java.util.Map;

public class AdvancedResult implements Result {
  private static final Map<Integer, String> FORMATTER_MAPPING = Map.of(0, "Deuce",
    1, "Advantage %s",
    2, "Win for %s");

  @Override
  public String display(Player player1, Player player2) {
    final int currentStepInGame = getCurrentStep(player1.getScore(), player2.getScore());
    final String scoreFormatter = FORMATTER_MAPPING.get(currentStepInGame);
    return String.format(scoreFormatter, getAdvantagedPlayer(player1, player2).getName());
  }

  private int getCurrentStep(int score1, int score2) {
    return Math.min(2, Math.abs(score1 - score2));
  }

  private Player getAdvantagedPlayer(Player player1, Player player2) {
    return player1.getScore() > player2.getScore() ? player1 : player2;
  }
}

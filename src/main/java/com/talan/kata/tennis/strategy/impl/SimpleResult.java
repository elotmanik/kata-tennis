package com.talan.kata.tennis.strategy.impl;

import com.talan.kata.tennis.Player;
import com.talan.kata.tennis.strategy.Result;

import java.util.Map;

public class SimpleResult implements Result {
  private static final Map<Integer, String> DISPLAY_MAPPING = Map.of(0, "Love",
    1, "Fifteen",
    2, "Thirty",
    3, "Forty");

  public static final String RESULT_FORMAT = "%s-%s";

  @Override
  public String display(Player player1, Player player2) {
    var player1ScoreText = DISPLAY_MAPPING.get(player1.getScore());
    String player2ScoreText;
    if (haveSameScore(player1, player2)) {
      player2ScoreText = "All";
    } else {
      player2ScoreText = DISPLAY_MAPPING.get(player2.getScore());
    }
    return String.format(RESULT_FORMAT, player1ScoreText, player2ScoreText);
  }

  private boolean haveSameScore(Player player1, Player player2) {
    return player1.getScore() == player2.getScore();
  }
}

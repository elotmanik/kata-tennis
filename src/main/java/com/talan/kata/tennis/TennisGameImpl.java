package com.talan.kata.tennis;

import com.talan.kata.tennis.strategy.impl.AdvancedResult;
import com.talan.kata.tennis.strategy.Result;
import com.talan.kata.tennis.strategy.impl.SimpleResult;

import java.util.Objects;

public class TennisGameImpl implements TennisGame {

  private final Player player1;
  private final Player player2;
  private final Result simpleResult;
  private final Result advancedResult;

  public TennisGameImpl(String player1, String player2) {
    this.player1 = new Player(player1);
    this.player2 = new Player(player2);
    this.simpleResult = new SimpleResult();
    this.advancedResult = new AdvancedResult();
  }

  @Override
  public void wonPoint(String playerName) {
    Objects.requireNonNull(playerName);
    if (playerName.equals(player1.getName())) {
      player1.wonPoint();
    } else if (playerName.equals(player2.getName())) {
      player2.wonPoint();
    } else {
      throw new IllegalArgumentException("the specified name is not a player" + playerName);
    }
  }

  @Override
  public String getScore() {
    if (gameIsStillSimple()) {
      return simpleResult.display(player1, player2);
    }
    return advancedResult.display(player1, player2);
  }

  private boolean gameIsStillSimple() {
    final int score1 = player1.getScore();
    final int score2 = player2.getScore();
    return score1 <= 3 && score2 <= 3 && score1 + score2 < 6;
  }

}

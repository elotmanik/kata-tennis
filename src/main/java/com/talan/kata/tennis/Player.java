package com.talan.kata.tennis;

import java.util.Objects;

public class Player {
  private final String name;
  private int score;

  public Player(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public String getName() {
    return name;
  }

  public void wonPoint() {
    score++;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return name.equals(player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

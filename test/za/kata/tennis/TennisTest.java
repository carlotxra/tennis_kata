package za.kata.tennis;

import junit.framework.TestCase;

/**
 * In a game of tennis, a player starts with a score of 0. With each success, the player earns more points. The points are earned in this sequence.
 * 0 -> 15 -> 30 -> 40
 * If a player has 40 and scores again that player wins the game as long as the other player does not also have 40 points. If both players reach 40 points it is referred to as "deuce".
 * Deuce:
 * Scoring during deuce gives a player advantage. If the other player scores again the score returns to deuce.
 * If a player has advantage and scores again, that player wins the game.
 * Requirements
 * Write a program to handle each of these requirements scoring a two player game of tennis.
 * • Players must be able to score points.
 * • The game must be able to be completed with a winner.
 * • The "deuce" case should be handled.
 * • After a game has been won, a winner must be determined.
 * • Be able to get the current score of either player at any point during the game.
 */
public class TennisTest extends TestCase {

  public void testStartOfGameScoreIsLoveAll() throws Exception {
    Game game = createGame();
    assertEquals("0-0", game.getScore());
    assertEquals("", game.winner());
  }

  public void testPlayerOneScores() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    assertEquals("15-0", game.getScore());
  }

  public void testPlayerOneScoresTwice30up() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    assertEquals("30-0", game.getScore());
  }

  public void testPlayerOneScoresThreeTimes40up() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();
    assertEquals("40-0", game.getScore());
  }

  public void testPlayerOneScoresFourTimesAndWins() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();
    assertEquals("win-0", game.getScore());
  }

  public void testPlayerOneScoresThreeTimesWhilePlayer2ScoresOnlyTwoTimes() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();

    game.playerTwoScores();
    game.playerTwoScores();
    assertEquals("40-30", game.getScore());
  }

  public void testGameIsDeuce() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();

    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();
    assertEquals("40-40", game.getScore());
  }

  public void testGameIsDeuceThenAdvantagePlayer1() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();

    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();

    game.playerOneScores();
    assertEquals("adv-40", game.getScore());
  }

  public void testAdvantagePlayer1ThenWin() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();

    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();

    game.playerOneScores();
    assertEquals("adv-40", game.getScore());

    game.playerOneScores();
    assertEquals("win-40", game.getScore());
  }

  public void testAdvantagePlayer1ThenDeuce() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();

    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();

    game.playerOneScores();
    assertEquals("adv-40", game.getScore());

    game.playerTwoScores();
    assertEquals("40-40", game.getScore());
  }

  public void testPlayerTwoScores() throws Exception {
    Game game = createGame();
    game.playerTwoScores();
    assertEquals("0-15", game.getScore());
  }

  public void testBothPlayerScoreIsFifteenAll() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerTwoScores();
    assertEquals("15-15", game.getScore());
  }

  public void testPlayerOneWins() throws Exception {
    Game game = createGame();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();
    game.playerOneScores();
    assertEquals("win-0", game.getScore());
    assertEquals("jack", game.winner());
  }

  public void testPlayerTwoWins() throws Exception {
    Game game = createGame();
    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();
    game.playerTwoScores();
    assertEquals("0-win", game.getScore());
    assertEquals("jill", game.winner());
  }

  private Game createGame() {
    return new Game("jack", "jill");
  }

}

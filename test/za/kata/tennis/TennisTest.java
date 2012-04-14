package za.kata.tennis;

import junit.framework.TestCase;
import za.katak.tennis.Game;

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
  private String loveAll = "0-0";
  private String fifteenLove = "15-0";
  private String fifteenAll = "15-15";
  private String thirtyLove = "30-0";
  private String fourtyLove = "40-0";

  public void testNewGameScoreIsLoveAll() throws Exception {
    Game game = new Game();
    assertEquals(loveAll, game.getScore());
  }

  public void testPlayerOneScores() throws Exception {
    Game game = new Game();
    game.playerOneScoresPoint();
    assertEquals(fifteenLove, game.getScore());
  }

  public void testFifteenAll() throws Exception {
    Game game = new Game();
    game.playerOneScoresPoint();
    game.playerTwoScoresPoint();
    assertEquals(fifteenAll, game.getScore());
  }

  public void testThirtyLove() throws Exception {
    Game game = new Game();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    assertEquals(thirtyLove, game.getScore());
  }

  public void testFourtyLove() throws Exception {
    Game game = new Game();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    assertEquals(fourtyLove, game.getScore());
  }

  public void testPlayerOneWins() throws Exception {
    Game game = new Game();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    assertEquals("win-0", game.getScore());
  }

  public void testPlayerTwoWins() throws Exception {
    Game game = new Game();
    game.playerTwoScoresPoint();
    game.playerTwoScoresPoint();
    game.playerTwoScoresPoint();
    game.playerTwoScoresPoint();
    assertEquals("0-win", game.getScore());
  }

  public void testDeuce() throws Exception {
    Game game = new Game();
    createDeuceGame(game);
    assertGameScoreIsDeuce(game);
  }

  private void assertGameScoreIsDeuce(Game game) {
    assertEquals("deuce", game.getScore());
  }

  public void testAdvantagePlayerOne() throws Exception {
    // Given
    Game game = new Game();
    createDeuceGame(game);
    assertGameScoreIsDeuce(game);
    //When
    game.playerOneScoresPoint();
    // Then
    assertEquals("adv-40", game.getScore());
  }

  public void testAdvantagePlayerOneThenWin() throws Exception {
    // Given
    Game game = new Game();
    createDeuceGame(game);
    game.playerOneScoresPoint();
    assertEquals("adv-40", game.getScore());
    //When
    game.playerOneScoresPoint();
    // Then
    assertEquals("win-40", game.getScore());
  }

  public void testAdvantagePlayerOneThenPlayerTwoScores() throws Exception {
    // Given
    Game game = new Game();
    createDeuceGame(game);
    game.playerOneScoresPoint();
    assertEquals("adv-40", game.getScore());
    //When
    game.playerTwoScoresPoint();
    // Then
    assertEquals("deuce", game.getScore());
  }

  public void testAfterLosingAdvantageAndScoresPointGainsAdvantageAgain() throws Exception {
    // Given
    Game game = new Game();
    createDeuceGame(game);
    game.playerOneScoresPoint();
    game.playerTwoScoresPoint();
    assertEquals("deuce", game.getScore());
    //When
    game.playerOneScoresPoint();
    // Then
    assertEquals("adv-40", game.getScore());
  }

  public void testLoseAdvantageThenGainAdvantageAndWin() throws Exception {
    // Given
    Game game = new Game();
    createDeuceGame(game);
    game.playerOneScoresPoint();
    game.playerTwoScoresPoint();
    game.playerOneScoresPoint();
    assertEquals("adv-40", game.getScore());
    //When
    game.playerOneScoresPoint();
    // Then
    assertEquals("win-40", game.getScore());
  }

  private Game createDeuceGame(Game game) {
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    game.playerOneScoresPoint();
    game.playerTwoScoresPoint();
    game.playerTwoScoresPoint();
    game.playerTwoScoresPoint();
    return game;
  }


}

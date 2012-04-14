package za.katak.tennis;

public class Game {
  private GameScore gameScore = new GameScore();

  public String getScore() {
    return gameScore.getScore();
  }

  public void playerOneScoresPoint() {
    gameScore.playerOneScoresPoint();
  }

  public void playerTwoScoresPoint() {
    gameScore.playerTwoScoresPoint();
  }
}

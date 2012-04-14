package za.katak.tennis;

/**
 *
 */
public class GameScore {
  private Score playerOneScore = new Score();
  private Score playerTwoScore = new Score();
  private String fourtyAll = "40-40";
  private String deuce = "deuce";

  public String getScore() {
    String score = playerOneScore + "-" + playerTwoScore;
    if (isDeuce(score)) return "deuce";

    return score;
  }

  private boolean isDeuce(String score) {
    return fourtyAll.equals(score);
  }

  public void playerOneScoresPoint() {
    if (playerTwoScore.isAdvantagePoint()) {
      playerTwoScore = playerTwoScore.losesAdvantage();
      return;
    }

    playerOneScore = nextScoreFor(playerOneScore);
  }

  public void playerTwoScoresPoint() {
    if (playerOneScore.isAdvantagePoint()) {
      playerOneScore = playerOneScore.losesAdvantage();
      return;
    }

    playerTwoScore = nextScoreFor(playerTwoScore);
  }

  protected Score nextScoreFor(Score playerScore) {
    if (currentScoreIsDeuce()) return new AdvantageScore(playerScore);

    return playerScore.point();
  }

  private boolean currentScoreIsDeuce() {
    return deuce.equals(getScore());
  }

}

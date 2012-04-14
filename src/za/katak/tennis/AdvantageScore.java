package za.katak.tennis;

/**
 *
 */
public class AdvantageScore extends Score {
  private Score previousScore;

  public AdvantageScore(Score previousScore) {
    this.previousScore = previousScore;
  }

  public Score point() {
    return new WinScore();
  }

  public String getScore() {
    return "adv";
  }

  public boolean isAdvantagePoint() {
    return true;
  }

  public Score losesAdvantage() {
    return getPreviousScore();
  }

  private Score getPreviousScore() {
    return previousScore;
  }
}

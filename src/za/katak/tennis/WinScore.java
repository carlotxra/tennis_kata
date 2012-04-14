package za.katak.tennis;

/**
 *
 */
public class WinScore extends Score {
  public String getScore() {
    return "win";
  }

  public Score point() {
    return this;
  }

  public boolean isAdvantagePoint() {
    return false;
  }

  public Score losesAdvantage() {
    return this;
  }
}

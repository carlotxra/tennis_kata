package za.katak.tennis;

/**
 */
public class Score implements TennisScore {
  private int points = 0;

  public Score point() {
    if (points == 3) return new WinScore();

    points++;
    return this;
  }

  public String getScore() {
    if (points == 1) return "15";
    if (points == 2) return "30";
    if (points == 3) return "40";

    return "0";
  }

  public String toString() {
    return getScore();
  }

  public boolean isAdvantagePoint() {
    return false;
  }

  public Score losesAdvantage() {
    return this;
  }
}

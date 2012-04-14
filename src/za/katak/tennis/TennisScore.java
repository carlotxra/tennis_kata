package za.katak.tennis;

/**
 *
 */
public interface TennisScore {
  Score point();

  String toString();

  boolean isAdvantagePoint();

  Score losesAdvantage();

  String getScore();

}

package za.kata.tennis;

/**
 */
public class Game {
  private int player1Score;
  private int player2Score;
  private String player1Name;
  private String player2Name;

  public Game(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public String getScore() {
    return player1Score() + "-" + player2Score();
  }

  private String player2Score() {
    return scoreFor(player2Score, player1Score);
  }

  private String player1Score() {
    return scoreFor(player1Score, player2Score);
  }

  public void playerOneScores() {
    if (player2Score >= 4) {
      player2Score--;
      return;
    }
    player1Score++;
  }

  public void playerTwoScores() {
    if (player1Score >= 4) {
      player1Score--;
      return;
    }
    player2Score++;
  }

  private String scoreFor(int score, int otherPlayersScore) {
    if (score == 0) return "0";
    if (score == 1) return "15";
    if (score == 2) return "30";
    if (score == 3 && otherPlayersScore <= 4) return "40";
    if (score == 3 && otherPlayersScore == 5) return "40";
    if (score == 4 && otherPlayersScore == 3) return "adv";
    if (score == 5) return "win";

    return "win";
  }

  public String winner() {
    if (player1Score().equals("win")) return player1Name;
    if (player2Score().equals("win")) return player2Name;
    return "";
  }
}

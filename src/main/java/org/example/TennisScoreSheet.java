public class TennisScoreSheet {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisScoreSheet(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void scorePoint(String playerName) {
        if (playerName.equalsIgnoreCase(player1Name)) {
            player1Score++;
        } else if (playerName.equalsIgnoreCase(player2Name)) {
            player2Score++;
        } else {
            System.out.println("Invalid player name.");
        }
    }

    public String getScore() {
        return player1Name + ": " + formatScore(player1Score) + " - " + player2Name + ": " + formatScore(player2Score);
    }

    private String formatScore(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "Advantage";
        }
    }

    public boolean isGameOver() {
        if ((player1Score > 3 && player1Score - player2Score >= 2) ||
                (player2Score > 3 && player2Score - player1Score >= 2)) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (isGameOver()) {
            return (player1Score > player2Score) ? player1Name : player2Name;
        } else {
            return "No winner yet.";
        }
    }

    public static void main(String[] args) {
        TennisScoreSheet match = new TennisScoreSheet("Player 1", "Player 2");

        match.scorePoint("Player 1");
        match.scorePoint("Player 1");
        match.scorePoint("Player 2");
        match.scorePoint("Player 2");
        match.scorePoint("Player 1");

        System.out.println(match.getScore());

        if (match.isGameOver()) {
            System.out.println("Winner: " + match.getWinner());
        } else {
            System.out.println("The game is still ongoing.");
        }
    }
}

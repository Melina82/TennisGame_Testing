public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;

    public void player1Scores() throws TennisGameException {
        if (isGameOver()) {
            throw new TennisGameException("Game is already over!");
        }
        player1Points++;
    }

    public void player2Scores() throws TennisGameException {
        if (isGameOver()) {
            throw new TennisGameException("Game is already over!");
        }
        player2Points++;
    }

    public String getScore() {
        // Handle Win conditions
        if (player1Points >= 4 && player1Points >= player2Points + 2) {
            return "Player 1 wins";
        }
        if (player2Points >= 4 && player2Points >= player1Points + 2) {
            return "Player 2 wins";
        }

        // Handle Deuce and Advantage
        if (player1Points >= 3 && player2Points >= 3) {
            if (player1Points == player2Points) {
                return "Deuce";
            }
            if (player1Points == player2Points + 1) {
                return "Advantage Player 1";
            }
            if (player2Points == player1Points + 1) {
                return "Advantage Player 2";
            }
        }

        // Default case: Regular score
        return translateScore(player1Points) + "-" + translateScore(player2Points);
    }

    private boolean isGameOver() {
        return (player1Points >= 4 && player1Points >= player2Points + 2) ||
               (player2Points >= 4 && player2Points >= player1Points + 2);
    }

    private String translateScore(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                return "Unknown";
        }
    }
}

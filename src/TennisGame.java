public class TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;

    // Player 1 scores a point
    public void player1Scores() throws TennisGameException {
        if (isGameOver()) { // Modified: Prevent scoring after game ends
            throw new TennisGameException("Game is already over!");
        }
        player1Points++;
    }

    // Player 2 scores a point
    public void player2Scores() throws TennisGameException {
        if (isGameOver()) { // Modified: Prevent scoring after game ends
            throw new TennisGameException("Game is already over!");
        }
        player2Points++;
    }

    // Get the score of the game
    public String getScore() {
        // Check if Player 1 has won
        if (player1Points >= 4 && player1Points >= player2Points + 2) { // Modified: Win condition
            return "Player 1 wins";
        }

        // Check if Player 2 has won
        if (player2Points >= 4 && player2Points >= player1Points + 2) { // Modified: Win condition
            return "Player 2 wins";
        }

        // Handle Deuce and Advantage scenarios
        if (player1Points >= 3 && player2Points >= 3) { // Modified: Deuce and Advantage logic
            if (player1Points == player2Points) {
                return "Deuce";
            } else if (player1Points == player2Points + 1) {
                return "Advantage Player 1";
            } else if (player2Points == player1Points + 1) {
                return "Advantage Player 2";
            }
        }

        // Default case: Regular score
        return translateScore(player1Points) + "-" + translateScore(player2Points);
    }

    // Helper method to check if the game is over
    private boolean isGameOver() { // Modified: New helper method to handle game-ending conditions
        return (player1Points >= 4 && player1Points >= player2Points + 2) ||
               (player2Points >= 4 && player2Points >= player1Points + 2);
    }

    // Helper method to translate points to tennis terms
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
                return "Unknown"; // Modified: Safeguard for invalid scores
        }
    }
}

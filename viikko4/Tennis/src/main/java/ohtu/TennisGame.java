package ohtu;

import java.util.HashMap;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private HashMap<Integer, String> scoreName;
    
    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scoreName = new HashMap<>();
        initializeStrings();
    }

    private void initializeStrings() {
        scoreName.put(0, "Love");
        scoreName.put(1, "Fifteen");
        scoreName.put(2, "Thirty");
        scoreName.put(3, "Forty");
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    private boolean gameIsEqual() {
        if (player1Score == player2Score) return true;
        return false;
    }
    
    private boolean playerHasOverFour() {
        if (player1Score >=4 || player2Score >=4) return true;
        return false;
    }
    
    public String scoreToString(int scoreToString) {
        return scoreName.get(scoreToString);
    }
    
    public String tieHandler() {
        if (player1Score < 4) {
            return scoreToString(player1Score) + "-All";
        } else {
            return "Deuce"; 
        }
    }
    
    public String winnerHandler() {
        if (player1Score > player2Score) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
    
    public String advantageHandler() {
        if (player1Score > player2Score) {
            return "Advantage player1";
        } else {
            return "Advantage player2";
        }
    }
    
    public String overFourHandler() {
        int scoreDifference = Math.abs(player1Score - player2Score);
        if (scoreDifference < 2) {
            return advantageHandler();
        } else {
            return winnerHandler();
        }
    }
    
    public String generalScoreHandler() {
        return scoreToString(player1Score) + "-" + scoreToString(player2Score);
    }
    
    public String getScore() {
        if (gameIsEqual()) {
            return tieHandler();
        } else if (playerHasOverFour()) {
            return overFourHandler();
        } else {
            return generalScoreHandler();
        }
    }
}
package ohtu;

public class TennisGame {
    
    private int score1;
    private int score2;
    private String player1;
    private String player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
        this.score1 = 0;
        this.score2 = 0;
    }

    public void wonPoint(String playerName) {
        int point = 1;
        
        if (playerName.equals(player1)) {
            score1 += point;
        }
        else if (playerName.equals(player2)) {
            score2 += point;
        }
        else {
            System.out.println("Invalid player name");
        }
    }

    public String getScore() {
        String scoreString = "";
        int scoreDifference = score1 - score2;
        int fortyPoints = 4;
        
        if (scoreDifference == 0)
        {
            scoreString = tie();
        }
        else if (score1 >= fortyPoints || score2 >= fortyPoints)
        {
            if (scoreDifference == 1 || scoreDifference == -1) {
                scoreString = advantage(scoreDifference);
            } else if (scoreDifference >= 2 || scoreDifference <= -2) {
                scoreString = winning(scoreDifference);
            }
        }
        else
        {
            scoreString = threeOrLessPoints();
        }
        
        return scoreString;
    }
    
    // get score string in a tie
    public String tie() {
        String scoreString;
        
        switch (score1)
            {
                case 0:
                    scoreString = "Love-All";
                    break;
                case 1:
                    scoreString = "Fifteen-All";
                    break;
                case 2:
                    scoreString = "Thirty-All";
                    break;
                case 3:
                    scoreString = "Forty-All";
                    break;
                default:
                    scoreString = "Deuce";
                    break;
                
            }
        
        return scoreString;
    }
    
    // get score string in a situation where one player has advantage
    public String advantage(int scoreDifference) {
        String scoreString = "";
        
        int advantage1 = 1;
        int advantage2 = -1;
            
        if (scoreDifference == advantage1) scoreString = "Advantage " + player1;
        else if (scoreDifference == advantage2) scoreString = "Advantage " + player2;
             
        return scoreString;
       
    }
    
    // get score string in a situation where one player is winning
    public String winning(int scoreDifference) {
        String scoreString = "";
        
        int win1 = 2;
        int win2 = -2;
        
        if (scoreDifference >= win1) {
            scoreString = "Win for " + player1;
        } else if (scoreDifference <= win2) {
            scoreString = "Win for "+ player2;
        }
        
        return scoreString;
    }
    
    // get score string in a situation where both players have 3 or less points
    public String threeOrLessPoints() {
        return getPlayerScoreString(score1) + "-" + getPlayerScoreString(score2);
    }
    
    // returns string for individual player's score
    public String getPlayerScoreString(int playerScore) {
        String scoreString = "";
        
        switch(playerScore)
        {
            case 0:
                scoreString += "Love";
                break;
            case 1:
                scoreString += "Fifteen";
                break;
            case 2:
                scoreString += "Thirty";
                break;
            case 3:
                scoreString += "Forty";
                break;
        }
        
        return scoreString;
    }
}
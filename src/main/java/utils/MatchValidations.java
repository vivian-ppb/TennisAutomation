package utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchValidations {

    public boolean isMatchFinished(TennisMatchObject tennisMatchObject, int highestSetNumber){

        List<Integer> setScores = tennisMatchObject.getSetScores();
        switch (highestSetNumber) {
            case 3:
                if(setScores.size()==2 && setScores.get(0)>setScores.get(1) ) {

                }
            case 5:
                //if()
        }

        return false;
    }

    //TODO: Add parameter from tennisMatchObject.getScores() to each method;
    private List<Integer> completedSetScores = null;


    public static PlayerOrDraw determineWinner(String score) {
        String setPattern = "(\\d+)-(\\d+)";

        Pattern pattern = Pattern.compile(setPattern);
        Matcher matcher = pattern.matcher(score);

        int playerAWins = 0;
        int playerBWins = 0;

        while (matcher.find()) {
            int playerAScore = Integer.parseInt(matcher.group(1));
            int playerBScore = Integer.parseInt(matcher.group(2));

            if (playerAScore > playerBScore) {
                playerAWins++;
            } else if (playerBScore > playerAScore) {
                playerBWins++;
            }
        }

        if (playerAWins > playerBWins) {
            return PlayerOrDraw.PLAYER_A;
        } else if (playerBWins > playerAWins) {
            return PlayerOrDraw.PLAYER_B;
        } else {
            return PlayerOrDraw.DRAW;
        }
    }

//TODO: Include * and ** in formatted score output
    public int numberOfSets() {
        String setsPerMatch = "";
        return setsPerMatch.contains("**") ? 5 : 3;
    }

    public int completedSets() {
        return completedSetScores.size() / 2; // Each set has two scores, one for each player
    }

    public int numberOfSetsRequiredToWin() {
        if (numberOfSets() == 3) return 2;
        if (numberOfSets() == 5) return 3;
        return 0;
    }

    public int numberOfSetsPlayer1Won() {
        int setsWon = 0;
        for (int i = 0; i < completedSetScores.size(); i += 2) {
            int aScore = completedSetScores.get(i);
            int bScore = completedSetScores.get(i + 1);
            if (aScore > bScore) {
                setsWon++;
            }
        }
        return setsWon;
    }

    public int numberOfSetsPlayer2Won() {
        int setsWon = 0;
        for (int i = 0; i < completedSetScores.size(); i += 2) {
            int aScore = completedSetScores.get(i);
            int bScore = completedSetScores.get(i + 1);
            if (bScore > aScore) {
                setsWon++;
            }
        }
        return setsWon;
    }

    public boolean isMatchFinished() {
        if (numberOfSetsPlayer1Won() == numberOfSetsRequiredToWin()) return true;
        if (numberOfSetsPlayer2Won() == numberOfSetsRequiredToWin()) return true;
        return false;
    }

    public String matchWinner() {
        if (isMatchFinished()) {
            if (numberOfSetsPlayer1Won() > numberOfSetsPlayer2Won()) return "PLAYER1";
            if (numberOfSetsPlayer2Won() > numberOfSetsPlayer1Won()) return "PLAYER2";
        }
        return "NONE";
    }

    public boolean tiebreakInSet1() {
        if (completedSetScores.size() >= 2) {
            int aScore = completedSetScores.get(0);
            int bScore = completedSetScores.get(1);
            return (aScore == 7 || bScore == 7);
        }
        return false;
    }

    public boolean tiebreakInSet2() {
        if (completedSetScores.size() >= 4) {
            int aScore = completedSetScores.get(2);
            int bScore = completedSetScores.get(3);
            return (aScore == 7 || bScore == 7);
        }
        return false;
    }

    public boolean tiebreakInSet3() {
        if (completedSetScores.size() >= 6) {
            int aScore = completedSetScores.get(4);
            int bScore = completedSetScores.get(5);
            return (aScore == 7 || bScore == 7);
        }
        return false;
    }

    public boolean tiebreakInSet4() {
        if (completedSetScores.size() >= 8) {
            int aScore = completedSetScores.get(6);
            int bScore = completedSetScores.get(7);
            return (aScore == 7 || bScore == 7);
        }
        return false;
    }

    public boolean tiebreakInSet5() {
        if (completedSetScores.size() >= 10) {
            int aScore = completedSetScores.get(8);
            int bScore = completedSetScores.get(9);
            return (aScore == 7 || bScore == 7);
        }
        return false;
    }

    public int numberOfTiebreaks() {
        int tiebreaks = 0;
        if (tiebreakInSet1()) tiebreaks++;
        if (tiebreakInSet2()) tiebreaks++;
        if (tiebreakInSet3()) tiebreaks++;
        if (tiebreakInSet4()) tiebreaks++;
        if (tiebreakInSet5()) tiebreaks++;
        return tiebreaks;
    }

    public String set1Winner() {
        if (completedSetScores.size() >= 2) {
            int aScore = completedSetScores.get(0);
            int bScore = completedSetScores.get(1);
            return aScore > bScore ? "PLAYER1" : "PLAYER2";
        }
        return "NONE";
    }

    public String set2Winner() {
        if (completedSetScores.size() >= 4) {
            int aScore = completedSetScores.get(2);
            int bScore = completedSetScores.get(3);
            return aScore > bScore ? "PLAYER1" : "PLAYER2";
        }
        return "NONE";
    }

    public String set3Winner() {
        if (completedSetScores.size() >= 6) {
            int aScore = completedSetScores.get(4);
            int bScore = completedSetScores.get(5);
            return aScore > bScore ? "PLAYER1" : "PLAYER2";
        }
        return "NONE";
    }

    public String set4Winner() {
        if (completedSetScores.size() >= 8) {
            int aScore = completedSetScores.get(6);
            int bScore = completedSetScores.get(7);
            return aScore > bScore ? "PLAYER1" : "PLAYER2";
        }
        return "NONE";
    }

    public String set5Winner() {
        if (completedSetScores.size() >= 10) {
            int aScore = completedSetScores.get(8);
            int bScore = completedSetScores.get(9);
            return aScore > bScore ? "PLAYER1" : "PLAYER2";
        }
        return "NONE";
    }

}

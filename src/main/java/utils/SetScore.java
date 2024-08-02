package utils;

import java.util.List;

public class SetScore {

    private int setNumber;
    private int playerAGamesWon; //no of games won in a set
    private int playerBGamesWon;
    private List<GameScore> gameScores; //current set in play from soupi, the rest not in soupi for completed sets
    private int aceInSet;
    private boolean isSetFinished;

    public PlayerOrDraw playerMostGames() {
        if (playerAGamesWon > playerBGamesWon) {
            return PlayerOrDraw.PLAYER_A;
        }
        if (playerBGamesWon > playerAGamesWon) {
            return PlayerOrDraw.PLAYER_B;
        }
        return PlayerOrDraw.DRAW;
    }

   public PlayerOrNone setWinner() {
        if (isSetFinished()) {
            if (playerAGamesWon > playerBGamesWon) {
                return PlayerOrNone.PLAYER_A;
            }
            if (playerBGamesWon > playerAGamesWon) {
                return PlayerOrNone.PLAYER_B;
            }
        }
        return PlayerOrNone.NONE;
    }

    //return player with most games won or none if set is finished
    public int gameDifference() {
        return playerBGamesWon - playerAGamesWon;
    }

    public TrueFalseNA sixZeroSet() {
        if (playerAGamesWon == 6 && playerBGamesWon == 0) {
            return TrueFalseNA.TRUE;
        }
        if (playerBGamesWon == 6 && playerAGamesWon == 0) {
            return TrueFalseNA.TRUE;
        }
        if (playerAGamesWon >= 1 && playerBGamesWon >= 1) {
            return TrueFalseNA.FALSE;
        }
        return TrueFalseNA.NA;
    }

    public boolean isSetFinished() {
        if (playerAGamesWon == 7 || playerBGamesWon == 7) {
            return true;
        }
        if (playerAGamesWon == 6 && (playerBGamesWon == 4 || playerBGamesWon == 3 || playerBGamesWon == 2 || playerBGamesWon == 1 || playerBGamesWon == 0)) {
            return true;
        }
        if (playerBGamesWon == 6 && (playerAGamesWon == 4 || playerAGamesWon == 3 || playerAGamesWon == 2 || playerAGamesWon == 1 || playerAGamesWon == 0)) {
            return true;
        } else return false;
    }
}

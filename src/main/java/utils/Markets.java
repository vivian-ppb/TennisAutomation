package utils;

import java.util.Arrays;
import java.util.List;

public class Markets {

    public static final String INCOMPLETE_EVENT_STATE = "IncompleteEventState";
    public static final String COMPLETE_MARKET_STATE = "CompleteMarketState";
    public static final String INCOMPLETE_MARKET_STATE = "IncompleteMarketState";
    public static final String COMPLETE_SELECTION_STATE = "CompleteSelectionState";
    public static final String INCOMPLETE_SELECTION_STATE = "IncompleteSelectionState";

    public static final Integer THREE_SET_MATCH = 3;
    public static final Integer FIVE_SET_MATCH = 5;

    public static final Integer SIX_GAMES_PER_SET = 6;
    public static final Integer FOUR_GAMES_PER_SET = 4;

    public static final String CHAMPIONSHIP_TIEBREAK_TYPE = "CHAMPIONSHIP_TIE_BREAK";

    public static final String MATCH_BETTING = "Match Betting";
    public static final String SET_BETTING = "Set Betting";

    public static final String GENDER_MEN = "MEN";
    public static final String GENDER_WOMEN = "WOMEN";
    public static final String GENDER_MIXED = "MIXED";

    public static final int POINTS_0 = 0;
    public static final int POINTS_TO_15 = 1;
    public static final int POINTS_TO_30 = 2;
    public static final int POINTS_TO_40 = 3;
    public static final int POINTS_TO_DEUCE = 3;
    public static final int POINTS_TO_WIN_NO_DEUCE = 4;
    public static final int POINTS_TO_ADVANTAGE = 4;
    public static final int POINTS_WIN_DEUCE = 5;
    public static final int SIXTY_SECONDS = 60;
    public static final int TEN_SECONDS = 10;
    public static final int TWENTY_SECONDS = 20;
    public static final int FIVE_SECONDS = 5;
    public static final int PLAYER_A = 1;
    public static final int PLAYER_B = 2;
    public static final int TEAM_A = 1;
    public static final int TEAM_B = 2;
    public static final int TIER_1 = 1;
    public static final int TIER_2 = 2;
    public static final int TIER_3 = 3;
    public static final int TIER_4 = 4;
    public static final int TIER_5 = 5;
    public static final int TIER_6 = 6;
    public static final int TIER_7 = 7;
    public static final int TIER_8 = 8;
    public static final int TIER_9 = 9;
    public static final int TIER_10 = 10;
    public static final int TIER_11 = 11;
    public static final int TIER_12 = 12;
    public static final int TIER_13 = 13;
    public static final int TIER_14 = 14;
    public static final String MARKET_ACTIVE = "ACTIVE";
    public static final String MARKET_SUSPENDED = "SUSPENDED";
    public static final String SELECTION_ACTIVE = "ACTIVE";
    public static final String SELECTION_SUSPENDED = "SUSPENDED";
    public static final String HEAT_DELAY = "HEAT DELAY";
    public static final int SEVEN_MINUTES = 420000;
    public static final Integer GAME_1 = 1;
    public static final Integer GAME_2 = 2;
    public static final Integer GAME_3 = 3;
    public static final Integer GAME_4 = 4;
    public static final Integer GAME_5 = 5;
    public static final Integer GAME_6 = 6;
    public static final Integer GAME_7 = 7;
    public static final Integer GAME_8 = 8;
    public static final Integer GAME_9 = 9;
    public static final Integer GAME_10 = 10;
    public static final Integer GAME_11 = 11;
    public static final Integer GAME_12 = 12;
    public static final Integer GAME_13 = 13;
    public static final Integer GAME_14 = 14;
    public static String PLAYER_A_WIN_1ST_SERVICE_GAME = "Player A to Win First Service Game";
    public static String PLAYER_B_WIN_1ST_SERVICE_GAME = "Player B to Win First Service Game";

    public static String SET_X_GAME_HANDICAP = "Set X Game Handicap";
    public static String TO_WIN_1ST_SET = "To Win 1st Set";
    public static String CORRECT_SCORE_1ST_SET = "Set 1 Correct Score";
    public static String PLAYER_A_TO_WIN_AT_LEAST_1_SET = "Player A To Win At Least 1 Set";
    public static String PLAYER_B_TO_WIN_AT_LEAST_1_SET = "Player B To Win At Least 1 Set";
    public static String SET_1_WINNER = "|To Win 1st Set|";
    public static String SET_2_WINNER = "Set 2 Winner";
    public static String SET_3_WINNER = "Set 3 Winner";
    public static String SET_4_WINNER = "Set 4 Winner";
    public static String SET_5_WINNER = "Set 5 Winner";
    public static String SET_HANDICAP = "|Set| |Handicap|";
    public static String CORRECT_SCORE_2ND_SET = "Set 2 Correct Score";
    public static String CORRECT_SCORE_3RD_SET = "Set 3 Correct Score";
    public static String CORRECT_SCORE_4TH_SET = "Set 4 Correct Score";
    public static String CORRECT_SCORE_5TH_SET = "Set 5 Correct Score";
    public static String TIE_BREAK_IN_MATCH = "Tie Break in Match?";

    public static String SET_1_TOTAL_GAMES_3_WAY = "Set 1 Total Games 3 Way";
    public static String SET_2_TOTAL_GAMES_3_WAY = "Set 2 Total Games 3 Way";
    public static String SET_3_TOTAL_GAMES_3_WAY = "Set 3 Total Games 3 Way";
    public static String SET_4_TOTAL_GAMES_3_WAY = "Set 4 Total Games 3 Way";
    public static String SET_5_TOTAL_GAMES_3_WAY = "Set 5 Total Games 3 Way";

    public static String SET_1_TOTAL_GAMES_OU_6_5 = "Set 1 Total Games Over/Under 6.5";
    public static String SET_1_TOTAL_GAMES_OU_7_5 = "Set 1 Total Games Over/Under 7.5";
    public static String SET_1_TOTAL_GAMES_OU_8_5 = "Set 1 Total Games Over/Under 8.5";
    public static String SET_1_TOTAL_GAMES_OU_9_5 = "Set 1 Total Games Over/Under 9.5";
    public static String SET_1_TOTAL_GAMES_OU_10_5 = "Set 1 Total Games Over/Under 10.5";
    public static String SET_1_TOTAL_GAMES_OU_12_5 = "Set 1 Total Games Over/Under 12.5";

    public static String SET_2_TOTAL_GAMES_OU_6_5 = "Set 2 Total Games Over/Under 6.5";
    public static String SET_2_TOTAL_GAMES_OU_7_5 = "Set 2 Total Games Over/Under 7.5";
    public static String SET_2_TOTAL_GAMES_OU_8_5 = "Set 2 Total Games Over/Under 8.5";
    public static String SET_2_TOTAL_GAMES_OU_9_5 = "Set 2 Total Games Over/Under 9.5";
    public static String SET_2_TOTAL_GAMES_OU_10_5 = "Set 2 Total Games Over/Under 10.5";
    public static String SET_2_TOTAL_GAMES_OU_12_5 = "Set 2 Total Games Over/Under 12.5";

    public static String SET_3_TOTAL_GAMES_OU_6_5 = "Set 3 Total Games Over/Under 6.5";
    public static String SET_3_TOTAL_GAMES_OU_7_5 = "Set 3 Total Games Over/Under 7.5";
    public static String SET_3_TOTAL_GAMES_OU_8_5 = "Set 3 Total Games Over/Under 8.5";
    public static String SET_3_TOTAL_GAMES_OU_9_5 = "Set 3 Total Games Over/Under 9.5";
    public static String SET_3_TOTAL_GAMES_OU_10_5 = "Set 3 Total Games Over/Under 10.5";
    public static String SET_3_TOTAL_GAMES_OU_12_5 = "Set 3 Total Games Over/Under 12.5";

    public static String SET_4_TOTAL_GAMES_OU_6_5 = "Set 4 Total Games Over/Under 6.5";
    public static String SET_4_TOTAL_GAMES_OU_7_5 = "Set 4 Total Games Over/Under 7.5";
    public static String SET_4_TOTAL_GAMES_OU_8_5 = "Set 4 Total Games Over/Under 8.5";
    public static String SET_4_TOTAL_GAMES_OU_9_5 = "Set 4 Total Games Over/Under 9.5";
    public static String SET_4_TOTAL_GAMES_OU_10_5 = "Set 4 Total Games Over/Under 10.5";
    public static String SET_4_TOTAL_GAMES_OU_12_5 = "Set 4 Total Games Over/Under 12.5";

    public static String SET_5_TOTAL_GAMES_OU_6_5 = "Set 5 Total Games Over/Under 6.5";
    public static String SET_5_TOTAL_GAMES_OU_7_5 = "Set 5 Total Games Over/Under 7.5";
    public static String SET_5_TOTAL_GAMES_OU_8_5 = "Set 5 Total Games Over/Under 8.5";
    public static String SET_5_TOTAL_GAMES_OU_9_5 = "Set 5 Total Games Over/Under 9.5";
    public static String SET_5_TOTAL_GAMES_OU_10_5 = "Set 5 Total Games Over/Under 10.5";
    public static String SET_5_TOTAL_GAMES_OU_12_5 = "Set 5 Total Games Over/Under 12.5";

    public static String OVER_6_5_SELECTION = "|Over| 6.5";
    public static String UNDER_6_5_SELECTION = "|Under| 6.5";
    public static String OVER_7_5_SELECTION = "|Over| 7.5";
    public static String UNDER_7_5_SELECTION = "|Under| 7.5";
    public static String OVER_8_5_SELECTION = "|Over| 8.5";
    public static String UNDER_8_5_SELECTION = "|Under| 8.5";
    public static String OVER_9_5_SELECTION = "|Over| 9.5";
    public static String UNDER_9_5_SELECTION = "|Under| 9.5";
    public static String OVER_10_5_SELECTION = "|Over| 10.5";
    public static String UNDER_10_5_SELECTION = "|Under| 10.5";
    public static String OVER_12_5_SELECTION = "|Over| 12.5";
    public static String UNDER_12_5_SELECTION = "|Under| 12.5";

    public static String TGAMES3WAY_UNDER_8_5_SELECTION = "|Under 8.5|";
    public static String TGAMES3WAY_IS_9_OR_10_SELECTION = "|9 or 10|";
    public static String TGAMES3WAY_OVER_10_5_SELECTION = "|Over 10.5|";

    public static String POINT_WINNER_MARKET_NAME = "Set X Game Y Point Z Winner";

    public static List<String> SET_1_TOTAL_GAMES = Arrays.asList(SET_1_TOTAL_GAMES_OU_6_5, SET_1_TOTAL_GAMES_OU_7_5,
            SET_1_TOTAL_GAMES_OU_8_5, SET_1_TOTAL_GAMES_OU_9_5, SET_1_TOTAL_GAMES_OU_10_5, SET_1_TOTAL_GAMES_OU_12_5);

    public static List<String> SET_2_TOTAL_GAMES = Arrays.asList(SET_2_TOTAL_GAMES_OU_6_5, SET_2_TOTAL_GAMES_OU_7_5,
            SET_2_TOTAL_GAMES_OU_8_5, SET_2_TOTAL_GAMES_OU_9_5, SET_2_TOTAL_GAMES_OU_10_5, SET_2_TOTAL_GAMES_OU_12_5);

    public static List<String> SET_3_TOTAL_GAMES = Arrays.asList(SET_3_TOTAL_GAMES_OU_6_5, SET_3_TOTAL_GAMES_OU_7_5,
            SET_3_TOTAL_GAMES_OU_8_5, SET_3_TOTAL_GAMES_OU_9_5, SET_3_TOTAL_GAMES_OU_10_5, SET_3_TOTAL_GAMES_OU_12_5);

    public static List<String> SET_4_TOTAL_GAMES = Arrays.asList(SET_4_TOTAL_GAMES_OU_6_5, SET_4_TOTAL_GAMES_OU_7_5,
            SET_4_TOTAL_GAMES_OU_8_5, SET_4_TOTAL_GAMES_OU_9_5, SET_4_TOTAL_GAMES_OU_10_5, SET_4_TOTAL_GAMES_OU_12_5);

    public static List<String> SET_5_TOTAL_GAMES = Arrays.asList(SET_5_TOTAL_GAMES_OU_6_5, SET_5_TOTAL_GAMES_OU_7_5,
            SET_5_TOTAL_GAMES_OU_8_5, SET_5_TOTAL_GAMES_OU_9_5, SET_5_TOTAL_GAMES_OU_10_5, SET_5_TOTAL_GAMES_OU_12_5);

    public static String TOTAL_ACES = "Total Aces";
    public static String PLAYER_WITH_MOST_ACES = "Player with Most Aces";
    public static String TOTAL_DOUBLE_FAULTS = "Total Double Faults";
    public static String PLAYER_WITH_MOST_DOUBLE_FAULTS = "Most Double Faults";
    public static String GAME_HANDICAP = "Game Handicap";
    public static String TOTAL_MATCH_GAMES = "Total Match Games";
    public static String TO_LOSE_1ST_SET_AND_WIN_MATCH = "|To lose 1st set and win match|";
    public static String TO_WIN_1ST_SET_AND_WIN_MATCH = "|To win 1st set and win match|";
    public static String TOTAL_SETS_2_5 = "Total Sets 2.5";
    public static String TOTAL_SETS_3_5 = "Total Sets 3.5";
    public static String BOTH_PLAYER_TO_WIN_A_SET = "Both player to win a set";
    public static String TOTAL_PLAYER_A_GAMES = "Total Player A Games";
    public static String TOTAL_PLAYER_B_GAMES = "Total Player B Games";
    public static String TOTAL_TIEBREAKS_OU_1_5 = "Total Tie-Breaks Over/Under 1.5";
    public static String TOTAL_TIEBREAKS_OU_2_5 = "Total Tie-Breaks Over/Under 2.5";
    public static String SET_1_TIEBREAK_WINNER = "Set 1 Tiebreak Winner";
    public static String SET_2_TIEBREAK_WINNER = "Set 2 Tiebreak Winner";
    public static String SET_3_TIEBREAK_WINNER = "Set 3 Tiebreak Winner";
    public static String SET_4_TIEBREAK_WINNER = "Set 4 Tiebreak Winner";
    public static String SET_5_TIEBREAK_WINNER = "Set 5 Tiebreak Winner";
    public static String SET_1_TIEBREAK_CORRECT_SCORE = "Set 1 Tiebreak Correct Score";
    public static String SET_2_TIEBREAK_CORRECT_SCORE = "Set 2 Tiebreak Correct Score";
    public static String SET_3_TIEBREAK_CORRECT_SCORE = "Set 3 Tiebreak Correct Score";
    public static String SET_4_TIEBREAK_CORRECT_SCORE = "Set 4 Tiebreak Correct Score";
    public static String SET_5_TIEBREAK_CORRECT_SCORE = "Set 5 Tiebreak Correct Score";
    // Player A Exact Games Winning Margin in Latest State
    public static String Player_A_Exact_Games_Winning_Margin = "Player A Exact Games Won Margin";
    public static String Player_B_Exact_Games_Winning_Margin = "Player B Exact Games Won Margin";
    public static String Player_A_Set_X_1st_Service_Break = "Player A Set X 1st Service Break";
    public static String Player_B_Set_X_1st_Service_Break = "Player B Set X 1st Service Break";
    public static String Alternative_Game_Handicap_1MI = "Alternative Game Handicap 1MI";
    public static String SET_HANDICAP_1_5 = "Set Handicap 1.5";
    public static String SET_HANDICAP_MINUS_1_5 = "Set Handicap -1.5";
    public static String SET_HANDICAP_2_5 = "Set Handicap 2.5";
    public static String SET_HANDICAP_MINUS_2_5 = "Set Handicap -2.5";
    public static String ALTERNATIVE_SET_HANDICAP_1_5 = "Alternative Set Handicap 1.5";
    public static String ALTERNATIVE_SET_HANDICAP_MINUS_1_5 = "Alternative Set Handicap -1.5";
    public static String ALTERNATIVE_SET_HANDICAP_2_5 = "Alternative Set Handicap 2.5";
    public static String ALTERNATIVE_SET_HANDICAP_MINUS_2_5 = "Alternative Set Handicap -2.5";
    public static String SET_1_SCORE_AFTER_2_GAMES = "1st Set Score after 2 games";
    public static String SET_1_SCORE_AFTER_4_GAMES = "1st Set Score after 4 games";
    public static String SET_1_SCORE_AFTER_6_GAMES = "1st Set Score after 6 games";
    public static String SET_2_SCORE_AFTER_2_GAMES = "2nd Set Score after 2 games";
    public static String SET_2_SCORE_AFTER_4_GAMES = "2nd Set Score after 4 games";
    public static String SET_2_SCORE_AFTER_6_GAMES = "2nd Set Score after 6 games";
    public static String SET_3_SCORE_AFTER_2_GAMES = "3rd Set Score after 2 games";
    public static String SET_3_SCORE_AFTER_4_GAMES = "3rd Set Score after 4 games";
    public static String SET_3_SCORE_AFTER_6_GAMES = "3rd Set Score after 6 games";
    public static String SET_4_SCORE_AFTER_2_GAMES = "4th Set Score after 2 games";
    public static String SET_4_SCORE_AFTER_4_GAMES = "4th Set Score after 4 games";
    public static String SET_4_SCORE_AFTER_6_GAMES = "4th Set Score after 6 games";
    public static String SET_5_SCORE_AFTER_2_GAMES = "5th Set Score after 2 games";
    public static String SET_5_SCORE_AFTER_4_GAMES = "5th Set Score after 4 games";
    public static String SET_5_SCORE_AFTER_6_GAMES = "5th Set Score after 6 games";
    public static String PLAYER_A_TO_WIN_SET_X_GAMES_Y_Z = "|Player A To Win| |Set X Games Y,Z|";
    public static String PLAYER_B_TO_WIN_SET_X_GAMES_Y_Z = "|Player B To Win| |Set X Games Y,Z|";
    public static String CORRECTSCORE_3RD_SET = "Correct Score 3rd Set";
    public static String CHAMPIONSHIP_TIEBREAK_CORRECTSCORE = "Champion Tiebreak Correct Score";
    public static String SET_1_GAME_1_WINNER = "Set 1 Game 1 Winner";
    public static String SET_1_GAME_2_WINNER = "Set 1 Game 2 Winner";
    public static String SET_2_GAME_1_WINNER = "Set 2 Game 1 Winner";
    public static String SET_2_GAME_2_WINNER = "Set 2 Game 2 Winner";
    public static String RESULT_WIN = "WIN";
    public static String RESULT_LOSE = "LOSE";
    public static String RESULT_VOID = "VOID";
    public static String SET_1_GAME_1_POINT_1_WINNER = "Set 1 Game 1 Point 1 Winner";
    public static String SET_1_GAME_1_POINT_2_WINNER = "Set 1 Game 1 Point 2 Winner";
    public static String SET_1_GAME_1_POINT_3_WINNER = "Set 1 Game 1 Point 3 Winner";
    public static String SET_1_GAME_1_POINT_4_WINNER = "Set 1 Game 1 Point 4 Winner";
    public static String SET_1_Game_1_CORRECT_SCORE = "Set 1 Game 1 Correct Score";
    public static String SET_1_Game_2_CORRECT_SCORE = "Set 1 Game 2 Correct Score";
    public static int SET_PREPLAY = 0;
    public static int SET_1 = 1;
    public static int SET_2 = 2;
    public static int SET_3 = 3;
    public static int SET_4 = 4;
    public static int SET_5 = 5;
    public static int SET_CHAMPIONSHIP_TIEBREAK = 99;
    public static String UNDER_1_5_SELECTION = "|Under| 1.5";
    public static String OVER_1_5_SELECTION = "|Over| 1.5";
    public static String UNDER_2_5_SELECTION = "|Under| 2.5";
    public static String OVER_2_5_SELECTION = "|Over| 2.5";
    public static String UNDER_4_5_SELECTION = "|Under| 4.5";
    public static String OVER_4_5_SELECTION = "|Over| 4.5";
    public static String YES_SELECTION = "|Yes|";
    public static String NO_SELECTION = "|No|";

    public static String SOUPI_ABANDONED_MATCH_SCORE = "AbandonedMatch";

    public static String BETTING_STATUS_ACTIVE = "ACTIVE";
    public static String BETTING_STATUS_SUSPENDED = "SUSPENDED";
    public static boolean EVENT_DISPLAYED = true;
    public static boolean EVENT_NOT_DISPLAYED = false;

    public static String OVER_SELECTION = "|Over|";
    public static String UNDER_SELECTION = "|Under|";
    public static String EXACTLY_SELECTION = "|Exactly|";

    public static String PLAYER_DOES_NOT_BREAK_IN_SET = "|Doesn't break serve in set|";
}

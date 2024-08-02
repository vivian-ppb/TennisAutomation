package utils;

import com.tennis.Driver;
import com.tennis.SoupiHomePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {

    public static List<String> extractKey(String input, String key) {
        String regex = null;
        regex = "\"" + Pattern.quote(key) + "\"\\s*:\\s*(\\d+)";

        if (key.equals("competitionName")) {
            regex = "\"" + Pattern.quote(key) + "\"\\s*:\\s*\"([^\"]*)\"";
        }

        if (key.equals("name")) {
            regex = "\"name\": \"\\|([^|]+)\\| \\|[^|]*\\| \\|([^|]+)\\|\"";

        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            list.add((matcher.group(1)));
        }
        return list;
    }

    public static String getEventName() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        String name = null;
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                name = state.get("name").toString();
            } else name = SoupiHomePage.resultError;
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static List<Integer> getSetScore(int setIndex) {
        String input = Driver.getText(SoupiHomePage.upiResult);
        List<Integer> setScoreList = new ArrayList<>();
        JSONParser parser = new JSONParser();

        if (input != null && !input.equals(SoupiHomePage.resultError)) {
            try {
                JSONObject soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = Optional.ofNullable((JSONObject) soupiObject.get("4-eventState")).orElse(new JSONObject());
                JSONObject state = Optional.ofNullable((JSONObject) eventState.get("state")).orElse(new JSONObject());
                JSONObject score = Optional.ofNullable((JSONObject) state.get("score")).orElse(new JSONObject());
                JSONArray completedSetScores = Optional.ofNullable((JSONArray) score.get("completedSetScores")).orElse(new JSONArray());

                if (setIndex < completedSetScores.size() && setIndex >= 1) {
                    JSONObject setScoreObject = (JSONObject) completedSetScores.get(setIndex);
                    Integer aScore = Optional.ofNullable(setScoreObject.get("aScore"))
                            .map(Object::toString)
                            .map(Integer::valueOf)
                            .orElse(0);
                    Integer bScore = Optional.ofNullable(setScoreObject.get("bScore"))
                            .map(Object::toString)
                            .map(Integer::valueOf)
                            .orElse(0);

                    setScoreList.add(aScore);
                    setScoreList.add(bScore);
                    System.out.println("ascore = " + aScore + " bscore = " + bScore);
                } else {
                    System.out.println("Set number " + setIndex + " does not exist.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return setScoreList;
    }

    public static int getHighestSetNumber() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        int highestSetNumber = 0;
        JSONParser parser = new JSONParser();

        try {
            if (input != null && !input.equals(SoupiHomePage.resultError)) {
                JSONObject jsonObject = (JSONObject) parser.parse(input);
                JSONObject eventState = Optional.ofNullable((JSONObject) jsonObject.get("4-eventState")).orElse(new JSONObject());
                JSONObject state = Optional.ofNullable((JSONObject) eventState.get("state")).orElse(new JSONObject());
                JSONObject score = Optional.ofNullable((JSONObject) state.get("score")).orElse(new JSONObject());
                JSONArray completedSetScores = Optional.ofNullable((JSONArray) score.get("completedSetScores")).orElse(new JSONArray());

                for (Object obj : completedSetScores) {
                    JSONObject setScore = (JSONObject) obj;
                    int setNumber = Optional.ofNullable((Long) setScore.get("setNumber")).orElse(0L).intValue();
                    if (setNumber > highestSetNumber) {
                        highestSetNumber = setNumber;
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return highestSetNumber;
    }

    /**
     * Extracts the player names from UPI response
     *
     * @param input upi response
     * @return list containing the names of Player A and Player B
     */
    public static List<String> extractPlayerNames(String input) {
        String regex = "\\|([^|]+ [^|]+(?: [^|]+)?)\\| \\|[^|]*\\| \\|([^|]+ [^|]+(?: [^|]+)?)\\|";
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String playerA = matcher.group(1);
            String playerB = matcher.group(2);
            list.add(playerA);
            list.add(playerB);
            System.out.println("playerA = " + playerA);
            System.out.println("playerB = " + playerB);
        } else {
            System.out.println("No match found.");
        }
        return list;
    }

    public static String extractStringDifference(String str1, String str2) {
        StringBuilder diff = new StringBuilder();
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLen = Math.max(len1, len2);

        for (int i = 0; i < maxLen; i++) {
            char charFromStr1 = (i < len1) ? str1.charAt(i) : '\0';
            char charFromStr2 = (i < len2) ? str2.charAt(i) : '\0';

            if (charFromStr1 != charFromStr2) {
                if (charFromStr1 != '\0') {
                    diff.append(charFromStr1);
                }
                if (charFromStr2 != '\0') {
                    diff.append(charFromStr2);
                }
            }
        }

        return diff.toString();
    }


}

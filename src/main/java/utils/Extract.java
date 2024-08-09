package utils;

import com.tennis.Driver;
import com.tennis.SoupiHomePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {

    /**
     * Gets a custom key's value from soupi via regex - currently mapped for competitionName and name keys
     *
     * @param input the soupi response as string
     * @param key   the key to get the value for as string
     * @return the value of the given key as a string
     */
    public static List<String> getSoupiKey(String input, String key) {
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

    /**
     * Gets the value of the type key, under 4-eventState from soupi response
     *
     * @return the value of type as a string
     */
    public static String getSoupiType() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        String type = null;
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                type = eventState.get("type").toString();
            } else type = SoupiHomePage.resultError;
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * Gets the value of the status key, under 1-bookingStatus from soupi response
     *
     * @return the value of status as a string
     */
    public static boolean getSoupiBookingStatus() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        boolean status = false;
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("1-bookingStatus");

                if (eventState.get("status").toString().equals("booked")) {
                    status = true;
                }
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * Gets the value of the extId key, under 4-eventState from soupi response
     *
     * @return the number value of extId as a long
     */
    public static long getSoupiAmelcoId() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        long id = 0;
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                id = Long.parseLong(state.get("extId").toString().replace("amelco.", ""));
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Gets the value of the name key, under 4-eventState from soupi response
     *
     * @return the value of name as a string
     */
    public static String getSoupiEventName() {
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

    /**
     * Gets the value of the bettingStatus key, under 4-eventState from soupi response
     *
     * @return the value of bettingStatus as a string
     */
    public static String getSoupiBettingStatus() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        String bstatus = null;
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                bstatus = state.get("bettingStatus").toString();
            } else bstatus = "No match found";
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return bstatus;
    }

    public static HashMap<String, MarketObject> getSoupiMarkets() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        HashMap<String, MarketObject> markets = new HashMap<>();

        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONArray soupiMarkets = (JSONArray) soupiObject.get("5-bettingMarkets");

                for (Object obj : soupiMarkets) {
                    JSONObject market = (JSONObject) obj;
                    String type = Optional.ofNullable(market.get("type")).orElse("").toString();
                    JSONObject state = (JSONObject) Optional.ofNullable(market.get("state")).orElse(new JSONObject());
                    String extId = Optional.ofNullable(state.get("extId")).orElse("").toString();
                    String id = Optional.ofNullable(state.get("id")).orElse("").toString();
                    String displayName = Optional.ofNullable(state.get("displayName")).orElse("").toString();
                    String displayOrder = Optional.ofNullable(state.get("displayOrder")).orElse("").toString();
                    boolean displayed = (boolean) Optional.ofNullable(state.get("displayed")).orElse(false);
                    boolean resulted = (boolean) Optional.ofNullable(state.get("resulted")).orElse(false);
                    String bettingStatus = Optional.ofNullable(state.get("bettingStatus")).orElse("").toString();
                    boolean offeredInRunning = (boolean) Optional.ofNullable(state.get("offeredInRunning")).orElse(false);

                    List<SelectionObject> selectionObjectList = getSoupiSelections(id);

                    MarketObject marketObject = new MarketObject.Builder()
                            .type(type)
                            .state(state.toString())
                            .extId(extId)
                            .id(id)
                            .displayName(displayName)
                            .displayed(displayed)
                            .displayOrder(displayOrder)
                            .resulted(resulted)
                            .bettingStatus(bettingStatus)
                            .offeredInRunning(offeredInRunning)
                            .selections(selectionObjectList)
                            .build();

                    markets.put(id, marketObject);

                    /*System.out.println("MarketType: " + marketObject.getType());
                    System.out.println("MarketState: " + marketObject.getState());
                    System.out.println("MarketExtId: " + marketObject.getExtId());
                    System.out.println("MarketId: " + marketObject.getId());
                    System.out.println("MarketDisplayName: " + marketObject.getDisplayName());
                    System.out.println("MarketDisplayOrder: " + marketObject.getDisplayOrder());
                    System.out.println("MarketResult: " + marketObject.getResulted());
                    System.out.println("MarketBettingStatus: " + marketObject.getBettingStatus());
                    System.out.println("MarketOfferedInRunning: " + marketObject.getOfferedInRunning());*/
                }
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return markets;
    }

    public static List<SelectionObject> getSoupiSelections(String marketId) {
        String input = Driver.getText(SoupiHomePage.upiResult);
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        List<SelectionObject> selections = new ArrayList<>();
        String actualMarketId = "";

        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONArray soupiSelections = (JSONArray) Optional.ofNullable(soupiObject.get("6-bettingSelections")).orElse(new JSONArray());
                for (Object obj : soupiSelections) {
                    JSONObject selection = (JSONObject) obj;
                    JSONObject state = (JSONObject) Optional.ofNullable(selection.get("state")).orElse(new JSONObject());
                    actualMarketId = Optional.ofNullable(state.get("marketId")).orElse("").toString();

                    String type = Optional.ofNullable(selection.get("type")).orElse("").toString();
                    if (Integer.valueOf(marketId).equals(Integer.valueOf(actualMarketId))) {
                        String extId = Optional.ofNullable(state.get("extId")).orElse("").toString();
                        String id = Optional.ofNullable(state.get("id")).orElse("").toString();
                        String name = Optional.ofNullable(state.get("name")).orElse("").toString();
                        String displayOrder = Optional.ofNullable(state.get("displayOrder")).orElse("").toString();
                        boolean displayed = (boolean) Optional.ofNullable(state.get("displayed")).orElse(false);
                        String probability = Optional.ofNullable(state.get("probability")).orElse("").toString();
                        String bettingStatus = Optional.ofNullable(state.get("bettingStatus")).orElse("").toString();
                        String resultedStatus = Optional.ofNullable(state.get("resultedStatus")).orElse("").toString();
                        String sgxColumnName = Optional.ofNullable(state.get("sgxColumnName")).orElse("").toString();

                        SelectionObject selectionObject = new SelectionObject.Builder()
                                .type(type)
                                .state(state.toString())
                                .extId(extId)
                                .id(id)
                                .name(name)
                                .displayOrder(displayOrder)
                                .displayed(displayed)
                                .probability(probability)
                                .bettingStatus(bettingStatus)
                                .resultedStatus(resultedStatus)
                                .sgxColumnName(sgxColumnName)
                                .build();

                        selections.add(selectionObject);
                        /*System.out.println("SelectionType: " + selectionObject.getType());
                        System.out.println("SelectionState: " + selectionObject.getState());
                        System.out.println("SelectionExtId: " + selectionObject.getExtId());
                        System.out.println("SelectionId: " + selectionObject.getId());
                        System.out.println("SelectionName: " + selectionObject.getName());
                        System.out.println("SelectionDisplayOrder: " + selectionObject.getDisplayOrder());
                        System.out.println("SelectionProbability: " + selectionObject.getProbability());
                        System.out.println("SelectionBettingStatus: " + selectionObject.getBettingStatus());
                        System.out.println("SelectionResultStatus: " + selectionObject.getResultedStatus());
                        System.out.println("SelectionSGXColumnName: " + selectionObject.getSgxColumnName());*/
                    }
                }
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return selections;
    }

    /**
     * Gets the value of the offeredInRunning key, under 4-eventState from soupi response
     *
     * @return the value of offeredInRunning as a boolean
     */
    public static boolean getSoupiOfferedInRunning() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        boolean oir = false;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                oir = Boolean.parseBoolean(state.get("offeredInRunning").toString());
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return oir;
    }

    /**
     * Gets the value of the display key, under 4-eventState from soupi response
     *
     * @return the value of display as a boolean
     */
    public static boolean getSoupiDisplay() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        boolean display = false;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                String displayString = state.get("display").toString();
                if (displayString != null) {
                    display = Boolean.parseBoolean(displayString);
                }
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return display;
    }

    /**
     * Gets the value of the resulted key, under 4-eventState from soupi response
     *
     * @return the value of resulted as a boolean
     */
    public static boolean getSoupiResulted() {
        String input = Driver.getText(SoupiHomePage.upiResult);
        JSONParser parser = new JSONParser();
        JSONObject soupiObject = null;
        boolean resulted = false;
        try {
            if (!input.equals(SoupiHomePage.resultError)) {
                soupiObject = (JSONObject) parser.parse(input);
                JSONObject eventState = (JSONObject) soupiObject.get("4-eventState");
                JSONObject state = (JSONObject) eventState.get("state");
                resulted = Boolean.parseBoolean(state.get("resulted").toString());
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
        }
        return resulted;
    }


    /**
     * Gets the score from the soupi response for a given set
     *
     * @param setIndex the set number
     * @return the score as an int list of playerA score & playerB score
     */
    public static List<Integer> getSoupiSetScore(int setIndex) {
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

                // Adjust setIndex to be zero-based
                int zeroBasedIndex = setIndex - 1;

                if (zeroBasedIndex < completedSetScores.size() && zeroBasedIndex >= 0) {
                    JSONObject setScoreObject = (JSONObject) completedSetScores.get(zeroBasedIndex);
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
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return setScoreList;
    }

    public static String getAllSetScoresFormatted(List<Integer> setScore, int maxSets) {
        String endScore = "";
        for (int i = 1; i <= maxSets; i++) {
            setScore = Extract.getSoupiSetScore(i);
            endScore = endScore.concat(formatScores(setScore, getSoupiHighestSetNumber()));
        }
        return endScore + getCurrentGameScore();
    }

    public static String getCurrentGameScore() {
        return "0-0";
    }


    /**
     * Gets the highest completed set number from a soupi response
     *
     * @return the highest number for a completed set as an int
     */
    public static int getSoupiHighestSetNumber() {
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
     * Formats a given list of set scores to the desired format
     *
     * @param scores       the list of scores
     * @param numberOfSets the numbers of sets
     * @return the formatted string to desired format of a final result i.e. 6-4 4-6 2-2 30-A || 6-4 4-6 2-2 *30-A
     */
    public static String formatScores(List<Integer> scores, int numberOfSets) {
        StringBuilder formattedString = new StringBuilder();
        formattedString = formattedString.append(scores.get(0)).append("-").append(scores.get(1)).append(" ");
        //TODO: Add condition to match for additional concatenation of "*30-A"
        return formattedString.toString();
    }

    /**
     * Extracts the player names from UPI response
     *
     * @param input upi response
     * @return list containing the names of Player A and Player B
     */
    public static List<String> getSoupiPlayerNames(String input) {
        String regex = "\\|([^|]+ [^|]+(?: [^|]+)?)\\| \\|[^|]*\\| \\|([^|]+ [^|]+(?: [^|]+)?)\\|";
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String playerA = matcher.group(1);
            String playerB = matcher.group(2);
            list.add(playerA);
            list.add(playerB);
        }
        return list;
    }

    /**
     * Extracts the difference between two given strings
     *
     * @param str1 String 1 to be compared
     * @param str2 String 2 to be compared
     * @return the resulted difference as a string
     */
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

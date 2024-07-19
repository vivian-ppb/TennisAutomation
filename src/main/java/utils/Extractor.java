package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public static List<String> extractKey(String input, String key) {
        String regex = null;
        // Regular expression to match "id" : followed by digits
        regex = "\"" + Pattern.quote(key) + "\"\\s*:\\s*(\\d+)";

        if (key.equals("competitionName")) {
            regex = "\"" + Pattern.quote(key) + "\"\\s*:\\s*\"([^\"]*)\"";
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // List to hold all the extracted IDs
        List<String> list = new ArrayList<>();

        // Find and add all matches to the list
        while (matcher.find()) {
            list.add((matcher.group(1)));
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

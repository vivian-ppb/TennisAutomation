package utils.soupi;

import java.util.ArrayList;
import java.util.List;

public class SoupiUtils {

    public static List<String> soupiUrlBuilder(List<String> ids, String baseUrl) {
        List<String> endUrls = new ArrayList<>();
        for (String id : ids) {
            String soupiUrl = baseUrl + id;
            endUrls.add(soupiUrl);
        }
        return endUrls;
    }

}

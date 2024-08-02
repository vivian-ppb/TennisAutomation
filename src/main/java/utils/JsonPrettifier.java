package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonPrettifier {

    public static String prettifyJson(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String prettyJsonString = null;

        try {
            Object json = objectMapper.readValue(jsonString, Object.class);
            prettyJsonString = objectWriter.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return prettyJsonString;
    }

}

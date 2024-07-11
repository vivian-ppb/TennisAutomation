package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;

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
            // You can also throw an exception or handle it based on your use case
        }

        return prettyJsonString;
    }

}

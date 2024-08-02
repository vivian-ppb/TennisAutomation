package utils;

import com.tennis.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.tennis.Driver.devTools;


public class Intercept {

    /**
     * Intercepts the url of a request
     *
     * @param locator
     */
    public static String interceptRequestUrl(By locator) {
        AtomicReference<String> url = new AtomicReference<>("");
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            url.set(req.getUrl());

        });
        Driver.click(locator);
        Sleeper.sleep(5000);
        return url.get();
    }

    /**
     * Sends an HTTP request using the given parameters
     *
     * @param requestMethod: GET/POST/PUT/DELETE
     * @param endpointUrl:   The request endpoint
     * @return Returns the response as a string
     */
    //TODO: If required, a parameter for the request body will be added
    public static String sendHttpRequest(String requestMethod, String endpointUrl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(endpointUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod.toUpperCase());
            if ("POST".equalsIgnoreCase(requestMethod) || "PUT".equalsIgnoreCase(requestMethod) || "PATCH".equalsIgnoreCase(requestMethod)) {
                connection.setDoOutput(true);
                String jsonInputString = "{\"name\": \"test\"}";
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }
            int responseCode = connection.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }

    public static List<String> sendHttpRequest(String requestMethod, List<String> endpointUrls) {
        List<String> responses = new ArrayList<>();

        for (String endpointUrl : endpointUrls) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            StringBuilder response = new StringBuilder();

            try {
                URL url = new URL(endpointUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(requestMethod.toUpperCase());
                if ("POST".equalsIgnoreCase(requestMethod) || "PUT".equalsIgnoreCase(requestMethod) || "PATCH".equalsIgnoreCase(requestMethod)) {
                    connection.setDoOutput(true);
                    String jsonInputString = "{\"name\": \"test\"}";
                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }
                }
                int responseCode = connection.getResponseCode();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                responses.add("Error: " + e.getMessage());
                continue;
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }

            responses.add(response.toString());
        }

        return responses;
    }
}
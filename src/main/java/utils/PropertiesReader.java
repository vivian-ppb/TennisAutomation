package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    /**
     * Returns a given property from a given properties file
     * @param fileName The name of the properties file
     * @param property The name of the property
     */
    public static String getProperty(String fileName, String property) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/" + fileName)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(property);
    }
}

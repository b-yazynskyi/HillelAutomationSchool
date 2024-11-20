package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    private static final Properties properties = loadProperties();
    private static final String FILE_NAME = "app.properties";

    private ConfigProvider(){}

    private static Properties loadProperties() {
        var prop = new Properties();

        try (FileInputStream inputStream = new FileInputStream(FILE_NAME)) {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return prop;
    }

    public static String getProperty(String name) { return properties.getProperty(name);}
}

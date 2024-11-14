package configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "/app.config";
    private static ConfigReader instance = null;
    private final Properties properties;

    public synchronized static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }

        return instance;
    }

    private ConfigReader() {
        properties = new Properties();

        try {
            properties.load(ConfigReader.class.getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String loadConfig(String name) {
        return getInstance().properties.getProperty(name);
    }

}

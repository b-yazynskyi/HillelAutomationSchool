package utils;

import utils.configs.ConfigReader;

public class AppConstants {
    public static final boolean HEADLESS_APP_MODE = Boolean.parseBoolean(ConfigReader.loadConfig("headless"));
    public static final String BASE_URL = ConfigReader.loadConfig("base_url");
}

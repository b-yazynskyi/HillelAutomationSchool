package utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class AppConfigUtils {
    private static final String PROJECT = "file:./src/main/resources/${project}_config.properties";
    private static final IConfig CONFIG;

    static {
        System.setProperty("project", ProjectUtils.project());
        CONFIG = ConfigFactory.create(IConfig.class);
    }

    @Config.Sources({PROJECT})
    public interface IConfig extends Config {
        @Key("browser.name")
        String browserName();

        @Key("isVNC")
        boolean isVnc();

        @Key("isEnableVideo")
        boolean isEnableVideo();

        @Key("isSelenoid")
        boolean isSelenoid();

        @Key("isHeadless")
        boolean isHeadless();
    }
}

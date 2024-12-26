package utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
public class ProjectUtils {
    public static String project() {
        return System.getProperty("project") == null ? Environment.LOCAL.get() : System.getProperty("project");
    }

    @RequiredArgsConstructor
    @Accessors(fluent = true)
    @Getter
    public enum Environment {
        STAGE("stage"),
        LOCAL("local"),
        PROD("prod");

        private final String get;
    }
}

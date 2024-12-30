package utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public class ProjectUtils {
    public static String project;

    static {
        project = System.getProperty("project") == null ? Environment.API.get() : System.getProperty("project");
    }

    @RequiredArgsConstructor
    @Accessors(fluent = true)
    @Getter
    public enum Environment {
        API("api");

        private final String get;
    }
}

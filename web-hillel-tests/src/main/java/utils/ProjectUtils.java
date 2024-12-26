package utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
public class ProjectUtils {
    public static String project;

    static {
        project = System.getProperty("project") == null ? Environment.FRONT.get() : System.getProperty("project");
    }

    @RequiredArgsConstructor
    @Accessors(fluent = true)
    @Getter
    public enum Environment {
        FRONT("front");

        private final String get;
    }
}

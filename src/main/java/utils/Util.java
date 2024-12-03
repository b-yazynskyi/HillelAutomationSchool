package utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Slf4j
public class Util {

    public static File createTxtFile() {
        String ext = "txt";
        String randomFileName = String.format("%s.%s", RandomStringUtils
                .random(10, 0, 0, true, true, null
                        , Random.from(RandomGenerator.getDefault())), ext);
        File dir = new File("/Users/bohdanyazynskyi/IdeaProjects/HillelAutomationQASchool/build/files");
        return new File(dir, randomFileName);
    }

    public static void writeDataToFile(List<String> textForFile, File file) {
        try (FileWriter myWriter = new FileWriter(file)) {
            myWriter.write(String.valueOf(textForFile));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static String readDataFromFile(File file) {
        String dataFromFile = "";
        try {
            Path filePath = file.toPath();
            List<String> linesFromFile = Files.readAllLines(filePath);
            dataFromFile = String.join("\n", linesFromFile);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return dataFromFile;
    }
}

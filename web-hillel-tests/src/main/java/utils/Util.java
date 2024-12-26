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
public final class Util {

    private Util(){}

    public static File createFile(String fileExtension, int randomStringLength) {
        String randomFileName = String.format("%s.%s", RandomStringUtils
                .random(randomStringLength, 0, 0, true, true, null), fileExtension);
        File dir = new File("/tmp/testData");
        return new File(dir, randomFileName);
    }

    public static void writeDataToFile(List<String> textForFile, File file) {
        try (FileWriter myWriter = new FileWriter(file)) {
            for (String line : textForFile) {
                myWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Error writing data to file", e);
        }
    }

    public static String readDataFromFile(File file) {
        String dataFromFile = "";
        try {
            Path filePath = file.toPath();
            List<String> linesFromFile = Files.readAllLines(filePath);
            dataFromFile = String.join(System.lineSeparator(), linesFromFile).trim();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Error reading data from file", e);
        }

        log.info("Data from file: {}", dataFromFile);
        return dataFromFile;
    }
}

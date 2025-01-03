package unit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static utils.Util.*;

public class UtilTest {

    @DataProvider(name = "fileCreationData")
    public Object[][] provideFileCreationData() {
        return new Object[][] {
                {"txt", 8},
                {"log", 12},
                {"csv", 5},
        };
    }

    @Test(dataProvider = "fileCreationData")
    public void testCreateFile(String fileExtension, int randomStringLength) {
        File createdFile = createFile(fileExtension, randomStringLength);

        Assert.assertNotNull(createdFile, "File should not be null");
        Assert.assertTrue(createdFile.getName().endsWith("." + fileExtension), "File extension is incorrect");
        Assert.assertEquals(createdFile.getName().split("\\.")[0].length(), randomStringLength, "File name length is incorrect");
    }

    @Test(groups = "unit-tests")
    public void testWriteDataToFile() throws IOException {
        File tempFile = File.createTempFile("testFile", ".txt");
        List<String> dataToWrite = Arrays.asList("Line 1", "Line 2", "Line 3");

        writeDataToFile(dataToWrite, tempFile);
        String dataRead = readDataFromFile(tempFile);

        String expectedData = String.join(System.lineSeparator(), dataToWrite);

        Assert.assertEquals(dataRead, expectedData, "Data read from file does not match data written");

        tempFile.delete();
    }

    @Test(groups = "unit-tests")
    public void testReadDataToFile() throws IOException {
        File tempFile = File.createTempFile("testFile", ".txt");
        List<String> dataToWrite = Arrays.asList("Line 1", "Line 2", "Line 3");

        writeDataToFile(dataToWrite, tempFile);
        String dataRead = readDataFromFile(tempFile);

        String expectedData = String.join(System.lineSeparator(), dataToWrite);

        Assert.assertEquals(dataRead, expectedData, "Data read from file does not match data written");

        tempFile.delete();
    }

    @Test(groups = "unit-tests")
    public void testReadDataFromNonExistentFile() {
        File nonExistentFile = new File("/tmp/nonExistentFile.txt");

        Assert.assertThrows(RuntimeException.class, () -> readDataFromFile(nonExistentFile));
    }
}

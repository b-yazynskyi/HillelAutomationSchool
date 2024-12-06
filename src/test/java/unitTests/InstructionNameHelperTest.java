package unitTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.InstructionNameHelper.createInstructionName;

public class InstructionNameHelperTest {

    @DataProvider(name = "instructionNameData")
    public Object[][] provideInstructionNameData() {
        return new Object[][] {
                {"Quick Start Guide", "BrandX", "ModelY", "Quick_20Start_20Guide_20BrandX_20ModelY.pdf"},
                {"User Manual", "CompanyA", "DeviceB", "User_20Manual_20CompanyA_20DeviceB.pdf"},
                {"Setup", "Brand123", "Model456", "Setup_20Brand123_20Model456.pdf"},
                {"", "BrandOnly", "ModelOnly", "_20BrandOnly_20ModelOnly.pdf"},
                {"NoBrand", "", "NoModel", "NoBrand_20_20NoModel.pdf"},
                {"SingleWord", "", "", "SingleWord_20_20.pdf"},
        };
    }

    @Test(dataProvider = "instructionNameData", groups = "unit-tests")
    public void testCreateInstructionName(String instructionDescription, String brandName, String modelName,
                                          String expectedResult) {
        String actualResult = createInstructionName(instructionDescription, brandName, modelName);

        Assert.assertEquals(actualResult, expectedResult,
                "Generated instruction name does not match the expected result.");
    }
}

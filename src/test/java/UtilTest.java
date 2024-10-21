import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Util;

import java.util.HashMap;
import java.util.Map;

public class UtilTest {

    @Test(groups = {"getLengthOfStrings"})
    void code3PlusBug1ShouldCountProperly() {
        String[] stringsList = new String[] {"a", "bb", "a", "bb"};
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("bb", 2);
        expectedResultMap.put("a", 1);

        Assert.assertEquals(Util.getLengthOfStrings(stringsList), expectedResultMap);
    }

    @Test(groups = {"getLengthOfStrings"})
    void thisAnd2ThatShouldCountProperly() {
        String[] stringsList = new String[] {"this", "and", "that", "and"};
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("that", 4);
        expectedResultMap.put("and", 3);
        expectedResultMap.put("this", 4);

        Assert.assertEquals(Util.getLengthOfStrings(stringsList), expectedResultMap);
    }

    @Test(groups = {"getLengthOfStrings"})
    void code3Bug1ShouldCountProperly() {
        String[] stringsList = new String[] {"code", "code", "code", "bug"};
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("code", 4);
        expectedResultMap.put("bug", 3);

        Assert.assertEquals(Util.getLengthOfStrings(stringsList), expectedResultMap);
    }


}

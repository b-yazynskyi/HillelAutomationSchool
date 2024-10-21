import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Util;

import java.util.*;

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

    @Test(groups = {"createMap"})
    public void testCreateMap_ValidInput() {
        String[] input = {"apple", "banana", "cherry"};

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "e");
        expectedMap.put("b", "a");
        expectedMap.put("c", "y");

        Map<String, String> result = Util.createMap(input);

        Assert.assertEquals(result, expectedMap);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"createMap"})
    public void testCreateMap_EmptyInput() {
        String[] input = {};
        Util.createMap(input); // Should throw IllegalArgumentException
    }

    @Test(groups = {"countWords"})
    public void testCountWords_ValidInput() {
        String[] input = {"apple", "banana", "apple"};

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("apple", 2);
        expectedMap.put("banana", 1);

        Map<String, Integer> result = Util.countWords(input);

        Assert.assertEquals(result, expectedMap);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"countWords"})
    public void testCountWords_EmptyInput() {
        String[] input = {};
        Util.countWords(input); // Should throw IllegalArgumentException
    }

    @Test(groups = {"mergeStringByFirstChar"})
    public void testMergeStringsByFirstChar_ValidInput() {
        String[] input = {"apple", "apricot", "banana", "berry"};

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "appleapricot");
        expectedMap.put("b", "bananaberry");

        Map<String, String> result = Util.mergeStringsByFirstChar(input);

        Assert.assertEquals(result, expectedMap);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"mergeStringByFirstChar"})
    public void testMergeStringsByFirstChar_EmptyInput() {
        String[] input = {};
        Util.mergeStringsByFirstChar(input); // Should throw IllegalArgumentException
    }

    @Test(groups = {"buildResultString"})
    public void testBuildResultString_EvenOccurrences() {
        String[] input = {"apple", "banana", "apple", "banana", "apple"};

        String expected = "banana";

        String result = Util.buildResultString(input);

        Assert.assertEquals(result, expected);
    }

    @Test(groups = {"buildResultString"})
    public void testBuildResultString_NoEvenOccurrences() {
        String[] input = {"apple", "banana", "cherry"};

        String result = Util.buildResultString(input);

        Assert.assertEquals(result, ""); // No even occurrence, should return empty string
    }

    // Test for findTheMostRepeatedElement method
    @Test(groups = {"findTheMostRepeatedElement"})
    public void testFindTheMostRepeatedElement_ValidInput() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 3, 3);

        int expected = 3;

        int result = Util.findTheMostRepeatedElement(input);

        Assert.assertEquals(result, expected);
    }

    // Test for haveCommonElement method
    @Test(groups = {"haveCommonElement"})
    public void testHaveCommonElement_TrueCase() {
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        LinkedHashSet<Integer> setB = new LinkedHashSet<>(Arrays.asList(3, 4, 5));

        boolean result = Util.haveCommonElement(setA, setB);

        Assert.assertTrue(result);
    }

    @Test(groups = {"haveCommonElement"})
    public void testHaveCommonElement_FalseCase() {
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        LinkedHashSet<Integer> setB = new LinkedHashSet<>(Arrays.asList(4, 5, 6));

        boolean result = Util.haveCommonElement(setA, setB);

        Assert.assertFalse(result);
    }

    @Test(groups = {"testMerge2SetsTo1Set"})
    public void testMerge2SetsTo1Set_ValidInput() {
        TreeSet<Integer> setA = new TreeSet<>(Arrays.asList(1, 2, 3));
        TreeSet<Integer> setB = new TreeSet<>(Arrays.asList(3, 4, 5));

        TreeSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));

        TreeSet<Integer> result = Util.merge2SetsTo1Set(setA, setB);

        Assert.assertEquals(result, expectedSet);
    }
}

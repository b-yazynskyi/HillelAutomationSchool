import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class UtilsTest {

    @Test(groups = {"catDog"})
    public void testCatDogEqualCounts() {
        Assert.assertTrue(Utils.catDog("catdogcatdog"), "cat and dog counts should be equal");
    }

    @Test(groups = {"catDog"})
    public void testCatDogUnequalCounts() {
        Assert.assertFalse(Utils.catDog("catdogcat"), "cat and dog counts should be unequal");
    }

    @Test(groups = {"centeredAverage"})
    public void testCenteredAverageValidInput() {
        int[] array = {1, 2, 3, 4, 5};
        Assert.assertEquals(Utils.centeredAverage(array), 3);
    }

    @Test(groups = {"centeredAverage"}, expectedExceptions = IllegalArgumentException.class)
    public void testCenteredAverageInvalidInput() {
        int[] array = {1, 2};
        Utils.centeredAverage(array);
    }

    @Test(groups = {"countEvenInts"})
    public void testCountEvenIntsAllEven() {
        int[] array = {2, 4, 6, 8};
        Assert.assertEquals(Utils.countEvenInts(array), 4);
    }

    @Test(groups = {"countEvenInts"})
    public void testCountEvenIntsMixed() {
        int[] array = {1, 2, 3, 4};
        Assert.assertEquals(Utils.countEvenInts(array), 2);
    }

    @Test(groups = {"sumIgnoreSections"})
    public void testSumIgnoreSections() {
        int[] array = {1, 2, 6, 7, 3};
        Assert.assertEquals(Utils.sumIgnoreSections(array), 6);
    }

    @Test(groups = {"sumWithoutUnlucky13"})
    public void testSumWithoutUnlucky13() {
        int[] array = {1, 2, 13, 4, 5};
        Assert.assertEquals(Utils.sumWithoutUnlucky13(array), 3);
    }

    @Test(groups = {"differenceLargestSmallest"})
    public void testDifferenceLargestSmallest() {
        int[] array = {10, 2, 4, 8};
        Assert.assertEquals(Utils.differenceLargestSmallest(array), 8);
    }

    @Test(groups = {"doubleChars"})
    public void testDoubleChars() {
        Assert.assertEquals(Utils.doubleChars("hello"), "hheelllloo");
    }

    @Test(groups = {"countHi"})
    public void testCountHi() {
        Assert.assertEquals(Utils.countHi("hihi hi"), 3);
    }

    @Test(groups = {"countCode"})
    public void testCountCode() {
        Assert.assertEquals(Utils.countCode("cozecocodecoee"), 3);
    }

    @Test(groups = {"endsWith"})
    public void testEndsWithTrue() {
        Assert.assertTrue(Utils.endsWith("hello", "lo"));
    }

    @Test(groups = {"endsWith"})
    public void testEndsWithFalse() {
        Assert.assertFalse(Utils.endsWith("hello", "world"));
    }
}

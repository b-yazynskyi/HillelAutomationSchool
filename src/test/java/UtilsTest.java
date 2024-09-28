import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class UtilsTest {

    @Test(groups = {"repeatEnd"})
    void wordAndNumber3Returns3lastLetters3times() {
        Assert.assertEquals(Utils.repeatEnd("Hello", 3), "llollollo");
    }

    @Test(groups = {"repeatEnd"})
    void wordAndNumber2Returns2lastLetters2times() {
        Assert.assertEquals(Utils.repeatEnd("Hello", 2), "lolo");
    }

    @Test(groups = {"repeatEnd"})
    void wordAndNumber1Returns1lastLetters1time() {
        Assert.assertEquals(Utils.repeatEnd("Hello", 1), "o");
    }

    @Test(groups = {"repeatEnd"})
    void wordLowerThanNumberShouldBeException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Utils.repeatEnd("Hello", 6));
    }

    @Test(groups = {"mixString"})
    void abcAndXyzShouldBeMixedOneByOne() {
        Assert.assertEquals(Utils.mixString("abc", "xyz").toString(), "axbycz");
    }

    @Test(groups = {"mixString"})
    void hiAndThereShouldBeMixedOneByOnePlusRest() {
        Assert.assertEquals(Utils.mixString("Hi", "There").toString(), "HTihere");
    }

    @Test(groups = {"mixString"})
    void xxxxAndThereShouldBeMixedOneByOnePlusRest() {
        Assert.assertEquals(Utils.mixString("xxxx", "There").toString(), "xTxhxexre");
    }
}

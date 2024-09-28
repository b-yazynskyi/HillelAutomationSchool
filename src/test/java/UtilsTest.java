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
}

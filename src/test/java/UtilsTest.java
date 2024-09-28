import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class UtilsTest {

    @Test(groups = {"repeatEnd"})
    void wordAndNumber3Returns3lastLetters3times() {
        Assert.assertEquals(Utils.repeatEnd("Hello", 3), "llollollo");
    }
}

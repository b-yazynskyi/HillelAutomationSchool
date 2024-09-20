import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class UtilsTests {

    @Test(groups = {"isAdult"})
    void eighteenShouldBeAdult() {
        Assert.assertEquals(Utils.isAdult(18), "Ви доросла особа");
    }

    @Test(groups = {"isAdult"})
    void zeroShouldBeChild() {
        Assert.assertEquals(Utils.isAdult(0), "Ви не є дорослою особою");
    }

    @Test(groups = {"isAdult"})
    void seventeenShouldBeChild() {
        Assert.assertEquals(Utils.isAdult(17), "Ви не є дорослою особою");
    }

    @Test(groups = {"isAdult"})
    void negativeNumberShouldThrowException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> Utils.isAdult(-1));
    }

    @Test(groups = {"isAdult"})
    void oneHundredTwentyShouldThrowException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> Utils.isAdult(121));
    }

    @Test(groups = {"isPerfectSquare"})
    void twentyFiveShouldBeTrue() {
        Assert.assertTrue(Utils.isPerfectSquare(25));
    }

    @Test(groups = {"isPerfectSquare"})
    void twentyShouldBeFalse() {
        Assert.assertFalse(Utils.isPerfectSquare(20));
    }

    @Test(groups = {"isPerfectSquare"})
    void nineShouldBeTrue() {
        Assert.assertTrue(Utils.isPerfectSquare(9));
    }

    @Test(groups = {"isPerfectSquare"})
    void minusOneThrowsException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Utils.isPerfectSquare(-1));
    }

}

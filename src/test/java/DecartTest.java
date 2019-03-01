import org.junit.Test;
import org.junit.Assert;


public class DecartTest {

    @Test
    public void toQuaternion() {
        Decart first = new Decart(Math.PI, 0, 10, 15);
        Quaternion second = new Quaternion(6.123233995736766E-17, 0, 0.5547001962252291, 0.8320502943378437);
        Assert.assertEquals(second, first.toQuaternion());
    }
}

import org.junit.Test;
import org.junit.Assert;


public class DecartTest {

    @Test
    public void toQuaternion() {
        Decart first = new Decart();
        first.alpha = Math.PI;
        first.x = 0.0;
        first.y = 10.0;
        first.z = 15.0;
        Assert.assertEquals(0.0, first.toQuaternion().s, 1e-10);
        Assert.assertEquals(0.0, first.toQuaternion().i, 1e-10);
        Assert.assertEquals(0.8320502943378437, first.toQuaternion().k, 1e-10);
        Assert.assertEquals(0.5547001962252291, first.toQuaternion().j, 1e-10);
    }
    }

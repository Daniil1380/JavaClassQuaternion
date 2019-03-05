import org.junit.Assert;
import org.junit.Test;



public class QuaternionTest {


    @org.junit.Test
    public void scalarMulti() {
        Quaternion first = new Quaternion(10, -5, 0, 15);
        Quaternion second = new Quaternion(30, -15, 0, 45);
        Assert.assertEquals(second, first.scalarMulti(3));
    }

    @org.junit.Test
    public void plus() {
        Quaternion first = new Quaternion(10, -5, 0, 15);
        Quaternion second = new Quaternion(-30, -15, 0, 45);
        Quaternion third = new Quaternion(-20, -20, 0, 60);
        Assert.assertEquals(third, first.plus(second));

    }

    @org.junit.Test
    public void minus() {
        Quaternion first = new Quaternion(10, -5, 0, 15);
        Quaternion second = new Quaternion(-30, -15, 0, 45);
        Quaternion third = new Quaternion(40, 10, 0, -30);
        Assert.assertEquals(third, first.minus(second));
    }

    @org.junit.Test
    public void mod() {
        Quaternion first = new Quaternion(1, 1, 1, 1);
        Assert.assertEquals(2, first.mod(), 1e-10);
    }

    @org.junit.Test
    public void inter() {
        Quaternion first = new Quaternion(1, -1, 0, 1);
        Quaternion second = new Quaternion(1, 1, 0, -1);
        Assert.assertEquals(second, first.inter());

    }

    @org.junit.Test
    public void vector() {
        Quaternion first = new Quaternion(1, -1, 0, 1);
        Quaternion second = new Quaternion(0, -1, 0, 1);
        Assert.assertEquals(second, first.vector());
    }


    @org.junit.Test
    public void scalar() {
        Quaternion first = new Quaternion(1, -1, 0, 1);
        Quaternion second = new Quaternion(1, 0, 0, 0);
        Assert.assertEquals(second, first.scalar());
    }

    @org.junit.Test
    public void multi() {
        Quaternion first = new Quaternion(10, -5, 0, 15);
        Quaternion second = new Quaternion(30, -15, 0, 45);
        Quaternion third = new Quaternion(-450, -300, 0, 900);
        Assert.assertEquals(third, first.multi(second));
        first = new Quaternion(0, 0, 0, 0);
        second = new Quaternion(0, 0, 0, 0);
        third = new Quaternion(0, 0, 0, 0);
        Assert.assertEquals(third, first.multi(second));

    }

    @org.junit.Test
    public void division() {
        Quaternion first = new Quaternion(10, -5, 0, 15);
        Quaternion second = new Quaternion(30, -15, 0, 45);
        Quaternion third = new Quaternion(1 / 3.0, 0.0, 0.0, 0.0);
        Assert.assertEquals(third, first.division(second));

    }

    @org.junit.Test
    public void normal() {
        Quaternion first = new Quaternion(10, 5, 0, 15);
        Quaternion second = new Quaternion(10, 5, 0, 15).scalarMulti(1 / first.mod());
        Assert.assertEquals(second, first.normal());
    }

    @Test
    public void multiNull() {
        Quaternion first = new Quaternion(0, 0, 0, 0);
        Quaternion second = new Quaternion(0, 0, 0, 0);
        Quaternion third = new Quaternion(0, 0, 0, 0);
        Assert.assertEquals(third, first.multi(second));
    }

    @Test(expected = NumberFormatException.class)
    public void divisionException() {
        Quaternion first = new Quaternion(0, 0, 0, 0);
        Quaternion second = new Quaternion(0, 0, 0, 0);
        Quaternion third = new Quaternion(0, 0, 0, 0);
        Assert.assertEquals(third, first.division(second));

    }

    @Test(expected = NumberFormatException.class)
    public void normalException() {
        Quaternion first = new Quaternion(0, 0, 0, 0);
        Quaternion second = new Quaternion(0, 0, 0, 0).scalarMulti(1 / first.mod());
        Assert.assertEquals(second, first.normal());
    }

    @Test(expected = NumberFormatException.class)
    public void getAngleException() {
        Quaternion first = new Quaternion(0, 0, 0, 0);
        Assert.assertEquals(0, first.getAngle(), 1e-10);
    }

    @Test
    public void getAngle() {
        Quaternion first = new Quaternion(0, 1, 0, -1);
        Assert.assertEquals(Math.PI, first.getAngle(), 1e-10);
    }

    @Test
    public void getAxis() {
        Quaternion first = new Quaternion(0, 1, 0, -1);
        Vector second  = new Vector(Math.PI / 2, 0, Math.PI / -2);
        Assert.assertEquals(second, first.getAxis());
    }

    @Test
    public void fromAngleAndAxis() {
        Vector first = new Vector(Math.PI / 2, 0, 0);
        Quaternion second = new Quaternion(1, 0, 0, 0);
        Assert.assertEquals(second, Quaternion.fromAngleAndAxis(0.0 / 2, first));

    }

    @Test(expected = NumberFormatException.class)
    public void fromAngleAndAxisException() {
        Vector first = new Vector(0, 0, 0);
        Quaternion second = new Quaternion(0, 0, 0, 0);
        Assert.assertEquals(second, Quaternion.fromAngleAndAxis(0.0 / 2, first));

    }
}
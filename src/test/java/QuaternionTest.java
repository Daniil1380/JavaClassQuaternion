import org.junit.Assert;
import org.junit.Test;

public class QuaternionTest {
    @org.junit.Test
    public void scalarMulti() {
        Quaternion first = new Quaternion();
        first.i = -5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Quaternion second = new Quaternion();
        second.i = -15.0;
        second.j = 0.0;
        second.s = 30.0;
        second.k = 45.0;
        Assert.assertEquals(second.s, first.scalarMulti(3).s, 1e-10);
        Assert.assertEquals(second.i, first.scalarMulti(3).i, 1e-10);
        Assert.assertEquals(second.j, first.scalarMulti(3).j, 1e-10);
        Assert.assertEquals(second.k, first.scalarMulti(3).k, 1e-10);
    }

    @org.junit.Test
    public void plus() {
        Quaternion first = new Quaternion();
        first.i = -5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Quaternion second = new Quaternion();
        second.i = -15.0;
        second.j = 0.0;
        second.s = 30.0;
        second.k = 45.0;
        Assert.assertEquals(40.0, first.plus(second).s, 1e-10);
        Assert.assertEquals(-20.0, first.plus(second).i, 1e-10);
        Assert.assertEquals(0.0, first.plus(second).j, 1e-10);
        Assert.assertEquals(60.0, first.plus(second).k, 1e-10);
    }

    @org.junit.Test
    public void minus() {
        Quaternion first = new Quaternion();
        first.i = -5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Quaternion second = new Quaternion();
        second.i = -15.0;
        second.j = 0.0;
        second.s = 30.0;
        second.k = 45.0;
        Assert.assertEquals(-20.0, first.minus(second).s, 1e-10);
        Assert.assertEquals(10.0, first.minus(second).i, 1e-10);
        Assert.assertEquals(0.0, first.minus(second).j, 1e-10);
        Assert.assertEquals(-30.0, first.minus(second).k, 1e-10);
    }

    @org.junit.Test
    public void mod() {
        Quaternion first = new Quaternion();
        first.i = 1.0;
        first.j = 1.0;
        first.s = 1.0;
        first.k = 1.0;
        Assert.assertEquals(2, first.mod(), 1e-10);
    }

    @org.junit.Test
    public void inter() {
        Quaternion first = new Quaternion();
        first.i = -1.0;
        first.j = 0.0;
        first.s = 1.0;
        first.k = 1.0;
        Assert.assertEquals(1.0, first.inter().s, 1e-10);
        Assert.assertEquals(1.0, first.inter().i, 1e-10);
        Assert.assertEquals(0.0, first.inter().j, 1e-10);
        Assert.assertEquals(-1.0, first.inter().k, 1e-10);
    }

    @org.junit.Test
    public void vector() {
        Quaternion first = new Quaternion();
        first.i = -1.0;
        first.j = 0.0;
        first.s = 1.0;
        first.k = 1.0;
        Assert.assertEquals(0.0, first.vector().s, 1e-10);
        Assert.assertEquals(-1.0, first.vector().i, 1e-10);
        Assert.assertEquals(0.0, first.vector().j, 1e-10);
        Assert.assertEquals(1.0, first.vector().k, 1e-10);
    }


    @org.junit.Test
    public void scalar() {
        Quaternion first = new Quaternion();
        first.i = -1.0;
        first.j = 0.0;
        first.s = 1.0;
        first.k = 1.0;
        Assert.assertEquals(1.0, first.scalar().s, 1e-10);
        Assert.assertEquals(0.0, first.scalar().i, 1e-10);
        Assert.assertEquals(0.0, first.scalar().j, 1e-10);
        Assert.assertEquals(0.0, first.scalar().k, 1e-10);
    }

    @org.junit.Test
    public void multi() {
        Quaternion first = new Quaternion();
        first.i = -5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Quaternion second = new Quaternion();
        second.i = -15.0;
        second.j = 0.0;
        second.s = 30.0;
        second.k = 45.0;
        Assert.assertEquals(-450.0, first.multi(second).s, 1e-10);
        Assert.assertEquals(-300.0, first.multi(second).i, 1e-10);
        Assert.assertEquals(0.0, first.multi(second).j, 1e-10);
        Assert.assertEquals(900.0, first.multi(second).k, 1e-10);
    }

    @org.junit.Test
    public void division() {
        Quaternion first = new Quaternion();
        first.i = -5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Quaternion second = new Quaternion();
        second.i = -15.0;
        second.j = 0.0;
        second.s = 30.0;
        second.k = 45.0;
        Assert.assertEquals(1 / 3.0, first.division(second).s, 1e-10);
        Assert.assertEquals(0.0, first.division(second).i, 1e-10);
        Assert.assertEquals(0.0, first.division(second).j, 1e-10);
        Assert.assertEquals(0.0, first.division(second).k, 1e-10);
    }

    @org.junit.Test
    public void normal() {
        Quaternion first = new Quaternion();
        first.i = 5.0;
        first.j = 0.0;
        first.s = 10.0;
        first.k = 15.0;
        Assert.assertEquals(first.i / first.mod(), first.normal().i, 1e-10);
        Assert.assertEquals(first.s / first.mod(), first.normal().s, 1e-10);
        Assert.assertEquals(first.j / first.mod(), first.normal().j, 1e-10);
        Assert.assertEquals(first.k / first.mod(), first.normal().k, 1e-10);
    }

    @Test
    public void toDecart() {
        Quaternion first = new Quaternion();
        first.i = 1.0;
        first.j = 0.0;
        first.s = 0.0;
        first.k = -1.0;
        Assert.assertEquals(Math.PI, first.toDecart().alpha, 1e-10);
        Assert.assertEquals(Math.PI / 2, first.toDecart().x, 1e-10);
        Assert.assertEquals(0, first.toDecart().y, 1e-10);
        Assert.assertEquals(Math.PI / -2, first.toDecart().z, 1e-10);

    }
}
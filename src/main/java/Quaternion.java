

public class Quaternion {
    private double s;
    private double i;
    private double j;
    private double k;

    Quaternion(double s, double i, double j, double k) {
        this.s = s;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    // Умножения на скаляр
    public Quaternion scalarMulti(double scalar) {
        return new Quaternion(s * scalar, i * scalar, j * scalar, k * scalar);
    }

    //Сложение
    public Quaternion plus(Quaternion n) {
        return new Quaternion(s + n.s, i + n.i, j + n.j, k + n.k);
    }

    //Вычитание
    public Quaternion minus(Quaternion n) {
        return new Quaternion(s - n.s, i - n.i, j - n.j, k - n.k);
    }

    //модуль
    public double mod() {
        return Math.sqrt(Math.pow(s, 2.0) + Math.pow(i, 2.0) + Math.pow(k, 2.0) + Math.pow(j, 2.0));
    }

    //обращение
    public Quaternion inter() {
        return  new Quaternion(s, i * -1, j * -1, k * -1);
    }

    //Векторная часть
    public Quaternion vector() {
        return new Quaternion(0, i, j, k);
    }

    //Скалярная часть
    public Quaternion scalar() {
        return new Quaternion(s, 0, 0, 0);
    }

    //Умножение
    public Quaternion multi(Quaternion second) {
        double newS = (s * second.s - i * second.i - j * second.j - k * second.k);
        double newI = (s * second.i + second.s * i + j * second.k - k * second.j);
        double newJ = (s * second.j + j * second.s + k * second.i - i * second.k);
        double newK = (s * second.k + k * second.s + i * second.j - j * second.i);
        return new Quaternion(newS, newI, newJ, newK);
    }

    //Деление
    public Quaternion division(Quaternion second) {
        double moduleInSqr = Math.pow(second.mod(), 2.0);
        if (moduleInSqr == 0) throw new NumberFormatException("Деление на ноль");
        return this.multi(second.inter()).scalarMulti(1 / moduleInSqr);
    }


    //Нормализация
    public Quaternion normal() {
        if (this.mod() == 0) throw new NumberFormatException("Деление на ноль");
        return new Quaternion(s, i, j, k).scalarMulti(1 / this.mod());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return s == other.s && i == other.i && j == other.j && k == other.k;
        }
        return false;
    }

    public boolean equalsRound(Object obj, double n) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return Math.abs(s - other.s) <= n * Math.ulp(Math.max(s, other.s)) &&
                    Math.abs(i - other.i) <= n * Math.ulp(Math.max(i, other.i)) &&
                    Math.abs(j - other.j) <= n * Math.ulp(Math.max(j, other.j)) &&
                    Math.abs(k - other.k) <= n * Math.ulp(Math.max(k, other.k));
        }
        return false;
    }

    public double getS() {
        return s;
    }

    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }

    public double getK() {
        return k;
    }

    public double getAngle() {
        if (this.mod() == 0) throw new NumberFormatException("Деление на ноль");
        Quaternion normalize = this.scalarMulti(1 / this.mod());
        return 2 * Math.acos(normalize.s);
    }
    public Vector getAxis() {
        if (this.mod() == 0) throw new NumberFormatException("Деление на ноль");
        Quaternion normalize = this.scalarMulti(1 / this.mod());
        return new Vector( 2 * Math.asin(normalize.i),
                2 * Math.asin(normalize.j), 2 * Math.asin(normalize.k));
    }

    public static Quaternion fromAngleAndAxis(double angle, Vector axis) {
        double normalize = Math.sqrt(Math.pow(axis.getX(), 2.0) + Math.pow(axis.getY(), 2.0) + Math.pow(axis.getZ(), 2.0));
        if (axis.getX()== 0 && axis.getY()== 0 && axis.getZ()== 0) throw new NumberFormatException("Деление на ноль");
        return new Quaternion(Math.cos(angle / 2.0), Math.sin(angle / 2.0) * axis.getX() / normalize,
                Math.sin(angle / 2.0) * axis.getY() / normalize,Math.sin(angle / 2.0) * axis.getZ() / normalize);
    }
}

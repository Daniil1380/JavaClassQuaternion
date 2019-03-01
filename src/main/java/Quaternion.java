
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
    Quaternion scalarMulti(double scalar) {
        return new Quaternion(s * scalar, i * scalar, j * scalar, k * scalar);
    }

    //Сложение
    Quaternion plus(Quaternion n) {
        return new Quaternion(s + n.s, i + n.i, j + n.j, k + n.k);
    }

    //Вычитание
    Quaternion minus(Quaternion n) {
        return new Quaternion(s - n.s, i - n.i, j - n.j, k - n.k);
    }

    //модуль
    double mod() {
        return Math.sqrt(Math.pow(s, 2.0) + Math.pow(i, 2.0) + Math.pow(k, 2.0) + Math.pow(j, 2.0));
    }

    //обращение
    Quaternion inter() {
        return  new Quaternion(s, i * -1, j * -1, k * -1);
    }

    //Векторная часть
    Quaternion vector() {
        return new Quaternion(0, i, j, k);
    }

    //Скалярная часть
    Quaternion scalar() {
        return new Quaternion(s, 0, 0, 0);
    }

    //Умножение
    Quaternion multi(Quaternion second) {
        Quaternion answer = new Quaternion(0, 0, 0, 0);
        answer.s = (s * second.s - i * second.i - j * second.j - k * second.k);
        answer.i = (s * second.i + second.s * i + j * second.k - k * second.j);
        answer.j = (s * second.j + j * second.s + k * second.i - i * second.k);
        answer.k = (s * second.k + k * second.s + i * second.j - j * second.i);
        return answer;
    }

    //Деление
    Quaternion division(Quaternion second) {
        double moduleInSqr = Math.pow(second.mod(), 2.0);
        if (moduleInSqr == 0) throw new NumberFormatException("Деление на ноль");
        return new Quaternion(s, i, j, k).multi(second.inter()).scalarMulti(1 / moduleInSqr);
}


    //Нормализация
    Quaternion normal() {
        if (this.mod() == 0) throw new NumberFormatException("Деление на ноль");
        return new Quaternion(s, i, j, k).scalarMulti(1 / this.mod());
    }

    //Из Кватерниона в Декартову
    Decart toDecart() {
        Quaternion normalize = new Quaternion(s, i, j, k).scalarMulti(1 / this.mod());
        return new Decart(2 * Math.acos(normalize.s), 2 * Math.asin(normalize.i),
                2 * Math.asin(normalize.j), 2 * Math.asin(normalize.k));
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Quaternion) {
            Quaternion other = (Quaternion) obj;
            return s == other.s && i == other.i && j == other.j && k == other.k;
        }
        return false;
    }

    Double getS() {
        return s;
    }

    Double getI() {
        return i;
    }

    Double getJ() {
        return j;
    }

    Double getK() {
        return k;
    }
}



public class JavaClassQuaternion {
    public static void main(String [] args) {
    }
}

//Для перевода в Декартову систему
class Decart {
    double alpha;
    double x;
    double y;
    double z;
    // Перевод в кватернион из Декарта
    Quaternion toQuaternion() {
        double normalize = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
        Quaternion answer = new Quaternion();
        answer.s = Math.cos(alpha / 2.0);
        answer.i = Math.sin(alpha / 2.0) * x / normalize;
        answer.j = Math.sin(alpha / 2.0) * y / normalize;
        answer.k = Math.sin(alpha / 2.0) * z / normalize;
        return answer;
    }
}
class Quaternion {
    double s;
    double i;
    double j;
    double k;
    // Умножения на скаляр
    Quaternion scalarMulti(double scalar) {
        Quaternion answer = new Quaternion();
        answer.s = s * scalar;
        answer.i = i * scalar;
        answer.j = j * scalar;
        answer.k = k * scalar;
        return answer;
    }
    //Сложение
    Quaternion plus(Quaternion n) {
        Quaternion answer = new Quaternion();
        answer.s = s + n.s;
        answer.i = i + n.i;
        answer.j = j + n.j;
        answer.k = k + n.k;
        return answer;
    }
    //Вычитание
    Quaternion minus(Quaternion n) {
        Quaternion answer = new Quaternion();
        answer.s = s - n.s;
        answer.i = i - n.i;
        answer.j = j - n.j;
        answer.k = k - n.k;
        return answer;
    }
    //модуль
    double mod() {
        return Math.sqrt(Math.pow(s, 2.0) + Math.pow(i, 2.0) + Math.pow(k, 2.0) + Math.pow(j, 2.0));
    }
    //обращение
    Quaternion inter() {
        Quaternion answer = new Quaternion();
        answer.i = i * -1;
        answer.j = j * -1;
        answer.k = k * -1;
        answer.s = s;
        return answer;
    }
    //Векторная часть
    Quaternion vector() {
        Quaternion answer = new Quaternion();
        answer.s = 0.0;
        answer.i = i;
        answer.j = j;
        answer.k = k;
        return answer;
    }
    //Скалярная часть
    Quaternion scalar() {
        Quaternion answer = new Quaternion();
        answer.s = s;
        answer.i = 0;
        answer.j = 0;
        answer.k = 0;
        return answer;
    }
    //Умножение
    Quaternion multi(Quaternion second) {
        Quaternion answer = new Quaternion();
        answer.s = (s * second.s - i * second.i - j * second.j - k * second.k);
        answer.i = (s * second.i + second.s * i + j * second.k - k * second.j);
        answer.j = (s * second.j + j * second.s + k * second.i - i * second.k);
        answer.k = (s * second.k + k * second.s + i * second.j - j * second.i);
        return answer;
    }
    //Деление
    Quaternion division(Quaternion second) {
        double moduleInSqr = Math.pow(second.mod(), 2.0);
        Quaternion answer = new Quaternion();
        if (moduleInSqr == 0) throw new NumberFormatException("Деление на ноль");
        answer.s = this.multi(second.inter()).s;
        answer.i = this.multi(second.inter()).i;
        answer.j = this.multi(second.inter()).j;
        answer.k = this.multi(second.inter()).k;
        return answer.scalarMulti(1 / moduleInSqr);
    }
    //Нормализация
    Quaternion normal() {
        if (this.mod() == 0) throw new NumberFormatException("Деление на ноль");
        Quaternion answer = new Quaternion();
        answer.s = s;
        answer.i = i;
        answer.j = j;
        answer.k = k;
        return answer.scalarMulti(1 / this.mod());
    }

    //Из Кватерниона в Декартову
    Decart toDecart() {

        Decart answer = new Decart();
        Quaternion normalize = new Quaternion();
        normalize.s = s;
        normalize.i = i;
        normalize.j = j;
        normalize.k = k;
        normalize = normalize.scalarMulti(1 / this.mod());
        answer.alpha = 2 * Math.acos(normalize.s);
        answer.x = 2 * Math.asin(normalize.i);
        answer.y = 2 * Math.asin(normalize.j);
        answer.z = 2 * Math.asin(normalize.k);
        return answer;
    }
}
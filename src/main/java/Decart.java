
//Для перевода в Декартову систему
public class Decart {
    private double alpha;
    private double x;
    private double y;
    private double z;

    Decart(double alpha, double x, double y, double z) {
        this.alpha = alpha;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Перевод в кватернион из Декарта
    Quaternion toQuaternion() {
        double normalize = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
        return new Quaternion(Math.cos(alpha / 2.0),Math.sin(alpha / 2.0) * x / normalize,
                Math.sin(alpha / 2.0) * y / normalize,Math.sin(alpha / 2.0) * z / normalize);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Decart) {
            Decart other = (Decart) obj;
            return alpha == other.alpha && x == other.x && y == other.y && y == other.y;
        }
        return false;
    }

    Double getAlpha() {
        return alpha;
    }

    Double getX() {
        return x;
    }

    Double getY() {
        return y;
    }

    Double getZ() {
        return z;
    }


}
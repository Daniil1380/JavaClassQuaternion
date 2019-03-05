public class Vector {
    private double x;
    private double y;
    private double z;

    Vector(double x, double y, double z) {
        this.x = x;
        this.y =y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public boolean equalsRound(Object obj, double n) {
        if (this == obj) return true;
        if (obj instanceof Vector) {
            Vector other = (Vector) obj;
            return Math.abs(x - other.x) <= n * Math.ulp(Math.max(x, other.x)) &&
                    Math.abs(y - other.y) <= n * Math.ulp(Math.max(y, other.y)) &&
                    Math.abs(z - other.z) <= n * Math.ulp(Math.max(z, other.z));
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Vector) {
            Vector other = (Vector) obj;
            return x == other.x && y == other.y && z == other.z;
        }
        return false;
    }

}

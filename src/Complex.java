class Complex {
    private double x;
    private double y;

    public Complex() {
        this(0, 0);
    }

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return x + (y >= 0 ? "+" : "") + y + "i";
    }

    public Complex add(Complex other) {
        return new Complex(this.x + other.x, this.y + other.y);
    }

    public Complex sub(Complex other) {
        return new Complex(this.x - other.x, this.y - other.y);
    }

    public Complex mul(Complex other) {
        return new Complex(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x);
    }

    public Complex div(Complex other) {
        double denominator = other.x * other.x + other.y * other.y;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Complex((this.x * other.x + this.y * other.y) / denominator, (this.y * other.x - this.x * other.y) / denominator);
    }

    public double module() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean equals(Complex other) {
        return this.x == other.x && this.y == other.y;
    }
    public static void main(String[] args) {
        Complex z1 = new Complex(5, 3);
        Complex z2 = new Complex(2, -1);

        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);
        System.out.println("z1 + z2 = " + z1.add(z2));
        System.out.println("z1 - z2 = " + z1.sub(z2));
        System.out.println("z1 * z2 = " + z1.mul(z2));
        System.out.println("z1 / z2 = " + z1.div(z2));
        System.out.println("|z1| = " + z1.module());
        System.out.println("z1 equals z2: " + z1.equals(z2));

        Complex z3 = new Complex(5,3);
        System.out.println("z1 equals z3: " + z1.equals(z3));

        Complex z4 = new Complex(0,0);
        System.out.println("z4 = "+z4);
        try{
            System.out.println("z1 / z4 = " + z1.div(z4));
        } catch (ArithmeticException e){
            System.out.println("Ошибка: "+e.getMessage());
        }
    }
}
}



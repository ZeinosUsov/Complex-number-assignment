class Complex {
    private double x; // Вещественная часть
    private double y; // Мнимая часть

    // Конструктор без параметров
    public Complex() {
        this(0, 0); // Вызов перегруженного конструктора
    }

    // Перегруженный конструктор
    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры и сеттеры
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

    // Метод toString()
    @Override
    public String toString() {
        if (y == 0) {
            return String.valueOf(x);
        } else if (y > 0) {
            return x + "+" + y + "i";
        } else {
            return x + "" + y + "i";
        }
    }

    // Метод сложения
    public Complex add(Complex other) {
        return new Complex(this.x + other.x, this.y + other.y);
    }

    // Метод вычитания
    public Complex sub(Complex other) {
        return new Complex(this.x - other.x, this.y - other.y);
    }

    // Метод умножения
    public Complex mul(Complex other) {
        return new Complex(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x);
    }

    // Метод деления
    public Complex div(Complex other) {
        double denominator = other.x * other.x + other.y * other.y;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Complex((this.x * other.x + this.y * other.y) / denominator, (this.y * other.x - this.x * other.y) / denominator);
    }

    // Метод для нахождения модуля
    public double module() {
        return Math.sqrt(x * x + y * y);
    }

    // Метод сравнения
    public boolean equals(Complex other) {
        return this.x == other.x && this.y == other.y;
    }


    public static void main(String[] args) {
        Complex c1 = new Complex(5, 3);
        Complex c2 = new Complex(2, -1);

        System.out.println("c1: " + c1); // 5+3i
        System.out.println("c2: " + c2); // 2-1i
        System.out.println("c1 + c2: " + c1.add(c2)); // 7+2i
        System.out.println("c1 - c2: " + c1.sub(c2)); // 3+4i
        System.out.println("c1 * c2: " + c1.mul(c2)); // 13+1i
        System.out.println("c1 / c2: " + c1.div(c2)); // 1.0+2.0i
        System.out.println("|c1|: " + c1.module()); // 5.830951894845301
        System.out.println("c1 == c2: " + c1.equals(c2)); // false

        Complex c3 = new Complex(5,3);
        System.out.println("c1 == c3: " + c1.equals(c3)); //true

        //Пример деления на ноль
        Complex c4 = new Complex(0,0);
        try{
            System.out.println("c1/c4: " + c1.div(c4));
        } catch (ArithmeticException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}



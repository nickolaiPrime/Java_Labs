public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction sum(Fraction other) {
        return new Fraction(this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator);
    }

    public Fraction sum(int integer) { return sum(new Fraction(integer, 1)); }

    public Fraction minus(Fraction other) {
        return new Fraction(this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator);
    }

    public Fraction minus(int integer) { return minus(new Fraction(integer, 1)); }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction multiply(int integer) { return multiply(new Fraction(integer, 1)); }

    public Fraction div(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction div(int integer) { return div(new Fraction(integer, 1)); }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
package homework2;

public class Triangular extends Shape {

   private Point a;
   private Point b;
   private Point c;

    public Triangular(Point a, Point b, Point c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangular(){
        super();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public double getPerimetr() {
        return (dist(a, b) + dist(b, c) + dist(a, c));
    }

    @Override
    public double getArea() {
        double hP = this.getPerimetr() / 2;
        return Math.sqrt(hP * (hP - dist(a, b))
                * (hP - dist(b, c)) * (hP - dist(a, c)));
    }

    @Override
    public String toString() {
        return "Triangular{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

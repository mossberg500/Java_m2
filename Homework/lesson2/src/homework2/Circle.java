package homework2;

public class Circle extends Shape {
    private Point o;
    private Point pR;

    public Circle(Point o, Point pR) {
        this.o = o;
        this.pR = pR;
    }

    public Circle(){
        super();
    }

    public Point getO() {
        return o;
    }

    public void setO(Point o) {
        this.o = o;
    }

    public Point getpR() {
        return pR;
    }

    public void setpR(Point pR) {
        this.pR = pR;
    }

    @Override
    public double getPerimetr() {
        return (2*Math.PI*dist(pR,o));
    }

    @Override
    public double getArea() {
        return (Math.PI*dist(pR,o)*dist(pR,o));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "o=" + o +
                ", pR=" + pR +
                '}';
    }
}

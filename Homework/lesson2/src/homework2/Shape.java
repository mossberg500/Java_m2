package homework2;

public abstract class Shape {

    abstract double getPerimetr();

    abstract double getArea();

    // calculating the distance between two points
    protected double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
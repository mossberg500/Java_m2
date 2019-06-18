package homework2;

public class Main {
    public static void main(String[] args) {


        Point a1 = new Point(1, 1);
        Point a2 = new Point(1, 3);
        Point a3 = new Point(6, 3);
        Point a4 = new Point(6, 1);


        Circle cr = new Circle(a1, a3);
        Shape sh = cr;
        System.out.println(sh.getArea());
        System.out.println(sh.getPerimetr());

        Rectangle rt = new Rectangle(a1, a2, a3, a4);
        sh = rt;
        System.out.println(sh.getArea());
        System.out.println(sh.getPerimetr());


        Triangular ta = new Triangular(a1, a2, a3);
        sh = ta;
        System.out.println(sh.getArea());
        System.out.println(sh.getPerimetr());

        System.out.println("-------------------");
        Board bd = new Board();
        System.out.println(bd.toString());
        bd.setFigureOnBoard(rt,3);
        System.out.println(bd.toString());
        System.out.println("-------------------");
        bd.setFigureOnBoard(cr,1);
        bd.setFigureOnBoard(ta,2);
        System.out.println(bd.toString());
        System.out.println("-------------------");
        bd.getFigureFromBoard(3);
        System.out.println(bd.toString());




    }
}

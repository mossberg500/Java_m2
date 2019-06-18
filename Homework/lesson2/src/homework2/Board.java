package homework2;

import java.util.Arrays;


public class Board {
    Shape[] figure = new  Shape[4];

    public Board(Shape[] figure) {
        super();
        this.figure = figure;
    }
    public Board(){
        super();
    }

    //Method of adding a figure to the board in the pos position.
    public void setFigureOnBoard(Shape shape, int pos){
        if (pos > 4 || pos < 1){
            System.out.println(" Invalid position on board");
        }
        else {
            figure[pos - 1] = shape;
            System.out.println(" A figure has been added to the board  "+ figure[pos-1].toString());
        }
    }
    //Method of removing a figure from the board by the specified pos area
    public void getFigureFromBoard(int pos){
        if (pos > 4 || pos < 1){
            System.out.println(" Invalid position on board");
        } else if(this.figure[pos-1] == null) {
            System.out.println(" The position on the board is empty, please choose another");
        }
        else {
            System.out.println(" Specified part of the board has been released "+ figure[pos-1].toString());
            figure[pos-1] = null;
        }


    }
    //Method of obtaining the area
    public double getSquareFigures() {
        double sum =0;
        for (int x = 0; x <4; x++){
            if(figure[x] == null)
                sum += 0;
            if (figure[x] != null)
            sum += figure[x].getArea();
        }
        return sum;

    }


    @Override
    public String toString() {

        return "Board condition ----{" +
                "figure=" + Arrays.toString(figure) +'}'+
                " ---- Full square Board = "+ getSquareFigures();

    }




}

package model;
import model.Direction.Orientation;
import model.Direction.Turn;

public class Coordinate {

    public static final int X_LOWER_LIMIT = 0;
    public static final int X_UPPER_LIMIT = 4;
    public static final int Y_LOWER_LIMIT = 0;
    public static final int Y_UPPER_LIMIT = 4;

    private int x;
    private int y;
    private Orientation orientation;

    public Coordinate(int x, int y,Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean withInRange(){
        return x >= X_LOWER_LIMIT && x <= X_UPPER_LIMIT &&
                y >= Y_LOWER_LIMIT && y <= Y_UPPER_LIMIT;
    }

    public boolean xInRange(){
        return x > X_LOWER_LIMIT && x < X_UPPER_LIMIT;
    }

    public boolean yInRange(){
        return y > Y_LOWER_LIMIT && y < Y_UPPER_LIMIT;
    }


    public boolean xPlus(){
        if(xInRange()){
            this.x ++;
            return true;
        }
        return false;
    }

    public boolean xMinus(){
        if(xInRange()){
            this.x --;
            return true;
        }
        return false;
    }

    public boolean yPlus(){
        if(yInRange()){
            this.y ++;
            return true;
        }
        return false;
    }

    public boolean yMinus(){
        if(yInRange()){
            this.y --;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }


}

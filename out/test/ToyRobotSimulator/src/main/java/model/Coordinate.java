package main.java.model;
import main.java.model.Direction.Orientation;

public class Coordinate {

    private static final int X_LOWER_LIMIT = 0;
    private static final int X_UPPER_LIMIT = 4;
    private static final int Y_LOWER_LIMIT = 0;
    private static final int Y_UPPER_LIMIT = 4;

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

    public int getY() {
        return y;
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

    public boolean xPlus(){
        if(x >= X_LOWER_LIMIT && x < X_UPPER_LIMIT){
            this.x ++;
            return true;
        }
        return false;
    }

    public boolean xMinus(){
        if(x > X_LOWER_LIMIT && x <= X_UPPER_LIMIT){
            this.x --;
            return true;
        }
        return false;
    }

    public boolean yPlus(){
        if(y >= Y_LOWER_LIMIT && y < Y_UPPER_LIMIT){
            this.y ++;
            return true;
        }
        return false;
    }

    public boolean yMinus(){
        if(y > Y_LOWER_LIMIT && y <= Y_UPPER_LIMIT){
            this.y --;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Current location X = %d, Y = %d, F = %s", x,y,orientation);
    }


}

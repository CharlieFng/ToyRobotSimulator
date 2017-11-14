package model;
import model.Direction.Orientation;
import model.Direction.Turn;

public class Robot {

    private Coordinate coordinate;

    public boolean place(Coordinate coordinate){

        if(coordinate.withInRange()){
            this.coordinate = coordinate;
            return true;
        }else{
            return false;
        }
    }

    public boolean move(){
        switch (coordinate.getOrientation()) {
            case EAST:
                return coordinate.xPlus();
            case WEST:
                return coordinate.xMinus();
            case NORTH:
                return coordinate.yPlus();
            case SOUTH:
                return coordinate.yMinus();
            default:
                return false;
        }

    }

    public boolean turnTo(Turn turn){
        coordinate.setOrientation(coordinate.getOrientation().turnTo(turn));
        return true;
    }

    public boolean report(){
        System.out.println(coordinate);
        return true;
    }


}

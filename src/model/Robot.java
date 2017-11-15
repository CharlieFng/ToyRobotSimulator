package model;
import model.Direction.Turn;

public class Robot {

    private Coordinate coordinate;

    public boolean place(Coordinate coordinate){
        if(coordinate.withInRange()){
            this.coordinate = coordinate;
            return true;
        }else{
            this.coordinate = null;
            return false;
        }
    }

    public boolean move(){
        if(coordinate == null) return false;
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
        if(coordinate == null) return false;
        coordinate.setOrientation(coordinate.getOrientation().turnTo(turn));
        return true;
    }

    public void report(){
        if(coordinate == null){
            System.out.println("I'm not born yet");
        }else{
            System.out.println(coordinate);
        }
    }

}

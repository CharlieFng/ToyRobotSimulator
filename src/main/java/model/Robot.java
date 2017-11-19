package model;
import model.Direction.Turn;

/**
 * The Robot class defines the properties hold by robot, and a bunch of valid behaviours that robot can take.
 */
public class Robot {

    /**
     * Property that determine the location of robot, which consist of X-axis, Y-axis and Orientation.
     */
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Place the robot in the location based on the given coordinate, if the coordinate is out of bounds, then ignore it.
     * @param coordinate
     * @return
     */
    public boolean place(Coordinate coordinate){
        if(coordinate.withInRange()){
            this.coordinate = coordinate;
            return true;
        }else{
            this.coordinate = null;
            return false;
        }
    }

    /**
     * Move the robot one unit forward in the direction it is currently facing. If the move will cause robot out of bound,
     * then ignore it.
     * @return
     */
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

    /**
     * Rotate the robot 90 degrees( left or right ) in the specified direction without changing the position of the robot.
     * If robot hasn't been placed, then ignore it.
     * @param turn
     * @return
     */
    public boolean turnTo(Turn turn){
        if(coordinate == null) return false;
        coordinate.setOrientation(coordinate.getOrientation().turnTo(turn));
        return true;
    }

    /**
     * Announce the location of robot.
     */
    public String report(){
        if(coordinate != null) return String.format("Current Location: %s", coordinate.toString());
        return "I have not been placed";
    }

}

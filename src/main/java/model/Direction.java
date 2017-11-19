package model;
import static model.Direction.Turn.RIGHT;

/**
 * The Direction defines the direction(Orientation) that robot can face towards, and the direction(Turn) that robot can rotate,
 */
public class Direction {

    public enum Orientation {

        NORTH, EAST, SOUTH, WEST;

        private static Orientation[] orientations= values();

        /**
         * Calculate the next Orientation after turn 90 degrees from current Orientation.
         * @param turn
         * @return
         */
        Orientation turnTo(Turn turn) {
            return  orientations[(4 + this.ordinal() + (turn == RIGHT ? 1 : -1)) % 4];
        }

    }

    public enum Turn {
        LEFT, RIGHT
    }

}

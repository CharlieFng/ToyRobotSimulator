package main.java.model;

import static main.java.model.Direction.Turn.RIGHT;

public class Direction {

    public enum Orientation {

        NORTH, EAST, SOUTH, WEST;

        private static Orientation[] orientations= values();

        Orientation turnTo(Turn turn) {
            return  orientations[(4 + this.ordinal() + (turn == RIGHT ? 1 : -1)) % 4];
        }

    }

    public enum Turn {
        LEFT, RIGHT
    }

}

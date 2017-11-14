package model;

import static model.Direction.Turn.RIGHT;

public class Direction {

    public enum Orientation {

        NORTH, EAST, SOUTH, WEST;

        private static Orientation[] vals = values();

        Orientation turnTo(Turn turn) {
            return vals[(4 + this.ordinal() + (turn == RIGHT ? 1 : -1)) % 4];
        }

    }

    public enum Turn {
        LEFT, RIGHT
    }
}

import model.Coordinate
import model.Direction.Orientation
import model.Direction.Turn
import model.Robot
import spock.lang.Specification
import spock.lang.Unroll

class UnitTest extends Specification {

    Robot robot

    def setup() {
        robot = new Robot()
    }

    @Unroll
    def "#source turn #turn to #target"() {

        Orientation sourceOri, targetOri
        Turn turnTo

        given:
        sourceOri = Orientation.valueOf(source)
        targetOri = Orientation.valueOf(target)
        turnTo = Turn.valueOf(turn)

        expect:

        sourceOri.turnTo(turnTo) == targetOri
        where:
        source  | turn    || target
        'NORTH' | 'LEFT'  || 'WEST'
        'NORTH' | 'RIGHT' || 'EAST'
        'SOUTH' | 'LEFT'  || 'EAST'
        'SOUTH' | 'RIGHT' || 'WEST'
        'WEST'  | 'LEFT'  || 'SOUTH'
        'WEST'  | 'RIGHT' || 'NORTH'
        'EAST'  | 'LEFT'  || 'NORTH'
        'EAST'  | 'RIGHT' || 'SOUTH'
    }

    @Unroll
    def "initialize Robot with (#X,#Y,#F) is #res"() {

        given:
        Coordinate coo = new Coordinate(X, Y, Orientation.valueOf(F))

        expect:
        robot.place(coo) == res

        where:
        X  | Y | F       || res
        2  | 2 | 'NORTH' || true
        4  | 0 | 'SOUTH' || true
        -1 | 3 | 'WEST'  || false
        6  | 5 | 'EAST'  || false

    }

    @Unroll
    def "from (#X1, #Y1, #F1) move one step to (#X2, #Y2, #F2)"() {

        given:
        Coordinate coo = new Coordinate(X1, Y1, Orientation.valueOf(F1))
        robot.place(coo)
        robot.move()

        expect:
        robot.getCoordinate().getX() == X2
        robot.getCoordinate().getY() == Y2
        robot.getCoordinate().getOrientation().toString().equals(F2)

        where:
        X1 | Y1 | F1      | X2 | Y2 | F2
        1  | 1  | 'NORTH' | 1  | 2  | 'NORTH'
        2  | 3  | 'SOUTH' | 2  | 2  | 'SOUTH'
        4  | 4  | 'WEST'  | 3  | 4  | 'WEST'
        3  | 0  | 'EAST'  | 4  | 0  | 'EAST'
        3  | 0  | 'SOUTH' | 3  | 0  | 'SOUTH'
        3  | 4  | 'NORTH' | 3  | 4  | 'NORTH'
        0  | 4  | 'WEST'  | 0  | 4  | 'WEST'
        4  | 4  | 'EAST'  | 4  | 4  | 'EAST'

    }

}
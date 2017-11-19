import Simulator
import spock.lang.Specification
import spock.lang.Unroll

class IntegrationTest extends Specification {

    Simulator simulator

    def setup() {
        simulator = new Simulator()
    }

    @Unroll
    def "load file from #path and execute, robot is at (#X, #Y, #F)"() {

        given:
        simulator.execute(path)

        expect:
        simulator.getRobot().getCoordinate().getX() == X
        simulator.getRobot().getCoordinate().getY() == Y
        simulator.getRobot().getCoordinate().getOrientation().toString() == F

        simulator.getRobot().report() == report


        where:
        path                     | X | Y | F       | report
        'src/test/data/ExampleA' | 0 | 1 | 'NORTH' | "Current Location: X = 0, Y = 1, F = NORTH"
        'src/test/data/ExampleB' | 0 | 0 | 'WEST'  | "Current Location: X = 0, Y = 0, F = WEST"
        'src/test/data/ExampleC' | 3 | 3 | 'NORTH' | "Current Location: X = 3, Y = 3, F = NORTH"
        'src/test/data/ExampleD' | 4 | 3 | 'SOUTH' | "Current Location: X = 4, Y = 3, F = SOUTH"
        'src/test/data/ExampleE' | 2 | 4 | 'NORTH' | "Current Location: X = 2, Y = 4, F = NORTH"

    }
}

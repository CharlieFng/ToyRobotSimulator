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


        where:
        path                     | X | Y | F
        'src/test/data/ExampleA' | 0 | 1 | 'NORTH'
        'src/test/data/ExampleB' | 0 | 0 | 'WEST'
        'src/test/data/ExampleC' | 3 | 3 | 'NORTH'
        'src/test/data/ExampleD' | 4 | 3 | 'SOUTH'
        'src/test/data/ExampleE' | 2 | 4 | 'NORTH'

    }
}

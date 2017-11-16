package test.groovy

import main.java.Simulator
import spock.lang.Specification
import spock.lang.Unroll

class IntegrationTest extends Specification {

    Simulator simulator

    def setup(){
        simulator = new Simulator()
    }

    @Unroll
    def "load file from #path and execute, robot is at (#X, #Y, #F)"() {

        given:
        simulator.execute(path)

        expect:
        simulator.robot.getCoordinate().getX() == X
        simulator.robot.getCoordinate().getY() == Y
        simulator.robot.getCoordinate().getOrientation().toString() == F


        where:
        path                       | X | Y | F
        '../../test/data/ExampleA' | 0 | 1 | 'NORTH'
        '../../test/data/ExampleB' | 0 | 0 | 'WEST'
        '../../test/data/ExampleC' | 3 | 3 | 'NORTH'
        '../../test/data/ExampleD' | 4 | 3 | 'SOUTH'

    }
}

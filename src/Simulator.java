import model.Coordinate;
import model.Direction.Turn;
import model.Direction.Orientation;
import model.Robot;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Simulator {

    private Robot robot;


    public Simulator(){
        robot = new Robot();
    }


    public boolean parseCommand(String input){
        String[] tmp = input.split(" ");
        String command = tmp[0];

        switch (command){
            case "PLACE":
                String[] params = tmp[1].split(",");
                Coordinate coordinate = new Coordinate(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Orientation.valueOf(params[2]));
                return robot.place(coordinate);
            case "MOVE":
                return robot.move();
            case "LEFT":
                return robot.turnTo(Turn.valueOf("LEFT"));
            case "RIGHT":
                return robot.turnTo(Turn.valueOf("RIGHT"));
            case "REPORT":
                return robot.report();
            default:
                return false;
        }
    }

    public boolean executeCommandsFromFile(String source) throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource(source).toURI();
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            stream.forEach(this :: parseCommand);
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws URISyntaxException {

        String source = "data/Robcommands1";

        Simulator sim = new Simulator();
        sim.executeCommandsFromFile(source);
    }


}

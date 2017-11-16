package main.java;
import main.java.model.Coordinate;
import main.java.model.Direction.Turn;
import main.java.model.Direction.Orientation;
import main.java.model.Robot;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Simulator {

    public Robot robot;

    public Simulator(){
        robot = new Robot();
    }

    private void parseCommand(String input){

        String command;
        int x = -1; int y = -1;
        Orientation o = null;

        String[] tmp = input.split(" ");
        if(tmp.length > 2 || tmp.length == 0 ) return;
        command = tmp[0];
        if(tmp.length == 2){
            String[] params = tmp[1].split(",");
            if(params.length != 3) return;
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                o = Orientation.valueOf(params[2]);
            }catch (Exception e){
                return;
            }
        }
        switch (command){
            case "PLACE":
                Coordinate coordinate = new Coordinate(x,y,o);
                robot.place(coordinate);
                break;
            case "MOVE":
                robot.move();
                break;
            case "LEFT":
                robot.turnTo(Turn.valueOf("LEFT"));
                break;
            case "RIGHT":
                robot.turnTo(Turn.valueOf("RIGHT"));
                break;
            case "REPORT":
                robot.report();
            default:
                break;
        }
    }

    public void execute(String source) {
        try {
            InputStream in = getClass().getResourceAsStream(source);
            Stream<String> stream = new BufferedReader(new InputStreamReader(in)).lines();
            stream.forEach(this :: parseCommand);
        }catch (Exception e){
            System.out.printf("File '%s' not exist", source);
            System.exit(-1);
        }
    }

    public static void main(String[] args) {

        String source = "../../test.data/ExampleD";
        Simulator sim = new Simulator();
        sim.execute(source);

    }


}

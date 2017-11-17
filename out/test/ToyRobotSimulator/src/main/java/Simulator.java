package main.java;
import main.java.model.Coordinate;
import main.java.model.Direction.Turn;
import main.java.model.Direction.Orientation;
import main.java.model.Robot;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * The Simulator class take 'commands file path' from user input, then apply each single command to the robot, only
 * valid and 'safe' commands will be executed.
 *
 */
public class Simulator {

    private Robot robot;


    public Simulator(){
        robot = new Robot();
    }

    public Robot getRobot() {
        return robot;
    }

    /**
     * Take each single line to parse, only those can be parsed to valid command will be apply to robot.
     * @param input
     */
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

    /**
     * Load 'command file' from given path, if file not exist, then program will exit.
     * @param source
     */
    public void execute(String source) {
        try {
            Stream<String> stream = Files.lines(Paths.get(source));
            stream.forEach(this :: parseCommand);
        }catch (Exception e){
            System.out.printf("File '%s' not exist", source);
            System.exit(-1);
        }
    }

    /**
     * Start the simulator, waiting for user input.
     * @param args
     */
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the absolute path of command file:");
        String filePath = reader.nextLine();
        new Simulator().execute(filePath);

    }


}

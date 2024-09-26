import java.io.IOException;

/**
 * Run in terminal "java Proj1 input.txt"
 * CSV file got rid of the columns condition as it wasn't fully complete for all cars
 */
public class Proj1 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }

        new Parser(args[0]);
    }
}




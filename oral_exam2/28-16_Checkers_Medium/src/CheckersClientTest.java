import javax.swing.*;

/**
 * Main class of checkers client
 * @author Dean Farwell
 */
public class CheckersClientTest {

    /**
     * Main method that creates the GUI and client object
     * @param args Required string of arguments from Java
     */
    public static void main(String[] args) {
        CheckersClient application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new CheckersClient("127.0.0.1"); // localhost
        else
            application = new CheckersClient(args[0]); // use args

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
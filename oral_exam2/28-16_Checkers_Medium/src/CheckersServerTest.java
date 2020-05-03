import javax.swing.*;

/**
 * Creates the server GUI and object
 * @author Dean Farwell
 */
public class CheckersServerTest {

    /**
     * Main method that creates the server
     * @param args String array of arguments required by Java
     */
    public static void main(String[] args) {
        CheckersServer application = new CheckersServer();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.execute();
    }
}

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

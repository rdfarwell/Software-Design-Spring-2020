import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class of the client side for checkers
 */
public class CheckersClient extends JFrame implements Runnable {

    /**
     * Mark for first client
     */
    private final String R_MARK = "R"; // mark for first client

    /**
     * Mark for second client
     */
    private final String B_MARK = "B"; // mark for second client

    /**
     * Textfield to display player's mark
     */
    private JTextField idField; // textfield to display player's mark

    /**
     * TTextArea to display output
     */
    private JTextArea displayArea; // JTextArea to display output

    /**
     * Panel for checker board
     */
    private JPanel boardPanel; // panel for checker board

    /**
     * Panel to hold board
     */
    private JPanel panel2; // panel to hold board

    /**
     * Checker board
     */
    private Square[][] board; // checker board

    /**
     * Current square
     */
    private Square currentSquare; // current square

    /**
     * Last square clicked
     */
    private Square lastSquare;

    /**
     * Connection to server
     */
    private Socket connection; // connection to server

    /**
     * Input from server
     */
    private Scanner input; // input from server

    /**
     * Output to server
     */
    private Formatter output; // output to server

    /**
     * Host name for server
     */
    private String checkerHost; // host name for server

    /**
     * This client's mark
     */
    private String myMark; // this client's mark

    /**
     * Determines which client's turn it is
     */
    private boolean myTurn; // determines which client's turn it is

    /**
     * Mark array for what to draw on the board
     */
    private String[] markArray = new String[64];

    /**
     * Set up user-interface and board
     * @param host Name of the server
     */
    public CheckersClient(String host) {
        checkerHost = host; // set name of server
        displayArea = new JTextArea(4, 30); // set up JTextArea
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        boardPanel = new JPanel(); // set up panel for squares in board
        boardPanel.setLayout(new GridLayout(8, 8, 0, 0));

        board = new Square[8][8]; // create board

        for (int i = 0; i < 64; i++) {
            if (i % 2 == 1) { // odd
                if (i > 7 && i < 16) {
                    markArray[i] = "R";
                }
                else if ((i > 39 && i < 48) || i > 55) {
                        markArray[i] = "B";
                }
                else {
                    markArray[i] = " ";
                }
            }
            else { // even
                if (i < 8 || (i > 15 && i < 24)) {
                    markArray[i] = "R";
                }
                else if (i > 47 && i < 56) {
                    markArray[i] = "B";
                }
                else {
                    if (i == 56) {
                        markArray[i] = "E";
                    }
                    else {
                        markArray[i] = " ";
                    }
                }
            }
        }

        // loop over the rows in the board
        for (int row = 0; row < board.length; row++) {
            // loop over the columns in the board
            for (int column = 0; column < board[row].length; column++) {
                // create square
                board[row][column] = new Square(markArray[row * 8 + column], row * 8 + column);
                boardPanel.add(board[row][column]); // add square
            }
        }

        idField = new JTextField(); // set up textfield
        idField.setEditable(false);
        add(idField, BorderLayout.NORTH);

        panel2 = new JPanel(); // set up panel to contain boardPanel
        panel2.add(boardPanel, BorderLayout.CENTER); // add board panel
        add(panel2, BorderLayout.CENTER); // add container panel

        setSize(300, 400); // set size of window
        setVisible(true); // show window

        startClient();
    }

    /**
     * Start the client thread
     */
    public void startClient() {
        try // connect to server and get streams
        {
            // make connection to server
            connection = new Socket(
                    InetAddress.getByName(checkerHost), 12345);

            // get streams for input and output
            input = new Scanner(connection.getInputStream());
            output = new Formatter(connection.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // create and start worker thread for this client
        ExecutorService worker = Executors.newFixedThreadPool(1);
        worker.execute(this); // execute client
    }

    /**
     * Control thread that allows continuous update of displayArea
     */
    public void run() {
        myMark = input.nextLine(); // get player's mark (X or O)

        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        // display player's mark
                        idField.setText("You are player \"" + myMark + "\"");
                    }
                }
        );

        myTurn = (myMark.equals(R_MARK)); // determine if client's turn

        // receive messages sent to client and output them
        while (true) {
            if (input.hasNextLine())
                processMessage(input.nextLine());
        }
    }

    /**
     * Process messages received by client
     * @param message Message to be interpreted from the server
     */
    private void processMessage(String message) {
        if (message.equals("Opponent ended")) {
            displayMessage("Other Player has ended the game.\n");
        }
        else if (message.equals("Ended")) {
            displayMessage("You ended the game.\n");
        }
        else if (message.equals("Valid move.")) {
            displayMessage("Valid move, please wait.\n");
            setMark(currentSquare, myMark); // set mark in square
            setMark(lastSquare, " ");
        } else if (message.equals("Capture.")) {
            displayMessage("Valid capture, please wait.\n");
            setMark(currentSquare, myMark);
            setMark(lastSquare, " ");
            if (currentSquare.getSquareLocation() == lastSquare.getSquareLocation() + 14) {
                setMark(board[(lastSquare.getSquareLocation() + 7) / 8][(lastSquare.getSquareLocation() + 7) % 8], " ");
            }
            else if (currentSquare.getSquareLocation() == lastSquare.getSquareLocation() + 18) {
                setMark(board[(lastSquare.getSquareLocation() + 9) / 8][(lastSquare.getSquareLocation() + 9) % 8], " ");
            }
            else if (currentSquare.getSquareLocation() == lastSquare.getSquareLocation() - 14) {
                setMark(board[(lastSquare.getSquareLocation() - 7) / 8][(lastSquare.getSquareLocation() - 7) % 8], " ");
            }
            else if (currentSquare.getSquareLocation() == lastSquare.getSquareLocation() - 18) {
                setMark(board[(lastSquare.getSquareLocation() - 9) / 8][(lastSquare.getSquareLocation() - 9) % 8], " ");
            }
            myTurn = true;
        } else if (message.equals("Invalid move, try again")) {
            displayMessage(message + "\n"); // display invalid move
            myTurn = true; // still this client's turn
        } else if (message.equals("Opponent captured")) {
            int newLocation = input.nextInt(); // get move location
            input.nextLine(); // skip newline after int location
            int oldLocation = input.nextInt();
            input.nextLine();
            int capturedLocation = input.nextInt();
            input.nextLine();
            int row = newLocation / 8; // calculate row
            int column = newLocation % 8; // calculate column
            int oldRow = oldLocation / 8;
            int oldColumn = oldLocation % 8;
            int capRow = capturedLocation / 8;
            int capColumn = capturedLocation % 8;

            System.out.println("old: " + oldLocation);
            System.out.println("new: " + newLocation);
            System.out.println("cap: " + capturedLocation);
            System.out.println("cap R: " + capRow);
            System.out.println("cap C: " + capColumn);

            setMark(board[row][column], (myMark.equals(R_MARK) ? B_MARK : R_MARK)); // mark move
            setMark(board[oldRow][oldColumn], " ");
            setMark(board[capRow][capColumn], " ");

            System.out.println("cap: " + board[capRow][capColumn].getMark());

            displayMessage("Opponent captured. Your turn.\n");

            if (myMark.equals(R_MARK) && ((board[(newLocation + 7) / 8][(newLocation + 7) % 8].getMark().equals(B_MARK) && board[(newLocation + 14) / 8][(newLocation + 14) % 8].getMark().equals(" "))
                    || (board[(newLocation + 9) / 8][(newLocation + 9) % 8].getMark().equals(B_MARK) && board[(newLocation + 18) / 8][(newLocation + 18) % 8].getMark().equals(" ")))) {
                myTurn = true;
            }
            else if(myMark.equals(B_MARK) && ((board[(newLocation - 7) / 8][(newLocation - 7) % 8].getMark().equals(B_MARK) && board[(newLocation - 14) / 8][(newLocation - 14) % 8].getMark().equals(" "))
                    || (board[(newLocation - 9) / 8][(newLocation - 9) % 8].getMark().equals(B_MARK) && board[(newLocation - 18) / 8][(newLocation - 18) % 8].getMark().equals(" ")))) {
                myTurn = true;
            }
            else {
                myTurn = false;
            }

            // myTurn = true; // now this client's turn
            //myTurn = false;
        } else if (message.equals("Opponent moved")) {
            int newLocation = input.nextInt(); // get move location
            input.nextLine(); // skip newline after int location
            int oldLocation = input.nextInt();
            input.nextLine();
            System.out.println(newLocation);
            System.out.println(oldLocation);
            int row = newLocation / 8; // calculate row
            int column = newLocation % 8; // calculate column
            int oldRow = oldLocation / 8;
            int oldColumn = oldLocation % 8;
            setMark(board[row][column], (myMark.equals(R_MARK) ? B_MARK : R_MARK)); // mark move
            setMark(board[oldRow][oldColumn], " ");

            System.out.println(board[row][column].getMark());
            System.out.println(board[oldRow][oldColumn].getMark());

            displayMessage("Opponent moved. Your turn.\n");
            myTurn = true; // now this client's turn
        } else
            displayMessage(message + "\n"); // display the message
    }

    /**
     * Manipulate displayArea in event-dispatch thread
     * @param messageToDisplay Message to be displayed
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        displayArea.append(messageToDisplay); // updates output
                    }
                }
        );
    }

    /**
     * Utility method to set mark on board in event-dispatch thread
     * @param squareToMark Square to be updated
     * @param mark Mark to be added to square
     */
    private void setMark(final Square squareToMark, final String mark) { //
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        squareToMark.setMark(mark); // set mark in square
                    }
                }
        );
    }

    /**
     * Send message to server indicating clicked square
     * @param location location of clicked square
     */
    public void sendClickedSquare(int location) {
        // if it is my turn
        if (myTurn) {
            output.format("%d\n", location); // send location to server
            output.flush();
            //myTurn = false; // not my turn any more
        }
    }

    /**
     * Set current Square
     * @param square square that has been clicked
     */
    public void setCurrentSquare(Square square) {
        currentSquare = square; // set current square to argument
    }

    /**
     * Set last square
     * @param square Last square that was clicked
     */
    public void setLastSquare(Square square) {
        lastSquare = square;
    }

    /**
     * Private inner class for the squares on the board
     */
    private class Square extends JPanel {

        /**
         * Mark to be drawn in this square
         */
        private String mark; // mark to be drawn in this square

        /**
         * Location of square
         */
        private int location; // location of square

        /**
         * Constructor of the square
         * @param squareMark Mark to be set for square
         * @param squareLocation Location of the square
         */
        public Square(String squareMark, int squareLocation) {
            mark = squareMark; // set mark for this square
            location = squareLocation; // set location of this square

            addMouseListener(
                    new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {
                            setLastSquare(currentSquare);
                            setCurrentSquare(Square.this); // set current square

                            // send location of this square
                            sendClickedSquare(getSquareLocation());
                        }
                    }
            );
        }

        /**
         * Return preferred size of Square
         * @return Size of the square
         */
        public Dimension getPreferredSize() {
            return new Dimension(30, 30); // return preferred size
        }

        /**
         * Return minimum size of Square
         * @return Preferred size of the square
         */
        public Dimension getMinimumSize() {
            return getPreferredSize(); // return preferred size
        }

        /**
         * Set mark for Square
         * @param newMark Mark to be set to square
         */
        public void setMark(String newMark) {
            mark = newMark; // set mark of square
            repaint(); // repaint square
        }

        /**
         * Gets the square's mark
         * @return The square's mark
         */
        public String getMark() {
            return mark;
        }

        /**
         * Return Square location
         * @return location of the square
         */
        public int getSquareLocation() {
            return location; // return location of square
        }

        /**
         * Draws the Square
         * @param g Graphics element for creating the drawings
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawRect(0, 0, 29, 29); // draw square
            if (mark.equals("R")) { // draw red checker
                g.setColor(Color.red);
                g.fillOval(5, 5, 20, 20);
            }
            else if (mark.equals("B")) { // draw black checker
                g.setColor(Color.black);
                g.fillOval(5, 5, 20, 20);
            }
            else { // draw empty
                g.drawString(mark, 11, 20);
            }
        }
    }
}
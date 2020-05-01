import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckersServer extends JFrame {
    private final static int PLAYER_R = 0; // constant for first player
    private final static int PLAYER_B = 1; // constant for second player
    private final static String[] MARKS = {"R", "B"}; // array of marks
    private String[] board = new String[64]; // tic-tac-toe board
    private JTextArea outputArea; // for outputting moves
    private Player[] players; // array of Players
    private ServerSocket server; // server socket to connect with clients
    private int currentPlayer; // keeps track of player with current move
    private ExecutorService runGame; // will run players
    private Lock gameLock; // to lock game for synchronization
    private Condition otherPlayerConnected; // to wait for other player
    private Condition otherPlayerTurn; // to wait for other player's turn
    private boolean capture;
    private boolean gameOver;

    // set up tic-tac-toe server and GUI that displays messages
    public CheckersServer() {
        super("Checkers Server"); // set title of window

        // create ExecutorService with a thread for each player
        runGame = Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock(); // create lock for game

        // condition variable for both players being connected
        otherPlayerConnected = gameLock.newCondition();

        // condition variable for the other player's turn
        otherPlayerTurn = gameLock.newCondition();

        for (int i = 0; i < 64; i++) {
            if (i % 2 == 1) { // odd
                if (i > 7 && i < 16) {
                    board[i] = "R";
                }
                else if ((i > 39 && i < 48) || i > 55) {
                    board[i] = "B";
                }
                else {
                    board[i] = "";
                }
            }
            else { // even
                if (i < 8 || (i > 15 && i < 24)) {
                    board[i] = "R";
                }
                else if (i > 47 && i < 56) {
                    board[i] = "B";
                }
                else {
                    board[i] = "";
                }
            }
        }
        players = new Player[2]; // create array of players
        currentPlayer = PLAYER_R; // set current player to first player

        try {
            server = new ServerSocket(12345, 2); // set up ServerSocket
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }

        outputArea = new JTextArea(); // create JTextArea for output
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");

        setSize(300, 300); // set size of window
        setVisible(true); // show window
    }

    // wait for two connections so game can be played
    public void execute() {
        // wait for each client to connect
        for (int i = 0; i < players.length; i++) {
            try // wait for connection, create Player, start runnable
            {
                players[i] = new Player(server.accept(), i);
                runGame.execute(players[i]); // execute player runnable
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        gameLock.lock(); // lock game to signal player X's thread

        try {
            players[PLAYER_R].setSuspended(false); // resume player X
            otherPlayerConnected.signal(); // wake up player X's thread
        } finally {
            gameLock.unlock(); // unlock game after signalling player X
        }
    }

    // display message in outputArea
    private void displayMessage(final String messageToDisplay) {
        // display message from event-dispatch thread of execution
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates outputArea
                    {
                        outputArea.append(messageToDisplay); // add message
                    }
                }
        );
    }

    // determine if move is valid
    public boolean validateAndMove(int oldLocation, int newLocation, int player) {
        // while not current player, must wait for turn
        while (player != currentPlayer) {
            gameLock.lock(); // lock game to wait for other player to go

            try {
                otherPlayerTurn.await(); // wait for player's turn
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                gameLock.unlock(); // unlock game after waiting
            }
        }

        // if location not occupied, make move
        if (!isOccupied(newLocation) && validCheckerMove(oldLocation, newLocation)) {
            if (capture) { // (oldLocation, newLocation, currentPlayer) TODO
                int capturedLocation = 0;
                board[newLocation] = MARKS[currentPlayer];
                board[oldLocation] = " ";
                if (currentPlayer == 0) { //R
                    if ((newLocation == (oldLocation + 14))) {
                        capturedLocation = oldLocation + 7;
                        board[oldLocation + 7] = " ";
                    }
                    else {
                        capturedLocation = oldLocation + 9;
                        board[oldLocation + 9] = " ";
                    }
                }
                else if (currentPlayer == 1) { // B
                    if ((newLocation == (oldLocation - 14))) {
                        capturedLocation = oldLocation - 7;
                        board[oldLocation - 7] = " ";
                    }
                    else {
                        capturedLocation = oldLocation - 9;
                        board[oldLocation - 9] = " ";
                    }
                }

                if (currentPlayer == 0 && (!isOccupied(newLocation+14) || !isOccupied(newLocation+18))) {
                    players[(currentPlayer + 1) % 2].otherPlayerCaptured(newLocation, oldLocation, capturedLocation);
                }
                else if(currentPlayer == 1 && (!isOccupied(newLocation-14) || !isOccupied(newLocation-18))) {
                    players[(currentPlayer + 1) % 2].otherPlayerCaptured(newLocation, oldLocation, capturedLocation);
                }
                else {
                    currentPlayer = (currentPlayer + 1) % 2;

                    players[currentPlayer].otherPlayerCaptured(newLocation, oldLocation, capturedLocation);

                    gameLock.lock(); // lock game to signal other player to go

                    try {
                        otherPlayerTurn.signal(); // signal other player to continue
                    } finally {
                        gameLock.unlock(); // unlock game after signaling
                    }
                }
            }
            else {
                board[newLocation] = MARKS[currentPlayer]; // set move on board
                board[oldLocation] = " ";
                currentPlayer = (currentPlayer + 1) % 2; // change player

                // let new current player know that move occurred
                players[currentPlayer].otherPlayerMoved(newLocation, oldLocation);

                gameLock.lock(); // lock game to signal other player to go

                try {
                    otherPlayerTurn.signal(); // signal other player to continue
                } finally {
                    gameLock.unlock(); // unlock game after signaling
                }
            }

            return true; // notify player that move was valid
        }
        else // move was not valid
            return false; // notify player that move was invalid
    }

    // determine whether location is occupied
    public boolean isOccupied(int location) {
        if (board[location].equals(MARKS[PLAYER_R]) || board[location].equals(MARKS[PLAYER_B])) {
            return true; // location is occupied
        }
        else {
            return false; // location is not occupied
        }
    }

    public boolean validCheckerMove(int oldLocation, int newLocation) {
        boolean validSpace;
        if ((newLocation % 2 == 1) && ((newLocation > 7 && newLocation < 16) || (newLocation > 23 && newLocation < 32) || (newLocation > 39 && newLocation < 48) || newLocation > 55)) { // odd spaces
            validSpace = true;
        }
        else if ((newLocation % 2 == 0) && (newLocation < 8 || (newLocation > 15 && newLocation < 24) || (newLocation > 31 && newLocation < 40) || (newLocation > 47 && newLocation < 56))) { // even
            validSpace = true;
        }
        else {
            validSpace = false;
        }

        if (validSpace) {
            capture = capture(oldLocation, newLocation, currentPlayer);
        }

        if (validSpace) {
            if (currentPlayer == 0) {// R
                if ((newLocation == (oldLocation + 7)) || (newLocation == (oldLocation + 9))) {
                    validSpace = true;
                }
                else {
                    validSpace = false;
                }
            }
            else if (currentPlayer == 1) { // B
                if ((newLocation == (oldLocation - 7)) || (newLocation == (oldLocation - 9))) {
                    validSpace = true;
                }
                else {
                    validSpace = false;
                }
            }
        }

        return (validSpace || capture);
    }

    public boolean capture(int oldLocation, int newLocation, int curPlayer) {
        boolean capture = false;

        if (curPlayer == 0) { // R
            capture = ((newLocation == (oldLocation + 14)) && (board[oldLocation + 7].equals("B"))) || ((newLocation == (oldLocation + 18)) && board[oldLocation + 9].equals("B"));
        }
        else if (curPlayer == 1) { // B
            capture = ((newLocation == (oldLocation - 14)) && (board[oldLocation - 7].equals("R"))) || ((newLocation == (oldLocation - 18)) && board[oldLocation - 9].equals("R"));
        }
        System.out.println(curPlayer);
        System.out.println(capture);

        return capture;
    }

    // place code in this method to determine whether game over
    public boolean isGameOver() {
        return gameOver; // this is left as an exercise
    }

    // private inner class Player manages each Player as a runnable
    private class Player implements Runnable {
        private Socket connection; // connection to client
        private Scanner input; // input from client
        private Formatter output; // output to client
        private int playerNumber; // tracks which player this is
        private String mark; // mark for this player
        private boolean suspended = true; // whether thread is suspended

        // set up Player thread
        public Player(Socket socket, int number) {
            playerNumber = number; // store this player's number
            mark = MARKS[playerNumber]; // specify player's mark
            connection = socket; // store socket for client

            try // obtain streams from Socket
            {
                input = new Scanner(connection.getInputStream());
                output = new Formatter(connection.getOutputStream());
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        // send message that other player moved
        public void otherPlayerMoved(int newLocation, int oldLocation) {
            output.format("Opponent moved\n");
            output.format("%d\n", newLocation); // send location of move
            output.format("%d\n", oldLocation);
            output.flush(); // flush output
        }

        public void otherPlayerCaptured(int newLocation, int oldLocation, int capturedLocation) {
            output.format("Opponent captured\n");
            output.format("%d\n", newLocation); // send location of move
            output.format("%d\n", oldLocation);
            output.format("%d\n", capturedLocation);
            output.flush(); // flush output
        }

        // control thread's execution
        public void run() {
            // send client its mark (X or O), process messages from client
            try {
                displayMessage("Player " + mark + " connected\n");
                output.format("%s\n", mark); // send player's mark
                output.flush(); // flush output

                // if player X, wait for another player to arrive
                if (playerNumber == PLAYER_R) {
                    output.format("%s\n%s", "Player X connected",
                            "Waiting for another player\n");
                    output.flush(); // flush output

                    gameLock.lock(); // lock game to  wait for second player

                    try {
                        while (suspended) {
                            otherPlayerConnected.await(); // wait for player O
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    } finally {
                        gameLock.unlock(); // unlock game after second player
                    }

                    // send message that other player connected
                    output.format("Other player connected. Your move.\n");
                    output.flush(); // flush output
                } else {
                    output.format("Player B connected, please wait\n");
                    output.flush(); // flush output
                }

                // while game not over
                while (!isGameOver()) {
                    int location = 0; // initialize move location
                    int location2 = 0;
                    int locCount = 0;

                    while (locCount < 2) { // used to be if
                        if (input.hasNext()) {
                            if (locCount == 0) {
                                location = input.nextInt(); // get move location
                                System.out.println(location);
                                locCount++;
                            }
                            else {
                                location2 = input.nextInt();
                                System.out.println(location2);
                                locCount++;
                            }
                        }
                    }

                    if (location == 56) {
                        displayMessage("Player " + MARKS[currentPlayer] + " has ended the game");
                        gameOver = true;
                        output.format("Ended");
                        output.flush();
                    }
                    else if (board[location].equals(MARKS[currentPlayer]) && !isOccupied(location2)) {
                        if (validateAndMove(location, location2, playerNumber)) {
                            if (capture) { // (location, location2, (currentPlayer + 1) % 2) TODO
                                displayMessage("\nFrom location: " + location);
                                displayMessage("\nTo location: " + location2);
                                displayMessage("\nPiece captured");
                                output.format("Capture.\n"); // notify client
                                output.flush(); // flush output
                            }
                            else {
                                displayMessage("\nFrom location: " + location);
                                displayMessage("\nTo location: " + location2);
                                output.format("Valid move.\n"); // notify client
                                output.flush(); // flush output
                            }
                        }
                        else { // move was invalid
                            output.format("Invalid move, try again\n");
                            output.flush(); // flush output
                        }
                    }
                    else {
                        output.format("Invalid move, try again\n");
                        output.flush(); // flush output
                    }
                }
            } finally {
                try {
                    connection.close(); // close connection to client
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.exit(1);
                }
            }
        }

        // set whether or not thread is suspended
        public void setSuspended(boolean status) {
            suspended = status; // set value of suspended
        }
    }
}
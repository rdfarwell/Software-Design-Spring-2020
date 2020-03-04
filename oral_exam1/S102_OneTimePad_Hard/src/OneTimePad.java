import java.io.IOException;
import java.util.Scanner;

/**
 *  Main class that contains the menu for the user to select if they want to generate a key file, encrypt a message,
 *  or decrypt a message.
 *
 * @author Dean Farwell
 * @version 1.2
 * @since 2020-02-16
 */
public class OneTimePad {
    /**
     * Character array of an all caps alphabet used by the encryptor and decryptor
     */
    public static final char[] ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * Main method that gives the user three options, then calls and passes input to a chosen class when selected
     * @param argv Array of Strings, standard for main method of Java programs
     * @throws IOException Thrown if there are any issues with reading or writing to a file
     */
    public static void main(String[] argv) throws IOException {

        Scanner scnr = new Scanner(System.in);
        String message = "", keyFileLocation = "", messageFileLocation = "";
        int choice = 0, input = 0;

        while (choice == 0) { // menu for user to select what they want to do, loops until a valid choice is selected
            System.out.println("Encryption Program, Please choose an option");
            System.out.println("1: Generate new key file");
            System.out.println("2: Encrypt a message");
            System.out.println("3: Decrypt a message");
            System.out.println("4: Exit");

            try { // uses String (nextLine) casted to Integer to avoid a  bug found when not taking in all end-line characters
                choice = Integer.parseInt(scnr.nextLine());
            }
            catch (NumberFormatException notInt) { // if the entry isn't an int, it just sets choice to zero
                choice = 0;
            }

            if (choice == 1) { //generate key file
                System.out.println("Please enter an integer for the number of keys you would like:");
                try { // uses String (nextLine) casted to Integer to avoid a  bug found when not taking in all end-line characters
                    input = Integer.parseInt(scnr.nextLine());
                    KeyGenerator.generator(input);
                }
                catch (NumberFormatException notInt) { // if the entry isn't an int, it just sets choice to zero
                    System.out.println("Not an Integer");
                }
                choice = 0;
            }

            else if (choice == 2) { // encrypt
                System.out.println("Please enter the location of the key file:");
                keyFileLocation = scnr.nextLine();
                System.out.println("Please enter your message:");
                message = scnr.nextLine();
                Encrypt.encryptor(keyFileLocation, message.toUpperCase());
                choice = 0;
            }

            else if (choice == 3) { // decrypt
                System.out.println("Please enter the location of the key file:");
                keyFileLocation = scnr.nextLine();
                System.out.println("Please enter the location of the encrypted message file:");
                messageFileLocation = scnr.nextLine();
                message = Decrypt.decryptor(keyFileLocation, messageFileLocation);
                System.out.println("Decrypted Message: " + message);
                choice = 0;
            }

            else if (choice != 4) { // if the entry isn't one of the three options, set to 0 (loop condition)
                choice = 0;
            }
        }


    }
}
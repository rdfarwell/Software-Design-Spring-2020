import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.Scanner;

public class OneTimePad {
    public static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] argv) throws IOException {

        Scanner scnr = new Scanner(System.in);
        String message = "", keyFileLocation = "", messageFileLocation = "";
        int choice = 0;

        while (choice == 0) {
            System.out.println("Encryption Program, Please choose an option");
            System.out.println("1: Generate new key file");
            System.out.println("2: Encrypt a message");
            System.out.println("3: Decrypt a message");

            choice = scnr.nextInt();

            if (choice != 1 && choice != 2 && choice != 3) {
                choice = 0;
            }
        }

        if (choice == 1) {
            System.out.println("Please enter an integer for the number of keys you would like:");
            System.out.println("Please enter the max of the range you would like your keys to fall between:");
            KeyGenerator.generator(scnr.nextInt(), scnr.nextInt());
        }

        else if (choice == 2) {
            System.out.println("Please enter the location of the key file:");
            keyFileLocation = scnr.next();
            System.out.println("Please enter your message:");
            message = scnr.next();
            Encrypt.encryptor(keyFileLocation, message.toUpperCase());
        }

        else if (choice == 3) {
            System.out.println("Please enter the location of the key file:");
            keyFileLocation = scnr.next();
            System.out.println("Please enter the location of the encrypted message file:");
            messageFileLocation = scnr.next();
            message = Decrypt.decryptor(keyFileLocation, messageFileLocation);
            System.out.println("Decrypted Message: " + message);
        }








        //message = scnr.nextLine();
        //message = message.toUpperCase();



        //System.out.println(altMessage);

    }


}

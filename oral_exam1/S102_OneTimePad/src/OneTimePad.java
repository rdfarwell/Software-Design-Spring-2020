import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OneTimePad {
    public static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] argv) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String keyFromFile = "", message = "", altMessage = "", keyToInt = "";
        boolean changed = false;
        int key, keystart = -1, k = 0, n = 0;
        int[] keyArray = new int[100];
        char[] readIn = new char[100];
        Arrays.fill(readIn, 'z');

        FileReader file = null; // create FileReader to read in key file
        try {
            file = new FileReader("oral_exam1/S102_OneTimePad/src/key.txt");
        }
        catch (FileNotFoundException notFound) {
            System.out.println("File not found");
        }

        file.read(readIn); // reads in an array of characters from the file

        for (char c : readIn) { // converts the characters into a string
            if(c != 'z') {
                keyFromFile = keyFromFile + c;
            }
        }

        for (int a = 0; a < keyFromFile.length(); a++) {
            if (keyFromFile.charAt(a) == ',' || keyFromFile.charAt(a) == '\n') {
                try {
                    if (keystart == -1) {
                        keystart = Integer.parseInt(keyToInt.trim());
                        keyToInt = "";
                    }
                    else {
                        //System.out.println(keyToInt);
                        keyArray[k] = Integer.parseInt(keyToInt.trim());
                        keyToInt = "";
                        k++;
                    }
                }
                catch (NumberFormatException formatIssue) {
                    System.out.println("Error converting keys in file to type int");
                }
            }
            else {
                keyToInt += keyFromFile.charAt(a);
            }
        }

        message = scnr.nextLine();
        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);
            changed = false;

            for (int x = 0; x < alphabet.length; x++) {
                if (alt == alphabet[x]) {
                    key = keyArray[n] % 26;
                    n++;
                    changed = true;
                    if ((x + key) > 26) {
                        altMessage = altMessage + alphabet[x + key - 26];
                    }
                    else {
                        altMessage = altMessage + alphabet[x + key];
                    }
                }
            }

            if (!changed) {
                altMessage = altMessage + alt;
            }
        }

        System.out.println(altMessage);

    }


}

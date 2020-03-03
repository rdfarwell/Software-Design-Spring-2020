import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 */
public class ReadKeyFile {
    private int[] keyArray = new int[100];
    private int keyStart = -1;
    private int length = 0;

    /**
     * Getter for the integer array of keys
     * @return An array of integers containing all keys of a file
     */
    public int[] getKeyArray() {
        return keyArray;
    }

    /**
     * Getter for the key start position
     * @return An integer that is the starting position from the key file
     */
    public int getKeyStart() {
        return keyStart;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * Method that reads in a key file and sets the parameters of the key object
     * @param fileName The name of the file that is given by the user, used to open and read the given file
     * @throws IOException Thrown if there are issues opening the file
     */
    public ReadKeyFile(String fileName) throws IOException {
        String keyFromFile = "", keyToInt = "";
        int k = 0;
        char[] readIn = new char[100];
        Arrays.fill(readIn, 'z');

        FileReader file = null; // create FileReader to read in key file
        try {
            file = new FileReader(fileName);
        }
        catch (FileNotFoundException notFound) {
            System.out.println("File not found");
        }

        file.read(readIn); // reads in an array of characters from the file and stores them in readIn

        for (char c : readIn) { // converts the characters into a string
            if(c != 'z') {
                keyFromFile = keyFromFile + c;
            }
        }

        for (int a = 0; a < keyFromFile.length(); a++) {
            if (keyFromFile.charAt(a) == ',' || keyFromFile.charAt(a) == '\n') {
                try {
                    if (keyStart == -1) { // checks if keystart has been assigned yet, as it is the first thing that should appear in the file
                        keyStart = Integer.parseInt(keyToInt.trim());
                        keyToInt = "";
                    }
                    else { // once there is a comma or endline, that means the key is built and needs to be converted
                        keyArray[k] = Integer.parseInt(keyToInt.trim());
                        keyToInt = ""; // resets the key save string as the current key has been saved and a new one must be constructed
                        k++;
                        length++;
                    }
                }
                catch (NumberFormatException formatIssue) { // catches any issues with the keys not being a number
                    System.out.println("Error converting keys in file to type int");
                }
            }
            else { // adds the next character to a String as a key can be multiple characters (Ex: 34)
                keyToInt += keyFromFile.charAt(a);
            }
        }
    }
}

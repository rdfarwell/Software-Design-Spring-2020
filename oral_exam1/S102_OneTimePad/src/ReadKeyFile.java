import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadKeyFile {

    private int[] keyArray = new int[100];
    private int keyStart = -1;
    private int length = 0;

    public int[] getKeyArray() {
        return keyArray;
    }

    public int getKeyStart() {
        return keyStart;
    }

    public int getLength() {
        return length;
    }

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

        file.read(readIn); // reads in an array of characters from the file

        for (char c : readIn) { // converts the characters into a string
            if(c != 'z') {
                keyFromFile = keyFromFile + c;
            }
        }

        for (int a = 0; a < keyFromFile.length(); a++) {
            if (keyFromFile.charAt(a) == ',' || keyFromFile.charAt(a) == '\n') {
                try {
                    if (keyStart == -1) {
                        keyStart = Integer.parseInt(keyToInt.trim());
                        keyToInt = "";
                    }
                    else {
                        keyArray[k] = Integer.parseInt(keyToInt.trim());
                        keyToInt = "";
                        k++;
                    }
                    length++;
                }
                catch (NumberFormatException formatIssue) {
                    System.out.println("Error converting keys in file to type int");
                }
            }
            else {
                keyToInt += keyFromFile.charAt(a);
            }
        }
    }
}

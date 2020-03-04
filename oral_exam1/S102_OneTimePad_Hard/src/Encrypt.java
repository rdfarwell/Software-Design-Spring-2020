import java.io.FileWriter;
import java.io.IOException;

/**
 * This class contains the encryptor function that takes in a message and key file and creates a new file containing
 * the encrypted message and starting point for the key file
 *
 * @author Dean Farwell
 */
public class Encrypt {

    /**
     * This method takes in a key file and a message and writes an encrypted message to a file encryptedMessage.txt
     * @param fileName Location of the key file
     * @param message Message entered by user
     * @throws IOException Thrown if there are issues opening the key file
     */
    public static void encryptor(String fileName, String message) throws IOException {

        boolean changed;
        String altMessage = "";
        int n, key;
        int[] keyArray;

        // creates the file where the encrypted message will be written
        FileWriter encryptedFile = new FileWriter("oral_exam1/S102_OneTimePad_Hard/src/encryptedMessage.txt");

        // sends the key file to the key reader to get the key array and starting position
        ReadKeyFile reader = new ReadKeyFile(fileName);

        // copies the start position and key array as they are altered
        keyArray = reader.getKeyArray();
        n = reader.getKeyStart();

        // writes the starting position to the message file
        encryptedFile.write(n + "\n");

        // iterates through each character of the message
        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);
            changed = false;

            for (int x = 0; x < OneTimePad.ALPHABET.length; x++) { // goes through the alphabet until the matching character is found
                if (alt == OneTimePad.ALPHABET[x]) {
                    key = keyArray[(n % reader.getLength())]; // finds the key associated with the current character
                    n++;
                    changed = true;
                    altMessage = altMessage + OneTimePad.ALPHABET[(x + key) % 26]; // creates the new letter of the encrypted message
                }
            }

            if (!changed) { // if a character was not altered, it was likely because it was not a letter, so it is just added onto the encrypted message (Ex: space)
                altMessage = altMessage + alt;
            }
        }

        encryptedFile.write(altMessage); // writes the message to the file

        KeyGenerator.positionUpdate((n % reader.getLength()), keyArray, reader.getLength()); // updates the starting position in the key file

        encryptedFile.close();
    }
}

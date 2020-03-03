import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class contains the method for decrypting a message file
 *
 * @author Dean Farwell
 */
public class Decrypt {

    /**
     * Decryption method that handles opening the encrypted message file and returning the decrypted message.
     * If the file can not be found, an error is returned.
     * @param keyFile Key file location given by user
     * @param messageFile Message file location given by user
     * @return String The decrypted message
     * @throws IOException Thrown if there are issues opening the given files
     */
    public static String decryptor(String keyFile, String messageFile) throws IOException {
        boolean changed;
        String message = "", messageFromFile = "", encryptedMessage = "";
        int keyStart = 0, n, key;
        char[] encryptedFile = new char[100];
        Arrays.fill(encryptedFile, 'z');

        ReadKeyFile keys = new ReadKeyFile(keyFile);
        FileReader altMessage = null; // create FileReader to read in message file

        try { // checks if the file can be found
            altMessage = new FileReader(messageFile);
        }
        catch (FileNotFoundException notFound) {
            return "File not found";
        }

        altMessage.read(encryptedFile);

        for (char c : encryptedFile) { // converts the character array into a string
            if(c != 'z') {
                messageFromFile = messageFromFile + c;
            }
        }

        for (int a = 0; a < messageFromFile.length(); a++) {
            if (messageFromFile.charAt(a) == '\n') {
                try { // converts key file entries to integers
                    keyStart = Integer.parseInt(encryptedMessage.trim());
                    encryptedMessage = "";
                }
                catch (NumberFormatException formatIssue) {
                    return "Error converting keys in key file to type int";
                }
            }
            else { // builds the message string, omitting the key starting position
                encryptedMessage += messageFromFile.charAt(a);
            }
        }

        n = keyStart;

        for (int i = 0; i < encryptedMessage.length(); i++) { // goes through the encrypted message character by character
            char alt = encryptedMessage.charAt(i);
            changed = false;

            for (int x = 0; x < OneTimePad.ALPHABET.length; x++) { // once the matching letter is found, its key position is subtracted to decrypt the message
                if (alt == OneTimePad.ALPHABET[x]) {
                    key = (keys.getKeyArray()[(n % keys.getLength())] % 26); // grabs the necessary key
                    n++;
                    changed = true;
                    message = message + OneTimePad.ALPHABET[(x - key + 26000) % 26]; // transforms back to original. +26000 and % 26 is to avoid negative numbers when subtracting
                }
            }

            if (!changed) { // if nothing changed it is because the character is not a letter and was never altered originally.
                message = message + alt;
            }
        }

        return message;

    }
}

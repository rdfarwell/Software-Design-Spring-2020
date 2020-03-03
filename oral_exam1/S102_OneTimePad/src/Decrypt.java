import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 */
public class Decrypt {

    /**
     * Decryption method that handles opeing the
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

        try {
            altMessage = new FileReader(messageFile);
        }
        catch (FileNotFoundException notFound) {
            System.out.println("File not found");
        }

        altMessage.read(encryptedFile);

        for (char c : encryptedFile) { // converts the characters into a string
            if(c != 'z') {
                messageFromFile = messageFromFile + c;
            }
        }

        for (int a = 0; a < messageFromFile.length(); a++) {
            if (messageFromFile.charAt(a) == '\n') {
                try {
                    keyStart = Integer.parseInt(encryptedMessage.trim());
                    encryptedMessage = "";
                }
                catch (NumberFormatException formatIssue) {
                    System.out.println("Error converting keys in file to type int");
                }
            }
            else {
                encryptedMessage += messageFromFile.charAt(a);
            }
        }

        n = keyStart;

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char alt = encryptedMessage.charAt(i);
            changed = false;

            for (int x = 0; x < OneTimePad.ALPHABET.length; x++) {
                if (alt == OneTimePad.ALPHABET[x]) {
                    key = (keys.getKeyArray()[(n % keys.getLength())] % 26);
                    n++;
                    changed = true;
                    message = message + OneTimePad.ALPHABET[(x - key + 26) % 26];
                }
            }

            if (!changed) {
                message = message + alt;
            }
        }

        return message;

    }
}

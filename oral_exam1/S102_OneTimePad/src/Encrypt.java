import java.io.FileWriter;
import java.io.IOException;

public class Encrypt {
    public static void encryptor(String fileName, String message) throws IOException {

        boolean changed;
        String altMessage = "";
        int n, key;
        int[] keyArray;

        FileWriter encryptedFile = new FileWriter("oral_exam1/S102_OneTimePad/src/encryptedMessage.txt");

        ReadKeyFile reader = new ReadKeyFile(fileName);


        keyArray = reader.getKeyArray();
        n = reader.getKeyStart();

        encryptedFile.write(n + "\n");

        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);
            changed = false;

            for (int x = 0; x < OneTimePad.ALPHABET.length; x++) {
                if (alt == OneTimePad.ALPHABET[x]) {
                    key = keyArray[(n % reader.getLength())];
                    n++;
                    changed = true;
                    altMessage = altMessage + OneTimePad.ALPHABET[(x + key) % 26];
                }
            }

            if (!changed) {
                altMessage = altMessage + alt;
            }
        }

        encryptedFile.write(altMessage);

        KeyGenerator.positionUpdate((n % reader.getLength()), keyArray, reader.getLength());

        encryptedFile.close();
    }
}

import java.io.IOException;

public class Encrypt {
    public static void encryptor(String fileName, String message) throws IOException {

        boolean changed;
        String altMessage = "";
        int n, key;
        int[] keyArray;

        ReadKeyFile reader = new ReadKeyFile(fileName);

        keyArray = reader.getKeyArray();
        n = reader.getKeyStart();

        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);
            changed = false;

            for (int x = 0; x < OneTimePad.alphabet.length; x++) {
                if (alt == OneTimePad.alphabet[x]) {
                    key = keyArray[(n % reader.getLength())];
                    n++;
                    changed = true;
                    altMessage = altMessage + OneTimePad.alphabet[(x + key) % 26];
//                    if ((x + key) > 26) {
//                        altMessage = altMessage + OneTimePad.alphabet[x + key - 26];
//                    }
//                    else {
//                        altMessage = altMessage + OneTimePad.alphabet[x + key];
//                    }
                }
            }

            if (!changed) {
                altMessage = altMessage + alt;
            }
        }



        KeyGenerator.positionUpdate((n % reader.getLength()), keyArray, reader.getLength());
    }
}

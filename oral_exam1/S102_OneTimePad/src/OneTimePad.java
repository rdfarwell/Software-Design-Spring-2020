import java.util.Scanner;

public class OneTimePad {
    public static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] argv) {
        Scanner scnr = new Scanner(System.in);
        String message, altMessage = "";
        boolean changed = false;
        int key;

        message = scnr.nextLine();
        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);
            changed = false;

            for (int x = 0; x < alphabet.length; x++) {
                if (alt == alphabet[x]) {
                    key = scnr.nextInt() % 26;
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

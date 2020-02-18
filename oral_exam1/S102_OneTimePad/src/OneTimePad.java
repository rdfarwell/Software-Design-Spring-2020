import java.util.Scanner;

public class OneTimePad {
    public static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static void main(String[] argv) {
        Scanner scnr = new Scanner(System.in);
        String message, altMessage = "";
        int key;

        message = scnr.nextLine();
        message = message.toUpperCase();
        key = scnr.nextInt();

        key = key % 26;

        for (int i = 0; i < message.length(); i++) {
            char alt = message.charAt(i);

            if (alt == ' ') {
                altMessage += " ";
            }
            else {
                for (int x = 0; x < alphabet.length; x++) {
                    if (alt == alphabet[x]) {
                        if ((x + key) > 26) {
                            altMessage = altMessage + alphabet[x + key - 26];
                        } else {
                            altMessage = altMessage + alphabet[x + key];
                        }
                    }
                }
            }
        }

        System.out.println(altMessage);

    }


}

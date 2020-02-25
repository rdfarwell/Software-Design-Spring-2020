import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class KeyGenerator {
    public static void generator(int n, int range) throws IOException {

        Random rand = new Random();
        FileWriter keyFile = new FileWriter("oral_exam1/S102_OneTimePad/src/key.txt");
        keyFile.write("0\n");

        for (int i = 0; i < n; i++) {
            keyFile.write(Integer.toString(rand.nextInt(range))); // generates random numbers to be written to file
            if (i < (n - 1)) {
                keyFile.write(',');
            }
        }

        keyFile.close();
    }

    public static void positionUpdate(int s, int[] keys, int length) throws IOException {
        FileWriter keyFile = new FileWriter("oral_exam1/S102_OneTimePad/src/key.txt");
        keyFile.write(s + "\n");

        for (int i = 0; i < length; i++) {
            keyFile.write(Integer.toString(keys[i])); // generates random numbers to be written to file
            if (i < (length - 1)) {
                keyFile.write(',');
            }
        }

        keyFile.close();
    }
}

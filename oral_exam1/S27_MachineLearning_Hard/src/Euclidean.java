import java.lang.Math;

public class Euclidean {
    public static double euclideanDistance(int[] num1, int[] num2) {
        int temp = 0;

        if (num1.length == num2.length) {
            for (int i = 0; i < num1.length; i++) {
                temp += ((num2[i] - num1[i]) * (num2[i] - num1[i]));
            }
            return Math.sqrt(temp);
        }
        else {
            return -1;
        }
    }
}

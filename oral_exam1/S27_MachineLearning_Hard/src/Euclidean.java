import java.lang.Math;

/**
 * Euclidean distance class that calculates the euclidean distance between two vectors (arrays)
 */
public class Euclidean {

    /**
     * Given euclidean distance calculation that takes in two arrays and returns their euclidean distance
     * @param num1 Array to be compared to num2
     * @param num2 Array to be compared to num1
     * @return A distance between the two arrays
     */
    public static double euclideanDistance(double[] num1, double[] num2) {
        double temp = 0; // summation variable

        if (num1.length == num2.length) { // length check
            for (int i = 0; i < num1.length; i++) { // sums the relevant calculation
                temp += (num2[i] - num1[i]);
            }
            return Math.sqrt(temp);
        }
        else { // if lengths not equal
            return -1;
        }
    }
}

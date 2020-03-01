/*
 * Name: Dean Farwell
 */

import java.lang.Math;

public class Euclidean {

    private int[] num1;
    private int[] num2;

    public Euclidean() {

    }

    public Euclidean(int[] n1, int[] n2) {
        num1 = n1;
        num2 = n2;
    }

    private double euclideanCalc() {
        int temp = 0;

        for (int i = 0; i < num1.length; i++) {
            temp += ((num2[i] - num1[i]) * (num2[i] - num1[i]));
        }

        return Math.sqrt(temp);
    }

    public void printEuclidean() {
        System.out.println("Euclidean distance between " + num1 + " and " + num2 + " = " + euclideanCalc());
    }

}

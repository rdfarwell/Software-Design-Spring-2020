/**
 * Class that contains a method that computes the hamming distance between two binary strings
 *
 * @author Dean Farwell
 */
public class Hamming {

    /**
     * Hamming Distance finds the difference between two strings of binary numbers and returns the number of non-similar occurrences
     * @param a A string of binary numbers to be compared to b
     * @param b A string of binary numbers to be compared to a
     * @return The number of non-similar bits between the strings
     */
    public static int hammingDistance(String a, String b) {
        int count = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) { // if characters are different, add one to count
                    count++;
                }
            }
            return count;
        }
        else { // if lengths aren't similar
            return -1;
        }
    }
}

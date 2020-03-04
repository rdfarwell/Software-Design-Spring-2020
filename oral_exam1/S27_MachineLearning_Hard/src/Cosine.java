/**
 * Cosine similarity class that contains the cosine similarity method which handles the similarity calculation
 *
 * @author Dean Farwell
 */
public class Cosine {

    /**
     * Follows a known equation to calculate the cosine similarity between two vectors (arrays)
     * @param a An array to compare against b
     * @param b An array to compare against a
     * @return A double of the similarity between two arrays (0 to 1)
     */
    public static double cosineSimilarity(double[] a, double[] b) {
        double ab = 0, aSqr = 0, bSqr = 0; // temp values for summation before single calculations
        if (a.length == b.length) { // check for equal length
            for (int i = 0; i < a.length; i++) { // calculates and sums the three relevant sections of the cosine similarity function
                ab += (a[i] * b[i]);
                aSqr += (a[i] * a[i]);
                bSqr += (b[i] * b[i]);
            }
            return (ab / (Math.sqrt(aSqr) * Math.sqrt(bSqr)));
        }
        else { // if lengths are not equal
            return -1;
        }
    }
}

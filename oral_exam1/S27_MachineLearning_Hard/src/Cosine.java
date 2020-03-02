public class Cosine {
    public double cosineSimilarity(double[] a, double[] b) {
        double ab = 0, aSqr = 0, bSqr = 0;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                ab += (a[i] * b[i]);
                aSqr += (a[i] * a[i]);
                bSqr += (b[i] * b[i]);
            }
            return (ab / (Math.sqrt(aSqr) * Math.sqrt(bSqr)));
        }
        else {
            return -1;
        }
    }
}

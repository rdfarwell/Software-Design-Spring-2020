import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test for Cosine Class, performs 5 tests
 *
 * @author Dean Farwell
 */
class CosineTest {

    /**
     * 5 tests for Cosine.cosineSimilarity. Tests various cases
     */
    @Test
    void testCosine() {
        double[] a = {1, 2, 3}, b = {3,2,1}, c = {1.2, 5, 67}, d = {1}, e = {5};
        assertEquals(0.7142857142857143, Cosine.cosineSimilarity(a, b));
        assertEquals(0.3205686040549993, Cosine.cosineSimilarity(c, b));
        assertEquals(-1, Cosine.cosineSimilarity(a, d));
        assertEquals(1, Cosine.cosineSimilarity(a, a));
        assertEquals(1, Cosine.cosineSimilarity(d, e));
    }
}
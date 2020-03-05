import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for euclidean distance method
 *
 * @author Dean Farwell
 */
class EuclideanTest {

    /**
     * 5 different tests of Euclidean's method euclideanDistance testing various cases
     */
    @Test
    void testEuclidean() {
        double[] a = {1, 2, 3}, b = {3,2,1}, c = {1.2, 5, 67}, d = {1}, e = {5};
        assertEquals(2.8284271247461903, Euclidean.euclideanDistance(a, b));
        assertEquals(66.09266222509122, Euclidean.euclideanDistance(c, b));
        assertEquals(-1, Euclidean.euclideanDistance(a, d));
        assertEquals(0, Euclidean.euclideanDistance(a, a));
        assertEquals(4, Euclidean.euclideanDistance(d, e));
    }

}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HammingTest {
    @Test
    void testHamming() {
        assertEquals(1, Hamming.hammingDistance("1011", "1010"));
        assertEquals(0, Hamming.hammingDistance("10101011", "10101011"));
        assertEquals(-1, Hamming.hammingDistance("101111", "10"));
        assertEquals(4, Hamming.hammingDistance("10101", "11010"));
        assertEquals(0, Hamming.hammingDistance("101011100011001100", "101011100011001100"));
    }

}
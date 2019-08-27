import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticJUnitTest {

    @Test
    void multiply() {
        assertEquals(4, Arithmetic.multiply(2,2));
        assertEquals(-15, Arithmetic.multiply(3,-5));
    }

    @Test
    void isPositive() {
        assertTrue(Arithmetic.isPositive(5));
        assertFalse(Arithmetic.isPositive(-5));
        assertFalse(Arithmetic.isPositive(0),"Zero is not positive");
    }


    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"8,3,24","2,-3,-6","-2,-3,6"})
    void testMultiply (int x, int y, int expected) {
        assertEquals(Arithmetic.multiply(x,y),expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {9,15,8,7,3})
    void testPositiveIsPositive (int i) {
        assertTrue(Arithmetic.isPositive(i));
    }

}
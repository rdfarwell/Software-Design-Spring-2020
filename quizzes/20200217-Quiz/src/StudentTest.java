import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student = new Student("", 0);

    @BeforeEach
    public void setUpStudent() {

    }

    @Test
    public void testSetName() {
        student.setName("Thomas");
        assertEquals("Thomas", student.getName(), "Thomas");
    }

    @Test
    public void testAverageZero() {
        student.setAverage(0);
        assertEquals(0, student.getAverage(), "Average is not zero!");
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RunSimulationTest {

    @Test
    public void testParseInt() throws Exception {
        // Getting the method that turns strings into ints (I think)
        var method = RunSimulation.class.getDeclaredMethod("parseInt", String.class);
        method.setAccessible(true); // needed so I can use it here

        // Normal Number
        assertEquals(42, method.invoke(null, "42"));

        // Not a Number
        assertEquals(0, method.invoke(null, "abc"));

        // Negative Numbers
        assertEquals(-5, method.invoke(null, "-5"));

        // Null
        assertEquals(0, method.invoke(null, null));

        // Numbers with extra spaces
        assertEquals(10, method.invoke(null, " 10 "));
    }

    @Test
    public void testParseDouble() throws Exception {
        // Getting the method to convert string to double
        var method = RunSimulation.class.getDeclaredMethod("parseDouble", String.class);
        method.setAccessible(true);

        // Normal Number
        assertEquals(3.14, (double) method.invoke(null, "3.14"), 0.001);

        // Not a Number
        assertEquals(0.0, (double) method.invoke(null, "not a number"), 0.001);

        // Negative Number
        assertEquals(-2.0, (double) method.invoke(null, "-2.0"), 0.001);

        // Null
        assertEquals(0.0, (double) method.invoke(null, null), 0.001);

        // Number with extra spaces
        assertEquals(1.5, (double) method.invoke(null, " 1.5 "), 0.001);
    }

    @Test
    public void testParseBoolean() throws Exception {
        // Getting the boolean parser method
        var method = RunSimulation.class.getDeclaredMethod("parseBoolean", String.class);
        method.setAccessible(true);

        // Lower case
        assertTrue((boolean) method.invoke(null, "true"));

        // Upper case
        assertFalse((boolean) method.invoke(null, "TRUE"));

        // Other words
        assertFalse((boolean) method.invoke(null, "yes"));

        // Empty String
        assertFalse((boolean) method.invoke(null, ""));

        // Null
        assertFalse((boolean) method.invoke(null, null));

        // With extra space
        assertFalse((boolean) method.invoke(null, " true "));
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllTests {

    @Test
    void testTrackObjectsInLEO() {
        TrackObjectsInLEOTest trackTest = new TrackObjectsInLEOTest();

        // Running the TrackObjectsInLEO test methods
        trackTest.testPrintInfoOutput();
        trackTest.testPrintLEOList();
    }

    @Test
    void testRunSimulation() throws Exception {
        RunSimulationTest runTest = new RunSimulationTest();

        // Running the RunSimulation test methods
        runTest.testParseInt();
        runTest.testParseDouble();
        runTest.testParseBoolean();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * It loads debris data from a CSV file and passes it to a Scientist user.
 */
public class Main {

    /**
     * Main method that starts the program.
     * It loads the debris data from a CSV file and shows the user menu for a Scientist.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        Debris[] debrisArray = loadDebrisFromCSV("rso_metrics.csv");

        Scientist scientist = new Scientist("Scientist", debrisArray);
        scientist.userMenu(); // display the Scientist's menu
    }

    /**
     * Reads a CSV file and creates Debris objects from the data.
     * This method extracts values from each line in the file and uses them to create
     * instances of the Debris class. It only includes entries where the object type is "DEBRIS".
     *
     * @param filePath the path to the CSV file
     * @return an array of Debris objects created from the file
     */
    public static Debris[] loadDebrisFromCSV(String filePath) {
        Debris[] debrisArray = new Debris[1000]; // Create a fixed-size array to store debris
        int debrisCount = 0;

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file, "UTF-8");

            // Skip the header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each line and parse its values
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into fields, considering quoted commas
                String[] allFields = new String[30];
                int fieldIndex = 0;
                boolean insideQuotes = false;
                StringBuilder field = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '"') {
                        insideQuotes = !insideQuotes;
                    } else if (c == ',' && !insideQuotes) {
                        allFields[fieldIndex++] = field.toString();
                        field.setLength(0);
                    } else {
                        field.append(c);
                    }
                }
                allFields[fieldIndex++] = field.toString(); // add the last field

                // Parse and extract each required value from the fields
                int i = 0;
                int recordId = parseInt(allFields[i++]);
                int noradCatId = parseInt(allFields[i++]);
                String satelliteName = allFields[i++];
                String country = allFields[i++];
                String approximateOrbitType = allFields[i++];
                String objectType = allFields[i++];
                int launchYear = parseInt(allFields[i++]);
                String launchSite = allFields[i++];
                double longitude = parseDouble(allFields[i++]);
                double avgLongitude = parseDouble(allFields[i++]);

                // Geohash is split into two numbers
                String[] geoParts = allFields[i++].split("[ ,]");
                double[] geoHash = new double[2];
                geoHash[0] = geoParts.length > 0 ? parseDouble(geoParts[0]) : 0.0;
                geoHash[1] = geoParts.length > 1 ? parseDouble(geoParts[1]) : 0.0;

                i++; // skip unused field
                boolean isNominated = parseBoolean(allFields[i++]);
                i++; // skip unused field
                boolean hasDossier = parseBoolean(allFields[i++]);
                i += 3; // skip 3 unused fields
                int daysOld = parseInt(allFields[i++]);
                int conjunctionCount = parseInt(allFields[i++]);
                boolean isUnkObject = parseBoolean(allFields[i++]);

                // Only create a Debris object if it's labeled as DEBRIS
                if ("DEBRIS".equalsIgnoreCase(objectType)) {
                    Debris debris = new Debris(
                            recordId, noradCatId, satelliteName, country, approximateOrbitType,
                            objectType, launchYear, launchSite, longitude, avgLongitude, geoHash,
                            isNominated, hasDossier, daysOld, conjunctionCount, isUnkObject, false
                    );

                    // Add to the array if there's space
                    if (debrisCount < debrisArray.length) {
                        debrisArray[debrisCount++] = debris;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        }

        // Return only the non-null Debris objects
        Debris[] trimmedArray = new Debris[debrisCount];
        System.arraycopy(debrisArray, 0, trimmedArray, 0, debrisCount);
        return trimmedArray;
    }

    /**
     * Converts a string to an integer safely.
     * If conversion fails, returns 0.
     *
     * @param value the string to convert
     * @return the integer value or 0 if invalid
     */
    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Converts a string to a double safely.
     * If conversion fails, returns 0.0.
     *
     * @param value the string to convert
     * @return the double value or 0.0 if invalid
     */
    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * Converts a string to a boolean.
     * Accepts "true" or "1" (case insensitive) as true.
     *
     * @param value the string to check
     * @return true if value is "true" or "1", otherwise false
     */
    private static boolean parseBoolean(String value) {
        return value != null && (value.trim().equalsIgnoreCase("true") || value.trim().equals("1"));
    }
}

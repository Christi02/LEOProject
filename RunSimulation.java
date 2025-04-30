import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Date: April 2025
 * Course: CS 3331 CRN 21024
 * Instructor: Dr. Bhanukiran Gurijala
 * Project Part 1
 * Description:
 *
 * Honesty Statement: Both Joseth and Christin have worked on this project
 * entirely on our own collaboration without any outside sources including
 * peers, experts, online sources, or the like. Only recieved assistance from
 * the Dr. Gurijala, TA or IAs.
 *
 *
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */



public class RunSimulation {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        mainMenu();
    }
    /**
     * Main menu of the system where the current user is selected.
     * If there is no user selected then the system will exit.
     *
     */
    public static void mainMenu(){
        String choice;
        Debris[] debrisArray = loadDebrisFromCSV("rso_metrics.csv");
        UnknownTypeObject[] unknownObjArray = loadUnknownTypeObjectsFromCSV("rso_metrics.csv");
        Payload[] payloadArray = loadPayloadFromCSV("rso_metrics.csv");
        RocketBody[] rocketbodyArray = loadRocketbodyFromCSV("rso_metrics.csv");
        TrackObjectsInLEO[] trackObjectsInLEO = loadTOLFromCSV("rso_metrics.csv");

        Scientist scientist = new Scientist("Scientist", debrisArray, unknownObjArray, trackObjectsInLEO, rocketbodyArray, payloadArray);
        SpaceAgencyRepresentative sap = new SpaceAgencyRepresentative("Space Agency Representative");
        Policymaker policymaker = new Policymaker("Policymaker");
        Administrator administrator = new Administrator("Administrator");

        do{
            System.out.println("-------- Welcome -------");
            System.out.println("Scientist");
            System.out.println("Space Agency Representative");
            System.out.println("Policymaker");
            System.out.println("Administrator");
            System.out.println("EXIT \n");
            System.out.println("Please pick a user or type EXIT.");
            choice = scanner.nextLine();
            System.out.println();

            switch(choice){
                case "Scientist":
                    scientist.userMenu();
                    break;
                case "Space Agency Representative":
                    sap.userMenu();
                    break;
                case "Policymaker":
                    policymaker.userMenu();
                    break;
                case "Administrator":
                    administrator.userMenu();
                    break;
                case "EXIT":
                    System.exit(0); //no errors, program ends
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        } while(!choice.equals("EXIT"));
    }
    /**
     * 
     * @param filePath the csv file
     * @return Debris array
     **/
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
    public static UnknownTypeObject[] loadUnknownTypeObjectsFromCSV(String filePath) {
        UnknownTypeObject[] unknownTypeObjectArray = new UnknownTypeObject[1000]; // Create a fixed-size array to store unknown type objects
        int unknownCount = 0;

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

                // Create UnknownTypeObject if objectType is "UNKNOWN"
                if ("UNKNOWN".equalsIgnoreCase(objectType)) {
                    UnknownTypeObject unkObject = new UnknownTypeObject(
                            recordId, noradCatId, satelliteName, country, approximateOrbitType,
                            objectType, launchYear, launchSite, longitude, avgLongitude, geoHash,
                            isNominated, hasDossier, daysOld, conjunctionCount, isUnkObject
                    );

                    // Add to the array if there's space
                    if (unknownCount < unknownTypeObjectArray.length) {
                        unknownTypeObjectArray[unknownCount++] = unkObject;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        }

        // Return only the non-null UnknownTypeObject objects
        UnknownTypeObject[] trimmedArray = new UnknownTypeObject[unknownCount];
        System.arraycopy(unknownTypeObjectArray, 0, trimmedArray, 0, unknownCount);
        return trimmedArray;
    }
    public static Payload[] loadPayloadFromCSV(String filePath) {
        Payload[] payloadArray = new Payload[1000]; // Create a fixed-size array to store unknown type objects
        int payloadCount = 0;

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

                // Create UnknownTypeObject if objectType is "UNKNOWN"
                if ("PAYLOAD".equalsIgnoreCase(objectType)) {
                    Payload payload = new Payload(
                            recordId, noradCatId, satelliteName, country, approximateOrbitType,
                            objectType, launchYear, launchSite, longitude, avgLongitude, geoHash,
                            isNominated, hasDossier, daysOld, conjunctionCount, isUnkObject
                    );

                    // Add to the array if there's space
                    if (payloadCount < payloadArray.length) {
                        payloadArray[payloadCount++] = payload;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        }

        // Return only the non-null UnknownTypeObject objects
        Payload[] trimmedArray = new Payload[payloadCount];
        System.arraycopy(payloadArray, 0, trimmedArray, 0, payloadCount);
        return trimmedArray;
    }
    public static RocketBody[] loadRocketbodyFromCSV(String filePath) {
        RocketBody[] rocketBodyArray = new RocketBody[1000]; // Create a fixed-size array to store unknown type objects
        int rocketBodyCount = 0;

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

                // Create UnknownTypeObject if objectType is "UNKNOWN"
                if ("ROCKETBODY".equalsIgnoreCase(objectType)) {
                    RocketBody rocketBody = new RocketBody(
                            recordId, noradCatId, satelliteName, country, approximateOrbitType,
                            objectType, launchYear, launchSite, longitude, avgLongitude, geoHash,
                            isNominated, hasDossier, daysOld, conjunctionCount, isUnkObject
                    );

                    // Add to the array if there's space
                    if (rocketBodyCount < rocketBodyArray.length) {
                        rocketBodyArray[rocketBodyCount++] = rocketBody;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        }

        // Return only the non-null UnknownTypeObject objects
        RocketBody[] trimmedArray = new RocketBody[rocketBodyCount];
        System.arraycopy(rocketBodyArray, 0, trimmedArray, 0, rocketBodyCount);
        return trimmedArray;
    }
    
    public static TrackObjectsInLEO[] loadTOLFromCSV(String filePath) {
        TrackObjectsInLEO[] trackObjectsLEOArray = new TrackObjectsInLEO[1000]; // Create a fixed-size array to store objects
        int trackObjectLEOCount = 0;

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

                // Create UnknownTypeObject if objectType is "UNKNOWN"
                if ("LEO".equalsIgnoreCase(approximateOrbitType)) {
                    TrackObjectsInLEO trackLEOobject = new TrackObjectsInLEO(
                            recordId, noradCatId, satelliteName, country, approximateOrbitType,
                            objectType, launchYear, launchSite, longitude, avgLongitude, geoHash,
                            isNominated, hasDossier, daysOld, conjunctionCount, isUnkObject
                    );

                    // Add to the array if there's space
                    if (trackObjectLEOCount < trackObjectsLEOArray.length) {
                        trackObjectsLEOArray[trackObjectLEOCount++] = trackLEOobject;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found.");
        }

        // Return only the non-null UnknownTypeObject objects
        TrackObjectsInLEO[] trimmedArray = new TrackObjectsInLEO[trackObjectLEOCount];
        System.arraycopy(trackObjectsLEOArray, 0, trimmedArray, 0, trackObjectLEOCount);
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
     * Tries to convert a string to a double.
     * If the string is invalid or null, returns 0.0.
     *
     * @param value the string to convert
     * @return the parsed double value, or 0.0 if invalid
     */
    private static double parseDouble(String value) {
        if (value == null) {
            return 0.0;
        }

        try {
            String trimmedValue = value.trim(); // Remove spaces before/after
            return Double.parseDouble(trimmedValue); // Try converting to double
        } catch (NumberFormatException e) {
            // If it fails to convert (like "abc"), return 0.0
            return 0.0;
        }
    }

    /**
     * Converts a string to a boolean.
     * Returns true only if the string is "true" (any case) or "1".
     *
     * @param value the string to check
     * @return true if the string is "true" or "1", otherwise false
     */
    private static boolean parseBoolean(String value) {
        if (value == null) {
            return false;
        }

        String trimmedValue = value.trim(); // Remove spaces

        if (trimmedValue.equalsIgnoreCase("true")) {
            return true;
        }

        if (trimmedValue.equals("1")) {
            return true;
        }

        return false;
    }
}

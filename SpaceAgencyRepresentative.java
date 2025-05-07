import java.util.Scanner;

/**
 * Curated menu for only Space Agency Representative.
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public class SpaceAgencyRepresentative extends User{
    private TrackObjectsInLEO[] trackObjectsInLEOarray = new TrackObjectsInLEO[1000];

    /** explicitly invokes from User class */
    public SpaceAgencyRepresentative(String position, TrackObjectsInLEO[] trackObjectsInLEOarray){
        super(position);
        this.trackObjectsInLEOarray = trackObjectsInLEOarray;
    }
    /**
     * Overrides subMenuChoice method from User class
     *  Specified menu options for the user.
     */
    @Override
    public void subMenuChoice(){
        System.out.println("1. Analyse long-term Impact");
        System.out.println("2. Generate density reports");
    }
    /**
     *  Overrides subSwitchCases from User class.
     *  These are the choice options for the specified menu.
     * @param choice user input for menu option
     */
    @Override
    public void subSwitchCases(int choice){
        switch(choice){
            case 1:
                analyzeLongTermImpact();
                break;
            case 2:
                generateDensityReport();
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                RunSimulation.mainMenu(); //sends back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }

    public void analyzeLongTermImpact() {
        for (TrackObjectsInLEO obj : trackObjectsInLEOarray) {
            if (obj != null && obj.getDaysOld() > 200 && obj.getConjunctionCount() > 0) {
                obj.printInfo();
            }
        }
    }

    public void generateDensityReport() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum longitude: ");
        double minLongitude = scanner.nextDouble();

        System.out.print("Enter maximum longitude: ");
        double maxLongitude = scanner.nextDouble();

        int count = 0;

        System.out.println("\n--- Density Report ---");
        for (TrackObjectsInLEO obj : trackObjectsInLEOarray) {
            if (obj != null) {
                double longitude = obj.getLongitude();
                if (longitude >= minLongitude && longitude <= maxLongitude) {
                    count++;
                    System.out.println("Record ID: " + obj.getRecordId());
                    System.out.println("Satellite Name: " + obj.getSatelliteName());
                    System.out.println("Country: " + obj.getCountry());
                    System.out.println("Orbit Type: " + obj.getOrbitType());
                    System.out.println("Launch Year: " + obj.getLaunchYear());
                    System.out.println("Object Type: " + obj.getObjectType());
                    System.out.println("---------------------------------------");
                }
            }
        }

        System.out.println("Total objects in range [" + minLongitude + ", " + maxLongitude + "]: " + count);
    }
}
/**
 * Curated menu for only Scientists.
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public class Scientist extends User{

    private Debris[] debrisArray;  // Array to hold debris objects

    /** explicitly invokes from User class */
    public Scientist(String position, Debris[] debrisArray){
        super(position);
        this.debrisArray = debrisArray;  // Pass the list of debris objects
    }

    /**
     * Overrides subMenuChoice method from User class
     *  Specified menu options for the user.
     */
    @Override
    public void subMenuChoice(){
        System.out.println("1. Track Objects in Space");
        System.out.println("2. Assess Orbit System");
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
                //TrackObjectInSpace.toisMenu();
                break;
            case 2:
                assessOrbitSystem();
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                //RunSimulation.mainMenu(); //sends back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }

    /**
     * Method to print the list of all debris objects.
     */
    private void assessOrbitSystem() {
        for (int i = 0; i < debrisArray.length; i++) {
            if (debrisArray[i] != null) {
                Debris debris = debrisArray[i];

                System.out.println("Record ID: " + debris.recordId);
                System.out.println("Satellite Name: " + debris.satelliteName);
                System.out.println("Country: " + debris.country);
                System.out.println("Orbit Type: " + debris.orbitType);
                System.out.println("Launch Year: " + debris.launchYear);
                System.out.println("Launch Site: " + debris.launchSite);
                System.out.println("Longitude: " + debris.longitude);
                System.out.println("Avg. Longitude: " + debris.avgLongitude);
                System.out.println("Geohash: [" + debris.geohash[0] + ", " + debris.geohash[1] + "]");
                System.out.println("Days Old: " + debris.daysOld);
                System.out.println("----------------------------------------------------");
            }
        }
    }
}

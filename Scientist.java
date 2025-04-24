/**
 * Menu for Track Object in Space in Scientist menu
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public class Scientist extends User {

    private Debris[] debrisArray = new Debris[1000];
    private UnknownTypeObject[] unknownObjArray = new UnknownTypeObject[1000];
    private TrackObjectsInLEO[] trackObjectsInLEOarray = new TrackObjectsInLEO[1000];

    /**
     *  Constroctor 
     * @param position for type of user
     * @param debrisArray the Debris array
     * @param unknownObjArray the unknown objects array
     * @param trackObjectsInLEOarray the objects for the LEO list array
     */
    public Scientist(String position, Debris[] debrisArray, UnknownTypeObject[] unknownObjArray, TrackObjectsInLEO[] trackObjectsInLEOarray) {
        super(position);
        this.debrisArray = debrisArray;
        this.unknownObjArray = unknownObjArray;
        this.trackObjectsInLEOarray = trackObjectsInLEOarray;
    }

    /**
     * Overrides subMenuChoice method from User class
     * Specifies menu options for the user.
     */
    @Override
    public void subMenuChoice() {
        System.out.println("1. Track Objects in Space");
        System.out.println("2. Assess Orbit System");
        System.out.println("3. Return to Main Menu");
    }

    /**
     *  Overrides subSwitchCases from User class.
     *  These are the choice options for the specified menu.
     * @param choice user input for menu option
     */
    @Override
    public void subSwitchCases(int choice) {
        switch (choice) {
            case 1:
                TrackObjectInSpace.toisMenu(debrisArray, unknownObjArray);
                break;
            case 2:
                AssessOrbitSystem.aosMenu(trackObjectsInLEOarray);
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                RunSimulation.mainMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }
}

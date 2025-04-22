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
                Debris.assessOrbitSystem(debrisArray);
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                //RunSimulation.mainMenu(); //sends back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }

}

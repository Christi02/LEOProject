/**
 * Curated menu for only Policymaker.
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public class Policymaker extends User{

    /** explicitly invokes from User class */
    public Policymaker(String position){
        super(position);
    }
    /** 
     * Overrides subMenuChoice method from User class 
     *  Specified menu options for the user.
    */
    @Override
    public void subMenuChoice(){
        System.out.println("1. Review reports on debris impact");
        System.out.println("2. Assess risk levels for future space missions");
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
                break;
            case 2:
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                RunSimulation.mainMenu(); //sends back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }
}

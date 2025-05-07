import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Abstract User class that holds the User Menu.
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
abstract class User extends SpaceObject{
    public String position;

    Scanner scanner = new Scanner(System.in);

    public User(String position){
        this.position = position;
    }
    /**
     * Skeleton menu for subclasses.
     */
    public void userMenu(){
        int choice = 0;
        do {
            System.out.println("-------- "+ position+"'s " +  "Menu -------");
            subMenuChoice();
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick a number option.");
            //choice = scanner.nextInt();
            try {
                choice = scanner.nextInt();
                if(choice < 1 || choice > 3){
                    System.out.println("Invalid choice. Please choose 1 - 3. \n");
                }else{
                    subSwitchCases(choice);
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please try again. \n");
                scanner.nextLine();
            }

        } while(choice != 3);

    }
    /**
     * Left empty because it is expected to be overridden in subclass.
     */
    public void subMenuChoice(){
    }
    /**
     * Left empty because it is expected to be overridden in subclass.
     * @param choice
     */
    public void subSwitchCases(int choice){
    }
}

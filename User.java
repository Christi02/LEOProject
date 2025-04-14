import java.util.Scanner;
/**
 * Abstract User class that holds the User Menu. 
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
abstract class User {
    public String position;

    Scanner scanner = new Scanner(System.in);

    public User(String position){
        this.position = position;
    }
    /**
     * Skeleton menu for subclasses.
     */
    public void userMenu(){
        int choice;
        do {
            System.out.println("-------- "+ position+"'s " +  "Menu -------");
            subMenuChoice(); 
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            subSwitchCases(choice);

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

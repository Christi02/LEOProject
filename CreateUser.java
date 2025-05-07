import java.util.Scanner;
/**
 * Creates a user under the control of the Administrator. 
 * Uses the Interface UserType
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */
public class CreateUser implements UserType{
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Creates the username for a new user
     * Makes sure its not null or empty
     * @return a username for the new User
     */
    public static String userName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please create a username:" );
        String inputUserName = scanner.nextLine();

        while((inputUserName == null) || (inputUserName == "")){ //should not be null or an empty string
            System.out.println("Cannot be an empty username: ");
            inputUserName = scanner.nextLine();
        }
        return inputUserName; //the created username
    }
    /**
     * Creates the password for the new user
     * Makes sure that the password isnt null or isnt 0 or greater than 10
     * @return a password for the new User
     */
    public static String password(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please create a password: "); 
        System.out.println("Minimum of length 1, maximum 10");

        String inputPassword = scanner.nextLine();
        //password cannot be null, and must be 1-10 in length
        while((inputPassword == null) || (inputPassword.length() <= 0) || (inputPassword.length() >= 11)){
            System.out.println("Incorrect length, please try again: ");
            inputPassword = scanner.nextLine();
        }
        return inputPassword;
    }
    @Override
    /**
     * Valid positions for the new user
     * @return the position of the new User
     */
    public String userType(){
        Scanner scanner = new Scanner(System.in);
        String position;

        while(true){
            System.out.println("Please indicate position: ");
            position = scanner.nextLine();
            if((position.equalsIgnoreCase("Scientist")) || 
                (position.equalsIgnoreCase("Space Agency Representative")) ||
                (position.equalsIgnoreCase("Policymaker")) || 
                (position.equalsIgnoreCase("Administrator"))){
                return position;
            }else{
                System.out.println("");
                System.out.println("Position does not exit or does not match, please try again: ");
            }
        }
    }
}

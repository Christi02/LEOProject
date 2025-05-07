import java.util.Scanner;

/**
 * Curated menu for only Administrator.
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */

public class Administrator extends User{

    /** explicitly invokes from User class */
    public Administrator(String position){
        super(position);
    }
    /**
     * Overrides user menu from User class completely since there is an extra option. 
     * */
    @Override
    public void userMenu(){
        Scanner scanner = new Scanner(System.in);
        UserType newUser = new CreateUser();
        int choice;
        do {
            System.out.println("-------- "+ position+"'s " +  "Menu -------");
            System.out.println("1. Create User");
            System.out.println("2. Manage User");
            System.out.println("3. Delete User");
            System.out.println("4. Back to main menu \n");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    UserCSV.infoSaved(CreateUser.userName(), CreateUser.password(), newUser.userType()); //makes the new user
                    System.out.println("User created successfully!");
                    break;
                case 2:
                    ManageUser.manage(); //goes into changing usernames and passwords
                    break;
                case 3:
                    DeleteUser.deleteUserOption(); // deletes the users
                    break;
                case 4:
                    System.out.println("Going back to the main menu. \n");
                    RunSimulation.mainMenu(); //sends back to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        }while(choice != 4);
    }
}

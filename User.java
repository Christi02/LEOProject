import java.util.Scanner;
/**
 * Abstract User class that holds the User Menu. 
 */
abstract class User {
    public String position;

    Scanner scanner = new Scanner(System.in);

    public User(String position){
        this.position = position;
    }
    public void userMenu(){
        int choice;
        do {
            System.out.println("-------- "+ position+"'s " +  "Menu -------");
            subMenuChoice();
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            subSwitchCases();

        } while(choice != 3);

    }
    public void subMenuChoice(){
    }
    public void subSwitchCases(){
    }
}
